
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户管理</title>
<link rel="stylesheet" type="text/css" href="${base}/css/index.css">
<script src="${base}/js/usermanage.js"></script>
<script src="${base}/js/title.js"></script>
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
</head>
<body onload="manage.init()">
	<div id="usermanage" class="container">
		<#include "/WEB-INF/freemarker/title.ftl">
		<ul class="nav nav-pills">
		   <li>
		   		<a href="#" class="btn btn-success btn-sm" onclick="manage.newuser()">
          			<span class="glyphicon glyphicon-plus"></span> 新建用户
        		</a>
           </li>
		</ul>
    	<div id="user_list">
	    	<table class="table table-striped table-bordered table-hover table-condensed">
	        	<#if userlist?exists>
	        	<#assign i=userlist>
	        		<#list 0..userlist?size-1 as params>
	        				<#if params%5==0><tr></#if>
		        				<td>
		        					${i[params].username?default('')}
		        				</td>
		        				<td>
		        					<button type="button" class="btn btn-default" onclick="manage.edituser(${i[params].userid?default('0')},'${i[params].username?default('')}')">编辑</button>
		        					<button type="button" class="btn btn-default" onclick="manage.deluser(${i[params].userid?default('0')})">删除</button>
		        				</td>
		        				<td class="success"></td>
	        		</#list>
	        	</#if>
	        </table>
        </div>
    </div>
</body>