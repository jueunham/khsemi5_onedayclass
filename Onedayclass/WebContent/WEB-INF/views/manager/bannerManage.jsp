<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<style type="text/css">

	 th, td{
		border:1px solid #bcbcbc;
		}

	table {
	align : center;
	border: 1px solid #ccc;
	width: 500px;
	height: 100px;
	}
	
	#ck{ 
	width : 20px; 
	height: 20px; 
	border: bold; 
	}
	 
</style>

<div align="center">
<h2>인기클래스배너관리</h2>
<hr>
</div>

<div class="container">

<table >
	<thead>
		<tr bgcolor = #bcbcbc align="center">
			<th style="width:20%;">클래스번호</th>
			<th style="width:20%;">클래스명</th>
			<th style="width:20%;">호스트</th>  <!-- 회원번호 불러오기 -->
			<th style="width:10%;">선택</th>
		</tr>
	</thead>
	
	<tbody>
	<c:forEach items="${classlist}" var="i">
		<tr align="center">
			<td>${i.classnum }</td>
			<td>${i.classname }</td>
			<td>${i.usernum }</td>
			<td><input type="checkbox" id="ck"></td>
		</tr>
	</c:forEach>	
	</tbody>
</table>

<table >
	<thead>
		<tr bgcolor = #bcbcbc align="center">
			<th style="width:20%;">클래스번호</th>
			<th style="width:20%;">클래스명</th>
			<th style="width:20%;">호스트</th>  <!-- 회원번호 불러오기 -->
			<th style="width:10%;">선택</th>
		</tr>
	</thead>
	
	<tbody>
	<c:forEach items="${classlist}" var="i">
		<tr align="center">
			<td>${i.classnum }</td>
			<td>${i.classname }</td>
			<td>${i.usernum }</td>
			<td><input type="checkbox" id="ck"></td>
		</tr>
	</c:forEach>	
	</tbody>
</table>
</div>






<br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br>

<c:import url="/WEB-INF/views/layout/footer.jsp" />