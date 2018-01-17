<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav id="nav">
		<ul style="height :10%">
			<li style="width: 15%; text-align: center;">
			<a id="bugerking" href="#">버거킹</a></li>
			<li style="width: 15%; text-align: center;">
			<a id="kakao" href="${ctx}/kakao.do?page=main">카카오뱅크</a></li>
			<li style="width: 15%; text-align: center;">
			<a id="bitcamp" href="${ctx}/user.do?cmd=move&dir=bitcamp&page=main">비트캠프</a></li>
			<li style="width: 15%; text-align: center;">
			<a id="sktellecom" href="#">SK 텔레콤</a></li>
			<li style="width: 15%; text-align: center;">
			<a id="lotto" href="#">로또</a></li>
			<li style="width: 15%; text-align: center;">
				<a id="mypage" href="${ctx}/user.do?cmd=move&page=mypage">마이페이지</a>
			</li>
			<li style="width: 15%; text-align: center;">
				<a id="logout" href="">로그아웃</a>
			</li>
		</ul>
</nav>