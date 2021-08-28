<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <div id="play">
            <h1>&lt;サンプル再生画面&gt;</h1>
            <%-- <c:forEach var="music" items="${musics}">
                <h3><c:out value="${music.name}" /></h3>
                <audio controls preload="metadata" controlslist="nodownload" src="items/mp3/${music.filename}"></audio>
                <a href="items/mp3/${music.filename}" download>ダウンロード</a>
                <p>${music.overview}</p>
            </c:forEach> --%>
            <table id="music_list">
	            <thead>
	                <tr>
	                    <th>曲名</th>
	                    <th>再生</th>
	                    <th>保存</th>
	                    <th>概要</th>
	                </tr>
	            </thead>
                <tbody>
	                <c:forEach var="music" items="${musics}">
	                    <tr>
	                        <td><c:out value="${music.name}" /></td>
	                        <td><audio controls preload="metadata" controlslist="nodownload" src="items/mp3/${music.filename}"></audio></td>
	                        <td><a href="items/mp3/${music.filename}" download>ダウンロード</a></td>
	                        <td><c:out value="${music.overview}" /></td>
	                    </tr>
	                </c:forEach>
	            </tbody>
	        </table>
            <div id="pagination">
	            （全 ${musics_count} 件）<br />
	            <c:forEach var="i" begin="1" end="${((musics_count - 1) / 5) + 1}" step="1">
	                <c:choose>
	                    <c:when test="${i == page}">
	                        <c:out value="${i}" />&nbsp;
	                    </c:when>
	                    <c:otherwise>
	                        <a href="${pageContext.request.contextPath}/play?page=${i}"><c:out value="${i}" /></a>&nbsp;
	                    </c:otherwise>
	                </c:choose>
	            </c:forEach>
            </div>
            <p id="link"><a href="<c:url value='index.html' />">トップページへ</a></p>
        </div>
  </c:param>
</c:import>
<script>
	let audios = document.querySelectorAll('audio');
	for (let i = 0; i < audios.length; i++) {
		audios[i].addEventListener("play", function() {
			for (let j = 0; j < audios.length; j++) {
				if(audios[j] != this){audios[j].pause()}
			}
		}, false);
	}
</script>