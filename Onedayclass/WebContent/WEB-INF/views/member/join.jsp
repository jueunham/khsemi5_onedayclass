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
		
		var typeValue = $('input:radio[name="type"]:checked').val()
	});
</script>

<form action="/member/join" method="post" class="form-horizontal">
<div class = "show1">
	<br> <br> <br>
	<div style="text-align: center">
		<span style="font-weight: bold"><h1>One Day Class</h1></span>
		<span style="font-weight: bold"><h3>회원가입</h3></span><br>
		<span style="color: red">회원가입</span><span style="font-weight: bold">을 하시면 Oneday class의</span><br> <span style="font-weight: bold">모든</span>
		<span style="color: red">서비스</span><span style="font-weight: bold">를 이용하실 수 있습니다</span><br><br>


		<div style="text-align: center">
			<input type="radio" name="type" value="HOST" checked/> 호스트
			<input type="radio" name="type" value="USER" /> 게스트 <br>
		</div>
		
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
	<input type = 'checkbox' value = 'termofservice' />
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

<div style="text-align: center">

	<input type = "checkbox" id="ch1" name="check" value="관심목록1" />관심목록1&nbsp;&nbsp;&nbsp;
	<input type = "checkbox" id="ch2" name="check" value="관심목록2" />관심목록2&nbsp;&nbsp;&nbsp;
	<input type = "checkbox" id="ch3" name="check" value="관심목록3" />관심목록3&nbsp;&nbsp;&nbsp;
	<input type = "checkbox" id="ch4" name="check" value="관심목록4" />관심목록4&nbsp;&nbsp;&nbsp;
	<input type = "checkbox" id="ch5" name="check" value="관심목록5" />관심목록5&nbsp;&nbsp;&nbsp;<br><br>
	<input type = "checkbox" id="ch6" name="check" value="관심목록6" />관심목록6&nbsp;&nbsp;&nbsp;
	<input type = "checkbox" id="ch7" name="check" value="관심목록7" />관심목록7&nbsp;&nbsp;&nbsp;
	<input type = "checkbox" id="ch8" name="check" value="관심목록8" />관심목록8&nbsp;&nbsp;&nbsp;
	<input type = "checkbox" id="ch9" name="check" value="관심목록9" />관심목록9&nbsp;&nbsp;&nbsp;
	<input type = "checkbox" id="ch10" name="check" value="관심목록10" />관심목록10&nbsp;<br><br>
	<input type = "checkbox" id="ch10" name="check" value="관심목록11" />관심목록11&nbsp;
	<input type = "checkbox" id="ch10" name="check" value="관심목록12" />관심목록12&nbsp;
	<input type = "checkbox" id="ch10" name="check" value="관심목록13" />관심목록13&nbsp;
	<input type = "checkbox" id="ch10" name="check" value="관심목록14" />관심목록14&nbsp;
	<input type = "checkbox" id="ch10" name="check" value="관심목록15" />관심목록15&nbsp;<br><br>
	<input type = "checkbox" id="ch10" name="check" value="관심목록16" />관심목록16&nbsp;
	<input type = "checkbox" id="ch10" name="check" value="관심목록17" />관심목록17&nbsp;
	<input type = "checkbox" id="ch10" name="check" value="관심목록18" />관심목록18&nbsp;
	<input type = "checkbox" id="ch10" name="check" value="관심목록19" />관심목록19&nbsp;
	<input type = "checkbox" id="ch10" name="check" value="관심목록20" />관심목록20&nbsp;

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








