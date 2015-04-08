manage = {
		init : function(){
			$("#report").attr("class","active");
			this.loadEvent();
		},
		loadEvent : function(){
			
			$("#sub").click(function(){
				var reportName = $("#reportName").val();
				var url = "getQueryList?reportName="+reportName;
				window.location.href=url;
			});
			$("#dele").click(function(){
				var reportName = $("#reportName").val();
				var url = "ajax/deleteReportHistory";
				$.post(url,{"reportName":reportName},function(){
					window.location.href="getQueryList?reportName="+reportName;
				});
			});
		}
};