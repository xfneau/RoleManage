
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>RloManage</title>
<link rel="stylesheet" type="text/css" href="${base}/css/index.css">
<script src="${base}/js/jquery-1.11.1.js"></script>
<script src="${base}/js/json.js"></script>
<script src="${base}/js/gamemanage.js"></script>
<script src="${base}/js/title.js"></script>
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
	<div id="game"  class="container">
		<#include "/WEB-INF/freemarker/title.ftl">
		<ul class="nav nav-pills">
		   <li>
		   		<a href="#" class="btn btn-success btn-sm" onclick="manage.shownewgame()">
          			<span class="glyphicon glyphicon-plus"></span> 新建游戏
        		</a>
           </li>
		</ul>
		<table class="table table-striped table-bordered table-hover table-condensed">
		<#if listGame?exists>
		<#assign i=listGame>
			<#list 0..listGame?size-1 as parm>
				<#if parm%4==0><tr></#if>
				  <td>
				  ${i[parm].game_name?default("null")}
				  <div name="gameinfo" id="${i[parm].game_id?default("null")}" style="position:absolute;width:350px;left:50%;top:20%;margin-left:-15%;z-index:3;background:#FFFFFF;padding: 20;">
				  	游戏名称：<input type="text" id="gamename${i[parm].game_id?default("null")}" value="${i[parm].game_name?default("null")}"/></br></br>
					游戏img：<input type="text" id="gameimg${i[parm].game_id?default("null")}" value="${i[parm].game_img?default("null")}"/></br></br>
					游戏等级：<input type="hidden" id="gamelevel_${i[parm].game_id?default("null")}" value="${i[parm].game_level?default("null")}"/>
						<select type="text" id="gamelevel${i[parm].game_id?default("null")}" >
							<#list 0..8 as t>
								<option value="${t}">${t}</option>
							</#list>
						</select><a><font color="#FF7F50">数字越大，代表该游戏优先级越高</font></a>
					</br></br>
					游戏别称：<input type="text" id="gamealias${i[parm].game_id?default("null")}" value="${i[parm].game_alias?default("null")}"/></br></br>
					<button type="button" class="btn btn-default" onclick="manage.editgame(${i[parm].game_id?default("null")})">提交</button>
					<button type="button" class="btn btn-default" onclick="manage.cancel(${i[parm].game_id?default("null")})">取消</button>
				  </div>
				  </td>
				  <td>
				  <button type="button" class="btn btn-default" onclick="manage.edit(${i[parm].game_id?default("null")})">编辑</button>
				  <button type="button" class="btn btn-default" onclick="manage.dele(${i[parm].game_id?default("null")})">删除</button>
			      </td>
			      <td class="success"></td>
		    </#list>
		   </#if>
		</table>
			
	</div>
	<div id="newgame" style="position:absolute;width:350px;left:50%;top:20%;margin-left:-15%;z-index:3;background:#FFFFFF;padding: 20;">
		游戏名称：<input type="text" id="gamename"/></br></br>
		游戏img：<input type="text" id="gameimg"/></br></br>
		游戏等级：<select type="text" id="gamelevel">
					<option value="0">0</option><option value="1">1</option><option value="2">2</option>
					<option value="3">3</option><option value="4">4</option><option value="5">5</option>
					<option value="6">6</option><option value="7">7</option><option value="8">8</option>
				</select><a><font color="#FF7F50">数字越大，代表该游戏优先级越高</font></a>
		</br></br>
		游戏别称：<input type="text" id="gamealias"/></br>
		<button type="button" class="btn btn-default" onclick="manage.newgame()">提交</button>
		<button type="button" class="btn btn-default" onclick="manage.cancel('newgame')">取消</button>
	</div>
	<div class="bigDiv"></div>
</body>