<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link href="themes/css/item-preview.css" rel="stylesheet">

<li class="span3-my">
        <div class="thumbnail-my">
                <a href="productDetails?id=${product.idProduct}"> <img class="my-image"
                        src="<c:out value="${product.description.itemPhotos[0].path }"></c:out>">
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
                                                <a class="btn btn-info" href="buyItServe?id_product=${product.idProduct}&quantity=1""> 
                                                        <c:out value="Buy It! ${product.auction.buyItNow}$"></c:out>
                                                </a>
                                        </c:when>
                                        <c:when test="${product.auction.buyItNow eq 0 and product.auction.currentPrice > 0}">
                                                <a class="btn btn-info" 
                                                        href="bid_serve?id_product=${product.idProduct}&bid=${product.auction.currentPrice + 1}">
                                                        <c:out value="Place a bid ${product.auction.currentPrice + 1}$"></c:out>
                                                </a>
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
                                                        <td>${product.auction.startTime}</td>
                                                </tr>
                                                <tr>
                                                        <th>End time:</th>
                                                        <td>${product.auction.endTime}</td>
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
                                
                                        <c:if test="${product.auction.buyItNow > 0}">
                                                <a class="btn btn-info" href="buyItServe?id_product=${product.idProduct}&quantity=1""> 
                                                        <c:out value="Buy It! ${product.auction.buyItNow}$"></c:out>
                                                </a>
                                        </c:if>
                                        <c:if test="${product.auction.currentPrice > 0}">
                                                <a class="btn btn-info" href="bid_serve?id_product=${product.idProduct}&bid=${product.auction.currentPrice + 1}">
                                                <c:out value="Place a bid ${product.auction.currentPrice + 1}$"></c:out>
                                                </a>
                                        </c:if>
                                
                                </div>
                        </div>
                        <!-- /.modal-content -->
                </div>
                <!-- /.modal-dialog -->
        </div> <!-- /.modal -->

</li>