<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h3>게시글 상세보기</h3>
<table>
	<tr>
		<th>Writer</th>
		<td>${board.name }</td>
		<th>Email</th>
		<td>${board.email }</td>
	</tr>
	<tr>
		<th>Regidate</th>
		<td>${board.writedate }</td>
		<th>Email</th>
		<td>${board.readcount }</td>
	</tr>
	<tr>
		<th>Title</th>
		<td colspan="3">${board.title }</td>
	</tr>
	<tr>
		<th>Content</th>
		<td colspan="3">${board.content }</td>
	</tr>
</table>
<br><br/>
<input type="button" value="게시글 수정" onclick="open_win('BoardServlet?command=board_check_pass_form&num=${board.num}', 'update')" />
<input type="button" value="게시글 삭제" onclick="open_win('BoardServlet?command=board_check_pass_form&num=${board.num}', 'delete')" />
<input type="button" value="게시글 리스트" onclick="location.href='BoardServlet?command=board_list'" />
<input type="button" value="게시글 등록" onclick="location.href='BoardServlet?command=board_write_form'" />
</div>

</body>
</html>