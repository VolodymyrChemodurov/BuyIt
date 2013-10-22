<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div id="addNewSale">
	<div class="mycontent">
		<h3>Create new auction</h3>
		<div class="myrow">
			<span class="span-1">Product name:</span> <span class="span-2"><input
				name="productName" value="" /></span>
		</div>
		<div class="myrow">
			<span class="span-1">Category:</span> <span class="span-2"> <select
				id="category" name="category">
					<option value=""></option>
					<c:forEach var="category" items="${categories}">
						<option value="${category.idCategory}">${category.name}</option>
					</c:forEach>
			</select>
			</span>
		</div>
		<div class="myrow">
			<span class="span-1">Sub Category:</span> <span class="span-2">
				<c:if test=""></c:if> <select disabled="disabled" id="subCategory"
				name="subCategory">
					<option value=""></option>

			</select>
			</span>
		</div>


	</div>
	<div id="right-menu" class="my-right-content">

		<div id="form-container"></div>
	</div>

	


</div>

<div id="editPage" style="display: none;">
	<c:if test="${empty userActiveSales}">
		<h1 style="text-align: center;">Sorry, but you can not add new
			sale, because you are BLOKED</h1>
		<h3 style="text-align: center;">Contact with admin.</h3>

	</c:if>
</div>