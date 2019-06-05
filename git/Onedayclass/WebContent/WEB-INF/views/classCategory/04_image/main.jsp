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
		<td><a href="/premier" style="color: black; font-weight: bold;" >프리미어</a></td>
	</tr>

	<tr>
		<td><a href="/aftereffect" style="color: black; font-weight: bold;" >에프터이펙트</a></td>
	</tr>

	<tr>
		<td><a href="/filming" style="color: black; font-weight: bold;" >영상기획/촬영</a></td>
	</tr>
	
	<tr>
		<td><a href="/finalcut" style="color: black; font-weight: bold;" >파이널컷</a></td>
	</tr>
	
	<tr>
		<td><a href="/cinema4d" style="color: black; font-weight: bold;" >시포디</a></td>
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
	<a href="/filming">
	<img src="/picture/04_image/filming.png" width="400px;" height="256px;" style= "display:block;"  ></a>

<br>

<table>
	<tr>
		<td width="400px" style="text-align: justify;" >
		<a href="/filming" style="color: black; font-weight: bold;">디자이너에게 배우는 영상편집X톤보정X모션그래픽 </a><br><br>
		
		<label style="font-size: 15px; font-family:fantasy; ">충무로 &nbsp; &nbsp; || &nbsp; &nbsp; &#8361; 30,000</label>
		
		</td>
	</tr>	
</table>


</div>
</div>	
</div>	

<div id="subwrap">

<div id="content02">
	
<div id="img01" style="width: 100px; height: 85px; float: left; padding: 2px; margin-top: 5px; ">
	<a href="/aftereffect">
	<img src="/picture/04_image/aftereffect.png" width="100" height="100" ></a>

</div>


<div style="width: 430px; height: 85px; margin-bottom: 30px; " >

		<table>
			<tr>
				<td><a href="/aftereffect" style="color: black; font-weight: bold;">에펙/프리미어 1:1로 4회만에 기초잡고 끝내버리기!</a></td>		
			</tr>
			
			<tr>
				<td style="font-size: 15px; font-family:fantasy; ">신촌/홍대  &nbsp; &nbsp; || &nbsp; &nbsp; &#8361; 30,000</td>
			</tr>
		</table>				
</div>



<div id="content03">
	
<div id="img01" style="width: 100px; height: 100px; float: left; padding: 2px; margin-top: 15px; ">
	<a href="/aftereffect">
	<img src="/picture/04_image/aftereffect02.png" width="100" height="100" ></a>

</div><hr>


<div style="width: 430px; height: 85px; margin-bottom: 30px;">

		<table>
			<tr>
				<td><a href="/aftereffect" style="color: black; font-weight: bold;">누구나 After effect 할 수 있습니다! 최강의 실무자와 함께라면...</a></td>		
			</tr>
			
			<tr>
				<td style="font-size: 15px; font-family:fantasy; ">강남  &nbsp; &nbsp; || &nbsp; &nbsp; &#8361; 20,000</td>
			</tr>
		</table>				
</div>

</div>

<div id="content04">
	
<div id="img01" style="width: 100px; height: 100px; float: left; padding: 2px; margin-top: 13px;">
	<a href="/finalcut">
	<img src="/picture/04_image/finalcut.png" width="100" height="100" ></a>

</div><hr>


<div style="width: 430px; height: 85px; margin-bottom: 30px;">

		<table>
			<tr>
				<td><a href="/finalcut" style="color: black; font-weight: bold;">파이널컷 기초부터 차근차근 - 1:1 맞춤형으로 쉽고 재밌게~</a></td>		
			</tr>
			
			<tr>
				<td style="font-size: 15px; font-family:fantasy; ">강남  &nbsp; &nbsp; || &nbsp; &nbsp; &#8361; 30,000</td>
			</tr>
		</table>				
</div>



</div>	

</div>
</div>


<div style="clear: both"></div><br><br><br><br><br>
<br><br><br><br><br><br><br><br>
<c:import url="/WEB-INF/views/layout/footer.jsp" />