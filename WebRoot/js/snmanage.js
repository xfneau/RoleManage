manage = {
		
	init : function(){
		$("#newgame").hide();
		$("div[name='gameinfo']").hide();
		$("#sn").attr("class","active");
	},
	editgame : function(id){
		if( id!=null ){
			var gamename=$("#gamename"+id).val();
			var gameimg=$("#gameimg"+id).val();
			var gamelevel=$("#gamelevel"+id+" option:selected").val();
			if( gamename=="" || gameimg=="" || gamelevel==""  ){
				alert("请填写完整");
				return;
			}
			var url="ajax/editsn";
			$.post(url,{"sn_id":id,"sn_name":gamename,"img":gameimg,"level":gamelevel},function(jsonStr){
				var obj = eval('('+jsonStr+')');
				if( obj.id==null || obj.id==-1 ){
					alert("修改失败");
				}
				window.location.href="snmanage";
			});
		}
	},
	edit : function(id){
		if( id!=null ){
			var l = $("#gamelevel_"+id).val();
			$("#gamelevel"+id).val(l);
			$(".bigDiv").show();
			$(".bigDiv").height($(document).height()).width($(document).width());
			$("div[id='"+id+"']").show();
		}
	},
	
	dele : function(id){
		if(id!=null){
			//alert("111");
			if( confirm("是否确定删除") ){
				var url="delesn?id="+id;
				window.location.href=url;
			}
		}
	},
	
	cancel : function(title){
		$("#"+title).hide();
		$(".bigDiv").hide();
	},
	
	shownewgame : function(){
		$("#newgame").show();
		$(".bigDiv").show();
		$(".bigDiv").height($(document).height()).width($(document).width());
	},
	newgame : function(){
		var snname=$("#gamename").val();
		var snimg=$("#gameimg").val();
		var snlevel=$("#gamelevel option:selected").val();
		var snalias=$("#gamealias").val();
		if( snname=="" || snimg=="" || snlevel=="" ){
			alert("请填写完整");
			return;
		}
		var url="ajax/newsn";
		$.post(url,{"sn_name":snname,"img":snimg,"level":snlevel},function(jsonStr){
			var obj =eval('('+jsonStr+')');
			if( obj.id==false || obj.id==null ){
				alert("创建失败");
			}
			window.location.href="snmanage";
		});
	}
};