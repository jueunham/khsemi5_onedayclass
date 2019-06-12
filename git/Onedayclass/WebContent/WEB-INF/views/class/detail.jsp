<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />




<style type="text/css">

#content{
	width: 1600px;

}

#content01{
	
	float: left;
	margin-left: 500px;
}

#content1-2{
	
	float: left;
	margin-left: 130px;
}

#hr{

	border: 0;
    height: 3px;
    background: #ccc;
  
}

</style>
</head>
<body>

<br><br>





<div id="content">
<div id="content01">

<div id="img01">
	<label style="font-size: 30px;"><a href="#"> 여행  </a></label>
	<a href="#">
	<img src="/picture/img01.png" width="400" height="300" style= "display:block;"  ></a>

<br>

<table>
	<tr>
		<td width="400px" style="text-align: justify;" >
		${viewdayClass.classContent }
		
		</td>
	</tr>	
</table>	
</div>
</div>


<div id="content1-2" style="width: 400px;">
	 
	<br><br>
	<label>위치: ${viewdayClass.classPlace }</label><hr>
	<label>요일: ${viewdayClass.classDay }</label><hr>
	<label>시간: ${viewdayClass.classTime }</label><hr>
	<label>가격: ${viewdayClass.classPrice }</label><hr>
	<label style="font-size: 15px; color: gray;">장소: 협의 후 결정</label><br>
	<label style="font-size: 15px; color: gray;">추가비용:</label><br><br><br><br>
		
	
	<a href="/classlist"><button style="width: 80px; height: 50px; margin: 15px; margin-left: 70px; border-radius:5px; background-color: pink; color: white">
	이전으로</button></a>
	
	<button style="width: 80px; height: 50px; margin-left: 45px; border-radius:5px; background-color: pink; color: white">
	<a href="#">예약하기</a></button>
	
	<button style="width: 80px; height: 50px; margin: 15px; margin-left: 70px; border-radius:5px; background-color: pink; color: white">
	<a href="#">찜하기</a></button>
	
	<button style="width: 80px; height: 50px; margin-left: 45px; border-radius:5px; background-color: pink; color: white">
	<a href="#">결제하기</a></button>	
	
		
</div>
</div><div style="clear: both;"></div><br><br>
<hr id="hr"><br>

<c:import url="/WEB-INF/views/class/reivew.jsp" />
