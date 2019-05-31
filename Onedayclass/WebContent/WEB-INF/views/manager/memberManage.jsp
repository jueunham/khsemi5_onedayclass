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
	width: 1100px;
	height: 100px;
	}
	
	#ck{ 
	width : 20px; 
	height: 20px; 
	border: bold; 
	}
	

	 
</style>

<div align="center">
<h2>회원관리</h2>
<hr>
</div>

<div class="container">
<div id="serch" class="float-right">
	<input type="text" i placeholder="회원명 검색">
	<button>검색</button>
</div>

<br><br>

<table class="float-center">
	<thead>
		<tr bgcolor = #bcbcbc align="center">
			<th style="width:20%;">회원 번호</th>
			<th style="width:20%;">회원ID</th>
			<th style="width:50%;">회원이름</th>		
			<th style="width:10%;">선택</th>
		</tr>
	</thead>
	
	<tbody>
	<c:forEach items="${memlist }" var="i">
		<tr align="center">
			<td>${i.usernum }</td>
			<td>${i.userid }</td>
			<td>${i.username }</td>
			<td><input type="checkbox" id="ck"></td>
		</tr>
	</c:forEach>	
	</tbody>
</table>

<br>
<div id="btnBox" class=float-right>
	<button id="btnDelete" class="btn btn-primary">삭제</button>
</div>
</div>

<br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br>

<c:import url="/WEB-INF/views/layout/footer.jsp" />