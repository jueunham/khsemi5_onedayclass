<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
$(document).ready(function() {
	$("#btnUpdate").click(function() {
		//수정 정보 전송 처리
		$("form").submit();
	})
	
	$("#btnCancel").click(function() {
		history.go(-1);
	})
});
</script>

<div class="container">

<div class="row">
<c:import url="/WEB-INF/views/mypage/host/menu.jsp" />

<div class="col order-1">

<div class="container">

<div style="border: solid 1px; padding: 10px; text-align:center;">
 <h4> 클래스를  정보를 수정하세요!! </h4>
<%--  <h4> ${className }를  정보를 수정하세요!! </h4> --%>
</div>  
</div>
<br>

<div class="container" style="border: solid 1px; padding: 10px; text-align:center;">
<form action="/mypage/host/upclassdetail" method="post" enctype="multipart/form-data">
<input type="hidden" name="classnum" value="${viewDayclass.classnum }" />

<table>
<tr>
<!-- 프로필 사진 등록 처리해야 함 -->
<td style="positon: absolute; padding-left: 50px;">프로필사진 </td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><i class="fas fa-child"></i></td>
</tr>

<tr>
<!-- 클래스 사진 등록 처리해야 함 -->
<td style="positon: absolute; padding-left: 50px;">클래스사진 </td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><i class="fas fa-child"></i></td>
</tr>

<tr>
<td></td>
</tr>
<tr>
<td style="positon: absolute; padding-left: 50px;">클래스 이름</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><input id="className" name="className" type="text" class="form-control" value="${viewDayclass.classname }"/></td>
</tr>

<tr>
<td style="positon: absolute; padding-left: 50px;">클래스 소개</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><input type="text" id="classContent" style="width:500px; height:400px;" class="form-control" value="${viewDayclass.classcontent }">
</tr>

<tr>
<td style="positon: absolute; padding-left: 50px;">강의 날짜</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>
<input type="text" id="datepicker" name="classDay" value="${viewDayclass.classday }">
</td>
</tr>

<tr>
<td style="positon: absolute; padding-left: 50px;">강의 시작 시간</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>
<select class="form-control" style="width:200px" name="classTime">
  <option value="09:00">09:00-10:00</option>
  <option value="10:00">10:00-11:00</option>
  <option value="11:00">11:00-12:00</option>
  <option value="12:00">12:00-13:00</option>
  <option value="13:00">13:00-14:00</option>
  <option value="14:00">14:00-15:00</option>
  <option value="15:00">15:00-16:00</option>
  <option value="16:00">16:00-17:00</option>
  <option value="17:00">17:00-18:00</option>
  <option value="19:00">19:00-20:00</option>
</select>
</td>
</tr>
<tr>
<td style="positon: absolute; padding-left: 50px;">강의 시간</td>
<td> &nbsp;&nbsp;&nbsp;&nbsp;</td>
<td>
<select class="form-control" name ="classRunningTime" style="width:200px">
  <option value="1">1</option>
  <option value="2">2</option>
  <option value="3">3</option>
</select>
</td>
</tr>

<tr>
<td style="positon: absolute; padding-left: 50px;">강의 장소</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><input id="classPlace" name="classPlace" type="text" class="form-control" value="${viewDayclass.classplace }" ></td>
</tr>
<tr>
<td style="positon: absolute; padding-left: 50px;">강의료</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><input type="text" class="form-control" value="${viewDayclass.classprice }"></td>
</tr>

</table>
<br>
<br>
</form>
<div>
<button type="submit" id="btnUpdate" class="btn btn-dark" >수정 완료</button>
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
