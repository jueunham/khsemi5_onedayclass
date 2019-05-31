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
		친구들 혹은 가족들 등 소중한 사람들과 함께 하는 여행은 언제나 즐겁고 행복합니다.
		 하지만 다른 누군가와 함께 하는 것이 아닌, 오롯이 나 혼자 여행을 떠났을 때에 경험할 수 있는 기회들은 훨씬 더 다양해집니다.

		혼자 여행했을 때 현지 친구들과 친해질 수 있는 기회들도 많아지고
		내가 하고싶은대로 빠른 의사결정이 가능하죠.
		예상치 못한 사건사고를 겪기도 하고 그걸 해결하는 과정 속에서 배우고 성장합니다.

		그래서 저는 늘 사람들에게 꼭 혼자 여행해보라고 적극 추천해요.
		</td>
	</tr>	
</table>	
</div>
</div>


<div id="content1-2" style="width: 400px;">
	
	<br><br>
	<label>위치:</label><hr>
	<label>요일:</label><hr>
	<label>시간:</label><hr>
	<label style="font-size: 15px; color: gray;">장소: 협의 후 결정</label><br>
	<label style="font-size: 15px; color: gray;">추가비용:</label><br><br><br><br>
		
	
	<button style="width: 80px; height: 50px; margin: 15px; margin-left: 70px; border-radius:5px; background-color: pink; color: white">
	<a href="#">이전으로</a></button>
	
	<button style="width: 80px; height: 50px; margin-left: 45px; border-radius:5px; background-color: pink; color: white">
	<a href="#">예약하기</a></button>
	
	<button style="width: 80px; height: 50px; margin: 15px; margin-left: 70px; border-radius:5px; background-color: pink; color: white">
	<a href="#">찜하기</a></button>
	
	<button style="width: 80px; height: 50px; margin-left: 45px; border-radius:5px; background-color: pink; color: white">
	<a href="#">결제하기</a></button>	
	
		
</div>
</div><div style="clear: both;"></div><br><br>
<hr><br>

<c:import url="/WEB-INF/views/class/reivew.jsp" />
