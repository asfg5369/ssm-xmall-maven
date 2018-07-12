<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		<c:forEach var="listItem" items="${list}" varStatus="status">
			<dl id="menu-article">
				<dt>
					<i class="Hui-iconfont">${listItem.icon}</i> ${listItem.name }<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<c:forEach var="childItem" items="${listItem.children }"
							varStatus="childStatus">
							<li><a data-href="${childItem.url}"
								data-title="${childItem.name}" href="javascript:void(0)"><i
									class="Hui-iconfont">${childItem.icon}</i>${childItem.name}</a></li>
						</c:forEach>
					</ul>
				</dd>
			</dl>
		</c:forEach>
	</div>
</aside>
