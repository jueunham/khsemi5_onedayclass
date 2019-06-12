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
<div style="width:200px; height:40px; background:lightgray; text-align:center;">
<h4>내가 작성한 글</h4>
</div>
<br>
<table>
<tbody>
<tr>
<td style="background:lightgray;">클래스 후기 답글</td>
</tr>
<!-- 작성글 목록을 불러서 스크롤바로 처리할 예정 -->
<%-- <c:forEach items="${list}" var="i"> --%>
	<tr>
		<!-- 임의지정 -->
		<td><img src="/resources/images/Tulips.jpg" style="width:250px; height:200px; padding:10px;" ></td>
		<td>클래스 명 :  ${i.className }</td>
		<td>작성일자 : ${i.writtenDate }</td>
	</tr>
<%-- </c:forEach> --%>

<tr>

<td style="background:lightgray;">클래스 질문 답글</td>
</tr>
<!-- 질문글 목록을 불러서 스크롤바로 처리할 예정 -->
<%-- <c:forEach items="${list}" var="i"> --%>
	<tr>
		<!-- 임의지정 -->
		<td><img src="/resources/images/Tulips.jpg" style="width:250px; height:200px; padding:10px;" ></td>
		<td>클래스 명 :  ${i.className }</td>
		<td>작성일자 : ${i.writtenDate }</td>
	</tr>
<%-- </c:forEach> --%>
</tbody>
</table>
<hr>
내가 쓴 게시글
<table class="table table-striped table-hover table-condensed">

<thead>
	<tr>
		<th style="width: 10%;">No</th>
		<th style="width: 15%;">게시판</th>
		<th style="width: 40%;">제목</th>
		<th style="width: 15%;">작성일</th>
	</tr>
</thead>

<tbody>
<%-- <c:forEach items="${list}" var="i"> --%>
	<tr>
		<td>${i.boardno }</td>
		<td>${i.boardtypeNum }</td>
		<td><a href="/board/view?boardno=${i.boardno }">${i.title }</a></td>
		<td><fmt:formatDate value="${i.writtenDate }" pattern="yyyy-MM-dd" /></td>
	</tr>
<%-- </c:forEach> --%>
</tbody>

</table>
</div>

</div>

</div>
<br>
<br>
<br>
<br><br>
<br>
<c:import url="/WEB-INF/views/layout/footer.jsp" />
