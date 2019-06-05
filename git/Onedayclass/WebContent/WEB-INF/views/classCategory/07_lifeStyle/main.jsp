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
		<td><a href="/handmade" style="color: black; font-weight: bold;" >핸드메이드</a></td>
	</tr>

	<tr>
		<td><a href="/picture" style="color: black; font-weight: bold;" >사진</a></td>
	</tr>

	<tr>
		<td><a href="/pottery" style="color: black; font-weight: bold;" >도예/물레</a></td>
	</tr>
	
	<tr>
		<td><a href="/cooking" style="color: black; font-weight: bold;" >요리/베이킹</a></td>
	</tr>
	
	<tr>
		<td><a href="/trip" style="color: black; font-weight: bold;" >여행/투어</a></td>
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
	<a href="/handmade">
	<img src="/picture/07_lifestyle/handmade.png" width="400px;" height="256px;" style= "display:block;"  ></a>

<br>

<table>
	<tr>
		<td width="400px" style="text-align: justify;" >
		<a href="/handmade" style="color: black; font-weight: bold;">나만의 천연비누 원데이 클래스</a><br><br>
		
		<label style="font-size: 15px; font-family:fantasy; ">합정 &nbsp; &nbsp; || &nbsp; &nbsp; &#8361; 30,000</label>
		
		</td>
	</tr>	
</table>


</div>
</div>	
</div>	

<div id="subwrap">

<div id="content02">
	
<div id="img01" style="width: 100px; height: 85px; float: left; padding: 2px; margin-top: 5px; ">
	<a href="/vocal">
	<img src="/picture/07_lifestyle/picture.png" width="100" height="100" ></a>

</div>


<div style="width: 430px; height: 85px; margin-bottom: 30px; " >

		<table>
			<tr>
				<td><a href="/picture" style="color: black; font-weight: bold;">감성사진, 나도 찍을 수 있다 ! 왕초보 강좌</a></td>		
			</tr>
			
			<tr>
				<td style="font-size: 15px; font-family:fantasy; ">강남  &nbsp; &nbsp; || &nbsp; &nbsp; &#8361; 25,000</td>
			</tr>
		</table>				
</div>



<div id="content03">
	
<div id="img01" style="width: 100px; height: 100px; float: left; padding: 2px; margin-top: 15px; ">
	<a href="/cooking">
	<img src="/picture/07_lifestyle/cooking.png" width="100" height="100" ></a>

</div><hr>


<div style="width: 430px; height: 85px; margin-bottom: 30px;">

		<table>
			<tr>
				<td><a href="/cooking" style="color: black; font-weight: bold;">'마카롱' 이제 사먹지말고 만들어먹자!</a></td>		
			</tr>
			
			<tr>
				<td style="font-size: 15px; font-family:fantasy; ">신촌/홍대 &nbsp; &nbsp; || &nbsp; &nbsp; &#8361; 25,000</td>
			</tr>
		</table>				
</div>

</div>

<div id="content04">
	
<div id="img01" style="width: 100px; height: 100px; float: left; padding: 2px; margin-top: 13px;">
	<a href="/trip">
	<img src="/picture/07_lifestyle/trip.png" width="100" height="100" ></a>

</div><hr>


<div style="width: 430px; height: 85px; margin-bottom: 30px;">

		<table>
			<tr>
				<td><a href="/trip" style="color: black; font-weight: bold;">혼자 처음 떠나는 해외여행 ✈️, 완벽하게 준비하기!</a></td>		
			</tr>
			
			<tr>
				<td style="font-size: 15px; font-family:fantasy; ">신촌/홍대  &nbsp; &nbsp; || &nbsp; &nbsp; &#8361; 20,000</td>
			</tr>
		</table>				
</div>



</div>	

</div>
</div>


<div style="clear: both"></div><br><br><br><br><br>
<br><br><br><br><br><br><br><br>
<c:import url="/WEB-INF/views/layout/footer.jsp" />