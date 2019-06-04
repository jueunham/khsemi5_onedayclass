<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">



<style type="text/css">

.list-group-item {
  user-select: none;
}

.list-group input[type="checkbox"] {
  display: none;
}

.list-group input[type="checkbox"] + .list-group-item {
  cursor: pointer;
}

.list-group input[type="checkbox"] + .list-group-item:before {
  content: "\2713";
  color: transparent;
  font-weight: bold;
  margin-right: 1em;

}

.list-group input[type="checkbox"]:checked + .list-group-item {
  background-color: #0275D8;
  color: #FFF;
}

.list-group input[type="checkbox"]:checked + .list-group-item:before {
  color: inherit;
}

label {
	max-width: 100px;
	font-size: medium;
	max-width: 110px;	
	text-align: left;
}


i {
	font-size:50px;
}
</style>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function(){
	$("#btnUploadReq").click(function(){
		$("form").submit();
	});
	
	$("#btnCancel").click(function(){
		history.go(-1);
	});
});

</script>
<div class="container">

<div class="row">
<c:import url="/WEB-INF/views/mypage/host/menu.jsp" />

<div class="col order-1">

<div class="container">

<div style="border: solid 1px; padding: 10px; text-align:center;">
 <h4> 클래스를 등록하세요!! </h4>
</div>  
</div>
<br>

<div class="container" style="border: solid 1px; padding: 10px; text-align:center; width:800px;">
<form action="/mypage/host/upload" method="post" enctype="multipart/form-data">
<table>
<tr>
<!-- 프로필 사진 등록 처리해야 함 -->
<td style="positon: absolute; padding-left: 50px; width:150px;">프로필사진 </td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><i class="fas fa-child"></i></td>
</tr>

<tr>
<td></td>
</tr>

<tr>
<!-- 클래스 사진 등록 처리해야 함 -->
<td style="positon: absolute; padding-left: 50px;">클래스사진 </td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><label>사진 첨부 : <input type="file" name="file" /></label></td>
</tr>

<tr>
<td></td>
</tr>

<tr>
<td style="positon: absolute; padding-left: 50px;">클래스 이름</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><input id="className" name="className" type="text" class="form-control" placeholder="클래스 이름을 입력해주세요"/></td>
</tr>

<tr>
<td></td>
</tr>

<tr>
<td style="positon: absolute; padding-left: 50px; ">클래스 소개</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><textarea id="classContent" name="classContent" rows="15" cols="70" class="form-control"
placeholder="상세한 클래스 소개로 수강생들에게 자신의 클래스를 어필해보세요!!"></textarea>
</tr>

<tr>
<td style="positon: absolute; padding-left: 50px;">강의 날짜</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>
<!-- <label class="checkbox-inline"> -->
<!--   <input type="checkbox" id="monday" name="monday" value="mon"> 월 -->
<!-- </label> -->
<!-- <label class="checkbox-inline"> -->
<!--   <input type="checkbox" id="tuesday" name="tuesday" value="tue"> 화 -->
<!-- </label> -->
<!-- <label class="checkbox-inline"> -->
<!--   <input type="checkbox" id="wendsday" name="wendsday" value="wen"> 수 -->
<!-- </label> -->
<!-- <label class="checkbox-inline"> -->
<!--   <input type="checkbox" id="thursday" name="thursday" value="thu"> 목 -->
<!-- </label> -->
<!-- <label class="checkbox-inline"> -->
<!--   <input type="checkbox" id="friday" name="friday" value="fri"> 금 -->
<!-- </label> -->
<input id="classDay" name="classDay" type="text" class="form-control"/></td>

</td>
</tr>

<tr>
<td style="positon: absolute; padding-left: 50px;">강의 시간</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>
<select class="form-control">
  <option id="time1" name="classTime">09:00-12:00</option>
  <option id="time2" name="classTime">12:00-14:00</option>
  <option id="time3" name="classTime">14:00-16:00</option>
  <option id="time4" name="classTime">16:00-18:00</option>
  <option id="time5" name="classTime">18:00-20:00</option>
  <option id="time6" name="classTime">20:00-22:00</option>
</select>
</td></tr>

<tr>
<td style="positon: absolute; padding-left: 50px;">강의 장소</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><input id="classPlace" name="classPlace" type="text" class="form-control" ></td>
</tr>

<tr>
<td style="positon: absolute; padding-left: 50px;">강의료 (원)</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><input id="classPrice" name="classPrice" type="text" class="form-control" ></td>
</tr>

</table>
<br>
<br>
</form>
<div>
<button type="button" id="btnUploadReq" class="btn btn-dark">등록 신청</button>
<button type="button" id="btnCancel" class="btn btn-dark">취소</button>
</div>
<br>

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
