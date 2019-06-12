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
<table>
<tbody>
<tr>
<td style="width:200px; height:50px; background:lightgray; text-align:center;">
찜한 클래스
</td>
</tr>
<!-- 찜한 클래스 리스트 목록을 불러서 스크롤바로 처리할 예정 -->
<c:forEach items="${list}" var="i">
	<tr>
		<!-- 임의지정 -->
		<td><img src="/resources/images/Tulips.jpg" style="width:250px; height:200px; padding:10px;" ></td>
		<td>클래스 명 :  ${i.className }</td>
		<td>수강료 : ${i.classPrice }</td>
	</tr>
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
