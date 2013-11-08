<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
	.menuCursor { cursor: pointer; cursor: hand; }
</style>

<div id="sidebar" class="span3">

	<ul id="sideManu" class="nav nav-tabs nav-stacked">
		<c:forEach var="category" items="${categories}">
			<c:if test="${category.idCategory == categoryId}">
				<li class="subMenu open"><a class="menuCursor">${category.name}</a>
					<ul>
						<c:forEach var="sub" items="${category.listSubCategories}">
							<li>
								<a href="select_category?id=${sub.idSubCategory}&categoryId=${category.idCategory}">
									<i style="vertical-align: middle;" class="icon-chevron-right"></i>${sub.name}
								</a>
							</li>
						</c:forEach>
					</ul>
			</c:if>
			<c:if test="${category.idCategory != categoryId}">
				<li class="subMenu"><a class="menuCursor">${category.name}</a>
					<ul style="display: none">
						<c:forEach var="sub" items="${category.listSubCategories}">
							<li><a href="select_category?id=${sub.idSubCategory}&categoryId=${category.idCategory}">
									<i  style="vertical-align: middle;" class="icon-chevron-right"></i>${sub.name}
								</a>
							</li>
						</c:forEach>
					</ul>
			</c:if>
				</li>
		</c:forEach>
	</ul>

	<br>
	<h4 style="text-align: center">Our Partners</h4>
	<div class="thumbnail">
		<a href="http://localhost:8080/dreamhost/"><img src="themes/images/mocks/filehosting.gif"></a>
	</div>
	<br>
	<div class="thumbnail">
		<a href="http://localhost:8080/memorium/"><img src="themes/images/mocks/forum.jpg"></a>
	</div>
</div>