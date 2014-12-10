<%@ page language="java"   pageEncoding="UTF-8" import="java.util.*,com.framelib.common.CommonConstants"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
	/*********PATH***********/
	String basePath = request.getContextPath();
	String imagePath = CommonConstants.IMAGE_PATH;
	String orderPath= CommonConstants.COMMON_PATH.getProperty("order.maxtp");
			
%>

<script type="text/javascript">  
	var basePath = '<%=basePath%>';
	var imagePath = '<%=imagePath%>';
	var orderPath='<%=orderPath%>';
</script>

<script type="text/javascript" src="<%=basePath%>/js/common/jquery-1.7.min.js" > </script>
<!-- 弹出层引入的资源 -->
<script type="text/javascript" src="<%=basePath%>/js/common/popup.js" > </script>
<link href="${pageContext.request.contextPath}/style/popup.css"
	rel="stylesheet" type="text/css" />

