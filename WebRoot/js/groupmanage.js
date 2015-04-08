manage = {
	init : function(){
		$("#group").attr("class","active");
	},
	edit : function(id){
		if( id!=null ){
			// alert(id);
			var url="edit?groupId="+id;
			window.location.href=url;
		}
	},

	dele : function(id){
		if(id!=null){
			// alert("111");
			if( confirm("是否确定删除") ){
				var url="dele?groupId="+id;
				window.location.href=url;
			}
		}
	},
	
	newGroup : function(){
		var url="newgroup";
		window.location.href=url;
	}
};