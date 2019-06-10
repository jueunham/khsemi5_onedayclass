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
		<td><a href="/englishconversation" style="color: black; font-weight: bold;" >영어회화</a></td>
	</tr>

	<tr>
		<td><a href="/chinese" style="color: black; font-weight: bold;" >중국어</a></td>
	</tr>

	<tr>
		<td><a href="/toeic_toefl" style="color: black; font-weight: bold;" >토익/토플</a></td>
	</tr>
	
	<tr>
		<td><a href="/japanese" style="color: black; font-weight: bold;" >일본어</a></td>
	</tr>
	
	<tr>
		<td><a href="/french" style="color: black; font-weight: bold;" >프랑스어</a></td>
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
	<a href="/toeic_toefl">
	<img src="/picture/05_foreignlanguage/toeic_toefl.png" width="400px;" height="256px;" style= "display:block;"  ></a>

<br>

<table>
	<tr>
		<td width="400px" style="text-align: justify;" >
		<a href="/toeic_toefl" style="color: black; font-weight: bold;">TOEIC, TOEFL 고수와 함께 고득점 족집게 수업 </a><br><br>
		
		<label style="font-size: 15px; font-family:fantasy; ">강남 &nbsp; &nbsp; || &nbsp; &nbsp; &#8361; 30,000</label>
		
		</td>
	</tr>	
</table>


</div>
</div>	
</div>	

<div id="subwrap">

<div id="content02">
	
<div id="img01" style="width: 100px; height: 85px; float: left; padding: 2px; margin-top: 5px; ">
	<a href="/chinese">
	<img src="/picture/05_foreignlanguage/chinese.png" width="100" height="100" ></a>

</div>


<div style="width: 430px; height: 85px; margin-bottom: 30px; " >

		<table>
			<tr>
				<td><a href="/chinese" style="color: black; font-weight: bold;">대세는 중국어♥ 하루만에 패턴 익히고 중국어회화 술술~ 해보자!</a></td>		
			</tr>
			
			<tr>
				<td style="font-size: 15px; font-family:fantasy; ">압구정  &nbsp; &nbsp; || &nbsp; &nbsp; &#8361; 25,000</td>
			</tr>
		</table>				
</div>



<div id="content03">
	
<div id="img01" style="width: 100px; height: 100px; float: left; padding: 2px; margin-top: 15px; ">
	<a href="/japanese">
	<img src="/picture/05_foreignlanguage/japanese.png" width="100" height="100" ></a>

</div><hr>


<div style="width: 430px; height: 85px; margin-bottom: 30px;">

		<table>
			<tr>
				<td><a href="/japanese" style="color: black; font-weight: bold;"> 한국식 일어 NO!! 일본인스러운 일본어 구사하게 해드립니다!</a></td>		
			</tr>
			
			<tr>
				<td style="font-size: 15px; font-family:fantasy; ">신촌/홍대 &nbsp; &nbsp; || &nbsp; &nbsp; &#8361; 25,000</td>
			</tr>
		</table>				
</div>

</div>

<div id="content04">
	
<div id="img01" style="width: 100px; height: 100px; float: left; padding: 2px; margin-top: 13px;">
	<a href="/finalcut">
	<img src="/picture/05_foreignlanguage/englishconversation.png" width="100" height="100" ></a>

</div><hr>


<div style="width: 430px; height: 85px; margin-bottom: 30px;">

		<table>
			<tr>
				<td><a href="/englishconversation" style="color: black; font-weight: bold;">미국식 영어발음 3시간만에 끝내기! 발음교정을 위한 꿀팁 명강의!</a></td>		
			</tr>
			
			<tr>
				<td style="font-size: 15px; font-family:fantasy; ">강남  &nbsp; &nbsp; || &nbsp; &nbsp; &#8361; 20,000</td>
			</tr>
		</table>				
</div>



</div>	

</div>
</div>


<div style="clear: both"></div><br><br><br><br><br>
<br><br><br><br><br><br><br><br>
<c:import url="/WEB-INF/views/layout/footer.jsp" />