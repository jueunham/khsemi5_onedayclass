<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<style>
.menubar{

margin-left: 20px;
margin-bottom: 30px;
width: 230px;
height:350px;

background:lightgray;

}
 .center{
width:200px;
margin: 0 auto;
} 

</style>

<br>
<br>
<br>

<nav>

<div class="col-4">
<div class="menubar" >
<form>


<div class="center">
<br>
<img src="/resources/images/Koala.jpg" style="width:50px; height:50px;">
수강생 ${userid }님
</div>
<br>
<div class="center">
<button type="button" class="btn btn-outline-secondary" onclick="location.href='/mypage/user/upinfo'">정보수정</button>
<button type="button" class="btn btn-outline-secondary" onclick="location.href='/main'">로그아웃</button>
</div>
</form>
<ul class="nav flex-column">
  <li class="nav-item">
    <a class="nav-link active" href="/mypage/user/myclass">마이 클래스</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="/mypage/user/wishclass">찜한 클래스</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="/mypage/user/written">내가 작성한 글</a>
  </li>
</ul>
<div class="center">
<br>
<button type="button" class="btn btn-outline-secondary" onclick="location.href='/main'">회원탈퇴</button>
</div>
</div>
</div>

</nav>