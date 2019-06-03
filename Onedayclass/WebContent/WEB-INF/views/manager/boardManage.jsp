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
	width: 1000px;
	height: 100px;
	}
	
	#ck{ 
	width : 20px; 
	height: 20px; 
	border: bold; 
	}
	 
</style>

<div align="center">
<h2>게시판관리</h2>
<hr>
</div>

<div class="container">

<div id="btnboard" class="float-left">
	<button id="btnnotice" class="btn btn-info">공지사항</button>	
	<button id="btnbulletim" class="btn btn-info">자유게시판</button>
	<button id="btnreport" class="btn btn-info">신고게시판</button>
</div>
<div id="serch" class="float-right">
	<input type="text" i placeholder="게시글 검색">
	<button>검색</button>
</div>

<br><br>
<table class = "table table-bordered">
	<thead>
		<tr bgcolor = #bcbcbc align="center">
			<th style="width:20%;">게시판 분류</th>
			<th style="width:20%;">글 번호</th>
			<th style="width:20%;">작성자 회원번호</th>
			<th style="width:30%;">작성일자</th>		
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
	<button id="btnAccept" class="btn btn-primary">수정</button>	

	<button id="btnDelete" class="btn btn-primary">삭제</button>
</div>

</div>
<br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br>


<c:import url="/WEB-INF/views/layout/footer.jsp" />