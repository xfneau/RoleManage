
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>群组管理</title>
<link rel="stylesheet" type="text/css" href="${base}/css/index.css">
<script src="${base}/js/groupmanage.js"></script>
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
	<div class="container"> 	
		<#include "/WEB-INF/freemarker/title.ftl">
		<ul class="nav nav-pills">
		   <li>
		   		<a href="#" class="btn btn-success btn-sm" onclick="manage.newGroup()">
          			<span class="glyphicon glyphicon-plus"></span> 新建组
        		</a>
           </li>
		</ul>
		<div>
			<table class="table table-striped table-bordered table-hover table-condensed">
			<#if listGroup?exists>
			<#assign i=listGroup>
				<#list 0..listGroup?size-1 as parm>
					<#if parm%4==0><tr></#if>
						  <td>
						  ${i[parm].group_name?default("null")}
						  </td>
						  <td>
					   		<button type="button" class="btn btn-default" onclick="manage.edit(${i[parm].group_id?default("null")})">编辑</button>
					   		<button type="button" class="btn btn-default" onclick="manage.dele(${i[parm].group_id?default("null")})">删除</button>
					      </td>
					    <td class="success"></td>
			    </#list>
			   </#if>
			   
			</table>
		</div>
			
	</div>
</body>