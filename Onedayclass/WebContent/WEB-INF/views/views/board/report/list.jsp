<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	
	//글쓰기 버튼 누르면 이동
	$("#btnWrite").click(function() {
		location.href="/board/report/write";
	});
	
});
</script>

<style type="text/css">
table, th {
	text-align: center;
}

/* 글쓰기 버튼 위치 설정 */
#pagingBox {
	position: relative;
}
#btnBox {
	position: absolute;
	top: 0;
	bottom: 0;
	right: 0;
	height: 40px;
	margin: auto;
}

</style>
<div><h1>신고게시판</h1></div>
<button type="button" id="btnnotice" class="btn btn-secondary" onclick = "location = '/board/notice/list'">공지사항</button>
<button type="button" id="btnbulletin" class="btn btn-secondary" onclick = "location = '/board/bulletin/list'">자유게시판</button>
<button type="button" id="btnreport" class="btn btn-secondary" onclick = "location = '/board/report/list'">신고게시판</button><br>
<div style="text-align : right; margin-right: 50px;"><strong>홈 > 게시판 > 신고게시판</strong></div>
<hr>

<table class="table table-striped table-hover table-condensed">

<thead>
	<tr>
		<th style="width: 10%;">번호</th>
		<th style="width: 45%;">제목</th>
		<th style="width: 15%;">작성자</th>
		<th style="width: 10%;">조회수</th>
	</tr>
</thead>

<tbody>
<c:forEach items="${reportlist}" var="i">
	<tr>
		<td>${i.boardno }</td>
		<td><a href="/board/report/view?boardno=${i.boardno }">${i.title }</a></td>
		<td>${i.usernum }</td>
		<td>${i.hit }</td>
	</tr>
</c:forEach>
</tbody>

</table>

<div id="pagingBox">
<c:import url="/WEB-INF/views/layout/reportPaging.jsp" />

<div id="btnBox">
	<button id="btnWrite" class="btn btn-primary" style="text-align : right; margin-right: 50px;">글쓰기</button>
</div>
</div>

  
<c:import url="/WEB-INF/views/layout/footer.jsp" />