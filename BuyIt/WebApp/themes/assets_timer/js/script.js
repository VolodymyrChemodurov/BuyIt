$(function(){
			
			var note = $('#note');
			var status = document.getElementById("status").value;
			var time = document.getElementById("time").value;
			var newTime = time.replace(' ','T')+'Z';
			
			
			ts = new Date(newTime),
				newYear = true;
			console.log(ts);
			//alert(time+"----"+ts);
			if(((new Date()) > ts)||(status =='closed')){
				newYear = false;
				message = "Closed";
				
				note.attr("style","color:red");
				note.html(message);
				
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
			else {
				$('#countdown').countdown({
					timestamp	: ts,
					callback	: function(days, hours, minutes, seconds){
						
						var message = "";
						message += " Auction end time: ";
						message +=ts.getDate() +"/ ";
						message +=(ts.getMonth()+1) +"/ ";
						message += ts.getFullYear() + "   ";
						message += ts.getHours() +  ": ";
						message += ts.getMinutes() +( ts.getMinutes()==0 ? '0':'' );
						
						
						
						note.html(message);
						
						
					}
				});
			}
				
			
			
		});
