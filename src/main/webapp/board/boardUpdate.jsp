<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/shopping.css" />
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
<div id="wrap" align="center">
<h3>게시글 등록</h3>
<form action="BoardServlet" method="post" name="frm">
<input type="hidden" name="command" value="board_update">
<input type="hidden" name="num" value="${board.num} }">
<table>
	<tr>
		<th>Writer</th>
		<td><input type="text" name="name" value=${board.name }>*필수</td>
	</tr>
	<tr>
		<th>Password</th>
		<td><input type="password" name="pwd">*필수(게시물 수정 삭제시 필요)</td>
	</tr>
	<tr>
		<th>Email</th>
		<td><input type="text" name="email" value=${board.email }></td>
	</tr>
	<tr>
		<th>Title</th>
		<td><input type="text" name="title" size="70" value=${board.title }>*필수</td>
	</tr>
	<tr>
		<th>Content</th>
		<td><textarea rows="15" cols="70" name="content">${board.content }</textarea></td>
	</tr>
</table>
<br><br />
<input type="submit" value="Save" onclick="return boardCheck()" />
<input type="reset" value="Re write" />
<input type="button" value="List" onclick="location.href='BoardServlet?command=board_list'" />
</form>
</div>
</body>
</html>