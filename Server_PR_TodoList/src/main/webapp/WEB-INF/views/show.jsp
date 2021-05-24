<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To Do List</title>
<link href="${rootPath}/static/css/basic.css?ver-002" rel="stylesheet" />
</head>
<body>
	<%@ include file = "/WEB-INF/views/header_nav.jsp" %>
		<table class="tb_list">
		<tr>
			<td style="width: 100px">No.</td>
			<td style="width: 150px">작성일자</td>
			<td style="width: 500px">할일</td>
			<td style="width: 200px">장소</td>
		</tr>
		<c:forEach items="${TDLIST}" var="td" varStatus="index">
			<tr>
				<td>${index.count}</td>
				<td>${td.td_date}</td>
				<td>${td.td_todo}</td>
				<td>${td.td_place}</td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>