<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.kabank.mvc.domain.MemberBean" %>
<!DOCTYPE html>	
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>JOIN</title>
	<link rel="stylesheet" href="${css}/common.css" />
</head>
<body>
<div id="wrapper">
<form id="change_pass_form" action="${ctx}/user.do">
	<section>
		<article>
			<header id="join_second_header">
				<hgroup>
					<h1>비밀번호 변경</h1>
				</hgroup>
			</header>
			<table>
			<tr>
				<td>현재 비밀번호</td>
				<td>
					<input id="now_pass" type="password" name="nowPass" value ="${sessionScope.user.pass}"/>
				</td>
			</tr>
			<tr>
				<td>변경 비밀번호</td>
				<td>
					<input id="change_pass" type="password" name="changePass" />
				</td>
			</tr>
			<tr>
				<td>변경 비밀번호 확인</td>
				<td>
					<input id="confirm_pass" type="password" />
				</td>
			</tr>
			</table>
		</article>
	</section>
	<input type="hidden" name="cmd" value="change_pass" />
	<input type="hidden" name="dir" value="bitcamp" />
	<input type="hidden" name="page" value="main" />
</form>	
					<button id="confirm_btn">확 인</button>
					<button id="cancel_btn">취 소</button>
					
	<aside>
	
	</aside>
</div>
<%@ include file="../common/footer.jsp" %>
<script>
document.querySelector('#confirm_btn').addEventListener("click",function (){
	alert('비밀번호 변경 완료');
	document.querySelector('#change_pass_form').submit();
	}
	,false);
document.querySelector('#cancel_btn').addEventListener("click",function (){
	alert('비밀번호 변경 취소');
	location.href ="${ctx}/user.do?cmd=move&dir=bitcamp&page=main";
	}
	,false);

</script>
</body>
</html>