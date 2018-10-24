<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>My JSP 'pml_userInfoPage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="UTF-8">
	<link type="text/css" rel="stylesheet" href="css/pml_userInfoPage.css"/>
	<link type="text/css" rel="stylesheet" href="css/normalize.css"/>
	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="js/ajaxfileupload.js"></script>
	<script type="text/javascript" src="js/pml_userInfoPage.js"></script>

  </head>
  
  <body>
  		<div id="imguploadBox" class="imgUploadBox">
	  			<div class="imgUpBoxCtrl">
	  				<div id="closeup" class="closeUp">X</div>
	  				<label class="iubctrlLab">用图片分享每日心情</label>
	  				<hr class="iubLine1">
	  				<s:form id="userMood" namespace="/" method="post" enctype="multipart/form-data">
	  					<input id="picVis" type="hidden" name="picvisitable" value="Y"/>
	  					<input id="dmImgFile" type="file" hidden="hidden" name="dayMoodImg"/>
		  				<div class="dmUploadTips">
		  					<label class="dmuTipsLab">图片上传注意事项：</label><br>
		  					<p>1、不能上传图片以外的文件哦！</p>
		  					<p>2、只能上传类型为jpeg，png，gif，bmp，dib，tiff，webp格式的图片文件哦！</p>
		  				</div>
		  				<input id="dmFileClick" class="dayMoodImgClick" value="+" type="button"/>
		  				<input hidden="hidden" id="cancelDmFile" type="button" value="取消" class="cancelDmf">
		  				<div hidden="hidden" id="dmBSCtrl" class="dmBSImgCtrl">
		  					<img />
		  				</div>
		  				<label id="dmFB" class="dmFB"></label>
		  				<hr class="iubLine2">
		  				<label class="bewriteLab">为你的图片写一段描述吧：</label><br/>
		  				<textarea id="dmBetxt" name="bewrite" class="bewirteUpLoad"></textarea>
	  				</s:form>
		  			<button id="dmSubClick" class="dmSubmitClick">分&nbsp;享</button>
	  			</div>
  		</div>
    	<div id="fartherBox">
			<div id="floatUserInfo" class="float_userinfo">
				<div id="modNow" class="ModNow"></div>
				<div id="userPort" class="userportrait">
					<c:choose>
						<c:when test="${session.portrait eq null or empty session.portrait}">
							<img src="img/user.png"/>
						</c:when>
						<c:otherwise>
							<img src="${session.portrait}"/>
						</c:otherwise>
					</c:choose>
				</div>
				<span id="usernameSpan" class="username">${session.username}</span>
				<div id="signCtrl" class="signatureCtrl">
					<c:choose>
						<c:when test="${session.signature eq null or empty session.signature}">
							<span class="signature">主人并没有写什么...</span>
						</c:when>
						<c:otherwise>
							<span class="signature">${session.signature}</span>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div hidden="hidden" id="jumpToMain" class="jumpToMainPage">
			    <a href="pml_MainPage.jsp">首页心情墙</a>
			</div>
			<div class="innerfa">
				<div id="headBarImg" class="headBar">
					<c:choose>
						<c:when test="${session.portrait eq null or empty session.portrait}">
							
						</c:when>
						<c:otherwise>
							<img src="${session.portrait}"/>
						</c:otherwise>
					</c:choose>
				</div>
				<div id="historyImg" class="infoBtn ifbtn1">过往相册</div>
				<div id="infoShow" class="infoBtn ifbtn2">基本信息</div>
				<div id="pwUpdate" class="infoBtn ifbtn3">修改密码</div>
				<div id="infoBox" class="infoBox">
					<div id="infoBC" class="infoBoxCtrl">
						<c:choose>
							<c:when test="${session.userId eq null or empty session.userId}">
								<div class="imgInfoBox">
									<div class="imgShowBox">
										<img src="img/img1.jpg"/>
									</div>
									<div class="showText">
										<span class="imgDate">那日时光</span><br/>
										<span class="dateText">留下是你的深夜，离去是我的岁月</span>
										<br/>
										<hr/>
										<span class="imgMoth">那日心情</span>
										<p class="moth">&nbsp;&nbsp;空空如也</p>
									</div>
								</div>
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>
					</div>
					<div id="uifB" class="userInfoBox">
						<div class="uifBoxCtrl">
							<div class="portraitInfo">
								<div id="btmPor" class="portrait">
									<c:choose>
										<c:when test="${session.portrait eq null or empty session.portrait}">
											<img src="img/user.png"/>
										</c:when>
										<c:otherwise>
											<img src="${session.portrait}"/>
										</c:otherwise>
									</c:choose>
								</div>
								<span class="pifText">大家都是“有头有脸”的朋友，上传头像让大家更快认识您。</span><br/>
								<span class="pifText">选择喜欢的图片作为您的头像：</span>
								<s:form id="uifPor" namespace="/" method="post" enctype="multipart/form-data">
									<input id="porUpdate" name="porUpdate" type="file" title=" " class="uploadP" name="portraitUpdate"/>
									<input type="button" hidden="hidden" id="porUpcomf" name="porUpdate" class="uploadP upcomf"/>
									<label id="upLab" class="fileBtnTxt"><span>选择图片</span></label>
									<label hidden="hidden" id="comfLab" class="fileBtnTxt"><span>确认上传</span></label>
								</s:form>
								<button hidden="hidden" id="porUpdelete">取消</button>
								<label id="porUpdateFB"></label>
							</div>
							<hr/>
							<div class="otherInfoText">
								<form id="testForm">
									<label class="txtlab1">用户名：</label>
										<input id="unameipt" name="username" value="${session.username}" readonly="readonly" type="text" class="txtBar txtBar1" /><span id="usernameSP"></span>
									<label class="txtlab2">用户id：</label>
										<input id="uidipt" name="userId" value="${session.userId}" readonly="readonly" type="text" class="txtBar" />
									<br/><br/>
									
									<label class="sexLab">性&nbsp;&nbsp;别：</label>
										<c:choose>
											<c:when test="${session.sex == '男'}">
												<input id="sexboy" name="sex" value="男" type="radio" checked="checked" disabled="disabled"/>男
												<input id="sexgirl" name="sex" value="女" type="radio" disabled="disabled"/>女
											</c:when>
											<c:otherwise>
												<input id="sexboy" name="sex" value="男" type="radio" disabled="disabled"/>男
												<input id="sexgirl" name="sex" value="女" type="radio" checked="checked" disabled="disabled"/>女
											</c:otherwise>
										</c:choose>
									<label class="sexVLab">性别是否可见：</label>
										<c:choose>
											<c:when test="${session.sexvisitable == 'Y'}">
												<input id="sexVyes" name="sexvisitable" type="radio" value="Y" checked="checked" disabled="disabled"/>可见
												<input id="sexVno" name="sexvisitable" type="radio" value="N" disabled="disabled"/>不可见
											</c:when>
											<c:otherwise>
												<input id="sexVyes" name="sexvisitable" type="radio" value="Y" disabled="disabled"/>可见
												<input id="sexVno" name="sexvisitable" type="radio" value="N" checked="checked" disabled="disabled"/>不可见
											</c:otherwise>
										</c:choose>
									<br/><br/>
									<label class="emailLab">Email：</label>
										<input id="emailipt" name="email" class="txtBar txtEmailBar" type="text" readonly="readonly" value="${session.email}"/>
									<label class="phoneLab">手机：</label>
										<input id="phoneipt" name="phone" class="txtBar" type="text" readonly="readonly" value="${session.phone}"/>
									<br/><br/>
									<label class="signatureLab">个性签名：</label><br/>
										<c:choose>
											<c:when test="${session.signature eq null or empty session.signature }">
												<textarea id="signatureTxta" name="signature" class="signatureTxt" readonly="readonly">主人并没有写什么...</textarea>
												<input id="changeComp" type="button" value="完成" class="upload" hidden="hidden"/>
												<input id="upChange" type="button" value="修改" class="upload"/>
											</c:when>
											<c:otherwise>
												<textarea id="signatureTxta" name="signature" class="signatureTxt" readonly="readonly">${session.signature}</textarea>
												<input id="changeComp" type="button" value="完成" class="upload" hidden="hidden"/>
												<input id="upChange" type="button" value="修改" class="upload"/>
											</c:otherwise>
										</c:choose>
								</form>
							</div>
						</div>
					</div>
					<div id="updatepw" class="updatePwBox">
						<div id="udpwCtrl" class="updatapwCtrl">
							<div id="pwTxtB" class="pwTextCtrl">
								<div class="pwTextBox">
									<span>更改密码</span>
									<hr/><br/>
									<form id="pwUpload">
										<label class="pwNowLab">当前密码：</label>
										<input id="pwNowid" class="pwNow pw" type="password" name="passwordNow"/><label class="tipsLab" id="pwNowok"></label><br/><br/>
										<br/>
										<label class="pwNewLab">新的密码：</label>
										<input id="pwNewid" class="pwNew pw" type="password" name="passwordNew"/><label class="tipsLab" id="pwNewok"></label><br/><br/>
										<br/>
										<label class="pwAgainLab">再次输入：</label>
										<input id="pwAgaid" class="pwAga pw" type="password" name="pwAgain"/><label class="tipsLab" id="pwAgaok"></label><br/><br/>
										<div class="checkMod">
						    				滑动模块完成验证
						    				<div id="modInner" class="modInnerBox"><font id="checkOk" hidden="hidden" style="color: white;">验证成功！</font></div>
						    				<div id="modClick" class="modInnerBox modClickBox"></div>
						    			</div>
						    			<input id="pwsubmit" type="button" class="pwSubmit" value="确认更改"/><label class="tipsLab tip3" id="modOK"></label>
					    			</form>
									<br/><hr/><br/>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
  </body>
</html>
