<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="text-center">
	<ul class="pagination pagination-sm">
		<!-- 처음으로 가기 -->
		<c:if test="${reportpaging.startPage ne 1 }">
		<li>
			<a href="/board/report/list"><span>&larr;처음</span></a>
		</li>
		</c:if>




		<!-- 이전 페이지 -->
		<!-- 첫 페이지라면 버튼 동작 안 되게 만들기 -->
		<c:if test="${reportpaging.curPage eq 1 }">
		<li class="disabled">
			<span>&laquo;</span>
		</li>
		</c:if>

		<c:if test="${reportpaging.curPage ne 1 }">
		<li>
			<a href="/board/report/list?curPage=${reportpaging.curPage-1 }"><span>&laquo;</span></a>
	    </li>
	    </c:if>





		<!-- 페이징 리스트 -->
		<c:forEach
	     begin="${reportpaging.startPage }" end="${reportpaging.endPage }"
	     var="i">
	
			<!-- 현재 보고 있는 페이지번호만 강조해주기 -->
			<c:if test="${reportpaging.curPage eq i}">
			<li class="active">
				<a href="/board/report/list?curPage=${i }">${i }</a>
			</li>
			</c:if>
		
			<c:if test="${reportpaging.curPage ne i}">
			<li>
				<a href="/board/report/list?curPage=${i }">${i }</a>
			</li>
			</c:if>
			
	    </c:forEach>



		
		<!-- 다음 페이지 -->
		<c:if test="${reportpaging.curPage eq reportpaging.totalPage }">
		<li class="disabled">
			<span>&raquo;</span>
		</li>
		</c:if>

		<c:if test="${reportpaging.curPage ne reportpaging.totalPage }">
		<li>
			<a href="/board/report/list?curPage=${reportpaging.curPage+1 }">
			<span>&raquo;</span>
		</a>
		</li>
		</c:if>
	</ul>
</div>
