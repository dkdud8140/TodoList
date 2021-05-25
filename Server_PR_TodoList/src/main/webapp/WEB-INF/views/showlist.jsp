<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<link href="${rootPath}/static/css/basic.css?ver-001" rel="stylesheet" />

<script>
	document.addEventListener("DOMContentLoaded",function(){
		document.querySelector("table#tb_list").addEventListener("click",function(ev){
			let tag_name = ev.target.tagName;
			if(tag_name == "TD") {
				let td_seq = ev.target.closest("TR").dataset.seq;
				document.location.href="${rootPath}/one?td_seq=" + td_seq ;
			}
		})
		
	})
	
</script>


	<table id="tb_list">
		<tr style ="pointer-events: none;">
			<td style="width: 100px">No.</td>
			<td style="width: 150px">작성일자</td>
			<td style="width: 500px">할일</td>
			<td style="width: 200px">장소</td>
		</tr>
		<c:forEach items="${TDLIST}" var="td" varStatus="index">
			<tr data-seq="${td.td_seq}">
				<td>${index.count}</td>
				<td>${td.td_date}</td>
				<td>${td.td_todo}</td>
				<td>${td.td_place}</td>
			</tr>
		</c:forEach>
	</table>