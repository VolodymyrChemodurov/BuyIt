$(function() {

	var note = $('#note');
	var status = document.getElementById("status").value;
	var time = document.getElementById("time").value;
	var newTime = time.replace(' ', 'T') + 'Z';

	ts = new Date(newTime), newYear = true;
	ts.setTime(ts.getTime() - 7200000);
	if (((new Date()) > ts) || (status == 'closed')) {
		message = "Closed";

		note.attr("style", "color:red");
		note.html(message);

		$('#buyItButton').attr("disabled", "disabled");

		$('#placeBidButton').attr("disabled", "disabled");
		$('#quantityInput').attr("disabled", "disabled");
		$('#bidInput').attr("disabled", "disabled");

	} else {
		$('#countdown').countdown(
				{
					timestamp : ts,
					callback : function(days, hours, minutes, seconds) {

						var message = "";
						message += " Auction end time: ";
						message += (ts.getDate() < 10 ? '0' : '') + ts.getDate() + "/ ";
						message += ((ts.getMonth() + 1) < 10 ? '0' : '') + (ts.getMonth() + 1) + "/ ";
						message += ts.getFullYear() + "   ";
						message += (ts.getHours() < 10 ? '0' : '') + ts.getHours() + ": ";
						message += (ts.getMinutes() < 10 ? '0' : '')
								+ ts.getMinutes();

						note.html(message);

					}
				});
	}

});
