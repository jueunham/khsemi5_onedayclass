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


#pasingBox{
	
	position: relative;
	
}





#content01{
	border-color: black;
	width: 1600px;

}

#img01{

	float: left;
	margin-left: 470px;
}

#img02{

	float: left;
	margin-left: 100px;
}



#content02{
	border-color: black;
	width: 1600px;
}

#img03{

	float: left;
	margin-left: 470px;
}

#img04{

	float: left;
	margin-left: 100px;
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


<div id="content01">

<div id="img01">
	<label style="font-size: 30px;"><a href="/trip"> 여행  </a></label>
	<a href="/trip">
	<img src="/picture/img01.png" width="400" height="300" style= "display:block;"  ></a>

<br>

<table>
	<tr>
		<td width="400px" style="text-align: justify;" ><a href="/trip" style="color: black;">
		친구들 혹은 가족들 등 소중한 사람들과 함께 하는 여행은 언제나 즐겁고 행복합니다.
		 하지만 다른 누군가와 함께 하는 것이 아닌, 오롯이 나 혼자 여행을 떠났을 때에 경험할 수 있는 기회들은 훨씬 더 다양해집니다.

		혼자 여행했을 때 현지 친구들과 친해질 수 있는 기회들도 많아지고
		내가 하고싶은대로 빠른 의사결정이 가능하죠.
		예상치 못한 사건사고를 겪기도 하고 그걸 해결하는 과정 속에서 배우고 성장합니다.

		그래서 저는 늘 사람들에게 꼭 혼자 여행해보라고 적극 추천해요.
		</a></td>
	</tr>	
</table>	
</div>



<div id="img02">
	<label style="font-size: 30px;"><a href="/beauty/main"> 뷰티 </a></label>
	<a href="/beauty/main">
	<img src="/picture/img02.png" width="400" height="300" style= "display:block;"  ></a>
<br>

<table>
	<tr>
		<td width="400px" style="text-align: justify;" ><a href="/beauty/main" style="color: black;">
		퍼스널 컬러부터 저렴이 고렴이 추천까지 정말 메이크업에 대한 많은 정보들이 넘실거리고 있는 요즘이지만, 자신한테 정말 딱 맞는, 그리고 나를 정말 빛내주는 메이크업을 찾는 건 정말 어려운 일이예요.
		그리고 사람이 참 아이러니한게 남의 떡이 더 커보인다고 웜톤이면 쿨톤처럼 핑크핑크한 메이크업이 더 예뻐보이고, 쿨톤이면 여리여리한 코랄 메이크업이 더 예뻐보이지 않으세요?
		좀 더 본인에게 어울리는 메이크업이 무엇인지 스스로 느끼고, 배워보는 시간입니다. 

		</a></td>
	</tr>	
</table>

</div>
</div> <div style="clear: both"></div><br><br>




<div id="content02">

<div id="img03">
	<label style="font-size: 30px;"><a href="/excel"> 엑셀 </a></label>
	<a href="/excel">
	<img src="/picture/img03.png" width="400" height="300" style= "display:block;"  ></a>

<br>

<table>
	<tr>
		<td width="400px" style="text-align: justify;" ><a href="/excel" style="color: black;">
		EXCEL 왕초보도 [Excel∴lerator] 밟고 업무 속도 UP!
		때론 천천히 걷다가도 빨리 달려야 할 때가 있습니다.
		하루하루 밀려만 가는 일거리, 늘지 않는 업무 속도 때문에
		엑셀을 배우고는 싶지만 시간과 비용 때문에 망설이셨다면,
		지금이 바로 [EXCELator]강의를 통해 달릴 시간입니다!
		왕초보분들도 '엑셀 고수' 소리를 들을 수 있도록
		가장 '쉽게', '빠르게', '쓸모있게' 준비했습니다!
		</a></td>
	</tr>	
</table>	
</div>



<div id="img04">
	<label style="font-size: 30px;"><a href="/composition"> 작곡  </a></label>
	<a href="/composition">
	<img src="/picture/img04.png" width="400" height="300" style= "display:block;"  ></a>
<br>

<table>
	<tr>
		<td width="400px" style="text-align: justify;" ><a href="/composition" style="color: black;">
		 누가 여러분의 취미를 물으면 '작곡'이라고 답하세요!
		기술의 발달이 악기를 다뤄본 적이 없어도, 음악적인 기초가 없어도,
		곡을 쓸 수 있도록 많은 부분들의 진입장벽을 낮춰주고 있습니다.
		이제 여러분이 필요한 것은 음악에 대한 열정과 첫 시도입니다.

		</a></td>
	</tr>	
</table>

</div>

</div> <div style="clear: both"></div><br><br>



<div id="pagingBox" style="margin-left: 900px" >
<c:import url="/WEB-INF/views/layout/paging.jsp" />
</div>

<div style="clear: both"></div>
<c:import url="/WEB-INF/views/layout/footer.jsp" />