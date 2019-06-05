<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />

<style type="text/css">

 div {
        margin: 10px 0px;
        text-align: center;

      }
      
#member-management{
	width: 400px;
	height: 200px; 
	
	margin-left: 300px;
	margin-right: 20px;
	margin-botton: 20px;
	
	float : left;
	border: 4px dashed gray;
	border-radius: 80px / 40px;
	background-color : #bcbcbc
	}

#class-management{
	width: 400px;
	height: 200px; 

	margin-left: 100px;
	margin-right: 20px;
	margin-botton: 20px;
	
	float : left;
	border: 4px dashed gray;
	border-radius: 80px / 40px;
	background-color : #bcbcbc
	}
	
#banner-management{
	width: 400px;
	height: 200px; 
	
	margin-top : 50px;
	margin-left: 300px;
	margin-right: 20px;
	margin-botton: 20px;
	
	float : left;
	border: 4px dashed gray;
	border-radius: 80px / 40px;
	background-color : #bcbcbc
	}
	
	
#board-management{
	width: 400px;
	height: 200px; 
	
	margin-top : 50px;
	margin-left: 100px;
	margin-right: 20px;
	margin-botton: 20px;
	
	float : left;
	border: 4px dashed gray;
	border-radius: 80px / 40px;
	background-color : #bcbcbc
	}
	
</style>

<div class="row">
	<div id= "member-management">
		<br><br><br>
		<a href="/admin/member"> <h3>회원 관리</h3> </a>
	</div>
	<div id= "class-management">
		<br><br><br>
		<a href="/admin/class"><h3> 클래스 관리</h3></a>
	</div>
</div>
<div class="row">
	<div id= "banner-management">
		<br><br><br>
		<a href="/admin/banner"><h3> 배너 관리</h3></a>
	</div>
	<div id= "board-management">
		<br><br><br>
		<a href="/admin/board"><h3> 게시판 관리</h3></a>
	</div>
</div>

<br><br><br><br><br><br>
<c:import url="/WEB-INF/views/layout/footer.jsp" />