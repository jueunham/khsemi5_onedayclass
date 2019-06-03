<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	// 공지사항 버튼 동작
	$("#btnNotice").click(function() {
		location.href="/WebContent/WEB-INF/views/manager/boardManage/noticeManage.jsp";
	});
	// 자유게시판 버튼 동작
	$("#btnBulletin").click(function() {
		location.href="/WebContent/WEB-INF/views/manager/boardManage/bulletinManage.jsp";
	});
	// 신고게시판 버튼 동작
	$("#btnReport").click(function() {
		location.href="/WebContent/WEB-INF/views/manager/boardManage/reportManage.jsp";
	});
	//글쓰기 버튼 누르면 이동
	$("#btnWrite").click(function() {
		location.href="/admin/boardManage/write";
	});
	
	//수정버튼 동작
	$("#btnUpdate").click(function() {
		$(location).attr("href","/admin/boardManage/update?boardno=${viewBoard.boardno}")
	});

	//삭제버튼 동작
	$("#btnDelete").click(function() {
		$(location).attr("href","/admin/boardManage/delete?boardno=${viewBoard.boardno}")
	});
	
});

</script>
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

}
	 
</style>

<div align="center">
<h2>게시판관리</h2>
<hr>
</div>

<div class="container">

<div id="btnboard" class="float-left">
	<button id="btnnotice" class="btn btn-info">공지사항</button>	
	<button id="btnbulletin" class="btn btn-info">자유게시판</button>
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
	<c:forEach items="${boardlist}" var="i">
		<tr align="center">
			<td> <c:choose> 
					<c:when test = "${i.boardtypenum ==1}">
						공지사항
					</c:when>
					<c:when test = "${i.boardtypenum ==2}">
						자유게시판
					</c:when>
					<c:when test = "${i.boardtypenum ==3}">
						신고게시판
					</c:when>
				</c:choose>
			</td>
			<td>${i.boardno}</td>
			<td>${i.usernum}</td>
			<td><fmt:formatDate value="${i.writedate}" pattern="yyyy-MM-dd"/></td>
			<td><input type="checkbox" id="ck"></td>
		</tr>
	</c:forEach>	
	</tbody>
</table>
<br><br>
<div id="btnBox" class="float-right">
	<button id="btnWrite" class="btn btn-primary">글쓰기</button>
	<button id="btnUpdate" class="btn btn-primary">수정</button>	
	<button id="btnDelete" class="btn btn-primary">삭제</button>
</div>

</div>
<br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br>


<c:import url="/WEB-INF/views/layout/footer.jsp" />