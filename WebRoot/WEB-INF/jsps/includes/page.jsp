<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


	<div class="yahoo">
		<c:if test="${page.pageNum gt 1}">
			<a href="javascript:toShowPage(${page.pageNum-1});">&lt; </a>
		</c:if>
		<c:if test="${page.pageNum <= 1}">
			<span class="disabled"> &lt; </span>
		</c:if>
		<c:if test="${page.pageNum<=5}">
			<c:forEach var="i" begin="1" end="${10}" step="1">
				<c:if test="${i<=page.totalPage}">
					<c:if test="${page.pageNum==i}">
						<span class="current">${page.pageNum}</span>
					</c:if>
					<c:if test="${page.pageNum!=i}">
						<a href="javascript:toShowPage(${i});">${i}</a>
					</c:if>
				</c:if>
			</c:forEach>
		</c:if>

		<c:if test="${page.pageNum>5}">
			<c:forEach var="i" begin="${page.pageNum-5}" end="${page.pageNum+5}"
				step="1">
				<c:if test="${i<=page.totalPage}">
					<c:if test="${page.pageNum==i}">
						<span class="current">${page.pageNum}</span>
					</c:if>
					<c:if test="${page.pageNum!=i}">
						<a href="javascript:toShowPage(${i});">${i}</a>
					</c:if>
				</c:if>
			</c:forEach>
		</c:if>





		<c:if test="${page.pageNum < page.totalPage}">
			<a href="javascript:toShowPage(${page.pageNum+1});">&gt; </a>
		</c:if>
		<c:if test="${page.pageNum >= page.totalPage}">
			<span class="disabled"> &gt; </span>
		</c:if>
		<input type="hidden" id="hidden_allPage" value="${page.totalPage}" />
		共${page.totalPage}页,${page.totalCount}条记录,去第 <input name="" type="text" style="color: #000000;font-size:10px" id="currentPage" /> 页
		<a href="javascript:toThisPage(${page.totalPage});" class="go">GO</a>
	</div>

