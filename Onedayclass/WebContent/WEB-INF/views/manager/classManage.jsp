<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	//검색 버튼 동작
	$("#btnSearch").click(function() {
		location.href="/admin/class?search="+$("#search").val();
	});
	// 선택체크 삭제
	$("#btnDelete").click(function() {
		// 선택된 체크박스
		var $checkboxes = $("input:checkbox[name='checkRow']:checked");
		
		// 체크된 대상들을 map으로 만들고 map을 문자열로 만들기
		var map = $checkboxes.map(function() {
			return $(this).val();
		});
		var names = map.get().join(",");
	
		// 전송 폼
		var $form = $("<form>")
			.attr("action", "/board/listDelete")
			.attr("method", "post")
			.append(
				$("<input>")
					.attr("type", "hidden")
					.attr("name", "names")
					.attr("value", names)
			);
		$(document.body).append($form);
		$form.submit();
	
	});
	
});

//전체 체크/해제
function checkAll() {
	// checkbox들
	var $checkboxes=$("input:checkbox[name='checkRow']");

	// checkAll 체크상태 (true:전체선택, false:전체해제)
	var check_status = $("#checkAll").is(":checked");
	
	if( check_status ) {
		// 전체 체크박스를 checked로 바꾸기
		$checkboxes.each(function() {
			this.checked = true;	
		});
	} else {
		// 전체 체크박스를 checked 해제하기
		$checkboxes.each(function() {
			this.checked = false;	
		});
	}
}
</script>

<style type="text/css">

	th, td{
		border:1px solid #bcbcbc;
		}

	table {
	align : center;
	border: 1px solid #ccc;
	width: 1100px;
	height: 100px;
	}
</style>

<div align="center">
<h2><a href="/admin/class">클래스관리</a></h2>
<hr>
</div>

<div class="container">

<div class="float-right">
	<input type="text"  placeholder="클래스명 검색">
	<button id="btnSearch" class="btn">검색</button>
</div>


<br><br>
<table class="float-center table table-bordered">
	<thead>
		<tr bgcolor = #bcbcbc align="center">
			<th style="width:20%;">클래스 번호</th>
			<th style="width:20%;">회원번호(호스트)</th>
			<th style="width:50%;">클래스명</th>		
			<th style="width:10%;">
				<input type="checkbox" id="checkAll" onclick="checkAll();" />
			</th>
		</tr>
	</thead>
	
	<tbody>
	<c:forEach items="${classlist}" var="i">
		<tr align="center">
			<td>${i.classnum }</td>
			<td>${i.usernum }</td>
			<td>${i.classname }</td>
			<td><input type="checkbox" name="checkRow" value="${i.classnum}" /></td>
		</tr>
	</c:forEach>	
	</tbody>
</table>
<br><br>
<div id="btnBox" class="float-right">

	<button id="btnDelete" class="btn btn-primary">삭제</button>
</div>

<div class="float-left">
<h3><a href ="/admin/main">관리 메인으로</a></h3>

</div>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br>

<c:import url="/WEB-INF/views/layout/footer.jsp" />