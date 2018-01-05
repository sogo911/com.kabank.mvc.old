<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>main</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css" />
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/img/Penguin_4.ico"/>
</head>
<body>
<div id="wrapper">
	<header id="index_header">
		<a id="go_home" href="#">HOME</a>
		<h1>BIT CAMP SAMPLE REPORT</h1>
	</header>
	<section>
		<article>
			<table id="index_table">
				<tr>
					<td id = index_join colspan="5">
						<form id = login_form action="${pageContext.request.contextPath}/user/auth.do">
							<table id="index_login_box" >
			 					<tr>
			 						<td> 
			 						<input id="index_input_id" type="text" name="id" placeholder="id"/>
			 						</td>
			 						<td id="index_input_btn" rowspan="2">
				 						<button id="index_login_btn">로그인</button>
									</td>
			 					</tr>
			 					<tr>
			 						<td >
			 						<input id="index_input_pw" type="password" name="pass" placeholder="pw"/>
			 						</td>
			 					</tr>			 				
			 				</table>
						</form>
						<a id="go_admin_link" href="#">
							관리자
						</a> <br />
						<a id="go_join_link" href="#">
							회원가입
						</a>
						<a id="go_jdbc_link" href="#">
							JDBC TEST
						</a>
					</td>
				</tr>
			</table>	
		</article>
	</section>
</div>
<%@ include file="../common/footer.jsp" %>
<script>
document.querySelector('#go_join_link').addEventListener("click",
function() {
			alert('회원가입으로 이동');
			location.href = "${pageContext.request.contextPath}/user/join.do";},false);
							<%-- <%=application.getContextPath()%> --%>
document.querySelector('#go_jdbc_link').addEventListener("click",aaa,false);
function aaa(){
	alert('JDBC TEST로 이동');
	location.href = "${pageContext.request.contextPath}/common/jdbc_test.do";
	}
document.querySelector('#index_login_btn').addEventListener("click",login,false);
function login() {
	alert('비트캠프로 이동');
	document.querySelector('#login_form').submit();
}
document.querySelector('#go_admin_link').addEventListener("click",admin,false);
function admin() {
	alert('관리자로 이동');	
	location.href = "${pageContext.request.contextPath}/admin/main.do";
}
</script>
</body>
</html>