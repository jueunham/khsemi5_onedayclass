<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />
<style type="text/css">



#menulist ul{
	list-style: none;
	
}

#menulist ul li {

	background-color: #4169e1;
	border: 1px solid #fff;
	width: 130px;
	height: 40px;
	line-height: 40px;
	text-align: center;
	float: left;
	position: relative;
	border-radius: 10px;
		
}

#menulist ul li a{
	
	text-decoration: none;
	color: white;
	display: block;
	
}

#menulist ul li a:hover{

	background-color: #e8491d;
}

#menulist ul ul {
	display: none;
	position: absolute;
}

#menulist ul li:hover > ul {

	display: block;
}

#menulist {
	
	width: 1600px;
	margin-left: 400px;
	
	
}


#pasingBox{
	position: relative;
}


#img01 {

	margin-left: 400px;

}


</style>
</head>
<body>

	<div id="menulist">
		<ul>
			<li><a href="#">디자인</a>
				<ul>
					<li><a href="#">포토샵</a></li>
					<li><a href="#">일러스트레이터</a></li>
					<li><a href="#">건축</a></li>
					<li><a href="#">제품디자인</a></li>
					<li><a href="#">편집디자인</a></li>
				</ul>
			</li>

		
			<li><a href="#">실무역량</a>
				<ul>
					<li><a href="#">엑셀</a></li>
					<li><a href="#">파워포인트</a></li>
					<li><a href="#">마케팅</a></li>
					<li><a href="#">브랜딩</a></li>
					<li><a href="#">재무회계</a></li>
				</ul>
			</li>			
		
			<li><a href="#">뷰티</a>
				<ul>
					<li><a href="#">메이크업</a></li>
					<li><a href="#">퍼스널컬러</a></li>
					<li><a href="#">헤어</a></li>
					<li><a href="#">패션</a></li>
					<li><a href="#">네일</a></li>
				</ul>
			</li>		
		
			<li><a href="#">영상</a>
				<ul>
					<li><a href="#">프리미어</a></li>
					<li><a href="#">에프터이펙트</a></li>
					<li><a href="#">영상기획/촬영</a></li>
					<li><a href="#">파이널컷</a></li>
					<li><a href="#">시포디</a></li>
				</ul>
			</li>		
		
			<li><a href="#">외국어</a>
				<ul>
					<li><a href="#">영어회화</a></li>
					<li><a href="#">중국어</a></li>
					<li><a href="#">토익/토플</a></li>
					<li><a href="#">일본어</a></li>
					<li><a href="#">프랑스어</a></li>
				</ul>
			</li>			
		
			<li><a href="#">음악</a>
				<ul>
					<li><a href="#">보컬</a></li>
					<li><a href="#">피아노</a></li>
					<li><a href="#">드럼</a></li>
					<li><a href="#">미디작곡</a></li>
					<li><a href="#">기타연주</a></li>
				</ul>
			</li>	

			<li><a href="#">라이프스타일</a>
				<ul>
					<li><a href="#">핸드메이드</a></li>
					<li><a href="#">사진</a></li>
					<li><a href="#">도예/물레</a></li>
					<li><a href="#">요리/베이킹</a></li>
					<li><a href="#">여행/투어</a></li>
				</ul>
			</li>	

			<li><a href="#">재테크</a>
				<ul>
					<li><a href="#">투잡</a></li>
					<li><a href="#">주식투자</a></li>
					<li><a href="#">가상화폐</a></li>
					<li><a href="#">기타 재테크</a></li>
				</ul>
			</li>	

		
		</ul>
	</div>

<br><br><br>

<div id="img01">
	
	<a href="#">
	<img src="/picture/img01.png" width="400" height="300" style= "display:block;"  ></a>
	가나다라마바사
	

</div>



<div id="pagingBox">
<c:import url="/WEB-INF/views/layout/paging.jsp" />
</div>

<br>
<c:import url="/WEB-INF/views/layout/footer.jsp" />