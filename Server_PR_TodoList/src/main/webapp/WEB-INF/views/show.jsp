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
	
	<%@ include file = "/WEB-INF/views/showlist.jsp" %>

</body>
</html>