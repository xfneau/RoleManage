
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理</title>
<link rel="stylesheet" type="text/css" href="${base}/css/index.css">
<script src="${base}/js/jquery-1.11.1.js"></script>
<script src="${base}/js/useredit.js"></script>
<script src="${base}/js/title.js"></script>
<script src="${base}/js/json.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/bootstrap-theme.css">
  <link rel="stylesheet" href="css/bootstrap-theme.min.css">
  <link rel="stylesheet" href="css/bootstrap.css">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="./css/index.css">
  <script type="text/javascript" src="js/bootstrap.js"></script>
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/json.js"></script>
  <script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<link rel="stylesheet" href="${base}/css/index.css" type="text/css" />
</head>
<body onload="manage.edituser()">
	<input type="hidden" value="${jsonStr?default('!')}" id="jsonStr">
	<div id="userinfodiv" class="container"> 	
		<#include "/WEB-INF/freemarker/title.ftl">
		
	      	<div id="user_info">
	      		<form class="form-inline" role="form">
	      			<#if userinfo?exists>
	        			<input name="userid" type="hidden" id="userid" value="${userinfo.userid?default('')}"/>
	        			<#else>
	        			<input name="userid" type="hidden" id="userid" />
	        		</#if>
  					<div class="form-group">
    					<p class="form-control-static">用户名称：</p>
 					 </div>
  					<div class="form-group">
   						 <#if userinfo?exists>
	        				<input name="username" class="form-control" type="text" id="username" value="${userinfo.username?default('')}"/>
	        			<#else>
	        				<input name="username" class="form-control" type="text" id="username" />
	        			</#if>
  					</div>
  					
  					<div class="form-group">
    					<p class="form-control-static">邮箱：</p>
 					 </div>
  					<div class="form-group">
   						<#if userinfo?exists>
	        				<input name="email" class="form-control" type="text" id="email" value="${userinfo.email?default('')}"/>
	        			<#else>
	        				<input name="email" class="form-control" type="text" id="email" />
	        			</#if>
  					</div>
  					
  					<div class="form-group">
    					<p class="form-control-static">真实姓名：</p>
 					 </div>
  					<div class="form-group">
   						<#if userinfo?exists>
	        				<input name="realname" class="form-control" type="text" id="realname" value="${userinfo.realname?default('')}"/>
	        			<#else>
	        				<input name="realname" class="form-control" type="text" id="realname" />
	        			</#if>
  					</div>
  					
  					
				</form>
	        </div>
	        
	        	<div id="groupofuser">
		        	
		        	<li>群组权限：<button type="button" class="btn btn-info" onclick="manage.selectAll(1)">全选</button>
		        	<button type="button" class="btn btn-info" onclick="manage.cancelAll(1)">重置</button>
	        		</li>
		        	<table class="table table-striped table-bordered table-hover table-condensed">
			        	<#if listGroup?exists>
			        	<#assign  i=listGroup>
			        	<#list 0..listGroup?size-1 as params>
			        	<#if params%(6)==0><tr></#if>
			        		
			        			<td>
			        				<input type="checkbox" name='group_user' value="${i[params].group_id}" id="${i[params].group_id}"/>${i[params].group_name}
			        			</td>
			        
			        	</#list>
			        	</#if>
		        	</table>
	        	</div>
	        <button type="button" class="btn btn-info" onclick="manage.savegroupInfo()" id="submit_user">提交</button>
	</div>
	
</body>