<%@page import="org.apache.jasper.tagplugins.jstl.core.Import"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>My JSP 'testjsp.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="js/testjspJS.js"></script>

  </head>
  
  <body>
  
  		<%
  			String uploadFB = "没拿到东西！";
  			if(request.getAttribute("uploadFB")!=null){
  				uploadFB = (String) request.getAttribute("uploadFB");
  			}
  		 %>
  		 <div>
  		 	<%-- <s:iterator value="list">
  		 		用户名：<s:property value="userId"/><br/>
  		 		用户id：<s:property value="username"/>
  		 	</s:iterator> --%>
  		 	用户id： ${session.userId}<br/>
  		 	用户名： ${session.username} <br/>
  		 	当前网址pageContext.request.contextPath的值：${pageContext.request.contextPath}<br/>
  		 	当前网址contextPath的值：${contextPath}
  		 </div>
		<div class="formBox">
			<div class="formBoxCtrl">
				<s:form id="formAjax" class="uploadImg" action="Pml_ImgUploadAction" namespace="/" enctype="multipart/form-data" method="post">
					<input type="hidden" name="picvisitable" value="Y"/>
					<s:textarea name="bewrite"></s:textarea>
					<s:file name="imgUpload"></s:file><input class="uploadCtrlBtn" type="submit" value="上传"/>
				</s:form>
				<input type="text" value="<%= uploadFB %>" />
			</div>
			<div class="AJaXText">
				<label id="AjaxTestLabel"></label>
				<s:form id="formajax" namespace="/" method="post" enctype="multipart/form-data">
					<input type="text" id="inp1" name="inp1"/>
					<input type="text" id="inp2" name="inp2"/>
					<input type="text" id="inp3" name="inp3"/>
					<input type="button" id="fs" value="提交" onclick="ajaxSubmit()"/>
				</s:form>
				<div id="divv"></div>
			</div>
		</div>
  </body>
</html>
