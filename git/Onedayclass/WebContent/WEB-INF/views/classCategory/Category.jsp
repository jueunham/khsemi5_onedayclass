<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/WEB-INF/views/layout/header.jsp" />


<style type="text/css">

*{
	margin: 0px;
	padding: 0px;
}


#menulist ul{
	list-style: none;
	
}

#menulist ul li {

	background-color: #6a5acd;
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

</style>
</head>
<body>

<div id="menulist">
		<ul>
			<li><a href="/design/main">디자인</a>
				<ul>
					<li><a href="/photoshop">포토샵</a></li>
					<li><a href="/illustrator">일러스트레이터</a></li>
					<li><a href="/architecture">건축</a></li>
					<li><a href="/productdesign">제품디자인</a></li>
					<li><a href="/editorialdesign">편집디자인</a></li>
				</ul>
			</li>

		
			<li><a href="/capability/main">실무역량</a>
				<ul>
					<li><a href="/excel">엑셀</a></li>
					<li><a href="/powerpoint">파워포인트</a></li>
					<li><a href="/marketing">마케팅</a></li>
					<li><a href="/branding">브랜딩</a></li>
					<li><a href="/financialaccounting">재무회계</a></li>
				</ul>
			</li>			
		
			<li><a href="/beauty/main">뷰티</a>
				<ul>
					<li><a href="/makeup">메이크업</a></li>
					<li><a href="/personalcolor">퍼스널컬러</a></li>
					<li><a href="/hair">헤어</a></li>
					<li><a href="/fashion">패션</a></li>
					<li><a href="/nail">네일</a></li>
				</ul>
			</li>		
		
			<li><a href="/image/main">영상</a>
				<ul>
					<li><a href="/premier">프리미어</a></li>
					<li><a href="/aftereffect">에프터이펙트</a></li>
					<li><a href="/filming">영상기획/촬영</a></li>
					<li><a href="/finalcut">파이널컷</a></li>
					<li><a href="/cinema4d">시포디</a></li>
				</ul>
			</li>		
		
			<li><a href="/foreignlanguage/main">외국어</a>
				<ul>
					<li><a href="/englishconversation">영어회화</a></li>
					<li><a href="/chinese">중국어</a></li>
					<li><a href="/toeic_toefl">토익/토플</a></li>
					<li><a href="/japanese">일본어</a></li>
					<li><a href="/french">프랑스어</a></li>
				</ul>
			</li>			
		
			<li><a href="/music/main">음악</a>
				<ul>
					<li><a href="/vocal">보컬</a></li>
					<li><a href="/piano">피아노</a></li>
					<li><a href="/drum">드럼</a></li>
					<li><a href="/composition">미디작곡</a></li>
					<li><a href="/guitar">기타연주</a></li>
				</ul>
			</li>	

			<li><a href="/lifestyle/main">라이프스타일</a>
				<ul>
					<li><a href="/handmade">핸드메이드</a></li>
					<li><a href="/picture">사진</a></li>
					<li><a href="/pottery">도예/물레</a></li>
					<li><a href="/cooking">요리/베이킹</a></li>
					<li><a href="/trip">여행/투어</a></li>
				</ul>
			</li>	

			<li><a href="/investmenttechniques/main">재테크</a>
				<ul>
					<li><a href="/twojob">투잡</a></li>
					<li><a href="/investmentinstocks">주식투자</a></li>
					<li><a href="/virtualmoney">가상화폐</a></li>
					<li><a href="/etctech">기타 재테크</a></li>
				</ul>
			</li>	

		
		</ul>
	</div><div style="clear: both;"></div>
	
<br><br>


</body>
</html>