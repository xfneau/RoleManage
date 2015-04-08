
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>RloManage</title>
<link rel="stylesheet" type="text/css" href="${base}/css/index.css">
<script src="${base}/js/jquery-1.11.1.js"></script>
<script src="${base}/js/json.js"></script>
<script src="${base}/js/title.js"></script>
<script src="${base}/js/reportingHistory.js"></script>
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
<body onload='manage.init()'>
	<div class="container">
		<#include "/WEB-INF/freemarker/title.ftl">
		
 		<form class="form-inline" role="form">
 			<div class="form-group">
    			<p class="form-control-static">Report名称：</p>
 			</div>
 			<div class="form-group">
	        	<input class="form-control" type="text" id="reportName" value="${reportName?default("")}" />
  			</div>
  			<div class="form-group">
	        	<a href="#" class="btn btn-success btn-sm" id="sub">
          			 搜索
        		</a>
  			</div>
  		</form>
		<table class="table table-striped table-condensed">
			<tr>
				<th>报表名称</th>
				<th>报表状态</th>
				<th>创建者</th>
				<th>创建时间</th>
			</tr>
			<#if listHistory?exists>
				<#assign i=1>	
					<#list listHistory as parm>
						<tr>
						 	<td>${parm.report_name?default("null")}</td>
						 	<td>${parm.report_status?default("null")}</td>
						 	<td>${parm.report_user?default("null")}</td>
						 	<td>${parm.report_date?default("null")}</td>
					    <tr>
			    	</#list>
			</#if>	
		</table>
		<div style="height:22px;line-height:22px;text-align:center; vertical-align:middle;">
			<button type="button" class="btn btn-success" id="dele">清除</button>
		</div>
	</div>
</body>