
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>群组管理</title>
<link rel="stylesheet" type="text/css" href="${base}/css/index.css">
<script src="${base}/js/jquery-1.11.1.js"></script>
<script src="${base}/js/groupedit.js"></script>
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
<body onload='manage.editgroup()'>
	<input type="hidden" value="${jsonStr?default('!')}" id="jsonStr">
	<input type="hidden" value="${groupId?default('0')}" id="groupId">
	<div class="container">
	  <#include "/WEB-INF/freemarker/title.ftl">
		
	<div id="grounpinfodiv" class="form-group" >
			<form class="form-inline" role="form">
 			 <div class="form-group">
   				 <label class="sr-only">Email</label>
   				 <p class="form-control-static">群组名称：</p>
 			 </div>
 			 <div id="group_name" class="form-group">
 			    <#if groupName?exists>
	        		 <input name="groupname" type="text" class="form-control" id="groupname" value="${groupName?default('')}"/>
	        	<#else>
	        		<input name="groupname" type="text" class="form-control" id="groupname" />
	        	</#if>
  			</div>
			</form>
		      	
	        <div id="groupsn"> 
	        	<li>SN平台
	        	<button type="button" class="btn btn-info" onclick="manage.selectAll(1)">全选</button>
	        	<button type="button" class="btn btn-info" onclick="manage.cancelAll(1)">重置</button>
	        	</li>
	        	<table class="table table-striped table-bordered table-hover table-condensed">
	        		<#if listSN?exists>
	        		<#assign i=listSN>
			        	<#list 0..listSN?size-1 as param>
			        		<#if param%9==0><tr></#if>
			        			<td>
			        			<input name='groupsninput' type='checkbox' id='${i[param].sn_id}' value='${i[param].sn_id}'/>${i[param].sn_name}
			        		</td>
			        	</#list>
			        </#if>
		        </table>
	        </div>
	        
	        <div id="groupgame">
	        	 <li>游戏
	        	<button type="button" class="btn btn-info" onclick="manage.selectAll(2)">全选</button>
	        	<button type="button" class="btn btn-info" onclick="manage.cancelAll(2)">重置</button>
	        	</li>
	        	<table class="table table-striped table-bordered table-hover table-condensed">
	        		<#if listGame?exists>
	        		<#assign i=listGame>
		        	<#list 0..listGame?size-1 as param>
		        			<#if param%6==0><tr></#if>
		        			<td>
		        			<input name='groupgameinput' type='checkbox' id='${i[param].game_id}' value='${i[param].game_id}'/>${i[param].game_name}
		        			</td>
		        	</#list>
		        	</#if>
		        	
		        </table>
	        </div>
	        <button type="button" class="btn btn-info" onclick="manage.savegroupInfo()" id="submit_group">提交</button>
	</div>
	</div>
</body>