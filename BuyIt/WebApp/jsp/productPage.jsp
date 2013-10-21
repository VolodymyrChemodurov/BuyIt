<%@ page language="java" contentType="text/html; charset=utf-8"
        pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<title>BuyIt online auction</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link rel="stylesheet"
        href="http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300" />
<link rel="stylesheet" href="themes/assets_timer/css/styles.css" />
<link rel="stylesheet"
        href="themes/assets_timer/countdown/jquery.countdown.css" />


<!--Less styles -->
<!-- Other Less css file //different less files has different color scheam
        <link rel="stylesheet/less" type="text/css" href="themes/less/simplex.less">
        <link rel="stylesheet/less" type="text/css" href="themes/less/classified.less">
        <link rel="stylesheet/less" type="text/css" href="themes/less/amelia.less">  MOVE DOWN TO activate
        -->
<!--<link rel="stylesheet/less" type="text/css" href="themes/less/bootshop.less">
        <script src="themes/js/less.js" type="text/javascript"></script> -->
</head>



<!-- Bootstrap style -->
<link id="callCss" rel="stylesheet"
        href="themes/bootshop/bootstrap.min.css" media="screen" />
<link href="themes/css/base.css" rel="stylesheet" media="screen" />
<!-- Bootstrap style responsive -->
<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
<link href="themes/css/font-awesome.css" rel="stylesheet"
        type="text/css">
<!-- Google-code-prettify -->
<link href="themes/js/google-code-prettify/prettify.css"
        rel="stylesheet" />
<!-- fav and touch icons -->
<link rel="shortcut icon" href="themes/images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
        href="themes/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
        href="themes/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
        href="themes/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
        href="themes/images/ico/apple-touch-icon-57-precomposed.png">
<style type="text/css" id="enject"></style>
</head>


