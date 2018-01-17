<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<link rel="stylesheet" href="${css}/common.css" />
</head>
<body>
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
<div id="wrapper">
<section>
<article>
<h1>마이페이지</h1>
<table id = "main_profil_table">
		<tr id = "main_profil_tr">
			<td rowspan="6">
			사진</td>
		</tr>
		<tr>
			<td class="column">ID</td>
			<td>${sessionScope.user.id}</td>
			<td class="column">생년월일</td>
			<td>${sessionScipe.user.ssn}</td>
		</tr>
		<tr>
			<td class="column">PW</td>
			<td>${sessionScope.user.pass}</td>
			<td class="column">전화번호</td>
			<td>${sessionScope.user.phone}</td>
		</tr>
		<tr>
			<td class="column">이름</td>
			<td>${sessionScope.user.name}</td>
			<td class="column">이메일</td>
			<td>${sessionScope.user.email}</td>
		</tr>
		<tr>
			<td class="column">성별</td>
			<td></td>
			<td class="column">주소</td>
			<td>${sessionScope.user.addr}</td>
		</tr>
		<tr>
			<td class="column">계좌번호</td>
			<td>${sessionScope.user.account}</td>
			<td class="column">준비중</td>
			<td></td>
		</tr>
	</table>
	<button id="pass_change_btn" >비밀번호 변경</button>
	<button id="delete_btn">탈 퇴</button>
</article>
</section>
</div>
</body>
</html>