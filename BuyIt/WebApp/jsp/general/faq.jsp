<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset="utf-8">
<html lang="en">
<head>
<meta charset="utf-8">
<title>BuyIt</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap style -->
<link id="callCss" rel="stylesheet"
	href="themes/bootshop/bootstrap.min.css" media="screen">
<link href="themes/css/base.css" rel="stylesheet" media="screen">
<!-- Bootstrap style responsive -->
<link href="themes/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="themes/css/font-awesome.css" rel="stylesheet"
	type="text/css">
<!-- Google-code-prettify -->
<link href="themes/js/google-code-prettify/prettify.css"
	rel="stylesheet">
<!-- fav and touch icons -->
<link rel="shortcut icon" href="themes/images/ico/favicon.ico">
<style type="text/css" id="enject"></style>

</head>
<body>
	<jsp:include page="navbar"></jsp:include>
	<!-- Header End====================================================================== -->
	<div class="container">
		<h1>FAQ</h1>
		<hr class="soften">
		<div class="accordion" id="accordion2">
			<div class="accordion-group">
				<div class="accordion-heading">
					<h4>
						<a class="accordion-toggle collapsed" data-toggle="collapse"
							data-parent="#accordion2" href="#collapseOne"> What should I
							sell? </a>
					</h4>
				</div>
				<div id="collapseOne" class="accordion-body collapse">
					<div class="accordion-inner">It's true that you can sell (or
						buy) almost anything on BuyIt, and we're willing to bet that most
						houses have literally dozens of items lying around unused. If
						you're stuck for ideas, visit our BuyIt House and see what you
						think will sell.</div>
				</div>
			</div>
			<div class="accordion-group">
				<div class="accordion-heading">
					<h4>
						<a class="accordion-toggle" data-toggle="collapse"
							data-parent="#accordion2" href="#collapseTwo"> How long will
							it take to sell? </a>
					</h4>
				</div>
				<div id="collapseTwo" class="accordion-body collapse">
					<div class="accordion-inner">How long it takes to sell very
						much depends on how long you set your auction for - one, three,
						five, seven or ten days. Some items and categories attract bidders
						straight away - to be honest, it's the age-old rule of supply and
						demand. However, what you can do is make sure your item stands out
						from the crowds - have a great descriptive title that will work
						well in search results, make sure you take a good, clear picture
						and consider using the gallery feature - this means a photograph
						will appear next to your listing in search results, making it even
						more eye-catching. Write a comprehensive item description, and
						above all be honest - make sure you describe the condition
						accurately.</div>
				</div>
			</div>
			<div class="accordion-group">
				<div class="accordion-heading">
					<h4>
						<a class="accordion-toggle collapsed" data-toggle="collapse"
							data-parent="#accordion2" href="#collapseThree"> How much
							will I get? </a>
					</h4>
				</div>
				<div id="collapseThree" class="accordion-body collapse">
					<div class="accordion-inner">The million dollar question!
						Again, how much you get for an item depends on the quality, age,
						and condition of the item, as well as to some extent, supply and
						demand - the desirability of the item, plus how many other similar
						items are available in the marketplace at the same time. You can
						search our completed listings to get an idea of how much similar
						items have been fetching in recent auctions. This is also a good
						idea when you are thinking of setting your starting price.</div>
				</div>
			</div>

			<div class="accordion-group">
				<div class="accordion-heading">
					<h4>
						<a class="accordion-toggle collapsed" data-toggle="collapse"
							data-parent="#accordion2" href="#collapseFour"> What starting
							price should I set? </a>
					</h4>
				</div>
				<div id="collapseFour" class="accordion-body collapse">
					<div class="accordion-inner">This is obviously up to you, but
						experience has shown that items with lower starting prices tend to
						attract more bids. This is because buyers find the auction more
						attractive as they are tempted by the possibility of a bargain.
						1.0$ is a common starting price, even for higher priced items, and
						what you will usually find is that the market sets a fair price.
						However, in order to avoid disappointment you obviously need to be
						sure that you are willing to part with the item if it does not
						reach your desired price and if it is of very high value, you
						could consider setting a reserve.</div>
				</div>
			</div>

			<div class="accordion-group">
				<div class="accordion-heading">
					<h4>
						<a class="accordion-toggle collapsed" data-toggle="collapse"
							data-parent="#accordion2" href="#collapseFive"> What is a
							reserve? </a>
					</h4>
				</div>
				<div id="collapseFive" class="accordion-body collapse">
					<div class="accordion-inner">Reserves, as in the normal
						auction world, set a price under which the item will not sell.
						Buyers do not know how much the reserve is, but they will know
						that you have set one, and bear in mind that in many lower price
						and non-collectable categories, this can put buyers off. Reserves
						are probably best used in high-value, collectable categories, as
						they are in the normal auction world. Please note that there are
						fees associated with setting a reserve.</div>
				</div>
			</div>

			<div class="accordion-group">
				<div class="accordion-heading">
					<h4>
						<a class="accordion-toggle collapsed" data-toggle="collapse"
							data-parent="#accordion2" href="#collapseSix"> How do I know
							my buyer will pay? </a>
					</h4>
				</div>
				<div id="collapseSix" class="accordion-body collapse">
					<div class="accordion-inner">Hundreds of millions of people
						buy and sell on BuyIt every day, and the vast majority of them are
						honest, just like you! You can check out a buyer's reputation,
						just as you can a seller's - remember to read the comments as well
						as looking at the % score. In addition, you can set your
						preferences to exclude certain types of buyers - those with
						negative scores, for example, or less than 10 feedback. We advise
						you to think very carefully before you do this, however, as it
						does limit the number of buyers who will bid on your items. Also,
						everyone has to start somewhere, just as you did, and inexperience
						isn't an indication that a buyer won't pay.</div>
				</div>
			</div>
		</div>
	</div>
	</div><jsp:include page="footer"></jsp:include>
	<!-- Placed at the end of the document so the pages load faster ============================================= -->
	<script src="themes/js/jquery.js" type="text/javascript"></script>
	<script src="themes/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="themes/js/google-code-prettify/prettify.js"></script>
	<script src="themes/js/bootshop.js"></script>
	<script src="themes/js/jquery.lightbox-0.5.js"></script>
	<script src="bootstrap/js/search.js"></script>
	<script type="text/javascript">
		function showFAQ(form) {
			form.answer.value = form.question.options[form.question.selectedIndex].value;
		}
	</script>
</body>
</html>