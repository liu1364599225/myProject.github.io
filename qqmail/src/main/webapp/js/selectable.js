$(document).ready(function() {
	
	function getshtime(t){
		var time = new Date(t);
		var y = time.getYear()+1900;
		var m = time.getMonth()+1;
		var d = time.getDate();
		if(m<10){
			m = '0'+(time.getMonth()+1);
		}
		if(d<10){
			d = '0'+time.getDate();
		}
		return y+'-'+m+'-'+d;
	}
	
  	var e;//事件对象
  	var d1 = new Date();
  	var nowM = (d1.getMonth()+1)<10?'0'+(d1.getMonth()+1):(d1.getMonth()+1);
  	var nowD = d1.getDate()<10?'0'+d1.getDate():d1.getDate();
    $('#calendar').fullCalendar({
      header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month,agendaWeek,agendaDay'
      },
      defaultDate: '2018-'+nowM+'-'+nowD,
      navLinks: true, // can click day/week names to navigate views
      selectable: true,
      selectHelper: true,
      select: function(start, end) {
		  var title = prompt('Event Title:');//拿到填进去的文本框内容即title
		  if(title){
			  console.log("title:"+(title != ""));
			  $.ajax({
				  type:"post",
	    		  url:"createEvent.do",
	    		  data:{"title":title,"start":getshtime(start),"end":getshtime(end)},
	    		  dataType:"text",
	    		  success:function(data){
	    			  //在页面添加一个event在这里实现
	    			  //var title = prompt('Event Title:');//拿到填进去的文本框内容即title
	    	          var eventData = '2018-'+nowM+"-"+nowD;
	    	          if (title) {
	    	            eventData = {
		            		title: title,
		                    start: start,
		                    end: end,
		                    _id:data
	    	            };
	    	            $('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
	    	          }
	    	          $('#calendar').fullCalendar('unselect');
	    		  }
	    	  });
		  }
      },
      editable: true,
      eventLimit: true, // allow "more" link when too many events
      events: function(start,end,timezone,callback){
    	  $.ajax({
    		 url:"readAllEventByMaster.do",
    		 data:{
				 start: start.format(),
				 end: end.format()
    		 },
    		 dataType:"json",
    		 success:function(data){
    			 var events = [];//创建一个事件的数组
//    			 $(data).each(function(){方法一
//    				console.log($(this));
//    				console.log("毫秒转日期："+getshtime($(this).attr('start')));
//    				events.push({
//    					title:$(this).attr('title'),
//    					start:getshtime($(this).attr('start')),
//    					end:getshtime($(this).attr('end')),
//    					id:$(this).attr('id')
//    				});
//    			 });
    			 
    			 for(var i=0;i<data.length;i++){//用for循环ajax传递过来的list集合
    				 events.push({
    					 title:data[i].title,
    					 start:getshtime(data[i].start),
    					 end:getshtime(data[i].end),
    					 _id:data[i].eid
    				 });
    			 }
    			 callback(events);//将创建并且赋值的events返回给event
    		 }
    	  });
      },
      eventClick: function(event) {
				 //事件点击后操作的
//				 console.log(111);
//				 console.log($(this).text());//获取点击even的内容;
//				 console.log(event);
				 var newDate = new Date(event.start);
		 	     var newDate1 = new Date(event.end);
				 newDate.getYear()+1900;
				 newDate.getMonth()+1;
				 newDate.getDate();
			   if(newDate1.getDate()-newDate.getDate()==1){
			   	  //在同一天
			   	  //console.log("在同一天");
			   }else{
			   	  //没有在同一天
			   	  //console.log("没有在同一天");
			   }
			   e = event;
         //$('#calendar').fullCalendar('updateEvent', event);  修改event
			   //$('#calendar').fullCalendar('removeEvents','_fc1');  删除event
			   $("#calendar").css("display","none");
			   $("#alerttest").css("display","block");
			   $("body").css({'background-color':'#B3B3B3'});
			   $("#thing").val(event.title);
			}
    });
    $("#close").click(function(){
    	   $("#calendar").css("display","block");
		   $("#alerttest").css("display","none");
		   $("body").css({'background-color':'white'});
    });
    
    $("#cancel").click(function(){
    	   $("#calendar").css("display","block");
		   $("#alerttest").css("display","none");
		   $("body").css({'background-color':'white'});
    });
    
    $("#delete").click(function(){
    	   $.ajax({
    		   url:"deleteEventById.do?id="+e._id,
    		   data:"",
    		   success:function(){
    			   $("#calendar").css("display","block");
    			   $("#alerttest").css("display","none");
    			   $("body").css({'background-color':'white'});
    	    	   $('#calendar').fullCalendar('removeEvents',e._id);
    		   }
    	   });
    });
    
    $("#update").click(function(){
    	   e.title=$("#thing").val();
    	   $.ajax({
    		   type:"post",
    		   url:"updateEventById.do",
    		   data:{"title":$("#thing").val(),"id":e._id},
    		   success:function(){
    			   $("#calendar").css("display","block");
    			   $("#alerttest").css("display","none");
    			   $("body").css({'background-color':'white'});
    			   $('#calendar').fullCalendar('updateEvent', e);
    		   }
    	   });
    });
});