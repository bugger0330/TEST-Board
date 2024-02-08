<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/css/save.css" rel="stylesheet">
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
			<tr>
				<th>아이디</th>
				<td>
					<input type="text">
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password">
				</td>
			</tr>
			<tr>
				<th>비밀번호 확인</th>
				<td>
					<input type="password">
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<button type="button">회원가입</button>
				</th>
			</tr>
		</table>
	</div>
	<script type="text/javascript" src="/js/header.js"></script>
	<script type="text/javascript" src="/js/signup.js"></script>
</body>
</html>