<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<script>
	$(function(){
		$("#province").change(function(){
			var provinceId = $(this).val();
			$.getJSON("province-ajax?provinceId=" + provinceId, function(data){
				$("#city").empty().append("<option>请选择</option>");
				if(data != null){
					$("#city").empty().append("<option>请选择</option>");
					var cities = eval(data);
					for(var i = 0; i < cities.length; i++){
						$("#city").append("<option value='" + cities[i].cityId + "'>" + cities[i].cityName + "</option>");
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<s:debug></s:debug>
	<br />
	
	省份:
	<select id="province">
		<option value="0">请选择</option>
		<s:iterator value="#request.provinces">
			<option value="${provinceId}">${provinceName}</option>
		</s:iterator>
	</select> 
	&nbsp;&nbsp;&nbsp;
	
	城市:
	<select id="city">
		<option>请选择</option>
	</select>

</body>
</html>