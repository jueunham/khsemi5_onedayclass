<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
	$(document).ready(function() {

		//페이지 첫 접속 시 입력창으로 포커스 이동
		$("input").eq(0).focus();

		//패스워드 입력 창에서 엔터 입력 시 form submit
		$("input").eq(1).keydown(function(key) {
			if (key.keyCode == 13) {
				$(this).parents("form").submit();
			}
		})

		//로그인 버튼 클릭 시 form submit
		$("#btnJoin").click(function() {
			$(this).parents("form").submit();
		})

	});
</script>

<form action="/member/join" method="post" class="form-horizontal">

	<br> <br> <br>
	<div style="text-align: center">
		<span style="font-weight: bold"><h1>Oneday Class</h1></span>
		<span style="font-weight: bold"><h3>회원가입</h3></span><br>
		<span style="color: red">회원가입</span><span style="font-weight: bold">을 하시면 Oneday class의</span><br> <span style="font-weight: bold">모든</span>
		<span style="color: red">서비스</span><span style="font-weight: bold">를 이용하실 수 있습니다</span><br><br>

		<div style="text-align: center">
			<input type="radio" name="type" value="호스트" /> 호스트 <input
				type="radio" name="type" value="게스트" checked /> 게스트 <br>
		</div>
		
	</div>

	<div class="form-group">
		<div style="text-align: center; margin-left: 85px;">
			<input type="text" id="username" name="username" placeholder=" Name" />
			<button type="button" id="btnLogin" class="btn btn-secondary">실명인증</button>
		</div>
		
	</div>

	<div class="form-group">
		<div style="text-align: center">
			<input type="email" id="userid" name="userid" placeholder=" Email" />
		</div>
	</div>

	<div class="form-group">
		<div style="text-align: center">
			<input type="text" id="userpw" name="userpw" placeholder=" Password" />
		</div>
	</div>

	<div class="form-group">
		<div style="text-align: center">
			<input type="text" id="userpw" name="userpw"
				placeholder=" Confirm Password" />
		</div>
	</div>

	<div class="form-group">
		<div style="text-align: center">
			<input type="text" id="phonenumber" name="phonenumber"
				placeholder=" Phone Number" />
		</div>
	</div>

	<div style="text-align: center">
	<input type = 'checkbox' value = 'termofservice' />
	<span>
	<a href="/info/termOfService.jsp">
	이용약관 </a></span>및 
	<span>
	<a href="/info/privacyPolicy.jsp">
	개인정보 취급방침</a></span>
	</div><br>
	
	<div style="text-align: center">
	<button type="button" id="btnLogin" class="btn btn-secondary" onclick = 'location.href = "/member/interList";'>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	NEXT
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</button>
	<br><br>
	</div>
	
</form>
<c:import url="/WEB-INF/views/layout/footer.jsp" />
