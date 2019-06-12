<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />
<style type="text/css">


#wrap{
	border-color: black;

	display: inline-block;
	margin-left: 70px;
	margin-right: 10px;
	
	
}

#margin{
	margin: 0 auto;
	width: 1100px;

	
}



</style>
</head>
<body>



<div style="width: 1100px; margin-left: 400px;">
<div id="margin">
<c:forEach  items="${classlist}" var="c">

<div id="wrap">
<div id="img01" style="width: 400px; ">
	<label style="font-size: 30px;"><a href="/classdetail?classNum=${c.classNum }">  ${c.className }  </a></label>
	<a href="/classdetail?classNum=${c.classNum }">
	<img src="/picture/img01.png" width="400" height="300" style= "display:block;"  ></a>
</div><br>


<div id="content">

<table>
	<tr>
		<td width="400px" style="text-align: justify;" ><a href="/classdetail" style="color: black;">
		
		${c.classContent }
		
		</a></td>
	</tr>
	<tr>
		<td style="font-family: fantasy; font-weight: bold;
				color: darkorange;">${c.classPlace } &nbsp; &nbsp; || &nbsp; &nbsp; &#8361; ${c.classPrice }</td>
	</tr>		
</table>
</div>
</div>
</c:forEach>
</div></div><div style="clear: both;"></div>






<div id="pagingBox" style="margin-left: 900px" >
<c:import url="/WEB-INF/views/layout/paging.jsp" />
</div>

<div style="clear: both"></div>
<c:import url="/WEB-INF/views/layout/footer.jsp" />