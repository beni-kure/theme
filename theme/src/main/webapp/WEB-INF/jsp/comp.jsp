<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.BasicInfo" %>
<%
BasicInfo b=(BasicInfo) request.getAttribute("basicinfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ランダムお題</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Aoboshi+One&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="styles.css" /> 
<style>
	p {
		font-size: 1.8rem;
		font-family: 'Aoboshi One', serif;
	}
	textarea {
		resize: none;
		width: 300px;
		height: 120px;
		font-size: 1rem;
	}
</style>
</head>
<body>
<div>
<p>おつかれさまでした m(_ _)m</p>
<textarea><%= b.getName() %>(<%= b.getTitle() %>)を60分で描いてみた！ #<%= b.getName() %> #<%= b.getTitle() %> #イラスト練習</textarea>
<br>
<br>
<a href="/theme/Start">トップへ</a>
</div>
</body>
</html>