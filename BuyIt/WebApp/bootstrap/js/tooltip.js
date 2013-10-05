
                         <script>
  
  function changeSourceCodeView(node_link, sc_id  ) {
   
     var node_sc = document.getElementById( sc_id );
	 
	 if( node_sc ) 
	   if( node_sc.style.display == "none" ) {
	      node_sc.style.display = "block";
		  node_link.innerHTML = node_link.innerHTML.replace(/Show/, "Hide");
	   } else {
	      node_sc.style.display = "none";	 
		  node_link.innerHTML = node_link.innerHTML.replace(/Hide/, "Show");
	   } // endif
     else 
	   alert("Id not found");
  }
  
  </script>

                         <script>
var KEY_ESC = 27;

$(document).ready(function() {

	var tips = []; // an array of tooltips

	// create a tooltip object for each input
	$('div.text input').each(function(index) {
		tips[index] = new tooltip($(this));
	});
		
}); // end ready event

//
// tooltip() is a tooltip widget. It requires the element that has the tooltip
// to reference
// the tooltip via aria-describedby. Normally this is a div that contains text
//
// @param ($id object) $id is the jquery object of the input or other element to
// bind the widget to
//
// @return N/A
//
function tooltip($id) {

	// define the object properties

	this.$id = $id;
	this.$tip = $('#' + $id.attr('aria-describedby'));
	this.mouseover = false; // set to true of the tooltip was displayed via
							// mouseover. reset on mouseout
	this.focus = false; // set to true of the input has focus (prevent hide on
						// mouseout)
	this.dismissed = false; // set to true of the user dismissed the tooltip
							// with the esc key. Reset on blur

	// hide the tooltip
	this.hideTip();

	// bind key handlers
	this.bindHandlers();

} // end tooltip() constructor

//
// function showTip() is a member function to display the tooltip
//
// @return N/A
//
tooltip.prototype.showTip = function() {

	// display the tooltip
	this.$tip.css('display', 'inline');

} // end showtip()

//
// function hideTip() is a member function to hide the tooltip
//
// @return N/A
//
tooltip.prototype.hideTip = function() {

	// hide the tooltip
	this.$tip.hide();

} // end hidetip()

//
// function bindHandlers() is a member function to bind event handlers to the
// input
//
// @return N/A
//
tooltip.prototype.bindHandlers = function() {

	var thisObj = this;

	this.$id.keydown(function(e) {
			return thisObj.handleKeyDown($(this), e);
	});

	this.$id.mouseover(function(e) {
			return thisObj.handleMouseOver($(this), e);
	});

	this.$id.mouseout(function(e) {
			return thisObj.handleMouseOut($(this), e);
	});

	this.$id.focus(function(e) {
			return thisObj.handleFocus($(this), e);
	});

	this.$id.blur(function(e) {
			return thisObj.handleBlur($(this), e);
	});

} // end bindHandlers()

//
// function handleKeyDown() is a member function to process keydown events for
// the input
//
// @param ($id object) $id is the jquery object of the element firing event
//
// @param (e object) e is the event object associated with the event
//
// @return (boolean) returns false if processing; true if doing nothing
//
tooltip.prototype.handleKeyDown = function($id, e) {

	if (e.altKey || e.shiftKey || e.ctrlKey) {
		// do nothing
		return true;
	}

	if (e.keyCode == KEY_ESC) {
		this.hideTip();
		this.dismissed = true;
		e.stopPropagation();
		return false;
	}

	return true;

} // end handleKeyDown()

//
// function handleMouseOver() is a member function to display the tooltip on
// mouseover
//
// @param ($id object) $id is the jquery object of the element firing event
//
// @param (e object) e is the event object associated with the event
//
// @return (boolean) returns false
//
tooltip.prototype.handleMouseOver = function($id, e) {

	this.showTip();

	// set the mouseover flag to prevent blur dismissing tooltip
	this.mouseover = true;

	e.stopPropagation();
	return false;

} // end handleMouseOver()

//
// function handleMouseOut() is a member function to hide the tooltip on
// mouseout. If the
// input has focus and the user did not dismiss the tooltip, the tooltip is not
// hidden.
//
// @param ($id object) $id is the jquery object of the element firing event
//
// @param (e object) e is the event object associated with the event
//
// @return (boolean) returns false
//
tooltip.prototype.handleMouseOut = function($id, e) {

	if (this.dismissed == true || this.focus == false) {
		this.hideTip();
	}

	// reset the mouseover flag
	this.mouseover = false;

	e.stopPropagation();
	return false;

} // end handleMouseOut()

//
// function handleFocus() is a member function to display the tooltip on focus
//
// @param ($id object) $id is the jquery object of the element firing event
//
// @param (e object) e is the event object associated with the event
//
// @return (boolean) returns false
//
tooltip.prototype.handleFocus = function($id, e) {

	this.showTip();

	// set the focus flag to prevent mouseout from hiding the tooltip as long
	// as the input has focus
	this.focus = true;

	e.stopPropagation();
	return false;

} // end handleFocus()

//
// function handleBlur() is a member function to hide the tooltip on blur. The
// tooltip is not
// hidden if the mouseover flag is true (i.e. tooltip was displayed via
// mouseover).
//
// @param ($id object) $id is the jquery object of the element firing event
//
// @param (e object) e is the event object associated with the event
//
// @return (boolean) returns false
//
tooltip.prototype.handleBlur = function($id, e) {

	if (this.mouseover == false) {
		this.hideTip();
	}

	// reset the focus and dismissed flags
	this.focus = false;
	this.dismissed = false;

	e.stopPropagation();
	return false;

} // end handleBlur()

  </script>