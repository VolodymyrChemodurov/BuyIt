function login() {

	var login = $("#username").val();
	var passw = $("#password").val();	
	
	$.ajax({
    type: "POST",
    url: "authentication",
    data: "login=" + login + "&passw=" + passw,
    success: function(data, textStatus) {
        if (data.location) {
            window.location.href = data.location;
        }
        else {
            $("#error").fadeIn(1001);
        }
    },
    error:function(data, status, er) {
          console.error("error: %s, status: %d, er: %s", data, status, er);
          $("#error").fadeIn(1001);
          $("#error").removeClass("hidden");
          alert("Ï³çäºö!!!");
    }
	});
}

function closeError() {
	$("#error").fadeOut(1001);
	$("#error").addClass("hidden");
};


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

