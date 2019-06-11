<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/WEB-INF/views/classCategory/Category.jsp" />

<style type="text/css">

@import url(//fonts.googleapis.com/earlyaccess/nanumgothiccoding.css);
.ngc{font-family: 'Nanum Gothic Coding', monospace;}

#block01{
	width: 1600px;
	display: inline-block;
}



#wrap01{
	float: left;
}

#content{


}

#contentsub{
	border: 1px solid #ccc;
}



#img01{
	border: 1px solid #ccc;
}





#txt01{
	display: -webkit-box;
	display: -ms-flexbox;
	display: box;
	margin-top:1px;
	max-height:80px;
	overflow:hidden;
	vertical-align:top;
	text-overflow: ellipsis;
	word-break:break-all;
	-webkit-box-orient:vertical;
	-webkit-line-clamp:3		
}



</style>



</head>
<body>

<div id="block01" >

<div id="wrap01">
	<a href="#"><img id="img01" src="/picture/test.png" width="300px;" height="300px;" 
		style="margin-left: 440px; margin-top: 30px; margin-right: 30px;"></a>
</div><div style="clear: both;"></div>

<div id="content">
<table id="contentsub" style="width: 300px; margin-left: 440px; height: 200px;">

	<tr>		
		<td>
				<label id="txt01" class="ngc"> <a href="#" style="color: black; font-weight: bold;">
					 클래스 내용ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ 
					 ddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd
					 </a></label></td>		
	
	</tr>
	
	
	<tr>
		<td> <label style="font-family: fantasy; font-weight: bold;
						 color: darkorange;"> &nbsp;&nbsp; &#8361; 50,000 </label></td>
	</tr>
	
	
	<tr>
		<td> <label style="font-family: fantasy; font-weight: bold;
						 color: darkorange;"> &nbsp;&nbsp; 호스트 명 &nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp;신촌/홍대 </label></td>
	</tr>
	
</table>
</div>

</div>


	 


	


<br><br><br><br><br><br><br><br><br>

<div id="pagingBox" style="margin-left: 900px" >
<c:import url="/WEB-INF/views/layout/paging.jsp" />
</div>

<div style="clear: both"></div>
<c:import url="/WEB-INF/views/layout/footer.jsp" />