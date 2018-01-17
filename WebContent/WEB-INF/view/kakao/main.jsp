<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<link rel="stylesheet" href="${css}/common.css" />
</head>
<body>
<div id="wrapper">
<%@ include file="../common/header.jsp" %>
<%@ include file="../common/nav.jsp" %>
<section>
<article>
<h1>카카오 뱅크 메인</h1>
<button id="kakao_make_btn">통장개설</button>
<button>입금</button>
<button>출금</button>
<button>송금</button>
<button>통장해지</button>
</article>
</section>
<aside></aside>

<%@ include file="../common/footer.jsp" %>
</div>>
</body>
<script>
document.querySelector('#kakao_make_btn').addEventListener("click",
		function(){
	alert('통장개설');
	location.href = "${ctx}/kakao.do?cmd=make_kakao&dir=user&page=mypage";
},false);
</script>
</html>