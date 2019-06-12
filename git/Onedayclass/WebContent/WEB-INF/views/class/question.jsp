<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script type="text/javascript">

$(document).ready(function() {

$("#qbtnCancel").click(function() {
	history.go(-1);
});

$("#qbtnWrite").click(function() {
	
	$("form").submit();
	
});

});

</script>

<style type="text/css">

#question{

	float: left; 
 	margin-left: 500px; 
}


#q1 {
    width: 100px; height: 100px;
    object-fit: cover;
    object-position: top;
    border-radius: 50%;
    background-color: gray;
}



</style>

</head>
<body>

<h3 style="text-align: center; width: 1900px;"> 질문 </h3>
<br><br>

<div id="question">
	<h4 style="float: left;"> 질문 </h4><br>
	
	<textarea rows="8" cols="100" style="float: left; margin-left: 100px;" placeholder="내용을 입력해주세요"></textarea>
</div><div style="clear: both;"></div><br><br>


<div style="width: 1600px;">

<form action="/question" method="post" >
<button type="button" id="qbtnWrite" class="btn btn-info"
	style="float: right; margin-right: 280px; background-color: #4169e1; color: white; border-radius: 5px;" >

작성완료</button>

<button type="button" id="qbtnCancel" class="btn btn-danger"
	style="float: right; margin-right:10px; background-color: #4169e1; color: white; border-radius: 5px;" >

취소</button><div style="clear: both;"></div><br>

</form>
</div>
<hr>
<br>

<c:forEach  items="${questionList}" var="q">
<div id="person1" style="margin-left: 500px;">
	<img id="q1" src="/picture/profile.png" style="float: left;"> 
	
	<div style="float: left; margin-left: 100px; width: 100px;">
	<label>아이디</label><br><label>${q.userNum }</label><br>
	</div>
	
	<div style="float: left; margin-left: 100px;">
	<table>
		<tbody>
		<tr>
			<td> 질문번호 :${q.quesNum }</td>
		</tr>
		
		<tr>
			<td><pre>${q.content }</pre></td>
		</tr>
			
		<tr>
			<td>${q.quesDate }</td>
		</tr>
		
		
		</tbody>
    		
	</table>
	
	</div><div style="clear: both;"></div><hr width="700px;" style="float: left; margin-left: 200px; "><br><br>
</div>
</c:forEach>


<div id="pasing" style="margin-left: 910px;">
<c:import url="/WEB-INF/views/layout/QuestionPaging.jsp" />
</div>

<br><br><br><br><br><br><br>

<c:import url="/WEB-INF/views/layout/footer.jsp" />