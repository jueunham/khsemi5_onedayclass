<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/views/layout/header.jsp" />

	<br> <br> <br>
	<div style="text-align: center">
		<span style="font-weight: bold"><h1>Oneday Class</h1></span>
		<span style="font-weight: bold"><h3>회원가입</h3></span><br><br>
		
		<h3>회원가입이 완료되었습니다</h3>
		<button type="button" id="btnLogin" class="btn btn-primary" onclick = 'location.href = "/reservation/main";'>
	메인으로
	</button>
	</div><br><br>

<c:import url="/WEB-INF/views/layout/footer.jsp" />
