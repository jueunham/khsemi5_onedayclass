<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<script type="text/javascript" src="code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	$("#btnUploadReq").click(function() {
		//요청 정보 전송 처리
	})
	
	$("#btnCancel").click(function() {
		history.go(-1);
	})
});
</script>

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

<div class="container">

<div class="row">
<c:import url="/WEB-INF/views/mypage/user/menu.jsp" />

<div class="col order-1">

<div class="container">

<div style="border: solid 1px; padding: 10px; text-align:center;">
 <h4> 클래스를 등록하세요!! </h4>
</div>  
</div>
<br>

<div class="container" style="border: solid 1px; padding: 10px; text-align:center;">
<table>
<tr>
<!-- 프로필 사진 등록 처리해야 함 -->
<td style="positon: absolute; padding-left: 50px;">프로필사진 </td>
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
<td><i class="fas fa-child"></i></td>
</tr>

<tr>
<td></td>
</tr>

<tr>
<td style="positon: absolute; padding-left: 50px;">클래스 이름</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><input type="text" class="form-control" value="${className }" placeholder="클래스 이름을 입력해주세요"/></td>
</tr>

<tr>
<td></td>
</tr>

<tr>
<td style="positon: absolute; padding-left: 50px;">클래스 소개</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><textarea id="classContent" rows="15" cols="70" class="form-control"
placeholder="상세한 클래스 소개로 수강생들에게 자신의 클래스를 어필해보세요!!"></textarea>
</tr>

<tr>
<td></td>
</tr>

<tr>
<td style="positon: absolute; padding-left: 50px;">강의료</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><input type="text" class="form-control" value="${classPrice }"></td>
</tr>

<tr>
<td></td>
</tr>

<tr>
<td style="positon: absolute; padding-left: 50px;">강의 장소</td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
<td><input type="text" class="form-control" value="${classPlace }"></td>
</tr>

<tr>
<td></td>
</tr>


</table>
<br>
<br>
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
