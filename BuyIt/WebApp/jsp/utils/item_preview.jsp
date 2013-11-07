<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link href="themes/css/item-preview.css" rel="stylesheet">

<li class="span3-my">
        <div class="thumbnail-my" style="visibility: hidden">
                <a href="productDetails?id=${product.idProduct}"> 
                <c:if test="${fn:length(product.description.itemPhotos) eq 0}">
                <img class="my-image"
                        src="<c:out value="themes/images/mocks/noAvailablePhoto.jpg"></c:out>">
                </c:if>
                <c:if test="${fn:length(product.description.itemPhotos) >= 1}">
                <img class="my-image"
                        src="<c:out value="${product.description.itemPhotos[0].path }"></c:out>">
                </c:if>
                </a>
                <div class="caption">
                        <h6>
                                <c:choose>
                                        <c:when test="${fn:length(product.name) < 30}">
                                                <c:out value="${product.name}"></c:out>
                                        </c:when>
                                        <c:when test="${fn:length(product.name) >= 30}">
                                                <c:out value="${fn:substring(product.name, 0, 26)}..."></c:out>
                                        </c:when>
                                </c:choose>
                        </h6>
                </div>
                <h4>
                        <a data-toggle="modal" href="#myModal${product.idProduct}"
                                class="btn icon-search" href="#"></a> 
                        <span class="pull-right">
                                <c:choose>
                                        <c:when test="${product.auction.buyItNow > 0}">
                                                <a class="btn btn-info"  
                                                <c:if test="${user.idUser eq product.userId}">
                                                		style="pointer-events: none; cursor: default; disabled: disabled" disabled tabindex=-1
                                                </c:if>  
                                                id="buyItButton" href="#buyConfirmation${product.idProduct}" role="button" data-toggle="modal"> 
                                                        <c:out value="Buy ${product.auction.buyItNow}$"></c:out>
                                                </a>
                                                
                                            	<div id="buyConfirmation${product.idProduct}" class="modal hide fade"
													tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
													aria-hidden="true">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-hidden="true">×</button>
													<h3 id="myModalLabel">Bid confirmation</h3>
												</div>
												<form id="buyItForm" class="form-horizontal qtyFrm"
													action="buyItServe" method="POST">
													<input type="hidden" name="id_product" value="${product.idProduct}" /> 
													<input type="hidden" name="count" id="count" value="${product.auction.count}" />
													<input type="hidden" name="quantity" id="quantity" value="1"/> <input
														type="hidden" name="price" id="price"
														value="${product.auction.buyItNow}" />
													<div class="modal-body">
														<p>Are you sure that you want to participate in this auction?</p>
														<p class="message">To pay: ${product.auction.buyItNow}</p>
													</div>
													<div class="modal-footer">
														<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
														<button type="submit" id="placeBidButton"
															class="btn btn-default btn-primary pull-right">Buy it now</button>
													</div>
												</form>
											</div>
                                                
                                                
                                        </c:when>
                                        <c:when test="${product.auction.buyItNow eq 0 and product.auction.currentPrice > 0}">
                                                <a class="btn btn-info" 
                                                <c:if test="${user.idUser eq product.userId}">
                                                	style="pointer-events: none; cursor: default; disabled: disabled" disabled tabindex=-1
                                                </c:if>
                                                id="placeBidButton${product.idProduct}" href="#bidConfirmation${product.idProduct}" 
                                                	role="button" data-toggle="modal">
                                                	<c:out value="Bid ${product.auction.currentPrice + 1}$"></c:out>
                                                </a>
                                                
                                                
                                         	<div id="bidConfirmation${product.idProduct}" class="modal hide fade"
												tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
												aria-hidden="true">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-hidden="true">×</button>
													<h3 id="myModalLabel">Bid confirmation</h3>
												</div>
												<form id="placeABidForm" method="get"
													action="bid_serve?id_product">
													<input type="hidden" id="currentPrice"
														value="${product.auction.currentPrice}">
													<input type="hidden" name="id_product"
														value="${product.idProduct}" /> 
													<input type="hidden" name="bid" id="placeBidInput" 
														value="${product.auction.currentPrice + 1}"/>
													<div class="modal-body">
														<p>
															Are you sure that you want to participate in this auction?
														</p>
														<p class="message">Your bid: ${product.auction.currentPrice + 1}$</p>
													</div>
													<div class="modal-footer">
														<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
														<button type="submit" id="placeBidButton"
															class="btn btn-default btn-primary pull-right">Place a Bid</button>
													</div>
												</form>
											</div>
                                                
                                        </c:when>
                                </c:choose>
                        </span>
                </h4>
        </div> <!-- Modal -->
        <div class="modal hide fade in" tabindex="-1" role="dialog" aria-hidden="false" id="myModal${product.idProduct}"
                aria-labelledby="myModalLabel">
                <div class="modal-dialog">
                        <div class="modal-content">
                                <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"
                                                aria-hidden="true">&times;</button>
                                        <h4 class="modal-title">${product.name}</h4>
                                </div>
                                <div class="modal-body my">
                                        <img class="img-rounded"
                                                src="<c:out value="${product.description.itemPhotos[0].path }"></c:out>">
                                        <table class="table table-striped">
                                                <tr>
                                                        <th>Start time:</th>
                                                        <td><span class="time">${product.auction.startTime}</span></td>
                                                </tr>
                                                <tr>
                                                        <th>End time:</th>
                                                        <td><span class="time">${product.auction.endTime}</span></td>
                                                </tr>
                                                <c:if test="${product.auction.buyItNow > 0}">
                                                <tr>
                                                        <th>Buy It Now:</th>
                                                        <td>${product.auction.buyItNow}$</td>
                                                </tr>
                                                </c:if>
                                                <tr>
                                                        <th>Count:</th>
                                                        <c:choose>
                                                                <c:when test="${product.auction.count  eq 1}">
                                                                        <td>${product.auction.count} item</td>
                                                                </c:when>
                                                                <c:when test="${product.auction.count  gt 1}">
                                                                        <td>${product.auction.count} items</td>
                                                                </c:when>
                                                        </c:choose>
                                                </tr>
                                                <c:if test="${product.auction.currentPrice > 0}">
                                                <tr>
                                                        <th>Current Price:</th>
                                                        <td>${product.auction.currentPrice}$</td>
                                                </tr>
                                                </c:if>
                                        </table>
                                
                                </div>
                        </div>
                        <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
        </div> <!-- /.modal -->

</li>