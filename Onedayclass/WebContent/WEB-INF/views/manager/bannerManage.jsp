<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript">
$(document).ready(function() {
	//배너로 추가 버튼 동작
	$("#btnAdd").click(function() {
		// 선택된 체크박스
		var $checkboxes = $("input:checkbox[name='checkRow']:checked");
		
		// 체크된 대상들을 map으로 만들고 map을 문자열로 만들기
		var map = $checkboxes.map(function() {
			return $(this).val();
		});
		var names = map.get().join(",");
	
		// 전송 폼
		var $form = $("<form>")
			.attr("action", "/banner/listAdd")
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
			.attr("action", "/banner/listDelete")
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
	width: 500px;
	height: 100px;
	}
	
</style>

<div align="center">
<h2><a href="/admin/banner">배너관리</a></h2>
<hr>
</div>

<div class="container">
<table class = "table table-bordered" >
	<thead>
		<tr bgcolor = #bcbcbc align="center">
			<th style="width:10%;">클래스번호</th>
			<th style="width:25%;">배너로 등록된 클래스명</th>
			<th style="width:10%;">호스트</th>  
			<th style="width:10%;">
				<input type="checkbox" id="checkAll" onclick="checkAll();" />
			</th>
		</tr>
	</thead>
	
	
	<tbody>
	<c:forEach items="${bannerlist}" var="b">
		<tr align="center">
			<td>${b.classnum }</td>
			<td>${b.classname }</td>
			<td>${b.usernum }</td>
			<td><input type="checkbox" name="checkRow" value="${b.classnum}" /></td>		
		</tr>
	</c:forEach>	
	</tbody>
</table>
<div id="btnBox" class=float-right>
	<button id="btnDelete" class="btn btn-primary">배너목록에서 삭제</button>
</div>
</div>

<br><br><br><br><br><br>
<div class="container">

<table class = "table table-bordered" >
	<thead>
		<tr bgcolor = #bcbcbc align="center">
			<th style="width:10%;">클래스번호</th>
			<th style="width:25%;">클래스명</th>
			<th style="width:10%;">호스트</th>  
			<th style="width:10%;">
				<input type="checkbox" id="checkAll" onclick="checkAll();" />
			</th>
		</tr>
	</thead>
	
	<tbody>
	<c:forEach items="${classlist}" var="i">
		<tr align="center">
			<td>${i.classnum }</td>
			<td>${i.classname }</td>
			<td>${i.usernum }</td>
			<td><input type="checkbox" name="checkRow" value="${i.classnum}" /></td>		
		</tr>
	</c:forEach>	
	</tbody>
</table>

<br>
<div id="btnBox" class=float-right>
	<button id="btnadd" class="btn-primary">배너로 추가</button>
</div>

<div class="float-left">
<h3><a href ="/admin/main">관리 메인으로</a></h3>
</div>
</div>




<br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br>

<c:import url="/WEB-INF/views/layout/footer.jsp" />