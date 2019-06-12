<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<!-- 스마트 에디터 라이브러리 추가 -->
<script type="text/javascript"
 src="/resources/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	//작성버튼 동작
	$("#btnWrite").click(function() {
		
		//스마트에디터의 내용으로 <textarea>에 적용시키기
//		submitContents($("#btnWrite"));
		
		//form submit 수행
		$("form").submit();

	});
		
	//취소버튼 동작
	$("#btnCancel").click(function() {
		history.go(-1);
	});
});
</script>

<style type="text/css">
#content {
	width: 98%;
}
</style>

<div class="container">

<div><h1>자유게시판</h1></div>
<button type="button" id="btnnotice" class="btn btn-secondary" onclick = "location = '/board/notice/list'">공지사항</button>
<button type="button" id="btnbulletin" class="btn btn-secondary" onclick = "location = '/board/bulletin/list'">자유게시판</button>
<button type="button" id="btnreport" class="btn btn-secondary" onclick = "location = '/board/report/list'">신고게시판</button><br>
<div style="text-align : right; margin-right: 50px;"><strong>홈 > 게시판 > 자유게시판</strong></div>
<hr>

<div>
<form action="/board/bulletin/write" method="post" enctype="multipart/form-data">
<table class="table table-bordered">
<tr><td class="info">제목</td><td><input type="text" name="title" style="width:98%"/></td></tr>
<tr><td class="info">작성자</td><td>${userid }</td></tr>
<tr><td class="info">글내용</td><td>
	<textarea id="content" name="content" rows="10" cols="100"></textarea>
</td></tr>
</table>

<label>첨부파일<input type="file" name="file" /></label>
</form>
</div>

<div style="text-align: right">	
	<button type="button" id="btnWrite" class="btn btn-info">등록</button>
	<button type="button" id="btnCancel" class="btn btn-danger">취소</button><br><br><br>
</div>
</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />

<!-- 스마트 에디터를 생성하는 코드 -->
<!-- 스마트 에디터의 스킨을 입히는 코드 -->
<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "content",	//<textarea>의 id 를 입력
	sSkinURI: "/resources/se2/SmartEditor2Skin.html",
	fCreator: "createSEditor2",
	htParams: {
		bUseToolbar: true, //툴바 사용여부
		bUseVerticalResizer: false, //입력창 크기 조절 바
		bUseModeChanger: true //글쓰기 모드 탭
	}
});

//<form>의 submit이 수행되면 스마트에디터의 내용이 <textarea>에 적용됨
function submitContents(elClickedObj) {
	// 에디터의 내용이 textarea에 적용된다.
	oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);

	try {
		elClickedObj.form.submit();
	} catch (e) { }
}
</script>
