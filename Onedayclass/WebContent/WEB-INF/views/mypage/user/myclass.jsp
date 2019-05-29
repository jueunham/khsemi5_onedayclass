<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">


<c:import url="/WEB-INF/views/layout/header.jsp" />

<div class="container">

<div class="row">
<c:import url="/WEB-INF/views/mypage/user/menu.jsp" />


<div class="col order-1">
<table>
<tbody>
<tr>
<td style="width:200px; height:50px; background:lightgray;">
마이클래스(신청한 클래스)
</td>
</tr>
<tr>
<td><img src="/"></td>
<td>클래스 명 :  ${className }<br></td>
<td>신청일 : ${payDate }<br></td>
</tr>
<tr>
<td><img src="/"></td>
<td>클래스 명 :  ${className }<br></td>
<td>신청일 : ${payDate }<br></td>
</tr>
<tr>
<td><img src="/"></td>
<td>클래스 명 :  ${className }<br></td>
<td>신청일 : ${payDate }<br></td>
</tr>
</tbody>
</table>

</div>

</div>

</div>
<br>
<br>
<br>
<br><br>
<br>
<c:import url="/WEB-INF/views/layout/footer.jsp" />
