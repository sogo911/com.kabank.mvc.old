<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.kabank.mvc.domain.MemberBean" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>JOIN</title>
	<link rel="stylesheet" href="${css}/common.css" />
	<link rel="stylesheet" href="${css}/member.css" />
</head>
<body>
<div id="wrapper">
	<header id="join_header">
		<a href="${ctx}/user.do">HOME</a>
	</header>
	<section>
		<article>
			<header id="join_second_header">
				<hgroup>
					<h1>MEMBER JOIN</h1>
					<h2>일반회원가입</h2>
				</hgroup>
			</header>
		</article>
		<form id="join_form" action="${ctx}/user.do">
			<table id="join_table">
				<tr>
					<td>아이디</td>
					<td>
						<input  id=join_id name="id" type="text" required/>
						<button id="id_check_dupl_btn" name="id_check_dupl_btn" >아이디 중복 확인</button>
					</td>
				</tr>
				<tr>
					<td>이름</td>
					<td>
					 	<input type="text" name="name" /> 
					 	* 반드시 실명을 입력해 주세요.
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
					 	<input id=join_pass pattern="[0-9]{4}" type="password" name="pass" required/> 
					 	* 비밀번호는 숫자로만 4자리 입니다.
					</td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td>
					<input type="password" name="repass"/> 
					</td>
				</tr>
				<tr>
					<td>이메일</td>
					<td>
						<input type="email" name="email"/> 
					</td>
				</tr>
				<tr>
				<td>가입일</td>
				<td>
				<input type="date"/>
				</td>
				</tr>
				<tr>
					<td>주민번호</td>
					<td>
					 <input  pattern="[0-9]{7}" type="text" name="ssn"/> 
					 * - 제외하고 생년월일과 앞번호만 입
					</td>
				</tr>
				<tr>
					<td>핸드폰번호</td>
					<td>
					<input pattern="[0-9]" type="tel" name="phone"/>
					* - 제외하고 입력
					</td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<input type="text" name="addr"/> 
						<input type="submit" name="addr_search" value="주소 검색"/>
					</td>
				</tr>
				<tr>
					<td>
					</td>
					<td>
						<button id=check_dupl_btn>확 인</button> 
						<button>취 소</button> 
					</td>
				</tr>
			</table>
			<input type="hidden" name="cmd" value="join" />
			<input type="hidden" name="dir" value="user" />
			<input type="hidden" name="page" value="login" />
		</form>
	</section>
	<aside>
	
	</aside>
</div>
<%@ include file="../common/footer.jsp" %>
<script>
document.querySelector('#check_dupl_btn').addEventListener("click",function (){
	alert('로그인으로 이동');
	document.querySelector('#join_form').submit();
},false);

</script>
</body>
</html>