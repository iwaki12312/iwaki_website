<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <div id="wrapper">
            <h1>トップページ</h1>
            <p id="link"><a href="<c:url value='play' />">再生画面へ</a></p>
        </div>
    </c:param>
</c:import>