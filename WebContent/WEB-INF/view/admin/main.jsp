<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>admin_main</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/admin_main.css" />
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
				<td>
					<button id="go_admin_create_btn">테이블 생성</button>
				</td>
				<td>준비중</td>
				<td>준비중</td>
			</tr>
			<tr>
				<td>
					테이블 생성 <br />
					<form id = "create_form" action="${pageContext.request.contextPath}/admin/create_table.do">
					<select name="table_name" id="table_name">
						<option value="member"> 회 원
						<option value="attend"> 출 석
						<option value="kakao_bank"> 은 행
					</select>
					<button id= "create_btn">생 성</button>
					</form>
				</td>
				<td>준비중</td>
				<td>준비중</td>
			</tr>
		</table>
	</section>
</div>		
</body>
<script>
document.querySelector('#create_btn').addEventListener("click",createForm,false);
function createForm() {
	alert('테이블 생성')
	document.querySelector('#create_form').submit();
}
</script>
</html>