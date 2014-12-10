<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品详情测试页</title>
</head>
<body>
	<div align="center">
		<form action="${pageContext.request.contextPath}/apply/addInit.htm">
			<br /> <br /> <br /> <br /> <br /> <br />
			<table>
				<tr>
					<td>活动编号</td>
					<td><input type="text" name="activityId" /></td>
				</tr>
				<tr>
					<td>规格编号</td>
					<td><input type="text" name="standardId" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="去申请" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>