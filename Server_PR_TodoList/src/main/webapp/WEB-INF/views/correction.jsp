<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선택한 목록</title>
<link href="${rootPath}/static/css/basic.css?ver-002" rel="stylesheet" />

<script>
	document.addEventListener("DOMContentLoaded", function(){
		
		document.querySelector("form.tb_one").addEventListener("click",function(ev) {
			let className = ev.target.className ;
			
			if(className == "btn_update") {
				
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
				
				alert("수정을 완료하였습니다.");
				//document.location.href="${rootPath}/one/update?td_seq="+${TDVO.td_seq};
				document.querySelector("form.tb_one").submit();
				
			} else if(className == "btn_delete") {
				
				if(confirm("정말 TO DO 내역을 삭제 하시겠습니까?")) {
					document.location.replace("${rootPath}/one/delete?td_seq="+${TDVO.td_seq});
					//document.querySelector("form.tb_one").submit();
				}
			}
		})
	})	
</script>

</head>
<body>
	<%@ include file = "/WEB-INF/views/header_nav.jsp" %>

	<form class="tb_one" method="POST" action = "${rootPath}/one/update?td_seq=${TDVO.td_seq}">
	<table>
		<tr>
			<td>작성일자</td>
			<td class="td_input"><input type="date" name="td_date"  value="${TDVO.td_date}" /></td>
		</tr>
		<tr>
			<td>작성시간</td>
			<td class="td_input"><input type="time" name="td_time" value="${TDVO.td_time}" /></td>
		</tr>
		<tr>
			<td>할 일</td>
			<td class="td_input" colspan="3"><textarea name="td_todo">${TDVO.td_todo}</textarea></td>
		</tr>
		<tr>
			<td>장소</td>
			<td class="td_input"><input name="td_place" value ="${TDVO.td_place}"/></td>
		</tr>
		<tr>
			<td style = "text-align: right; align-content: right; padding-right:7% " colspan="2">
			<button class = "btn_update" type="button">수정하기</button>
			<button class = "btn_delete" type="button">삭제하기</button>
			</td>
		</tr>
	</table>
	</form>


	
	
</body>
</html>