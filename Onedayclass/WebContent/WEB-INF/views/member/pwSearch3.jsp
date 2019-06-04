<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<br><br><br>
	<div class="form-group">
		<div style="text-align: center;">
		<h3>비밀번호 찾기</h3>
		</div>
	</div>
	
	<br><br>
	
	<div style="text-align: center;">
		<h2>비밀번호 변경을 완료하였습니다</h2>
		</div>

	<br><br>
	
	<div style="text-align: center;">
	<button type="button" id="btnLogin" class="btn btn-secondary" onclick = 'location.href = "/member/login";'>
	&nbsp;로그인 화면으로&nbsp;
	</button>
	<br><br>
	</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />
