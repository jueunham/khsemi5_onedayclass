<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<!-- Bootstrap 3 -->
<link rel="stylesheet"

   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
   
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
	
	// 댓글 입력
	$("#btnCommInsert").click(function() {

	      $form = $("<form>").attr({
	         action: "/board/bulletin/comment/insert",
	         method: "post"
	      }).append(
	         $("<input>").attr({
	            type:"hidden",
	            name:"boardno",
	            value:"${viewBoard.boardno }"
	         })
	      ).append(
	         $("<input>").attr({
	            type:"hidden",
	            name:"userid",
	            value:"${sessionScope.userid }"
	         })
	      ).append(
	         $("<textarea>")
	            .attr("name", "content")
	            .css("display", "none")
	            .text($("#commentContent").val())
	      );
	      $(document.body).append($form);
	      $form.submit();
	      
	   });
	
});
	   
	//댓글 삭제
	function deleteComment(commentno) {
	   $.ajax({
	      type: "post"
	      , url: "/board/bulletin/comment/delete"
	      , dataType: "json"
	      , data: {
	         commentno: commentno
	      }
	      , success: function(data){
	         if(data.success) {
	            
	            $("[data-commentno='"+commentno+"']").remove();
	            
	         } else {
	            alert("댓글 삭제 실패");
	         }
	      }
	      , error: function() {
	         console.log("error");
	      }
	   });
	}
	
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

<!-- 댓글 리스트 -->
<table class="table table-striped table-hover table-condensed"
style=" width:1350px; margin-top:30px;">
<thead>
<tr>

   <th style="width: 10%;"></th>
   <th style="width: 50%;"></th>
   <th style="width: 20%;"></th>
   <th style="width: 5%;"></th>
</tr>
</thead>
<tbody id="commentBody">
<c:forEach items="${commentList }" var="comment">
<tr data-commentno="${comment.commentno }">

   <td>${comment.userid }</td><!-- 닉네임으로 해도 좋음 -->
   <td>${comment.content }</td>
   <td>${comment.commentdate }</td>
   <td>
      <c:if test="${sessionScope.userid eq comment.userid }">
      <button class="btn btn-default btn-xs"
         onclick="deleteComment(${comment.commentno  });">삭제</button>
      </c:if>
   </td>
   
</tr>
</c:forEach>
</tbody>
</table>   <!-- 댓글 리스트 end -->
 
<!-- 로그인상태 -->
<c:if test="${login }">
<!-- 댓글 입력 -->
<div class="form-inline text-center">
   <input type="text" size="15" class="form-control" id="commentWriter" value="${userid }" readonly="readonly"/>&nbsp;&nbsp;&nbsp;
   <textarea rows="1" cols="80" class="form-control" id="commentContent"></textarea>
   <button id="btnCommInsert" class="btn">입력</button>
</div>   <!-- 댓글 입력 end -->
</c:if>
 <br><br>

<c:import url="/WEB-INF/views/layout/footer.jsp" />

