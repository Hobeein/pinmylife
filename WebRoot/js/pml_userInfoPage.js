var modCheckFlag = false;
$(function () {
	var porInPorupdate = $("#btmPor img")[0].src;
	var usernamex=$("#unameipt").val();
	var sexx="";
	var sexvisitablex="";
	var email=$("#emailipt").val();
	var phone=$("#phoneipt").val();
	var signature=$("#signatureTxta")[0].value;
	if($("#sexVyes")[0].checked==true){
		sexvisitablex=$("#sexVyes").val();
	}else if($("#sexVno")[0].checked==true){
		sexvisitablex=$("#sexVno").val();
	}
	if($("#sexboy")[0].checked==true){
		sexx=$("#sexboy").val();
	}else if($("#sexgirl")[0].checked==true){
		sexx=$("#sexgirl").val();
	}
	
	$.ajax({
		async:false,
		type:"post",
		url:"Pml_userInfoAction",
		data:"",
		success: function (data) {
			if(data.length>=100||data.error=="error"){
				alert("您尚未登录，登录后才可以进入这里哦！");
				window.location.href="pml_LoginPage.jsp";
			}else{
				if(data.length==0){
					$("#infoBC").append("<div id='defaultMoodImg' class='imgInfoBox'><div class='imgShowBox'><img src='img/img1.jpg'/></div><div class='showText'><span class='imgDate'>那日时光</span><br/><span class='dateText'>留下是你的深夜，离去是我的岁月</span><br/><hr/><span class='imgMoth'>那日心情</span><p class='moth'>&nbsp;&nbsp;空空如也，主人什么都没有写哦。</p></div></div>");
				}else{
					$("#infoBC")[0].innerHTML="";
					for(i=0;i<data.length;i++){
						$("#infoBC").append("<div class='imgInfoBox'><div class='imgShowBox'><img src='"+data[i].piclink+"'/></div><div class='showText'><span class='imgDate'>那日时光</span><br/><span class='dateText'>"+data[i].uploaddate+"</span><br/><hr/><span class='imgMoth'>那日心情</span><p class='moth'>"+data[i].bewrite+"</p></div></div>");
					}
				}
			}
		},
		error: function (data) {
			alert("onload网页加载失败！");
		}
	});
	$("#jumpToMain").on("mouseover", function () {
		$("#jumpToMain").stop().animate({
			height:"30px"
		},300);
    });
	$("#jumpToMain").mouseleave(function () {
		$("#jumpToMain").stop().animate({
			height:"8px"
		},500);
    });
	$("#modNow").on("click", function () {
		$("#imguploadBox").animate({top:"0px"},500);
    });
	$("#closeup").on("click", function () {
		$("#imguploadBox").animate({top:"-629px"},500);
		$("#dmFB")[0].innerText="";
		$("#dmImgFile").val("");
		$("#dmBetxt").val("");
		$("#dmBSCtrl").hide();
		$("#dmBSCtrl img").attr("src","");
		$("#cancelDmFile").hide();
    });
	$("#dmFileClick").on("click", function () {
		$("#dmFB")[0].innerText="";
    	$("#dmImgFile")[0].click();
    	$("#dmImgFile")[0].onchange= function () {
    		$("#cancelDmFile").show();
    		var fReader = new FileReader();
    		fReader.readAsDataURL($("#dmImgFile")[0].files[0]);
    		fReader.onload= function (e) {
    			$("#dmBSCtrl").show();
    			$("#dmBSCtrl img").attr("src",e.target.result);
    		}
    	}
    });
	$("#cancelDmFile").on("click", function () {
		$("#dmImgFile").val("");
		$("#dmBSCtrl").hide();
		$("#dmBSCtrl img").attr("src","");
		$("#cancelDmFile").hide();
    });
	
	$("#floatUserInfo").animate({
		top:"105px",
	},1000, function () {
		$("#jumpToMain").show(400);
    });
	$("#infoBC").show();
	$("#uifB").hide();
	$("#updatepw").hide();
	$("#historyImg").css({
			"margin-top":"6px",
			"color":"pink"
		}).click(function () {
		$("#porUpdateFB")[0].innerText="";
		$("#infoBC").show();
		$("#uifB").hide();
		$("#updatepw").hide();
		$("#historyImg").css({
			"margin-top":"6px",
			"color":"pink"
		});
		$("#infoShow").css({
			"margin-top":"5px",
			"color":"black"
		});
		$("#pwUpdate").css({
			"margin-top":"5px",
			"color":"black"
		});
	});
	$("#infoShow").click(function () {
		$("#porUpdateFB")[0].innerText="";
		$("#infoBC").hide();
		$("#uifB").show();
		$("#updatepw").hide();
		$("#historyImg").css({
			"margin-top":"5px",
			"color":"black"
		});
		$("#infoShow").css({
			"margin-top":"6px",
			"color":"pink"
		});
		$("#pwUpdate").css({
			"margin-top":"5px",
			"color":"black"
		});
	});
	$("#pwUpdate").click(function () {
		$("#porUpdateFB")[0].innerText="";
		$("#infoBC").hide();
		$("#uifB").hide();
		$("#updatepw").show();
		$("#historyImg").css({
			"margin-top":"5px",
			"color":"black"
		});
		$("#infoShow").css({
			"margin-top":"5px",
			"color":"black"
		});
		$("#pwUpdate").css({
			"margin-top":"6px",
			"color":"pink"
		});
	});
	$("#upChange").on("click",function () {
		$("#porUpdateFB")[0].innerHTML="";
		$("#unameipt").prop("readonly",false);
		$("#unameipt").css("border-bottom","1px pink solid");
		$("#sexboy").prop("disabled",false);
		$("#sexgirl").prop("disabled",false);
		$("#sexVyes").prop("disabled",false);
		$("#sexVno").prop("disabled",false);
		$("#emailipt").prop("readonly",false);
		$("#emailipt").css("border-bottom","1px pink solid");
		$("#phoneipt").prop("readonly",false);
		$("#phoneipt").css("border-bottom","1px pink solid");
		$("#signatureTxta").prop("readonly",false);
		$("#signatureTxta").css("border-color","pink");
		$("#upChange").hide();
		$("#changeComp").show();
	});
	$("#changeComp").on("click",function () {
		$("#unameipt").prop("readonly",true);
		$("#unameipt").css("border-bottom","none");
		$("#sexboy").prop("disabled",true);
		$("#sexgirl").prop("disabled",true);
		$("#sexVyes").prop("disabled",true);
		$("#sexVno").prop("disabled",true);
		$("#emailipt").prop("readonly",true);
		$("#emailipt").css("border-bottom","none");
		$("#phoneipt").prop("readonly",true);
		$("#phoneipt").css("border-bottom","none");
		$("#signatureTxta").prop("readonly",true);
		$("#signatureTxta").css("border-color","");
		$("#changeComp").hide();
		$("#upChange").show();
		
		var usernameReg = /[a-z0-9A-Z\u4e00-\u9fa5][a-z0-9A-Z\u4e00-\u9fa5]{3,20}$/i;
		var emailReg = /\w+@.+[.](com|cn)$/i;
		var phoneReg = /1[34578][0-9]{9}$/i;
		var username = $("#unameipt").val();
		var useremail = $("#emailipt").val();
		var userPhone = $("#phoneipt").val();
		var signatureTxta = $("#signatureTxta").val();
		if(!usernameReg.test(username)){
			alert("用户名不能为字母、数字和中文以外的符号");
			$("#upChange").click();
			return false;
		}else if(!emailReg.test(useremail)){
			alert("请输入正确的邮箱格式");
			$("#emailipt").val("");
			$("#upChange").click();
		}else if(!phoneReg.test(userPhone)){
			alert("请输入正确的手机号码");
			$("#phoneipt").val("");
			$("#upChange").click();
		}else if(signatureTxta.length>50){
			alert("个性签名不能超过50个字");
			$("#upChange").click();
		}else{
			var sex="";
			var sexvisitable="";
			if($("#sexVyes")[0].checked==true){
				sexvisitable=$("#sexVyes").val();
			}else if($("#sexVno")[0].checked==true){
				sexvisitable=$("#sexVno").val();
			}
			if($("#sexboy")[0].checked==true){
				sex=$("#sexboy").val();
			}else if($("#sexgirl")[0].checked==true){
				sex=$("#sexgirl").val();
			}
			$.ajax({
				async:false,
				type:"post",
				url:"pml_uifUpdateAction",
				data:{
					username:$("#unameipt").val(),
					sex:sex,
					sexvisitable:sexvisitable,
					email:$("#emailipt").val(),
					phone:$("#phoneipt").val(),
					signature:$("#signatureTxta")[0].value,
				},
				success: function (data) {
					console.log(data);
					if(data.error00 != undefined){
						if(sexx=='男'){
							$("#sexboy")[0].checked=true;
							$("#sexgirl")[0].checked=false;
						}else{
							$("#sexgirl")[0].checked=true;
							$("#sexboy")[0].checked=false;
						}
						if(sexvisitablex=='Y'){
							$("#sexVyes")[0].checked=true;
							$("#sexVno")[0].checked=false;
						}else{
							$("#sexVno")[0].checked=true;
							$("#sexVyes")[0].checked=false;
						}
						$("#unameipt").val(usernamex);
						console.log(usernamex);
						$("#emailipt").val(email);
						$("#phoneipt").val(phone);
						console.log(phone);
						$("#signatureTxta")[0].value=signature;
						alert(data.error00);
					}else if(data[0]!=undefined&&data[0].error!=undefined){
						$("#unameipt").val(usernamex);
						if(sexx =='男'){
							$("#sexboy")[0].checked=true;
							$("#sexgirl")[0].checked=false;
						}else{
							$("#sexgirl")[0].checked=true;
							$("#sexboy")[0].checked=false;
						}
						if(sexvisitablex=='Y'){
							$("#sexVyes")[0].checked=true;
							$("#sexVno")[0].checked=false;
						}else{
							$("#sexVno")[0].checked=true;
							$("#sexVyes")[0].checked=false;
						}
						$("#emailipt").val(email);
						$("#phoneipt").val(phone);
						$("#signatureTxta")[0].value=signature;
						alert("用户信息上传失败。");
					}else{
						$("#usernameSpan")[0].innerHTML=data[0].username;
						$("#signCtrl")[0].innerHTML="<span class='signature'>"+data[0].signature+"</span>";
						
						usernamex=$("#unameipt").val();
						email=$("#emailipt").val();
						phone=$("#phoneipt").val();
						signature=$("#signatureTxta")[0].value;
						if($("#sexVyes")[0].checked==true){
							sexvisitablex=$("#sexVyes").val();
						}else if($("#sexVno")[0].checked==true){
							sexvisitablex=$("#sexVno").val();
						}
						if($("#sexboy")[0].checked==true){
							sexx=$("#sexboy").val();
						}else if($("#sexgirl")[0].checked==true){
							sexx=$("#sexgirl").val();
						}
						alert("保存成功!");
					}
				},
				error: function (data) {
					alert("onUserInfoUpdate网页加载失败！")
				},
			});
		}
	});
	$("#modClick").mousedown(modCfunc);
	
	$("#pwNowid").blur(function () {
		if($("#pwNowid").val()==""||$("#pwNowid").val()==null){
			$("#pwNowok")[0].innerText="密码不能为空！";
			whenFail ();
		}
	});
	$("#pwNewid").blur(function () {
		if($("#pwNewid").val()==""||$("#pwNewid").val()==null){
			$("#pwNewok")[0].innerText="更新密码不能为空！";
			whenFail ();
		}
    });
	$("#pwAgaid").blur(function () {
		if($("#pwAgaid").val()==""||$("#pwAgaid").val()==null){
			$("#pwAgaok")[0].innerText="再次输入密码错误！";
			$("#pwAgaid").val("");
			whenFail ();
		}
    });
	
	$("#pwsubmit").on("click",function () {
		var pwReg = /^[^\u4e00-\u9fa5][^\u4e00-\u9fa5]{0,19}$/i;
		$("#pwNowok")[0].innerText="";
		$("#pwNewok")[0].innerText="";
		$("#pwAgaok")[0].innerText="";
		$("#modOK")[0].innerText="";
		if($("#pwNowid").val()==""||$("#pwNowid").val()==null){
			$("#pwNowok")[0].innerText="密码不能为空！";
			whenFail ();
		}else if(!pwReg.test($("#pwNowid").val())){
			$("#pwNowok")[0].innerText="密码必须在20位以内并且不能为中文!";
			$("#pwNowid").val("");
			whenFail ();
		}else if($("#pwNewid").val()==""||$("#pwNewid").val()==null){
			$("#pwNewok")[0].innerText="新密码不能为空！";
			whenFail ();
		}else if(!pwReg.test($("#pwNewid").val())){
			$("#pwNewok")[0].innerText="新密码必须在20位以内并且不能为中文！";
			$("#pwNewid").val("");
			whenFail ();
		}else if($("#pwAgaid").val()==""||$("#pwAgaid").val()==null||$("#pwNewid").val()!=$("#pwAgaid").val()){
			$("#pwAgaok")[0].innerText="再次输入密码错误！";
			$("#pwAgaid").val("");
			whenFail ();
		}else if(!modCheckFlag){
			$("#modOK")[0].innerText="请先完成滑动验证模块!";
			whenFail ();
		}else{
			$("#pwNowok")[0].innerText="";
			$("#pwNewok")[0].innerText="";
			$("#pwAgaok")[0].innerText="";
			$("#modOK")[0].innerText="";
			$.ajax({
				async:true,
				type:"post",
				url:"Pml_pwUpdateAction",
				data:{
					password:$("#pwNewid").val(),
					passwordNow:$("#pwNowid").val()
				},
				success: function (data) {
					if(data.error00!=undefined&&data.error00!=""){
						$("#pwNowok")[0].style.color="red";
						$("#pwNowok")[0].innerText="<---"+data.error00;
						$("#pwNowid").val("");
						whenFail ();
					}else if(data.error01!=undefined&&data.error01!=""){
						$("#modOK")[0].style.color="red";
						$("#modOK")[0].innerText=data.error01;
						$("#pwNowid").val("");
						$("#pwNewid").val("");
						$("#pwAgaid").val("");
						whenFail ();
					}else if(data.error02!=undefined&&data.error02!=""){
						$("#modOK")[0].style.color="red";
						$("#modOK")[0].innerText=data.error02;
						$("#pwNowid").val("");
						$("#pwNewid").val("");
						$("#pwAgaid").val("");
						whenFail ();
					}else if(data.success!=undefined&&data.success!=""){
						$("#modOK")[0].style.color="green";
						$("#modOK")[0].innerText="成功！";
						$("#pwNowid").val("");
						$("#pwNewid").val("");
						$("#pwAgaid").val("");
						whenFail ();
						alert("更改密码后，请点击确定，并重新登录！");
						window.location.href="pml_LoginPage.jsp";
					}
				},
				error: function (data) {
					alert("onPwUpdate网页加载失败！");
				}
			});
		}
	});
	
	$("#porUpdate").on("click", function () {
		$("#porUpdate")[0].hidden=true;
		$("#porUpcomf")[0].hidden=false;
		$("#upLab").hide();
		$("#comfLab").show();
		$("#porUpdelete")[0].hidden=false;
		$("#porUpdateFB")[0].innerText="";
		$("#porUpdate")[0].onchange= function () {
			var fReader = new FileReader();
    		fReader.readAsDataURL($("#porUpdate")[0].files[0]);
    		fReader.onload= function (e) {
    			$("#btmPor img").attr("src",e.target.result);
    		}
		}
    });
	$("#porUpcomf").on("click", function () {
    	console.log($("#porUpdate")[0].files[0].type);
    	var imgReg = /^(image).+(jpeg|png|gif|bmp|dib|tiff|webp)$/i;
    	if(!imgReg.test($("#porUpdate")[0].files[0].type)){
        	console.log(!imgReg.test($("#porUpdate")[0].files[0].type));
			$("#porUpdateFB")[0].style.color="red";
			$("#porUpdateFB")[0].innerText="只能上传类型是jpeg，png，gif，bmp，dib，tiff，webp的图片文件哦！";
    		$("#porUpdate")[0].hidden=false;
    		$("#porUpcomf")[0].hidden=true;
    		$("#upLab").show();
    		$("#comfLab").hide();
    		$("#porUpdelete")[0].hidden=true;
    	}else{
        	$.ajaxFileUpload({
        		async:true,
        		type:"post",
        		secureuri: false,
        		url:"Pml_porUpdateAction",
        		fileElementId: "porUpdate",
        		cache:false,
        		dataType:"json",
        		success: function (data) {
        			$("#porUpdate").on("click", function () {
        				$("#porUpdate")[0].hidden=true;
        				$("#porUpcomf")[0].hidden=false;
        				$("#upLab").hide();
        				$("#comfLab").show();
        				$("#porUpdelete")[0].hidden=false;
        				$("#porUpdateFB")[0].innerText="";
        				$("#porUpdate")[0].onchange= function () {
        					var fReader = new FileReader();
        		    		fReader.readAsDataURL($("#porUpdate")[0].files[0]);
        		    		fReader.onload= function (e) {
        		    			$("#btmPor img").attr("src",e.target.result);
        		    		}
        				}
        		    });
        			if(data.error00!=undefined&&data.error00!=""){
        				$("#porUpdateFB")[0].style.color="red";
        				$("#porUpdateFB")[0].innerText=data.error00;
        			}else if(data.error01!=undefined&&data.error01!=""){
        				$("#porUpdateFB")[0].style.color="red";
        				$("#porUpdateFB")[0].innerText=data.error01;
        			}else if(data.error02!=undefined&&data.error02!=""){
        				$("#porUpdateFB")[0].style.color="red";
        				$("#porUpdateFB")[0].innerText=data.error02;
        			}else if(data.error03!=undefined&&data.error03!=""){
        				$("#porUpdateFB")[0].style.color="red";
        				$("#porUpdateFB")[0].innerText=data.error03;
        			}else if(data.portrait!=undefined){
        				$("#porUpdateFB")[0].style.color="green";
        				$("#porUpdateFB")[0].innerText="完成！";
        				$("#btmPor")[0].innerHTML="<img src='"+data.portrait+"'/>";
        				$("#userPort")[0].innerHTML="<img src='"+data.portrait+"'/>";
        				$("#headBarImg")[0].innerHTML="<img src='"+data.portrait+"'/>";
        				porInPorupdate=data.portrait;
        			}
        		},
        		error: function (data) {
        			console.log(data);
        		}
        	});
    		$("#porUpdate")[0].hidden=false;
    		$("#porUpcomf")[0].hidden=true;
    		$("#upLab").show();
    		$("#comfLab").hide();
    		$("#porUpdelete")[0].hidden=true;
    		$("#porUpdateFB")[0].innerText="";
    	}
    });
	$("#porUpdelete").on("click", function () {
		$("#porUpdate").val("");
		$("#porUpdate")[0].hidden=false;
		$("#porUpcomf")[0].hidden=true;
		$("#upLab").show();
		$("#comfLab").hide();
		$("#porUpdelete")[0].hidden=true;
		$("#porUpdateFB")[0].innerText="";
		$("#btmPor img").attr("src",porInPorupdate);
    });
	
	$("#dmSubClick").on("click", function () {
		$("#dmFB")[0].innerText="";
		$("#cancelDmFile").hide();
    	var imgReg = /^(image).+(jpeg|png|gif|bmp|dib|tiff|webp)$/i;
    	if(!imgReg.test($("#dmImgFile")[0].files[0].type)){
        	console.log(!imgReg.test($("#dmImgFile")[0].files[0].type));
        	$("#dmImgFile").val("");
			$("#dmFB")[0].style.color="red";
			$("#dmFB")[0].innerText="只能上传类型是jpeg，png，gif，bmp，dib，tiff，webp的图片哦！";
			$("#dmBSCtrl").hide();
			$("#dmBSCtrl img").attr("src","");
			$("#cancelDmFile").hide();
			$("#dmImgFile").val("");
    	}else{
    		$.ajaxFileUpload({
	    		async:false,
	    		type:"post",
	    		url:"Pml_ImgShareUploadAction",
	    		fileElementId: "dmImgFile",
	    		dataType:"json",
	    		data:{
	    			bewrite:$("#dmBetxt").val(),
	    			picvisitable:$("#picVis").val(),
	    		},
	    		success: function (data) {
	    			console.log(data);
	    			if(data.error01!=undefined&&data.error01!=""){
	    				$("#dmFB")[0].style.color="red";
	    				$("#dmFB")[0].innerText=data.error01;
	    			}else if(data.error02!=undefined&&data.error02!=""){
	    				$("#dmFB")[0].style.color="red";
	    				$("#dmFB")[0].innerText=data.error02;
	    			}else if(data.error03!=undefined&&data.error03!=""){
	    				$("#dmFB")[0].style.color="red";
	    				$("#dmFB")[0].innerText=data.error03;
	    			}else if(data.piclink!=undefined){
	    				if($("#defaultMoodImg")[0]!=undefined){
	    					$("#defaultMoodImg").remove();
	    				}
	    				$("#infoBC").append("<div class='imgInfoBox'><div class='imgShowBox'><img src='"+data.piclink+"'/></div><div class='showText'><span class='imgDate'>那日时光</span><br/><span class='dateText'>"+data.uploaddate+"</span><br/><hr/><span class='imgMoth'>那日心情</span><p class='moth'>"+data.bewrite+"</p></div></div>");
	    				$("#dmFB")[0].style.color="green";
	    				$("#dmFB")[0].innerText="已分享！";
	    			}
	    		},
	    		error : function (data) {
	    			alert("网页加载失败！");
	    		},
	    	});
			$("#dmFB")[0].innerText="";
			$("#dmImgFile").val("");
			$("#dmBetxt").val("");
			$("#dmBSCtrl").hide();
			$("#dmBSCtrl img").attr("src","");
			$("#cancelDmFile").hide();
    	}
    	
    });
});

