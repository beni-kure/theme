<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.BasicInfo" %>
<%@ page import="java.util.*" %>
<%
BasicInfo b=(BasicInfo) session.getAttribute("basicinfo");
List<String> tList=(List<String>) session.getAttribute("tList");
List<String> nList=(List<String>) session.getAttribute("nList");
int n = (int) (Math.random() * tList.size());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ランダムお題</title>
<style>
	p{
	font-size: 20px;
	}
	.title-text{
	font-weight: bold;
	font-size: 30px;
	}
	.name-text{
	font-weight: bold;
	font-size: 65px;
	}
	#colorbox{
	border-radius: 25px;
	width:100px;
	height:80px;
	background-color:<%=b.getColor()%>;
	}
</style>
</head>
<body>
<div>
<p><span class="title-text"><%= tList.get(n) %></span>の<br>
<p><span class="name-text"><%= nList.get(n) %></span>
	を６０分で描こう！</p>
<p><% if(b.getColor()!=null){%>
		テーマカラー
		<div class="box" id="colorbox"></div>
		<br>
		カラーコード：<%=b.getColor()%>
		<% } %></p>
		<br>
<p><% if(b.getPattern()!=null){%>
		絵柄：<%=b.getPattern()%>
		<% } %></p>
<h2>タイマー</h2>
  <div id="timerDisplay">残り時間: 00:00</div>
  <button onclick="startTimer()">スタート</button>
  <button onclick="pauseTimer()">ストップ</button>
  <script src="timer.js"></script>
		
<form action="/theme/Ending" method="post">
<input type="hidden" name="title" value="<%= tList.get(n) %>">
<input type="hidden" name="name" value="<%= nList.get(n) %>">
<br>
<input type="submit" id="submitButton" style="display: none;" value="おわり">
</form>
<br>
<br>
<input type="button" value="キャラクター変更" onclick="window.location.reload();" /><br>
<a href="/theme/Start">トップへ戻る</a>
</div>

</body>
</html>