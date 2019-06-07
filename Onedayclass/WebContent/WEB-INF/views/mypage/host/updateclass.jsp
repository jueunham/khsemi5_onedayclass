<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">


<c:import url="/WEB-INF/views/layout/header.jsp" />

<div class="container">

<div class="row">
<c:import url="/WEB-INF/views/mypage/host/menu.jsp" />


<div class="col order-1">
<table>
<tbody>
<tr>
<td style="width:200px; height:50px; background:lightgray; text-align:center;">
마이 클래스 수정/삭제
</td>
</tr>
<!-- 수강 클래스 리스트 목록을 불러서 스크롤바로 처리할 예정 -->
<c:forEach items="${myclasslist}" var="i">
	<tr>
		<!-- 임의지정 -->
		<td style="width: 40%;"><img src="/resources/images/Tulips.jpg" style="width:250px; height:200px; padding:10px;" ></td>
		<td>
		<td style="width: 30%;">클래스 명 :  ${i.classname }</td>
		<td style="width: 20%;">수업일 : ${i.classday }</td>
		<td style="width: 10%;">
			<button id=btnUpdate class="btn btn-dark float-right" onclick="location.href='/mypage/host/upclassdetail?classnum=${i.classnum }'">수정</button>
			&nbsp;
			<button id=btnDelete class="btn btn-dark float-right" onclick="location.href='/mypage/host/deleteclass'">삭제</button>
		</td>
	</tr>
</c:forEach>


</tbody>
</table>

</div>

</div>

<div id="pagingBox">
<c:import url="/WEB-INF/views/layout/hostclassPaging.jsp" />
</div>
</div>
<br>
<br>
<br>
<br><br>
<br>
<c:import url="/WEB-INF/views/layout/footer.jsp" />
