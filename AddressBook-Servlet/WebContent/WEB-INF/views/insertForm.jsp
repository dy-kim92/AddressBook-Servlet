<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "/WEB-INF/views/includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h3>새 주소 등록</h3>
	
		<form action="<c:url value='/ab' />" method="post">
			<input type="hidden" name="a" value="insert"/>
			
			<label for = "name">이름</label><br/>
			<input type="text" name="name" id="name"><br/>
			
			<label for = "phone">휴대전화</label><br/>
			<input type="text" name="phone" id="phone"><br/>
			
			<label for = "tel">집전화</label><br/>
			<input type="text" name="tel" id="tel"><br/>
			
			<br/>
			<input type="submit" value="주소 등록">
		</form>
			<br/>
			<a href = "<c:url value = "/ab" />">목록보기</a>

<%@ include file = "/WEB-INF/views/includes/footer.jsp" %>