<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색하기</title>
<link href="${rootPath}/static/css/basic.css?ver-002" rel="stylesheet" />
</head>
<body>
	<%@ include file = "/WEB-INF/views/header_nav.jsp" %>
	
	
	<form method="POST" class="search">
		<table>
			<tr>
				<td><label>작성날짜로 검색하기</label></td>
				<td class="td_input"><input type="date" name="td_date"
					value="${DATE}" /></td>
				<td><button style="width: 150px">검색하기</button></td>
			</tr>
		</table>
	</form>
	
	
	
</body>
</html>