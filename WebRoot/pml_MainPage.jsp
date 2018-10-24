<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link type="text/css" href="css/jquery-ui.min.css" rel="stylesheet" />
	<link type="text/css" href="css/pml_MainPage.css" rel="stylesheet" />
	<link type="text/css" href="css/normalize.css" rel="stylesheet" />
	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/ajaxfileupload.js"></script>
	<script type="text/javascript" src="js/imagesloaded.pkgd.min.js"></script>
	<script type="text/javascript" src="js/masonry.pkgd.min.js"></script>
	<script type="text/javascript" src="js/pml_MainPage.js"></script>
  </head>
  
  <body>
    <div id="fatherBox">
				<div class="floatFindBox ui-widget-shadow ui-corner-right">
					<div class="InnerFindBox" hidden="hidden">
						<div class="InnerScrollBox">
							<div class="userInfoShow ui-corner-all">
								<div class="userInfoCtrl">
									<div class="uifCtrlUp">
										<div id="userPor" class="userPortrait">
										<c:choose>
											<c:when test="${session.portrait eq null or empty session.portrait}">
												<img atl="y" src="img/user.png"/>
											</c:when>
											<c:otherwise>
												<img atl="x" src="${session.portrait}"/>
											</c:otherwise>
										</c:choose>
										</div>
										<div class="usernameAndSex">
											<font id="usernameFont" class="f1">${session.username}</font>
											<font id="sexFont">${session.sex}</font>
											<div id="setting" class="setting">
												<img src="img/engine.png"/>
											</div>
										</div>
									</div>
									<div class="uifCtrlBtm">
										<font id="signFont">${session.signature}</font>
									</div>
								</div>
							</div>
							<div hidden="hidden" id="updif" class="updateInfoBox">
								<s:form>
									<label>用户名：</label>
										<input id="usernameVal" name="username" value="${session.username}" type="text"/><span></span><br><br>
									<label>用户id：</label>
										<input id="useridVal" name="userId" readonly="readonly" value="${session.userId}" type="text"/>
									<br/><br/>
									
									<label>性&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
										<c:choose>
											<c:when test="${session.sex == '男'}">
												<input id="sexBoy" class="sexVal" name="sex" value="男" type="radio" checked="checked"/>男
												<input id="sexGirl" class="sexVal" name="sex" value="女" type="radio"/>女<br><br>
											</c:when>
											<c:otherwise>
												<input id="sexBoy" class="sexVal" name="sex" value="男" type="radio"/>男
												<input id="sexGirl" class="sexVal" name="sex" value="女" type="radio" checked="checked"/>女<br><br>
											</c:otherwise>
										</c:choose>
									<label>显示性别：</label>
										<c:choose>
											<c:when test="${session.sexvisitable == 'Y'}">
												<input id="sexVisY" class="sexvisVal" name="sexvisitable" type="radio" value="Y" checked="checked"/>可见
												<input id="sexVisN" class="sexvisVal" name="sexvisitable" type="radio" value="N"/>不可见<br>
											</c:when>
											<c:otherwise>
												<input id="sexVisY" class="sexvisVal" name="sexvisitable" type="radio" value="Y"/>可见
												<input id="sexVisN" class="sexvisVal" name="sexvisitable" type="radio" value="N" checked="checked"/>不可见<br>
											</c:otherwise>
										</c:choose>
									<br/><br/>
									<label>Email：</label>
										<input id="emailVal" name="email" type="text" value="${session.email}"/><br><br>
									<label>手&nbsp;机：</label>
										<input id="phoneVal" name="phone" type="text" value="${session.phone}"/><br>
									<br/><br/>
									<label>个性签名：</label><br/>
										<c:choose>
											<c:when test="${session.signature eq null or empty session.signature }">
												<textarea id="sign" class="sign" name="signature">主人并没有写什么...</textarea><br><br>
											</c:when>
											<c:otherwise>
												<textarea id="sign" class="sign" name="signature">${session.signature}</textarea><br><br>
											</c:otherwise>
										</c:choose>
										<input id="uifUpd" class="uifUpdcompelet" type="button" value="完成"/>
										<input id="updCancel" class="uifUpdcompelet uifupc2" type="button" value="取消"/>
										<label id="updFB"></label>
								</s:form>
							</div>
							<div id="mimgupl" class="moodImgUpload">
								<label class="titleImgShare">分享每日心情</label>
								<div id="bsImg" hidden="hidden" class="backShowImgBox">
									<img/>
								</div>
								<form>
									<label class="btnTxt">+</label>
									<input id="fclick" type="button" class="fileClick"/>
									<input id="mImgObj" hidden="hidden" type="file" name="dayMoodImg"/>
									<input id="picvisVal" type="hidden" name="picvisitable" value="Y"/>
									<label class="titleImgShare">描述你的图片:</label>
									<textarea id="bewVal" name="bewrite"></textarea>
								</form>
								<button id="imgShare" class="upLcomp">分享</button>
								<button hidden id="imguplcancel" class="upLcomp">取消</button><br>
								<label id="uplimgFB"></label>
							</div>
						</div>
					</div>
				</div>
				
				<div class="waterFall">
					<div id="wfCtrl" class="wfInnerBox">
					</div>
				</div>
			</div>
  </body>
</html>
