

manage = {
		usermanage : function(){
//			alert(url);
			var url="usermanage";
			window.location.href=url;
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
				var parent = $("#userinfodiv");
				var username=$("#username").val();
				var email=$("#email").val();
				var realname=$("#realname").val();
				var userid=$("#userid").val();
				var jsonparams = [];
				
				var chanvalue = this.getLiValue($("#groupofuser"));
				if( chanvalue=='' ){
					alert("请选择组");
					return;
				}
				if(username==''){
					alert("请输入用户名");
					return ;
				}else{
					 document.getElementById("submit_user").style.display = "none";
				}
						
				
				jsonparams.push("[");
				
				var json=[];
				json.push("{");
				
				
//				alert(chanvalue);
				json.push("\"groupofuser\":");
				json.push("\""+chanvalue+"\"");
				
				json.push("}");
				
				jsonparams.push(json.join(""));
				jsonparams.push("]");
				var params = jsonparams.join("");
//				alert(params);
				var url="ajax/builduser";
				if($("#userid").val()!=''){
					url="ajax/updateuser";
				}//alert($("#userid").val());
				$.post(url,{"userid":userid,"username":username,"email":email,"realname":realname,"jsonStr":params},function(data){
					 document.getElementById("submit_user").style.display = "block";
					 window.location.href = "usermanage";
				});	
			
		},
		
		edituser : function(){
			$("#user").attr("class","active");
			if(userid!='0'){
//				alert($("#jsonStr").val());
				var jsonStr=eval("("+$("#jsonStr").val()+")");
				var group_sn = new Array(); 
				if( jsonStr[0].role_id!=""){
					var parent = $("#groupofuser");
					group_sn = jsonStr[0].role_id.split(",");//alert(group_sn[0]);
					for(var i=0; i < group_sn.length;i++){
						parent.find("input[type='checkbox'][id='"+group_sn[i]+"'][value='"+group_sn[i]+"']").attr("checked",true);
					}
				}
			}
		},
		
		selectAll : function(b){
			if(b==1){
//				$("input[name='groupsninput']").attr('checked',true);
				var cc = document.getElementsByName("group_user");  
//				alert(cc[0].id);
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
				$("input[name='group_user']").attr('checked',false);
			}else{
				$("input[name='groupgameinput']").attr('checked',false);
			}
		}
};