<body>
        <!-- ---------------------------NAVBAR---------------------------------------- -->
        <jsp:include page="navbar"></jsp:include>
        <div id="header" style="background: white">
                <div class="container">

                        <div id="mainBody">
                                <div class="container">
                                        <div class="row">
                                                <!-- -----------------SIDEBARMENU--------------- -->
                                                <jsp:include page="sidebarMenu"></jsp:include>
                                                <div class="span9">
                                                        <ul class="breadcrumb">
                                                                <li><a href="homePageServlet">Home</a> <span
                                                                        class="divider">/</span></li>
                                                                <li><a href="categoryViewer?id=${category.idCategory}">${category.name}</a>
                                                                        <span class="divider">/</span></li>


                                                                <c:forEach var="subCategory"
                                                                        items="${category.listSubCategories}">
                                                                        <li><a
                                                                                href="select_category?id=${subCategory.idSubCategory}">${subCategory.name}</a>
                                                                                <span class="divider">/</span></li>

                                                                        <li class="active"><c:out value="${product.name}"></c:out></li>
                                                                </c:forEach>
                                                        </ul>

                                                        <div class="row">
                                                                <c:if test="${fn:length(product.description.itemPhotos) eq 0}">
                                                                        <div id="gallery" class="span3">
                                                                                <img
                                                                                        src="<c:out value="themes/images/mocks/noAvailablePhoto.jpg"></c:out>"
                                                                                        style="height: 250px" alt="no photo" />


                                                                        </div>
                                                                </c:if>
                                                                <c:if test="${fn:length(product.description.itemPhotos) eq 1}">
                                                                        <div id="gallery" class="span3" style="text-align: center">
                                                                                <a
                                                                                        href="<c:out value="${product.description.itemPhotos[0].path}"></c:out>"
                                                                                        title="<c:out value="${product.name }" />"> <img class="my-image"
                                                                                        src="<c:out value="${product.description.itemPhotos[0].path}"></c:out>"
                                                                                       
                                                                                        alt="<c:out value="${product.name }" />">

                                                                                </a>

                                                                        </div>
                                                                </c:if>
                                                                <c:if
                                                                        test="${(fn:length(product.description.itemPhotos) gt 1) && (fn:length(product.description.itemPhotos) le 3)}">
                                                                        <div id="gallery" class="span3" style="text-align: center ">
                                                                                <a
                                                                                        href="<c:out value="${product.description.itemPhotos[0].path}"></c:out>"
                                                                                        title="<c:out value="${product.name }" />"><div style="height: 250px; text-align: center"><img class="my-image"
                                                                                        src="<c:out value="${product.description.itemPhotos[0].path}"></c:out>"
                                                                                        alt="<c:out value="${product.name }" />"></div>

                                                                                </a>

                                                                                <div id="differentview" class="moreOptopm carousel slide">

                                                                                        <div class="carousel-inner">

                                                                                                <div class="item active">
                                                                                                        <c:forEach var="image"
                                                                                                                items="${product.description.itemPhotos }">
                                                                                                                <a href="${image.path}"> <img
                                                                                                                        style="width: 81px; height: 65px" src="${image.path}"
                                                                                                                        alt="" /></a>
                                                                                                        </c:forEach>
                                                                                                </div>

                                                                                        </div>



                                                                                </div>
                                                                                Photos in Gallery:
                                                                                <c:out value="${fn:length(product.description.itemPhotos)}"></c:out>
                                                                        </div>
                                                                </c:if>

                                                                <c:if test="${(fn:length(product.description.itemPhotos) >= 4)}">
                                                                        <div id="gallery" class="span3" style="text-align: center; height: 250px">
                                                                                <a
                                                                                        href="<c:out value="${product.description.itemPhotos[0].path}"></c:out>"
                                                                                        title="<c:out value="${product.name }" />"> <img class="my-image"
                                                                                        src="<c:out value="${product.description.itemPhotos[0].path}"></c:out>"
                                                                                        alt="<c:out value="${product.name }" />">

                                                                                </a>

                                                                                <div id="differentview" class="moreOptopm carousel slide">

                                                                                        <div class="carousel-inner">

                                                                                                <div class="item active">
                                                                                                        <c:forEach var="image" begin="0" end="2"
                                                                                                                items="${product.description.itemPhotos }">
                                                                                                                <a href="${image.path}"> <img style="width: 29%"
                                                                                                                        src="${image.path}" alt="" /></a>
                                                                                                        </c:forEach>
                                                                                                </div>

                                                                                                <div class="item">
                                                                                                        <c:forEach var="image" begin="3"
                                                                                                                items="${product.description.itemPhotos }">
                                                                                                                <a href="${image.path}"> <img style="width: 29%"
                                                                                                                        src="${image.path}" alt="" /></a>
                                                                                                        </c:forEach>

                                                                                                </div>
                                                                                                Photos in Gallery:
                                                                                                <c:out value="${fn:length(product.description.itemPhotos)}"></c:out>
                                                                                        </div>


                                                                                </div>
                                                                        </div>
                                                                </c:if>







                                                                <!-- -------------------------CENTRAL CONTROL PANEL (place a bid , Buy it now )-------------------- -->
                                                                <div class="span6">
                                                                		<input type="hidden" id="userIdProduct" value="${product.userId}" />
                                                                		<input type="hidden" id="userId" value="${user.idUser}" />
                                                                        <font size="5"> <c:out value="${product.name}"></c:out>
                                                                        </font> <br>
                                                                        <dir class="form-horizontal qtyFrm" style="padding: 10px">
                                                                                <small style="width: 250px" id="note"></small>
                                                                        </dir>
                                                                        <dir class="form-horizontal qtyFrm">
                                                                                <input type="hidden" id="currentBid"
                                                                                        value="${product.auction.currentPrice}" />
                                                                                <input type="hidden" id="time"
                                                                                        value="${product.auction.endTime}" />
                                                                                <input type="hidden" id="status"
                                                                                        value="${product.auction.status}" />
                                                                                <div id="countdown"></div>
                                                                        </dir>
                                                                        <hr class="soft" />

                                                                        <!--                                                 ----------------------        PLACE A BID------------------------- -->
                                                                        <c:if test="${product.auction.currentPrice != 0 }">
                                                                                <form class="form-horizontal qtyFrm">
                                                                                        <div class="control-group">
                                                                                                <label class="control-label"><span>Current
                                                                                                                Price: <c:out value="${product.auction.currentPrice}"></c:out>$
                                                                                                </span></label>
                                                                                                <div class="controls">
                                                                                                        <label class="control-label"><span> You Bid:</span></label>
                                                                                                        <input type="number" id="placeBidInput"
                                                                                                                value="<c:out value="${product.auction.currentPrice+1}"></c:out>"
                                                                                                                class="span1" placeholder="Your Bid" />
                                                                                                        <button type="submit" id="placeBidButton"
                                                                                                                class="btn btn-large btn-primary pull-right">
                                                                                                                Place a Bid</button>
                                                                                                </div>
                                                                                        </div>
                                                                                </form>
                                                                                <hr class="soft" />
                                                                        </c:if>


                                                                        <!-- ---------------------------------------------BUY IT NOW------------------------ -->

                                                                        <c:if test="${product.auction.buyItNow != 0 }">
                                                                                <form class="form-horizontal qtyFrm" action="buyItServe" 
                                                                                        method="POST">
                                                                                        <div class="control-group">
                                                                                                <input type="hidden" name="id_product"
                                                                                                        value="${product.idProduct}" /> <label
                                                                                                        class="control-label"><span> Buy it By: <c:out
                                                                                                                        value="${product.auction.buyItNow}"></c:out> $
                                                                                                </span></label>
                                                                                                <div class="controls">
                                                                                                        <input type="hidden" name="count" id="count"
                                                                                                                value="${product.auction.count}" /> <label
                                                                                                                class="control-label" text-align="right"><span>
                                                                                                                        Quantity:</span></label> <input type="number" id="quantity"
                                                                                                                name="quantity" class="span1" value="1" />
                                                                                                        <button type="submit" id="buyItButton"
                                                                                                                class="btn btn-large btn-primary pull-right">Buy
                                                                                                                it now</button>
                                                                                                </div>
                                                                                        </div>
                                                                                </form>
                                                                                <hr class="soft" />
                                                                        </c:if>

                                                                        <h4>
                                                                                <c:out value="${product.auction.count}"></c:out>
                                                                                Items in Stock
                                                                        </h4>

                                                                        <hr class="soft clr" />
                                                                       
                                                                        <br class="clr" /> <a href="#" name="detail"></a>

                                                                </div>
                                                                <!--    ------------DELIVERY--------BID HISTORY----------DETAILS------------ -->
                                                                <div class="span9">
                                                                        <div class="thumbnail">
                                                                                <ul id="productDetail" class="nav nav-tabs">
                                                                                        <li class="active"><a href="#home" data-toggle="tab">Product
                                                                                                        Details</a></li>
                                                                                        <li><a href="#history" data-toggle="tab">Bid History</a></li>
                                                                                        <li><a href="#delivery" data-toggle="tab">Delivery</a></li>
                                                                                        <li><a href="#features" data-toggle="tab">Features</a></li>
                                                                                </ul>
                                                                                <div id="myTabContent" class="tab-content">
                                                                                        <div class="tab-pane fade active in" id="home">
                                                                                                <h4>Product Information</h4>
                                                                                                <hr class="soft" />
                                                                                                Auction start time:
                                                                                                <c:out value="${product.auction.startTime}"></c:out>
                                                                                                <br> Auction end time:
                                                                                                <c:out value="${product.auction.endTime}"></c:out>
                                                                                                <hr class="soft" />
                                                                                                ${product.description.descText}
                                                                                        </div>


                                                                                        <div class="tab-pane fade" id="history">
                                                                                                <h4>Bid History</h4>
                                                                                                <hr class="soft" />
                                                                                                <table class="table table-bordered">
                                                                                                        <tbody>
                                                                                                                <tr class="techSpecRow">
                                                                                                                        <th>User Name</th>
                                                                                                                        <th>Time</th>
                                                                                                                        <th>Amount</th>
                                                                                                                </tr>
                                                                                                                <c:forEach var="userItem" items="${userList}">
                                                                                                                        <tr class="techSpecRow">
                                                                                                                                <td class="techSpecTD1">${userItem.login}</td>
                                                                                                                                <c:forEach var="bid" items="${userItem.bidList}">
                                                                                                                                        <td class="techSpecTD1">${bid.time}</td>
                                                                                                                                        <td class="techSpecTD1">${bid.amount}</td>
                                                                                                                                </c:forEach>
                                                                                                                        </tr>
                                                                                                                </c:forEach>

                                                                                                        </tbody>
                                                                                                </table>

                                                                                        </div>



                                                                                        <div class="tab-pane fade" id="delivery">
                                                                                                <h4>Information for Buyers</h4>

                                                                                                <hr class="soft" />
                                                                                                <c:out value="${product.delivery }"></c:out>
                                                                                                <hr class="soft" />
                                                                                                <br class="clr">
                                                                                        </div>
                                                                                        
                                                                                        <div class="tab-pane fade" id="features">
                                                                                                <h4>Features</h4>

                                                                                                <hr class="soft" />
                                                                                                ${product.description.features }"
                                                                                                <hr class="soft" />
                                                                                                <br class="clr">
                                                                                        </div>
                                                                                        

                                                                                </div>
                                                                        </div>
                                                                </div>

                                                        </div>
                                                </div>
                                        </div>
                                </div>

                        </div>

                        <!-- MainBody End ============================= -->
                        <script src="themes/js/jquery.js" type="text/javascript"></script>
                        <script src="themes/js/bootstrap.min.js" type="text/javascript"></script>
                        <script src="themes/js/google-code-prettify/prettify.js"></script>

                        <script src="themes/js/bootshop.js"></script>
                        <script src="themes/js/jquery.lightbox-0.5.js"></script>

                        <!-- JavaScript includes -->
                        <!--                 <script src="http://code.jquery.com/jquery-1.7.1.min.js"></script> -->
                        <script src="themes/assets_timer/countdown/jquery.countdown.js"></script>
                        <script src="themes/assets_timer/js/script.js"></script>
                        <script src="bootstrap/js/search.js"></script>
                        <script src="bootstrap/js/thumbnail-image-large.js" type="text/javascript"></script>

                        <script type="text/javascript">
                                $(document)
                                            .ready(
                                                   function() {
                                                	   $(window).load(function(){
                                                		   console.log("session user:"+$('#userId').val() + "  product userId:"+$('#userIdProduct').val() );
                                                    	   if ($('#userId').val() == $('#userIdProduct').val()){
                                                    		   $('#buyItButton')
                                                               .attr(
                                                                               "disabled",
                                                                               "disabled");
                                                    		   
                                                               $('#placeBidButton')
                                                               .attr(
                                                                               "disabled",
                                                                               "disabled");
                                                               $(
                                                               '#quantity').attr(
                                                                       			"disabled",
                                                               					"disabled");
                                                               $(
                                                               '#placeBidInput').attr(
                                                              					"disabled",
                                              									"disabled");
                                                    	   }
                                                   		});
                                                	   
                                                	   
                                                	   
                                                	  
                                                	   
                                                	   
                                                	   
                                                              $('#placeBidInput')
                                                                               .change(
                                                                                               function() {
                                                                                                       var placeBidButton = $('#placeBidButton');
                                                                                                        var currentPrice = document
                                                                                                                        .getElementById("currentBid").value;
                                                                                                         var bid = $(
                                                                                                                            '#placeBidInput')
                                                                                                                            .attr('value');
                                                                                                               if (parseInt(currentPrice) >= parseInt(bid)) {
                                                                                                                        placeBidButton
                                                                                                                                        .attr(
                                                                                                                                                        "disabled",
                                                                                                                                                        "disabled");
                                                                                                                } else {
                                                                                                                        placeBidButton
                                                                                                                                        .removeAttr("disabled");
                                                                                                                }

                                                                                                        });

                                                                        $('#quantity')
                                                                                        .change(
                                                                                                        function() {
                                                                                                                var count = $('#count')
                                                                                                                                .val();
                                                                                                                console.log("count: "
                                                                                                                                + count);
                                                                                                                var quantity = $(
                                                                                                                                '#quantity')
                                                                                                                                .val();
                                                                                                                if ((parseInt(quantity) > parseInt(count))||(parseInt(quantity) < 1)) {
                                                                                                                        $('#buyItButton')
                                                                                                                                        .attr(
                                                                                                                                                        "disabled",
                                                                                                                                                        "disabled");
                                                                                                                } else {
                                                                                                                	
                                                                                                                        $('#buyItButton')
                                                                                                                                        .removeAttr(
                                                                                                                                                        "disabled");
                                                                                                                }

                                                                                                        });
                                                                        
                                                                          
                                                                   
                                                                        
                                                                });
                              
                                
                        </script>
                </div>
                <!--                 ----------------footer--------------------------------------- -->
                <jsp:include page="footer"></jsp:include>
        </div>
</body>
</html>
