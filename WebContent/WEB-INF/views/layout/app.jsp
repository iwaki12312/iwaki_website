<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>iwaki_website</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <p id="headerstring">サンプル再生WEBサイト</p>
	            <form id="searchform" action="play">
	                <input type="text" name="search" value="${search}">
	                <button type="submit">楽曲を検索</button>
	            </form>
            </div>
            <div id="content">
                ${param.content}
            </div>
            <div id="footer">
                <p id="name">by Iwaki Matsumoto.</p>
                <p id="gomanagement"><a href="<c:url value='management'/>">管理</a></p>

            </div>
        </div>
    </body>
</html>