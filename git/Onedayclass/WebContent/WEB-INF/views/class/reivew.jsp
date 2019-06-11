<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    

     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

$(document).ready(function() {
	
	
$(".starRev span").click(function(){
	  $(this).parent().children('span').removeClass('on');
	  $(this).addClass('on').prevAll('span').addClass('on');
	  return false;
	});


$("#btnCancel").click(function() {
	history.go(-1);
});

$("#btnWrite").click(function() {
	

	$form = $("<form>").attr({
		action: "/review/insert",
		method: "post"
	}).append(
		$("<input>").attr({
			type:"hidden",
			name:"classNum",
			value:"${classdetail.classNum}"
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
			.text($("#reviewcontent").val())
	);
	$(document.body).append($form);
	$form.submit();
	
});



});







</script>

<style type="text/css">

.starR1{
    background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat -52px 0;
    background-size: auto 100%;
    width: 15px;
    height: 30px;
    float:left;
    text-indent: -9999px;
    cursor: pointer;
}
.starR2{
    background: url('http://miuu227.godohosting.com/images/icon/ico_review.png') no-repeat right 0;
    background-size: auto 100%;
    width: 15px;
    height: 30px;
    float:left;
    text-indent: -9999px;
    cursor: pointer;
}

.starR1.on{background-position:0 0;}
.starR2.on{background-position:-15px 0;}




#review{

	float: left; 
 	margin-left: 500px; 
}

#hr{

	border: 0;
    height: 3px;
    background: #ccc;
  
}


</style>
</head>
<body>
	
	<h3 style="text-align: center; width: 1900px;"> 후기 & 별점 </h3><br>
	
<div style="width: 1900px;">
	<div class="starRev" style="margin-left: 875px;">
  		<span class="starR1 on">별1_왼쪽</span>
  		<span class="starR2">별1_오른쪽</span>
  		<span class="starR1">별2_왼쪽</span>
  		<span class="starR2">별2_오른쪽</span>
  		<span class="starR1">별3_왼쪽</span>
  		<span class="starR2">별3_오른쪽</span>
  		<span class="starR1">별4_왼쪽</span>
  		<span class="starR2">별4_오른쪽</span>
  		<span class="starR1">별5_왼쪽</span>
  		<span class="starR2">별5_오른쪽</span>
	</div><div style="clear: both;"></div><br><br><br>
</div>




<div id="review">
	<h4 style="float: left;"> 리뷰 </h4><br>
	
	<textarea rows="8" cols="100" style="float: left; margin-left: 100px;"></textarea>
</div><div style="clear: both;"></div><br><br>

<div style="width: 1600px;">

<form action="/review/insert" method="post" >
<button type="button" id="btnWrite" class="btn btn-info"
	style="float: right; margin-right: 280px; background-color: #4169e1; color: white; border-radius: 5px;" >

작성완료</button>

<button type="button" id="btnCancel" class="btn btn-danger"
	style="float: right; margin-right:10px; background-color: #4169e1; color: white; border-radius: 5px;" >

취소</button><div style="clear: both;"></div><br>
</form>

</div>
<hr><br>


<c:forEach  items="${reviewList}" var="i">
<div id="person1" style="margin-left: 500px;">
	<img id="q1" src="/picture/profile.png" style="float: left;"> 
	
	<div style="float: left; margin-left: 100px; width: 100px;">
	<label>아이디</label><br><label>${i.userNum }</label><br>
	</div>
	<div style="float: left; margin-left: 100px;">	
	<table>
		<tbody>
		<tr>
			<td> 리뷰번호 :${i.reviewNum }</td>
		</tr>
		
		<tr>
			<td><pre>${i.content }</pre></td>
		</tr>
		
		
		
		</tbody>
    		
	</table>	
	</div><div style="clear: both;"></div><hr width="700px;" style="float: left; margin-left: 200px; "><br><br>
</div>
</c:forEach>


<div id="pasing" style="margin-left: 910px;">
<c:import url="/WEB-INF/views/layout/ReviewPaging.jsp" />
</div>


<hr id="hr"><br>
	
<c:import url="/WEB-INF/views/class/question.jsp" />



