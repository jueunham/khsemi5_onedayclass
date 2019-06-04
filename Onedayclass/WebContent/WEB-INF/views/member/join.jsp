<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
	$(document).ready(function() {
		
			$('.show1').show(); //페이지를 로드할 때 표시할 요소
			$('.show2').hide(); //페이지를 로드할 때 숨길 요소
			$('.show3').hide(); //페이지를 로드할 때 숨길 요소
		
		$('.next1').click(function(){
			$('.show1').hide(); //클릭 시 첫 번째 요소 숨김
			$('.show2').show(); //클릭 시 두 번째 요소 표시
			$('.show3').hide(); //페이지를 로드할 때 숨길 요소
			return false;
		});
			
		$('.next2').click(function(){
			$('.show').hide(); //클릭 시 첫 번째 요소 숨김
			$('.show2').hide(); //클릭 시 두 번째 요소 표시
			$('.show3').show(); //페이지를 로드할 때 숨길 요소
		
		return false;
		});
		
		//페이지 첫 접속 시 입력창으로 포커스 이동
		$("input").eq(0).focus();
		
		//패스워드 입력 창에서 엔터 입력 시 form submit
		$("input").eq(1).keydown(function(key) {
			if(key.keyCode == 13) {
				$(this).parents("form").submit();
			}
		})
		
		//가입 버튼 클릭 시 form submit
		$("#btnJoin").click(function() {
			$(this).parents("form").submit();
		})
		
		//취소 버튼 누르면 뒤로가기
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

</style>

<form action="/member/join" method="post" class="form-horizontal" name="join">
<div class = "show1">
	<br> <br> <br>
	<div style="text-align: center">
		<span style="font-weight: bold"><h1>One Day Class</h1></span>
		<span style="font-weight: bold"><h3>회원가입</h3></span><br>
		<span style="color: red">회원가입</span><span style="font-weight: bold">을 하시면 Oneday class의</span><br> <span style="font-weight: bold">모든</span>
		<span style="color: red">서비스</span><span style="font-weight: bold">를 이용하실 수 있습니다</span><br><br>
		
	</div>

	<div class="form-group">
		<div style="text-align: center; margin-left: 95px;">
			<input type="text" id="username" name="username" placeholder=" Name" />
			<button type="button" id="btnLogin" class="btn btn-secondary">실명인증</button>
		</div>
		
	</div>

	<div class="form-group">
		<div style="text-align: center">
			<input type="email" id="userid" name="userid" placeholder=" Email" />
		</div>
	</div>

	<div class="form-group">
		<div style="text-align: center">
			<input type="text" id="userpw" name="userpw" placeholder=" Password" />
		</div>
	</div>

	<div class="form-group">
		<div style="text-align: center">
			<input type="text" id="userpw" name="userpw"
				placeholder=" Confirm Password" />
		</div>
	</div>

	<div class="form-group">
		<div style="text-align: center">
			<select name="ph1">
       <option value="010">010</option>
       <option value="011">011</option>
       <option value="016">016</option>
       <option value="017">017</option>
       <option value="019">019</option>
     </select> -
   <input type="text" size="4" maxlength="4" name="ph2"> -
   <input type="text" size="4" maxlength="4" name="ph3">
		</div>
	</div>

		<div style="text-align: center">
			<input type="radio" name="userlevel" value="HOST" checked/> 호스트
			<input type="radio" name="userlevel" value="USER" /> 게스트 <br>
		</div><br><br>

	<div style="text-align: center" id = "term">
	<input type = 'checkbox' name = "term" value = 'termofservice' />
	<span>
	<a href="/info/termOfService">
	이용약관 </a></span>및 
	<span>
	<a href="/info/privacyPolicy">
	개인정보 취급방침</a></span>
	</div><br>

<div class = "next1">

	<div style="text-align: center">
	<button type="button" id="btninterList" class="btn btn-secondary">
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	NEXT
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</button>
	</div>
	<br><br><br>

</div>
</div>


<div class = "show2">
<br> <br> <br>
	<div style="text-align: center">
		<span style="font-weight: bold"><h1>One Day Class</h1></span>
		<span style="font-weight: bold"><h3>회원가입</h3></span><br>
	</div>
	
<div style = "text-align : left; margin-left: 420px;">
관심 목록 선택></div><br>
<div style = "text-align : center;">
<table>
<tr>
<td style="positon: absolute; padding: 230px;"></td>
<td>

<div class="list-group" data-toggle="buttons">
<input type="checkbox" name="CheckBoxInputName" value="Value1" id="CheckBox1" />
  <label class="list-group-item" for="CheckBox1">Box1</label>

<input type="checkbox" name="CheckBoxInputName" value="Value2" id="CheckBox2" />
  <label class="list-group-item" for="CheckBox2">Box2</label>

<input type="checkbox" name="CheckBoxInputName" value="Value3" id="CheckBox3" />
  <label class="list-group-item" for="CheckBox3">Box3</label>

<input type="checkbox" name="CheckBoxInputName" value="Value4" id="CheckBox4" />
  <label class="list-group-item" for="CheckBox4">Box4</label>
  
</div>
</td>

<td>

<div class="list-group" data-toggle="buttons">
<input type="checkbox" name="CheckBoxInputName" value="Value1" id="CheckBox5" />
  <label class="list-group-item" for="CheckBox5">Box5</label>

<input type="checkbox" name="CheckBoxInputName" value="Value2" id="CheckBox6" />
  <label class="list-group-item" for="CheckBox6">Box6</label>

<input type="checkbox" name="CheckBoxInputName" value="Value3" id="CheckBox7" />
  <label class="list-group-item" for="CheckBox7">Box7</label>

<input type="checkbox" name="CheckBoxInputName" value="Value4" id="CheckBox8" />
  <label class="list-group-item" for="CheckBox8">Box8</label>

</div>
</td>

<td>

<div class="list-group" data-toggle="buttons">
<input type="checkbox" name="CheckBoxInputName" value="Value1" id="CheckBox9" />
  <label class="list-group-item" for="CheckBox9">Box9</label>

<input type="checkbox" name="CheckBoxInputName" value="Value2" id="CheckBox10" />
  <label class="list-group-item" for="CheckBox10">Box10</label>

<input type="checkbox" name="CheckBoxInputName" value="Value3" id="CheckBox11" />
  <label class="list-group-item" for="CheckBox11">Box11</label>

<input type="checkbox" name="CheckBoxInputName" value="Value4" id="CheckBox12" />
  <label class="list-group-item" for="CheckBox12">Box12</label>

</div>

</td>
<td>

<div class="list-group" data-toggle="buttons">
<input type="checkbox" name="CheckBoxInputName" value="Value1" id="CheckBox13" />
  <label class="list-group-item" for="CheckBox13">Box13</label>

<input type="checkbox" name="CheckBoxInputName" value="Value2" id="CheckBox14" />
  <label class="list-group-item" for="CheckBox14">Box14</label>

<input type="checkbox" name="CheckBoxInputName" value="Value3" id="CheckBox15" />
  <label class="list-group-item" for="CheckBox15">Box15</label>

<input type="checkbox" name="CheckBoxInputName" value="Value4" id="CheckBox16" />
  <label class="list-group-item" for="CheckBox16">Box16</label>

</div>

</td>
</tr>
</table>
</div>
<div class = "next2">

<span>

	<div style="text-align: right">
			<button type="button" id="btncomplete" class="btn btn-primary">
				&nbsp;NEXT>&nbsp;
			</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			&nbsp;
	</div>
			<br><br>

</span>
	
</div>
</div>


<div class = "show3">
<br> <br> <br>
	<div style="text-align: center">
		<span style="font-weight: bold"><h1>One Day Class</h1></span>
		<span style="font-weight: bold"><h3>회원가입</h3></span><br><br>
		
		<h4>가입완료 버튼을 누르셔야 가입이 완료됩니다</h4><br><br>
<div class = "next3">

	<span>
		<button type="button" id="btnJoin" class="btn btn-primary">
		가입완료
		</button>
		<button type="button" id="btnCancel" class="btn btn-primary">
		뒤로
		</button>
	</span><br><br>
	
</div>
</div>
</div>

</form>
<c:import url="/WEB-INF/views/layout/footer.jsp" />








