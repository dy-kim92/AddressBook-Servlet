<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "/WEB-INF/views/includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

		<h3>목록 
		<c:if test = "${ keyword != null }">
		(검색어 : ${ keyword }) 
		</c:if>
		</h3>
		
		<form action="<c:url value='/ab'/>">
			<input type = "hidden" name = "a" value = "search">
			<span>검색어</span>
			<input type = "text" name = "keyword" id = "keyword"/>
			<input type = "submit" value = "검색"/>
		</form><br/>
		
		<table border="1">
			<thead>
				<tr>
					<tr style = "background:lightgray">
					<th>이름</th><th>휴대전화</th><th>전화번호</th><th>도구</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items = "${ addressList }" var="vo" varStatus="status">
					<tr>
						<td>${ vo.name }</td>
						<td>${ vo.phone }</td>
						<td>${ vo.tel }</td>
						<td>
							<form action = "<c:url value="/ab" />">
							<input type = "hidden" name = "a" value = "delete" />
							<!-- 게시물의 no(PK값) -->
							<input type = "hidden" name = "id" value = ${ vo.id } />
							<!-- 전송 버튼 -->
							<input type = "submit" value = "삭제" />
						</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br/>
		
		<p>
			<a href="<c:url value='/ab?a=insert' />">새 주소 추가</a>
		</p>


<%@ include file = "/WEB-INF/views/includes/footer.jsp" %>