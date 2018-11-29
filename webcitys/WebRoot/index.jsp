<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <body>

		<p>
			省份:
			<select id="fs" onchange="change_province()">
				<option value="">
					--请选择省份--
				</option>
				<c:forEach items="${list}" var="pv">
					<option value="${pv.id}">
						${pv.provincename}
					</option>
				</c:forEach>
			</select>
		</p>
		
		城市:
				<div id="city" >
				<select>
				<option>---选择城市---</option>
				</select>
					</div>
		
		<p>
		区域:
		<div id="area">
			
			<select id="area">
				<option>
					--请选择区域--
				</option>
			</select>
			</div>
		</p>
  </body>
  <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
  <script type="text/javascript">
  function change_province(){
  		 var opid =document.getElementById("fs").value;
  		 $.ajax({
  		 		"url":"UserServlet?action=city",
  		 		"type":"post",
  		 		"data":{"opid":opid},
  		 		//"dataType":"html",
  		 		"dataType":"JSON",
  		 		success:function(data){	
  		 		  $("#city").empty();
  		 			//alert(data);
  		 			$select=$("<select id=\"cit\" onchange=\"change_city()\"><option>---选择城市---</option></select>");
  		 			$(data).each(function(){
  		 				$select.append("<option value="+this.id+">"+this.cityName+"</option>");
  		 			})
                    $("#city").append($select);
  		 		}
  		 })
  		
  }
  function change_city(){
  	var cityid=document.getElementById("cit").value;
  	$.ajax({
  		"url":"UserServlet?action=area",
  		"type":"post",
  		"data":{"cityid":cityid},
  		"dataType":"JSON",
  		success:function(data){
  			$("#area").empty();
  			//alert(data);
  			 $select=$("<select id=\"area\"><option>---选择城市---</option></select>");
  			 $(data).each(function(){
  			 $select.append("<option value="+this.id+">"+this.areaname+"</option>");
  			 })
          	$("#area").append($select);
  		}
  		
  	})
  }
  
  </script>
</html>
