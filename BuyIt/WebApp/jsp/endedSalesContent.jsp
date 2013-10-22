<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div id="endedSales">
	<c:if test="${empty userEndedSales}">
		<h1 style="text-align: center;">Sorry, but you have not any ended
			sales!</h1>
		<h3 style="text-align: center;">You can add new sale, and when it
			will ended you can see it here</h3>
	</c:if>
	<c:if test="${not empty userEndedSales}">
		<h1>Ended sales</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Product Name</th>
					<th>Start Time</th>
					<th>End Time</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${userEndedSales}">
					<tr>
						<td><a href="productDetails?id=${product.idProduct}">${product.name}</a></td>
						<td>${product.auction.startTime}</td>
						<td>${product.auction.endTime}</td>

						<td>
							<form>
								<input type="hidden" value="${product.idProduct}" name="id" />
								<button class="btn btn-success" style="padding: 0 4px 0 4px;"
									onclick="editProduct(${product.idProduct})">restore</button>
							</form>
						</td>
						<td>
							<form action="userCardsS" method="post">
								<input type="hidden" value="${product.idProduct}" name="id" />
								<button class="btn btn-danger" style="padding: 0 4px 0 4px;"
									type="submit">delete</button>
							</form>
						</td>
					</tr>
				</c:forEach>


			</tbody>
		</table>

	</c:if>
</div>
<div id="addNewSale" style="display: none;">
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

	<div class="hero-unit" style="margin-top: 40px">
		<ul class="wysihtml5-toolbar" style="">
			<li class="dropdown"><a class="btn dropdown-toggle"
				data-toggle="dropdown" href="#"><i class="icon-font"></i>&nbsp;<span
					class="current-font">Normal text</span>&nbsp;<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a data-wysihtml5-command="formatBlock"
						data-wysihtml5-command-value="div" href="javascript:;"
						unselectable="on">Normal text</a></li>
					<li><a data-wysihtml5-command="formatBlock"
						data-wysihtml5-command-value="h1" href="javascript:;"
						unselectable="on">Heading 1</a></li>
					<li><a data-wysihtml5-command="formatBlock"
						data-wysihtml5-command-value="h2" href="javascript:;"
						unselectable="on">Heading 2</a></li>
				</ul></li>
			<li><div class="btn-group">
					<a class="btn" data-wysihtml5-command="bold" title="CTRL+B"
						href="javascript:;" unselectable="on">Bold</a><a class="btn"
						data-wysihtml5-command="italic" title="CTRL+I" href="javascript:;"
						unselectable="on">Italic</a><a class="btn"
						data-wysihtml5-command="underline" title="CTRL+U"
						href="javascript:;" unselectable="on">Underline</a>
				</div></li>
			<li><div class="btn-group">
					<a class="btn" data-wysihtml5-command="insertUnorderedList"
						title="Unordered List" href="javascript:;" unselectable="on"><i
						class="icon-list"></i></a><a class="btn"
						data-wysihtml5-command="insertOrderedList" title="Ordered List"
						href="javascript:;" unselectable="on"><i class="icon-th-list"></i></a><a
						class="btn" data-wysihtml5-command="Outdent" title="Outdent"
						href="javascript:;" unselectable="on"><i
						class="icon-indent-right"></i></a><a class="btn"
						data-wysihtml5-command="Indent" title="Indent" href="javascript:;"
						unselectable="on"><i class="icon-indent-left"></i></a>
				</div></li>
			<li><div
					class="bootstrap-wysihtml5-insert-link-modal modal hide fade">
					<div class="modal-header">
						<a class="close" data-dismiss="modal">×</a>
						<h3>Insert Link</h3>
					</div>
					<div class="modal-body">
						<input value="http://"
							class="bootstrap-wysihtml5-insert-link-url input-xlarge">
					</div>
					<div class="modal-footer">
						<a href="#" class="btn" data-dismiss="modal">Cancel</a><a href="#"
							class="btn btn-primary" data-dismiss="modal">Insert link</a>
					</div>
				</div> <a class="btn" data-wysihtml5-command="createLink" title="Link"
				href="javascript:;" unselectable="on"><i class="icon-share"></i></a></li>
			<li><div
					class="bootstrap-wysihtml5-insert-image-modal modal hide fade">
					<div class="modal-header">
						<a class="close" data-dismiss="modal">×</a>
						<h3>Insert Image</h3>
					</div>
					<div class="modal-body">
						<input value="http://"
							class="bootstrap-wysihtml5-insert-image-url input-xlarge">
					</div>
					<div class="modal-footer">
						<a href="#" class="btn" data-dismiss="modal">Cancel</a><a href="#"
							class="btn btn-primary" data-dismiss="modal">Insert image</a>
					</div>
				</div> <a class="btn" data-wysihtml5-command="insertImage"
				title="Insert image" href="javascript:;" unselectable="on"><i
					class="icon-picture"></i></a></li>
		</ul>
		<textarea class="textarea"
			style="width: 810px; height: 200px; display: none;"
			placeholder="Enter text ..."></textarea>
		<input type="hidden" name="_wysihtml5_mode" value="1">
		<iframe class="wysihtml5-sandbox" security="restricted"
			allowtransparency="true" frameborder="0" width="0" height="0"
			marginwidth="0" marginheight="0"
			style="background-color: rgb(255, 255, 255); border-collapse: separate; border: 1px solid rgb(204, 204, 204); clear: none; display: inline-block; float: none; margin: 0px 0px 9px; outline: rgb(85, 85, 85) none 0px; outline-offset: 0px; padding: 4px; position: static; top: auto; left: auto; right: auto; bottom: auto; z-index: auto; vertical-align: top; text-align: start; box-sizing: content-box; -webkit-box-shadow: rgba(0, 0, 0, 0.0745098) 0px 1px 1px 0px inset; box-shadow: rgba(0, 0, 0, 0.0745098) 0px 1px 1px 0px inset; border-top-right-radius: 3px; border-bottom-right-radius: 3px; border-bottom-left-radius: 3px; border-top-left-radius: 3px; width: 810px; height: 200px;"></iframe>
	</div>


</div>

<div id="editPage" style="display: none;">
	<c:if test="${empty userActiveSales}">
		<h1 style="text-align: center;">Sorry, but you can not add new
			sale, because you are BLOKED</h1>
		<h3 style="text-align: center;">Contact with admin.</h3>

	</c:if>
</div>