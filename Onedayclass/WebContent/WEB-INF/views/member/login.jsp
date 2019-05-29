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
		$("#btnLogin").click(function() {
			$(this).parents("form").submit();
		})

	});
</script>

<form action="/member/login" method="post" class="form-horizontal">

	<br>
	<br>
	<br>
	<br>
	<div style="text-align: center">
		<h1>Oneday Class</h1>
		<br>
	</div>

	<div style="text-align: center">
		<input type="radio" name="type" value="호스트" /> 호스트 <input
			type="radio" name="type" value="게스트" checked /> 게스트 <br>
	</div>

	<div class="form-group">
		<div style="text-align: center">
			<input type="text" id="userid" name="userid" placeholder=" ID" />
		</div>
	</div>
	<div class="form-group">
		<div style="text-align: center">
			<input type="text" id="userpw" name="userpw" placeholder=" PASSWORD" />
		</div>
	</div>

	<div style="text-align: center">
		<button type="button" id="btnLogin" class="btn btn-secondary">로그인</button>
		<br>
		<br>
	</div>

	<div style="text-align: center">
		<a href="idSerch.jsp">아이디 찾기</a>&nbsp;&nbsp;&nbsp;
		<a href="pwSerch1.jsp">비밀번호 찾기</a>&nbsp;&nbsp;&nbsp;
		<a href="join.jsp">회원가입</a>
	</div>
	<br>


</form>

<c:import url="/WEB-INF/views/layout/footer.jsp" />
