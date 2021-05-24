<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TO DO LIST</title>
<link href="${rootPath}/static/css/basic.css?ver-001" rel="stylesheet" />
<script>
	document.addEventListener("DOMContentLoaded", function() {

		document.querySelector("button.btn_save").addEventListener("click",function(ev) {

					let td_date = document.querySelector("input[name='td_date']");
					let td_time = document.querySelector("input[name='td_time']");
					let td_todo = document.querySelector("textarea");
					let td_place = document.querySelector("input[name='td_place']");

					if (td_date.value == "") {
						alert("작성일자는 반드시 입력하세요.");
						td_date.focus();
						return false;
					}
					if (td_time.value == "") {
						alert("작성시간은 반드시 입력하세요.");
						td_time.focus();
						return false;
					}
					if (td_todo.value == "") {
						alert("할 일은 반드시 입력하세요.");
						td_todo.focus();
						return false;
					}

					alert("입력이 완료되었습니다.");
					document.querySelector("form.save").submit();

				})
	})
</script>

</head>

<body>
	
	<%@ include file = "/WEB-INF/views/header_nav.jsp" %>

	<form method="POST" class="save">
		<table>
			<tr>
				<td><label>작성일자</label></td>
				<td class="td_input"><input type="date" name="td_date"
					value="${DATE}" /></td>
				<td><label>작성시간</label></td>
				<td class="td_input"><input type="time" name="td_time"
					value="${TIME}" /></td>
			</tr>
			<tr>
				<td><label>할일</label></td>
				<td class="td_input" colspan="3"><textarea name="td_todo"></textarea>
				</td>
			</tr>
			<tr>
				<td><label>장소</label></td>
				<td class="td_input"><input name="td_place" /></td>
				<td><button class="btn_save" type="button">추가</button></td>
			</tr>
		</table>
	</form>

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