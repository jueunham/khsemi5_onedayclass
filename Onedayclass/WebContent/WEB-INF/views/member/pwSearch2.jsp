<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<br><br><br>
	<div class="form-group">
		<div style="text-align: center; margin-left: 20px;">
		<h3>비밀번호 찾기</h3>
		</div>
	</div>

	<div class="form-group">
		<div style="text-align: center; margin-left: 60px;" >비밀번호 :
			<input type="text" id="userPw" name="userPw" placeholder=" Password" />
		</div>
	</div>
	
	<div class="form-group">
		<div style="text-align: center; margin-left: 30px;" >비밀번호 확인 :
			<input type="email" id="userPw" name="userPw" placeholder=" confirm Password" />
		</div>
	</div>
	
		<div style="text-align: right; margin-right: 415px;">
	<button type="button" id="btnLogin" class="btn btn-secondary" onclick = 'location.href = "/member/pwSerch3";'>
	&nbsp;NEXT>&nbsp;
	</button>
	<br><br>
	</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />
