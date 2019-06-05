<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/WEB-INF/views/classCategory/Category.jsp" />

<script type="text/javascript">

</script>

<style type="text/css">

#tb01{

	width: 200px;
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	float: left;
	margin-left: 400px;	 
}

#tr,td{
	padding: 10px;

}


#wrap{

	width: 1900px;
}

#content01{

	float: left;
	margin-left: 20px;
	border: 1px solid #ccc;
	
}

#subwrap{

	width: 1900px;
}

#content02{

	float: left;
	border: 1px solid #ccc;
}



</style>

</head>
<body>


<div id="title" style="font-size: 30px; color: magenta; margin-left: 400px;">카테고리</div>

<div id="title" style="font-size: 30px; color: magenta; margin-left: 620px;">추천수업</div><br>

<table id="tb01">
	<tr>
		<td><a href="/photoshop" style="color: black; font-weight: bold;" >엑셀</a></td>
	</tr>

	<tr>
		<td><a href="/illustrator" style="color: black; font-weight: bold;" >파워포인트</a></td>
	</tr>

	<tr>
		<td><a href="/architecture" style="color: black; font-weight: bold;" >마케팅</a></td>
	</tr>
	
	<tr>
		<td><a href="/productdesign" style="color: black; font-weight: bold;" >브랜딩</a></td>
	</tr>
	
	<tr>
		<td><a href="/editorialdesign" style="color: black; font-weight: bold;" >재무회계</a></td>
	</tr>
	
	<tr>
		<td></td>
	</tr>
	
	<tr>
		<td></td>
	</tr>
	<tr>
		<td></td>
	</tr>
	<tr>
		<td></td>
	</tr>
	
	<tr>
		<td></td>
	</tr>
	
	<tr>
		<td></td>
	</tr>
	
	<tr>
		<td></td>
	</tr>
	
	<tr>
		<td></td>
	</tr>
	
</table>

<div id="wrap">

<div id="content01">

<div id="img01">
	<a href="/excel">
	<img src="/picture/02_capability/excel.png" width="400px;" height="256px;" style= "display:block;"  ></a>

<br>

<table>
	<tr>
		<td width="400px" style="text-align: justify;" >
		<a href="/excel" style="color: black; font-weight: bold;">직장인 필수 스킬! 칼퇴 하고싶어? 엑셀을 배워봐!</a><br><br>
		
		<label style="font-size: 15px; font-family:fantasy; ">강남  &nbsp; &nbsp; || &nbsp; &nbsp; &#8361; 30,000</label>
		
		</td>
	</tr>	
</table>


</div>
</div>	
</div>	

<div id="subwrap">

<div id="content02">
	
<div id="img01" style="width: 100px; height: 85px; float: left; padding: 2px; margin-top: 5px; ">
	<a href="/excel">
	<img src="/picture/02_capability/excel02.png" width="100" height="100" ></a>

</div>


<div style="width: 430px; height: 85px; margin-bottom: 30px; " >

		<table>
			<tr>
				<td><a href="/illustrator" style="color: black; font-weight: bold;">왕초보도 엑셀 밟고 업무 속도 UP!</a></td>		
			</tr>
			
			<tr>
				<td style="font-size: 15px; font-family:fantasy; ">강남  &nbsp; &nbsp; || &nbsp; &nbsp; &#8361; 30,000</td>
			</tr>
		</table>				
</div>



<div id="content03">
	
<div id="img01" style="width: 100px; height: 100px; float: left; padding: 2px; margin-top: 15px; ">
	<a href="/powerpoint">
	<img src="/picture/02_capability/powerpoint.png" width="100" height="100" ></a>

</div><hr>


<div style="width: 430px; height: 85px; margin-bottom: 30px;">

		<table>
			<tr>
				<td><a href="/photoshop" style="color: black; font-weight: bold;">PPT, 막막함은 없애고 자신감을 채워드립니다!</a></td>		
			</tr>
			
			<tr>
				<td style="font-size: 15px; font-family:fantasy; ">강남  &nbsp; &nbsp; || &nbsp; &nbsp; &#8361; 30,000</td>
			</tr>
		</table>				
</div>

</div>

<div id="content04">
	
<div id="img01" style="width: 100px; height: 100px; float: left; padding: 2px; margin-top: 13px;">
	<a href="/financialaccounting">
	<img src="/picture/02_capability/financialaccounting.png" width="100" height="100" ></a>

</div><hr>


<div style="width: 430px; height: 85px; margin-bottom: 30px;">

		<table>
			<tr>
				<td><a href="/financialaccounting" style="color: black; font-weight: bold;">단 4시간 만으로 재무제표 마스터하기</a></td>		
			</tr>
			
			<tr>
				<td style="font-size: 15px; font-family:fantasy; ">신촌/홍대  &nbsp; &nbsp; || &nbsp; &nbsp; &#8361; 25,000</td>
			</tr>
		</table>				
</div>



</div>	

</div>
</div>


<div style="clear: both"></div><br><br><br><br><br>
<br><br><br><br><br><br><br><br>
<c:import url="/WEB-INF/views/layout/footer.jsp" />