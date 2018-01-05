<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import= "java.sql.*" %>
<%@ page import= "java.util.*" %>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>admin_create_table</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}resources/css/common.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}resources/css/admin_main.css" />
</head>
<body>
<div id="wrapper">
	<header id="admin_header">
		<h1 >관리자페이지 메인</h1>
	</header>
	<aside id="admin_aside">
		<a id="member_mgmt_link">회원관리</a>
	</aside>
	<section id="admin_section">
		<h1>회원관리</h1>
		<table id="admin_section_table">
			<tr>
			<td id="member_search" colspan="8">
				<select style="margin 0px auto;" name="menu">
				<option value="">검색</option>
				<option value="name">이름</option>
				<option value="gender">성별</option>
				</select>
				<input type="text" placeholder="검색어 입력" />
				<button>검색</button>
			</td>
			</tr>
			<tr>
				<th>NO</th>
				<th>ID</th>
				<th>이 름</th>
				<th>생년월일</th>
				<th>성 별</th>
				<th>핸드폰번호</th>
				<th>이메일</th>
				<th>주 소</th>
			</tr>	
			<tr>
				<td id="add_member_td" colspan="8">
					<button id="member_register_form_btn">추가</button>
				</td>
			</tr>
		</table>
	</section>
</div>		
</body>
<script>

</script>
</html>