<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="sidebar" class="span3">

	<ul id="sideManu" class="nav nav-tabs nav-stacked">
		<c:forEach var="category" items="${categories}">
			<c:if test="${category.idCategory == categoryId}">
				<li class="subMenu open"><a>${category.name}</a>
					<ul>
						<c:forEach var="sub" items="${category.listSubCategories}">
							<li>
								<a href="select_category?id=${sub.idSubCategory}&categoryId=${category.idCategory}">
									<i class="icon-chevron-right"></i>${sub.name}
								</a>
							</li>
						</c:forEach>
					</ul>
			</c:if>
			<c:if test="${category.idCategory != categoryId}">
				<li class="subMenu"><a>${category.name}</a>
					<ul style="display: none">
						<c:forEach var="sub" items="${category.listSubCategories}">
							<li><a href="select_category?id=${sub.idSubCategory}&categoryId=${category.idCategory}">
									<i class="icon-chevron-right"></i>${sub.name}
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
		<a href="#"><img src="themes/images/mocks/filehosting.gif"></a>
	</div>
	<br>
	<div class="thumbnail">
		<a href="#"><img src="themes/images/mocks/forum.jpg"></a>
	</div>
</div>