<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsps/includes/import.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网站屏蔽词</title>
<script type="text/javascript">
function addWord(){
	if($("#shieldWord").val().trim().length>0){
		$("#addForm").submit();
	}else{
		alert("屏蔽词不能为空！");
	}
}
function search(){
	var url =  "${pageContext.request.contextPath}/common/getShieldWordList.htm";
	$("#addForm").attr("action",url);
	$("#addForm").submit();
	
}
</script>
</head>
<body>
	<form id="addForm"
		action="${pageContext.request.contextPath}/common/addShieldWord.htm"
		method="post">
		<table align="center">
			<tr>
				<td>屏蔽词：</td>
				<td><input type="text" id="shieldWord" name="shieldWord" /></td>
				<td><input type="button" onclick="addWord()" value="添加" />&nbsp;&nbsp;&nbsp;<input type="button" onclick="search()" value="查询" /></td>
			</tr>
		</table>
	</form>

	<table align="center" width="40%" border="1" cellpadding="2" cellspacing="0">
		<thead>
			<tr>
				<td align="center">序号</td>
				<td align="center">屏蔽词</td>
				<td align="center">操作</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${shieldWordSet}" var="word" varStatus="s">
				<tr>
					<td align="center" valign="middle">${s.getCount()}</td>
					<td align="center" valign="middle">${word}</td>
					<td align="center" valign="bottom">
						<form
							action="${pageContext.request.contextPath}/common/deleteShieldWord.htm"
							method="post">
							 <input
								type="submit" value="删除" />
								<input type="hidden" name="shieldWord" value="${word}" />
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>