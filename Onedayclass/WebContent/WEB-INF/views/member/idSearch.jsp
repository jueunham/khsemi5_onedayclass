<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script>
function goidserch() {
	  var frm = document.idfindscreen;
	  frm.method = "post";
	  frm.action = "/idSerch.jsp";
	  frm.submit();
	 }

 function gopwserch() {
  var frm = document.idfindscreen;
  frm.method = "post";
  frm.action = "/pwSerch.jsp";
  frm.submit();
 }
 
 function idSearch() { //이름,핸드폰으로 '찾기' 버튼

	  var frm = document.idfindscreen;

	  if (frm.name.value.length < 1) {
	   alert("이름을 입력해주세요");
	   return;
	  }

	  if (frm.ph1.value.length<2 || frm.ph1.value.length>4) {
	   alert("핸드폰번호를 정확하게 입력해주세요");
	   return;
	  }
	  if (frm.ph2.value.length<2 || frm.ph2.value.length>4) {
	   alert("핸드폰번호를 정확하게 입력해주세요");
	   return;
	  }

	  frm.method = "post";
	  frm.action = "/idSerch2.jsp"; //넘어간화면
	  frm.submit();  
	  }
</script>

<div style="text-align: center;">
<h2>아이디 찾기</h2>
<h5>휴대전화로 인증</h5><br><br>
</div>

	<div class="form-group">
		<div style="text-align: center; margin-left: 50px;" >이름 :
			<input type="text" id="userName" name="userName" placeholder=" Name" />
		</div>
	</div>
	
		<div class="form-group">
		<div style="text-align: center">휴대폰 번호 :
			<input type="text" id="userPhone" name="userPhone" placeholder=" Phone Number" />
		</div>
	</div>
	
	<div style="text-align: center; margin-left: 75px;">
	<button type="button" id="btnSerch" class="btn btn-secondary" onclick = 'location.href = "/member/idserch2";'>
	찾기
	</button>
	<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
	<br><br>
	</div>


<c:import url="/WEB-INF/views/layout/footer.jsp" />
