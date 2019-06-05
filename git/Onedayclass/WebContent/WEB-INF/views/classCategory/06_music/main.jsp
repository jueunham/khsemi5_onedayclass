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
		<td><a href="/vocal" style="color: black; font-weight: bold;" >보컬</a></td>
	</tr>

	<tr>
		<td><a href="/piano" style="color: black; font-weight: bold;" >피아노</a></td>
	</tr>

	<tr>
		<td><a href="/drum" style="color: black; font-weight: bold;" >드럼</a></td>
	</tr>
	
	<tr>
		<td><a href="/composition" style="color: black; font-weight: bold;" >미디작곡</a></td>
	</tr>
	
	<tr>
		<td><a href="/guitar" style="color: black; font-weight: bold;" >기타연주</a></td>
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
	<a href="/guitar">
	<img src="/picture/06_music/guitar.png" width="400px;" height="256px;" style= "display:block;"  ></a>

<br>

<table>
	<tr>
		<td width="400px" style="text-align: justify;" >
		<a href="/guitar" style="color: black; font-weight: bold;">내가 좋아하는 음악으로 배우는 기타 레슨 </a><br><br>
		
		<label style="font-size: 15px; font-family:fantasy; ">신촌/홍대 &nbsp; &nbsp; || &nbsp; &nbsp; &#8361; 30,000</label>
		
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
	<img src="/picture/06_music/vocal.png" width="100" height="100" ></a>

</div>


<div style="width: 430px; height: 85px; margin-bottom: 30px; " >

		<table>
			<tr>
				<td><a href="/vocal" style="color: black; font-weight: bold;">즐겁게 노래해요! 꼼꼼하고 확실한 보컬 레슨</a></td>		
			</tr>
			
			<tr>
				<td style="font-size: 15px; font-family:fantasy; ">압구정  &nbsp; &nbsp; || &nbsp; &nbsp; &#8361; 20,000</td>
			</tr>
		</table>				
</div>



<div id="content03">
	
<div id="img01" style="width: 100px; height: 100px; float: left; padding: 2px; margin-top: 15px; ">
	<a href="/piano">
	<img src="/picture/06_music/piano.png" width="100" height="100" ></a>

</div><hr>


<div style="width: 430px; height: 85px; margin-bottom: 30px;">

		<table>
			<tr>
				<td><a href="/piano" style="color: black; font-weight: bold;"> 누구나 가능한 1시간 1곡 연주!_정해진커리큘럼없이_only 수강생 버전으로</a></td>		
			</tr>
			
			<tr>
				<td style="font-size: 15px; font-family:fantasy; ">신촌/홍대 &nbsp; &nbsp; || &nbsp; &nbsp; &#8361; 25,000</td>
			</tr>
		</table>				
</div>

</div>

<div id="content04">
	
<div id="img01" style="width: 100px; height: 100px; float: left; padding: 2px; margin-top: 13px;">
	<a href="/drum">
	<img src="/picture/06_music/drum.png" width="100" height="100" ></a>

</div><hr>


<div style="width: 430px; height: 85px; margin-bottom: 30px;">

		<table>
			<tr>
				<td><a href="/drum" style="color: black; font-weight: bold;">1시간 동안 원없이 두드리는 유쾌한!! 드럼 레슨 :)</a></td>		
			</tr>
			
			<tr>
				<td style="font-size: 15px; font-family:fantasy; ">신림  &nbsp; &nbsp; || &nbsp; &nbsp; &#8361; 20,000</td>
			</tr>
		</table>				
</div>



</div>	

</div>
</div>


<div style="clear: both"></div><br><br><br><br><br>
<br><br><br><br><br><br><br><br>
<c:import url="/WEB-INF/views/layout/footer.jsp" />