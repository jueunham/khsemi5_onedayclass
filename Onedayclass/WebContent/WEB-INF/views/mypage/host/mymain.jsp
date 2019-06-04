<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<script type="text/javascript" src="code.jquery.com/jquery-2.2.4.min.js"></script>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	$("#btnUpload").click(function() {
	
		location.href="/mypage/host/upload";	

	});
});
</script>

<div class="container">

<div class="row">
<c:import url="/WEB-INF/views/mypage/host/menu.jsp" />


<div class="col order-1">

<div style="border: solid 1px; padding: 10px; text-align:center; width: 300px; height: 50px;">
 <h5> 클래스 등록 소개 </h5>
</div>  

<br>

<table class="table">
<tbody>

<tr>
<td style="width:400px; height:250px; background:#ccc; text-align:center;">
<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. 
Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, 
when an unknown printer took a galley of type and scrambled it to make a type 
specimen book. It has survived not only five centuries, but also the leap into 
electronic typesetting, remaining essentially unchanged. It was popularised in 
the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, 
and more recently with desktop publishing software like Aldus PageMaker including
 versions of Lorem Ipsum. It is a long established fact that a reader will be 
 distracted by the readable content of a page when looking at its layout. 
 The point of using Lorem Ipsum is that it has a more-or-less normal distribution 
 of letters, as opposed to using 'Content here, content here', making it look 
 like readable English. Many desktop publishing packages and web page editors 
 now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' 
 will uncover many web sites still in their infancy. Various versions have evolved
  over the years, sometimes by accident, sometimes on purpose 
  (injected humour and the like).</p>
</td>
</tr>

</tbody>
</table>
<br>

<div class="text-center">
	<button id="btnUpload" class="btn btn-dark">클래스 등록하러 가기</button>
</div>

</div>

</div>

</div>
<br>
<br>
<br>
<br><br>
<br>
<c:import url="/WEB-INF/views/layout/footer.jsp" />