function whenFail () {
	$(document).unbind("mouseup");
	$("#modClick").mousedown(modCfunc);
	$("#modClick").css("left","0px");
	$("#modInner").css("width","43px");
	modCheckFlag = false;
	$("#checkOk").hide();
}

function modCfunc () {
	var left=0;
	$(document).mousemove(function (e) {
		left = e.clientX - ($("#modClick")[0].offsetWidth/2) - $("#udpwCtrl")[0].offsetLeft - $("#pwTxtB")[0].offsetLeft - $("#updatepw")[0].offsetLeft - $("#infoBox")[0].offsetLeft;
		if(left<=0){
			$("#modClick").css("left","0px");
			$("#modInner").css("width","43px");
		}else if(left>=256){
			$("#modClick").css("left","256px");
			$("#modInner").css("width",300+"px");
		}else{
			$("#modClick").css("left",left+"px");
			$("#modInner").css("width",(left+43)+"px");
		}
	});
	$(document).mouseup(function () {
		if(left>=256){
			$("#modClick").css("left","256px");
			$("#modInner").css("width",300+"px");
			$("#modClick").unbind("mousedown");
			$("#modOK")[0].innerText="";
			$("#checkOk").show();
			modCheckFlag=true;
		}else{
			$("#modClick").css("left","0px");
			$("#modInner").css("width","43px");
			modCheckFlag=false;
		}
		$(document).unbind("mousemove");
	});
}