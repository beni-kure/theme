<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.AddInfo" %>
<%@ page import="java.util.*" %>
<%
List<AddInfo> aList=(List<AddInfo>) request.getAttribute("aList");
String errorMsg=(String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ランダムお題</title>
</head>
<body>
<a href="/theme/Start">トップへ</a>
<form action="/theme/Change" method="post">
キャラ検索：<input type="textbox" name="search" placeholder="作品名 or キャラクター名"><br>
<input type="submit" value="キャラ検索">
</form>
<hr>
<% if(errorMsg != null){ %>
<p><%= errorMsg %></p>
<% } else if (aList == null || aList.isEmpty()) {%>
<p>No data found.</p>
<% } else { %>
<% for(AddInfo a : aList){ %>
	<p><%=a.getTitle() %>:<%=a.getName() %>:<%=a.getSex() %>:<%=a.getGenre() %>:<%=a.getFreeword1() %>:<%=a.getFreeword2() %>:<%=a.getFreeword3() %>:<%=a.getFreeword4() %>:<%=a.getFreeword5() %>:<%=a.getFreeword6() %>:<%=a.getFreeword7() %>:<%=a.getFreeword8() %>:<%=a.getFreeword9() %>:<%=a.getFreeword10() %></p>
<% } %>
<% } %>
</body>
</html>