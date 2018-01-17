<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import= "java.util.*" %>
<%
Statement stmt = null;
Connection conn = null;
ResultSet rs = null;
String sql = "";
try{
	Class.forName("oracle.java.driver.OracleDriver");
	conn = DriverManager
			.getConnection("jdbc:oracle:thin:@localhost:1521:xe","bitcamp","bitcamp");
	stmt = conn.createStatement();
	sql = "SELECT * FROM tab";
	rs = stmt.executeQuery(sql);
	List<String> list = new ArrayList<>();
	while(rs.next()){
		String temp = rs.getString("TNAME");
		list.add(temp);
	}
	boolean exist = false;
	for(String s : list){
		if(s.equalsIgnoreCase("attend")){
			exist = true;
			break;
		}
	}
		
	if(!exist){
		stmt.executeUpdate("CREATE TABLE Attend("
				+"id VARCHAR2(20) PRIMARY KEY,"
				+"week VARCHAR2(10),"
				+"status VARCHAR2(10)"
				+")"); 
	}
}catch(Exception e){
	e.printStackTrace();
}
%>
<!doctype html>
<html lang="en">
<head>
<link rel="stylesheet" href="${css}/common.css" />
<link rel="stylesheet" href="${css}/bitcamp.css" />
</head>
<body>
<%@ include file="../common/header.jsp" %>	
<%@ include file="../common/nav.jsp" %>
<div id="wrapper">
<form id="main_form" action="${ctx}/user.do">
<section>
<article>
	<h1>비트캠프 메인</h1>
	<table id = "main_profil_table">
		<tr id = "main_profil_tr">
			<td rowspan="5">
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
	</table>
</article>
<article>
	<table>
		<tr>
			<th>월</th>
			<th>화</th>
			<th>수</th>
			<th>목</th>
			<th>금</th>
		</tr>
		<tr>
			<td>
			<select name="monday" id="">
			<option value="a">결석</option>
			<option value="b">지각</option>
			<option value="c">조퇴</option>
			<option value="d">출석</option>
			</select>
			</td>
			<td>
			<select name="tuesday" id="">
			<option value="a">결석</option>
			<option value="b">지각</option>
			<option value="c">조퇴</option>
			<option value="d">출석</option>
			</select>
			</td>
			<td>
			<select name="wednesday" id="">
			<option value="a">결석</option>
			<option value="b">지각</option>
			<option value="c">조퇴</option>
			<option value="d">출석</option>
			</select>
			</td>
			<td>
			<select name="thursday" id="">
			<option value="a">결석</option>
			<option value="b">지각</option>
			<option value="c">조퇴</option>
			<option value="d">출석</option>
			</select>
			</td>
			<td>
			<select name="friday" id="">
			<option value="a">결석</option>
			<option value="b">지각</option>
			<option value="c">조퇴</option>
			<option value="d">출석</option>
			</select>
			</td>
		</tr>
		<tr>
			<td>ㅇ</td>
			<td>ㅇ</td>
			<td>ㅇ</td>
			<td>ㅇ</td>
			<td>ㅇ</td>
		</tr>
	</table> 
</article>
</section>
</form>
				<button id="attend_result_btn" >확 인</button>
				<button id="pass_change_btn" >비밀번호 변경</button>
				<button id="delete_btn">탈 퇴</button>
<%@ include file="../common/footer.jsp" %>
</div>
</body>
<script>
document.querySelector('#pass_change_btn').addEventListener("click",changePass,false);
function changePass(){
	alert('비밀번호 변경으로 이동');
	location.href = "${ctx}/user.do?cmd=move&page=change_pass";
}
document.querySelector('#delete_btn').addEventListener("click",function(){
	alert('회원 탈퇴 / 로그인으로 이동');
	location.href = "${ctx}/user.do?cmd=delete_member"
	}
	,false);
</script>
</html>