<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">

<!-- common CSS -->
<link rel="stylesheet" href="<c:url value='/resources/common/css/common.css'/>" >

<!-- fontawesome 아이콘 CSS -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">


</head>
<body>

<!-- 상단 메뉴바{s} -->
<nav class="navbar navbar-expand-sm navbar-light bg-white">
<div class="container" style='background:white'>
<span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
  <a class="navbar-brand" href="/main">OneDayClass</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample03" 
  aria-controls="navbarsExample03" aria-expanded="false" aria-label="Toggle navigation">
  <span class="navbar-toggler-icon"></span>
  </button>
<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>

  <div class="collapse navbar-collapse" id="navbarsExample03">
    
	<form class="form-inline my-2">
     <input class="form-control" style="width:400px; margin:center " type="text" placeholder="클래스를 검색해보세요!!">
    </form>
  </div>
  
	<span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
	<div class="collapse navbar-collapse navbar-right">
 	<ul class="navbar-nav mr-auto ">
      <li class="nav-item">
        <a class="nav-link" href="/info/introduce">서비스 소개 <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/board/notice/list">게시판</a>
      </li>
     
     <!-- 로그인 전이면 로그인, 회원가입 창 표시 -->
     <c:if test="${userid eq null }">
      <li class="nav-item">
        <a class="nav-link" href="/member/login">로그인</a>
      </li>
	  
	  <li class="nav-item">
        <a class="nav-link" href="/member/join">회원가입</a>
      </li>
      </c:if>
      
      <!-- 로그인 한 후에는 마이페이지 창 표시 -->
     <c:if test="${userid ne null }">
     	<!-- 유저가 일반회원이면 회원마이페이지로 연결, 호스트이면 호스트마이페이지로 연결 -->
     	<c:if test="${userLevel eq user }">
	     	<li class="nav-item">
	        <a class="nav-link" href="/mypage/member">마이페이지</a>
	        </li>
     	</c:if>
     	<c:if test="${userLevel eq host }">
     		<li class="nav-item">
	        <a class="nav-link" href="/mypage/host">마이페이지</a>
	        </li>
     	</c:if>
     </c:if>
     
    </ul>
  </div>
</div>
</nav>
