$(function(){
			
			var note = $('#note');
			var status = document.getElementById("status").value;
			var time = document.getElementById("time").value,
				ts = new Date(time),
				newYear = true;
			
			if(((new Date()) > ts)||(status =='closed')){
				// The new year is here! Count towards something else.
				// Notice the *1000 at the end - time must be in milliseconds
				//ts = (new Date()).getTime() + 10*24*60*60*1000;
				newYear = false;
				message = "Closed";
				
				note.attr("style","color:red");
				note.html(message);
				
			}
			else {
				$('#countdown').countdown({
					timestamp	: ts,
					callback	: function(days, hours, minutes, seconds){
						
						var message = "";
						message +=ts.getDate() +"/ ";
						message +=(ts.getMonth()+1) +"/ ";
						message += ts.getFullYear() + "   ";
						message += ts.getHours() +  ": ";
						message += ts.getMinutes() +( ts.getMinutes()==0 ? '0':'' )+ ", ";
						message += " auction finished!";
						
						
						note.html(message);
					}
				});
			}
				
			
			
		});
