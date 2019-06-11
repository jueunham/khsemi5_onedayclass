<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">


<c:import url="/WEB-INF/views/layout/header.jsp" />

<div class="container">

<div class="row">
<c:import url="/WEB-INF/views/mypage/user/menu.jsp" />


<div class="col order-1">

<div style="width:200px; height:30px; background:lightgray; text-align: center;">
<h5>내가 작성한 글</h5>
</div>
<br>

<table>
<tbody>
<tr>
<td style="background:lightgray;">클래스 후기</td>
</tr>
<!-- 작성글 목록을 불러서 스크롤바로 처리할 예정 -->
<c:forEach items="${reviewList }" var="i">
<%-- <c:if test="${usernum }"> --%>
	<tr>
		<!-- 임의지정 -->
		<td><img src="/resources/images/Tulips.jpg" style="width:250px; height:200px; padding:10px;" ></td>
		<td>
			클래스 명 :  ${i.className }<br>
			작성일자 : <fmt:formatDate value="${i.reviewDate }" pattern="yyyy-MM-dd"/>
		</td>
	</tr>
<%-- </c:if> --%>
</c:forEach>

<tr>

<td style="background:lightgray;">클래스 질문</td>
</tr>
<!-- 질문글 목록을 불러서 스크롤바로 처리할 예정 -->
<c:forEach items="${quesList }" var="i">
<%-- <c:if test="${usernum }"> --%>
	<tr>
		<!-- 임의지정 -->
		<td><img src="/resources/images/Tulips.jpg" style="width:250px; height:200px; padding:10px;" ></td>
		<td>
			클래스 명 :  ${i.className }<br>
			작성일자 : <fmt:formatDate value="${i.quesDate }" pattern="yyyy-MM-dd"/>
		</td>
	</tr>
<%-- </c:if> --%>
</c:forEach>
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

<c:forEach items="${boardList }" var="i">
<%-- <c:if test="${usernum }"> --%>
	<tr>
		<td>${i.boardno }</td>
		<td>${i.boardtypenum }</td>
		<td><a href="/board/view?boardno=${i.boardno }">${i.title }</a></td>
		<td><fmt:formatDate value="${i.writedate }" pattern="yyyy-MM-dd" /></td>
	</tr>
<%-- </c:if> --%>
</c:forEach>

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
