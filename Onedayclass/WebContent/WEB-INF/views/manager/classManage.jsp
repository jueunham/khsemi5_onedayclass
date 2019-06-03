<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<style type="text/css">

	 div {
        text-align: center;
      }    
        
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

<div>
<h2>클래스관리</h2>
<hr>
</div>

<div class="container">

<div class="float-right">
	<input type="text" i placeholder="클래스명 검색">
	<button>검색</button>
</div>


<br><br>
<table class="float-center">
	<thead>
		<tr bgcolor = #bcbcbc align="center">
			<th style="width:20%;">클래스 번호</th>
			<th style="width:20%;">회원번호(호스트)</th>
			<th style="width:50%;">클래스명</th>		
			<th style="width:10%;">선택</th>
		</tr>
	</thead>
	
	<tbody>
	<c:forEach items="${classlist}" var="i">
		<tr align="center">
			<td>${i.classnum }</td>
			<td>${i.usernum }</td>
			<td>${i.classname }</td>
			<td><input type="checkbox" id="ck"></td>
		</tr>
	</c:forEach>	
	</tbody>
</table>
<br><br>
<div id="btnBox" class="float-right">
	<button id="btnAccept" class="btn btn-primary">수락</button>	

	<button id="btnDelete" class="btn btn-primary">삭제</button>
</div>

</div>
<br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br>

<c:import url="/WEB-INF/views/layout/footer.jsp" />