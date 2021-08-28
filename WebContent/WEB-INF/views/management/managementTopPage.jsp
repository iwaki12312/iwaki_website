<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>管理画面</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    </head>
    <body>
        <div id="wrapper">
        	<div id="menu">
	            <h1>&lt;管理画面&gt;</h1>
	            <h2>--Menu--</h2>
	            <p id="link"><a href="<c:url value='management/index' />">楽曲情報を編集する</a></p>
	            <h2>--------</h2>
	        </div>

	        <p id="link"><a href="<c:url value='/index.html' />">トップページへ</a></p>

        </div>
    </body>
</html>