<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>楽曲一覧画面</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    </head>
    <body>
        <div id="wrapper">
        <table id="music_list">
	            <thead>
	                <tr>
	                    <th>曲名</th>
	                    <th>再生</th>
	                    <th>概要</th>
	                    <th>編集</th>
	                </tr>
	            </thead>
                <tbody>
	                <c:forEach var="music" items="${musics}">
	                    <tr>
	                        <td><c:out value="${music.name}" /></td>
	                        <td><audio controls preload="metadata" controlslist="nodownload" src="../items/mp3/${music.filename}"></audio></td>
	                        <td><c:out value="${music.overview}" /></td>
	                        <td><a href="<c:url value='edit?name=${music.name}' />">編集する</a></td>
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

	        <p id="link"><a href="<c:url value='/management' />">トップページへ</a></p>

        </div>
    </body>
</html>