manage = {
		init : function(){
			$("#user").attr("class","active");
		},
	newuser : function(){
//		alert(url);
		var url="newuser";
		window.location.href=url;
	},
	edituser : function(userid,username){
		//alert();
		var url="edituser?userid="+userid+"&username="+username;
		window.location.href=url;
	},
	deluser : function(userid){
		//alert();	
		if(confirm("是否删除？")){
			var url="deleuser?userid="+userid;
		window.location.href=url;
		}
	}
	
};