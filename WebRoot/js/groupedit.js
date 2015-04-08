

manage = {
		init : function(){
			$("#group").attr("class","active");
		},
		getLiValue : function(ulobj){
			var ckx = ulobj.find("input[type='checkbox']:checked");
			
			var arr = [];
			ckx.each(function(i){
				arr[i] = $(this).attr("value");
			});
			return arr.join(",");
		},
		savegroupInfo : function(){
			
				var parent = $("#grounpinfodiv");
				var groupname=$("#groupname").val();
				var groupsn=parent.find("div[name='groupsn']"),
					groupgame=parent.find("div[name='groupgame']");
				var jsonparams = [];
				
				if(groupname==''){
					alert("请输入组名称");
					return;
				}else{
					 document.getElementById("submit_group").style.display = "none";
				}
				jsonparams.push("[");
				
				var json=[];
				json.push("{");
				json.push("\"groupname\":");
				json.push("\""+groupname+"\",");
				
				var chanvalue = this.getLiValue($("#groupsn"));
				json.push("\"groupsn\":");
				json.push("\""+chanvalue+"\",");
				var chanvalue = this.getLiValue($("#groupgame"));
				json.push("\"groupgame\":");
				json.push("\""+chanvalue+"\"");
				
				json.push("}");
				
				jsonparams.push(json.join(""));
				jsonparams.push("]");
				var params = jsonparams.join("");
				var groupId=$("#groupId").val();
				
				var url="ajax/buildgroup";
				if($("#groupId").val()!='0'){
					url="ajax/updategroup";
				}
				$.post(url,{"groupId":groupId,"groupName":groupname,"groupJsonStr":params},function(data){
					document.getElementById("submit_group").style.display = "block";
					 window.location.href = "groupmanage";
				});	
			
		},
		
		editgroup : function(){
			$("#group").attr("class","active");
			if(groupId!='0'){
				var jsonStr=eval("("+$("#jsonStr").val()+")");
				var group_sn = new Array(); 
				var group_game = new Array();
				if( jsonStr[0].group_SN!=""){
					var parent = $("#groupsn");
					group_sn = jsonStr[0].group_SN.split(",");
					for(var i=0; i < group_sn.length;i++){
						parent.find("input[type='checkbox'][id='"+group_sn[i]+"'][value='"+group_sn[i]+"']").attr("checked",true);
					}
				}
				if( jsonStr[0].group_Game!="" ){	
					var parent = $("#groupgame");
					group_game = jsonStr[0].group_Game.split(",");
					for( var i=0;i<group_game.length;i++ ){
					parent.find("input[type='checkbox'][id='"+group_game[i]+"'][value='"+group_game[i]+"']").attr("checked",true);
					}
				}
			}
			
		},
		
		selectAll : function(b){
			if(b==1){
//				$("input[name='groupsninput']").attr('checked',true);
				var cc = document.getElementsByName("groupsninput");  
				    for(i=0; i<cc.length; i++){  
				        if(cc[i].type="checkbox"){  
				            cc[i].checked = true;  
				        }  
				    }  
			}else{
//				$("input[name='groupgameinput']").attr('checked',true);
				var cc = document.getElementsByName("groupgameinput");  
			    for(i=0; i<cc.length; i++){  
			        if(cc[i].type="checkbox"){  
			            cc[i].checked = true;  
			        }  
			    }  
			}
			
		},
		cancelAll : function(b){
			if(b==1){
				$("input[name='groupsninput']").attr('checked',false);
			}else{
				$("input[name='groupgameinput']").attr('checked',false);
			}
		}
};