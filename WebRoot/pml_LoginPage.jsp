<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML>
<html>
  <head>
    
    <title>pml_LoginPage.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="PinMyLife">
	
	<link rel="stylesheet" type="text/css" href="css/pml_LoginPage.css">
	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="js/pml_LoginPage.js"></script>

  </head>
  
  <body>
  		<%  String messageBack="";
  			String error="";
  			String userPhone="";
  			String loginHidden="false";
  			String logupHidden="true";
  			if(request.getAttribute("error")!=null){
  				error = (String) request.getAttribute("error");
  				%>
  					<script type="text/javascript">alert("<%=error%>")</script>
  				<%
  			}
  			if(request.getAttribute("logupFB")!=null){
  				loginHidden="true";
  				logupHidden="false";
				if(request.getAttribute("PhoneisExist")!=null){
	  				messageBack=(String) request.getAttribute("PhoneisExist");
	  			}else if(request.getAttribute("EmailisExist")!=null){
	  				messageBack=(String) request.getAttribute("EmailisExist");
	  			}else if(request.getAttribute("logupSuccess")!=null){
  			 		loginHidden="false";
  					logupHidden="true";
	  				userPhone=(String) request.getAttribute("logupSuccess");
	  			}else if(request.getAttribute("")!=null){
	  				messageBack=(String) request.getAttribute("");
	  			}
  			}else{
	  			if(request.getAttribute("PoEisNotExist")!=null){
	  				messageBack = (String) request.getAttribute("PoEisNotExist");
	  			}else if(request.getAttribute("passWordFalse")!=null){
	  				messageBack=(String) request.getAttribute("passWordFalse");
	  			}
  			}
  			
  		%>
  		<input type="hidden" id="loginFlag" value="<%=loginHidden%>"/>
  		<input type="hidden" id="logupFlag" value="<%=logupHidden%>"/>
    	<div class="login_box">
    		<s:form id="needCheck" action="pml_LoginAction" namespace="/">
	    		<div class="login_boxCtrl">
	    			<div class="titlePic">
	    				<img alt="Title" src="img/titleIcon.png">
	    			</div>
	    			<div class="userInfo1 phnoeOrEmail">
	    				<span>手机/邮箱：</span><input id="POE" name="phoneOremail" type="text" value="<%=userPhone%>"/>
	    			</div>
	    			<div class="userInfo1 passWord">
	    				<span>输入 密码：</span><input id="PW" name="password" type="password"/><br><br><font class="feedBackFont modFB"><%= messageBack %></font>
	    			</div>
	    			<div class="checkMod">
	    				滑动模块完成验证
	    				<div class="modInnerBox"><font id="checkOk" hidden="hidden" style="color: white;">验证成功！</font></div>
	    				<div class="modInnerBox modClickBox"></div>
	    			</div>
	    			<div class="logBtn">
	    				<input class="logBtnIn" type="submit" value="登录" onclick=""/>
	    				<input class="logbtnUp" type="button" value="注册" onclick="logupFunc()"/>
	    			</div>
	    		</div>
    		</s:form>
    	</div>
    	
    	<div id="logup_box" class="login_box" hidden="hidden">
    		<s:form id="logupNeedCheck" action="pml_LogupAction" namespace="/">
	    		<div class="login_boxCtrl">
	    			<div class="titlePic">
	    				<img alt="Title" src="img/titleIcon.png">
	    			</div>
	    			<input type="hidden" name="username" value=""/>
	    			<div class="userInfo_s sex">
	    				<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性别：</span><input id="sexM" class="sexRadio sexRadio1" type="radio" name="sex" value="男"/>男<input id="sexFM" class="sexRadio" type="radio" name="sex" value="女"/>女
	    			</div>
	    			<input type="hidden" name="sexvisitable" value="Y"/>
	    			<div class="userInfo phnoeOrEmail">
	    				<span>手机：</span><input id="Phone" name="phone" type="text"/>
	    			</div>
	    			<div class="userInfo phnoeOrEmail">
	    				<span>邮箱：</span><input id="Email" name="email" type="text"/>
	    			</div>
	    			<div id="uifpw" class="userInfo passWord">
	    				<span>密码：</span><input id="pw" name="password" type="password"/>
	    			</div>
	    			<br><font style="margin-left: 80px;" class="feedBackFont upFB"><%=messageBack %></font>
	    			<input type="hidden" name="signature" value=""/>
	    			<input type="hidden" name="portrait" value=""/>
	    			<div class="logBtn">
	    				<input class="logBtnIn" type="submit" value="注册"/>
	    				<input class="logbtnUp" type="button" value="返回" onclick="loginFunc()"/>
	    			</div>
	    		</div>
    		</s:form>
    	</div>
    	
    	<div id="textBox" hidden="hidden">
    		<div id="txtCtrl">
	    		<div id="txtPicCtrl">
	    			<div class="picCtrl_img">
	    				<img alt="" src="img/img1.jpg">
	    			</div>
	    			<div class="picCtrl_img picCtrl_img2">
	    				<img alt="" src="img/img2.jpg">
	    			</div>
	    		</div>
	    		<div id="textBoxInner">
	    			<font>余生，愿你快乐<br><br>人生在意识中权衡自己<br><br>落雨听心恬淡无尘<br><br>难忘的芭蕉扇<br><br>七月微步，纳凉冲浪雨泻凌波<br><br>书香文觞，绽放生命的闪烁荣光<br><br>
						暗香魅惑，拳拳心房的一腔挚爱<br><br>只有纯净的心灵，才能照进阳光<br><br>月明风细，绿窗锁情长<br><br>一方庭院，半卷闲书<br><br>
	    			</font>
	    		</div>
    		</div>
    	</div>

  </body>
</html>
