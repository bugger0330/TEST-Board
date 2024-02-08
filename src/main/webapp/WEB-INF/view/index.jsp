<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/css/board.css" rel="stylesheet">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<div class="main">
	<div class="header">
		<div class="menu">홈</div>
		<div class="menu">로그인</div>
		<div class="menu">회원가입</div>
	</div>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>내용</th>
				<th>작성자</th>
				<th></th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	<div class="btn-box">
		<button type="button" class="insert-btn">글 등록</button>
	</div>
</div>
	<script type="text/javascript" src="/js/header.js"></script>
	<script type="text/javascript" src="/js/board.js"></script>
</body>
</html>