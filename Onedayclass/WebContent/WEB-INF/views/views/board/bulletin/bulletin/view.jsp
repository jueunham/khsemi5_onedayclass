<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	//목록버튼 동작
	$("#btnList").click(function() {
		$(location).attr("href", "/board/bulletin/list");
	});
	
	//수정버튼 동작
	$("#btnUpdate").click(function() {
		$(location).attr("href", "/board/bulletin/update?boardno=${viewBoard.boardno }");
	});

	//삭제버튼 동작
	$("#btnDelete").click(function() {
		$(location).attr("href", "/board/bulletin/delete?boardno=${viewBoard.boardno }");
	});
	
});
</script>

<div><h1>자유게시판</h1></div>
<button type="button" id="btnnotice" class="btn btn-secondary" onclick = "location = '/board/notice/list'">공지사항</button>
<button type="button" id="btnbulletin" class="btn btn-secondary" onclick = "location = '/board/bulletin/list'">자유게시판</button>
<button type="button" id="btnreport" class="btn btn-secondary" onclick = "location = '/board/report/list'">신고게시판</button><br>
<div style="text-align : right; margin-right: 50px;"><strong>홈 > 게시판 > 자유게시판</strong></div>
<hr>

<c:if test="${login }">
<button id="btnRecommend" class="btn pull-right" style="margin-top: 30px;"></button>
</c:if>

<div class="clearfix"></div>
<hr>

<table class="table table-bordered">

<tr>
<td class="info">제목</td><td>${viewBoard.title }</td>
</tr>

<tr>
<td class="info">작성자</td><td>${viewBoard.userid }</td>
</tr>

<tr>
<td class="info">작성일</td><td>${viewBoard.writedate }</td>
</tr>

<tr>
<td class="info">본문</td><td>${viewBoard.content }</td>
</tr>

</table>

<div>
첨부파일 다운로드 : <a href="/file/download?boardno=${boardFile.boardno }">${boardFile.originName }</a>
</div>

<div style="text-align: right;">	
	<button id="btnList" class="btn btn-primary">목록</button>
	<c:if test="${userid eq viewBoard.userid }">
	<button id="btnUpdate" class="btn btn-info">수정</button>
	<button id="btnDelete" class="btn btn-danger">삭제</button>
	</c:if>
</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />
