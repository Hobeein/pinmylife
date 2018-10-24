$(function () {
	var firstResult = 0;
	var maxResult = 9;
	
	var username = $("#usernameVal").val();
	var sex = "";
	$(".sexVal").each(function (i,e) {
    	if($(".sexVal").eq(i).prop("checked")){
    		sex = $(".sexVal").eq(i).val();
    	}
    });
	var sexvisitable = "";
	$(".sexvisVal").each(function (i,e) {
    	if($(".sexvisVal").eq(i).prop("checked")){
    		sexvisitable = $(".sexvisVal").eq(i).val();
    	}
    });
	var email = $("#emailVal").val();
	var phone = $("#phoneVal").val();
	var signature = $("#sign").val();
	
	$(".floatFindBox").stop().hover(
		function () {
			$(".InnerFindBox").show(400);
			$(this).animate({
				width:"270px"
			},400);
		}, 
		function () {
			$("#uplimgFB").html("");
			$("#bewVal").val("");
			$("#updFB").text("");
			$(".floatFindBox").animate({
				width:"15px"
			},500);
			$(".InnerFindBox").fadeOut(400);
			$("#updif")[0].hidden = true;
		}
	);
	
	$("#userPor").on("click", function () {
    	window.location.href="pml_userInfoPage.jsp";
    });
	$("#setting").on("click", function () {
		$("#updFB").text("");
    	$("#updif")[0].hidden = !$("#updif")[0].hidden;
    	$("#mimgupl")[0].hidden = !$("#mimgupl")[0].hidden;
    	console.log($("#updif")[0].hidden);
    	if($("#updif")[0].hidden){
    		console.log($("#updif")[0].hidden);
    		$(".floatFindBox").stop().hover(function () {
    			$(".InnerFindBox").show(400);
    			$(this).animate({
    				width:"270px"
    			},400);
    		}, function () {
    			$("#uplimgFB").html("");
    			$("#bewVal").val("");
    			$("#updFB").text("");
    			$(".floatFindBox").animate({
    				width:"15px"
    			},500);
    			$(".InnerFindBox").fadeOut(400);
    			$("#updif")[0].hidden = true;
    	    });
    	}else{
        	$(".floatFindBox").unbind();
        	console.log("执行unbind");
    	}
    });
	$("#updCancel").on("click", function () {
		$("#mimgupl")[0].hidden = false;
		$("#updFB").text("");
		 $("#updif")[0].hidden = true;
		 $("#usernameVal").val(username);
		 if(sex = '男'){
			 $("#sexBoy").prop("checked",true);
			 $("#sexGirl").prop("checked",false);
		 }else{
			 $("#sexGirl").prop("checked",true);
			 $("#sexBoy").prop("checked",false);
		 }
		 if(sexvisitable = 'Y'){
			 $("#sexVisY").prop("checked",true);
			 $("#sexVisN").prop("checked",false);
		 }else{
			 $("#sexVisN").prop("checked",true);
			 $("#sexVisY").prop("checked",false);
		 }
		 $("#emailVal").val(email);
		 $("#phoneVal").val(phone);
		 $("#sign").val(signature);
		 $(".floatFindBox").stop().hover(
			function () {
				$(".InnerFindBox").show(400);
				$(this).animate({
					width:"270px"
				},400);
			}, 
			function () {
				$("#bewVal").val("");
				$("#uplimgFB").html("");
				$("#updFB").text("");
				$("#updif")[0].hidden = true;
				$(".floatFindBox").animate({
					width:"15px"
				},500);
				$(".InnerFindBox").fadeOut(400);
			}
		 );
    });
	$("#uifUpd").on("click", function () {
		$("#updFB").text("");
		$(".floatFindBox").stop().hover(
			function () {
				$(".InnerFindBox").show(400);
				$(this).animate({
					width:"270px"
				},400);
			}, 
			function () {
				$("#bewVal").val("");
				$("#uplimgFB").html("");
				$("#updFB").text("");
				$("#updif")[0].hidden = true;
				$(".floatFindBox").animate({
					width:"15px"
				},500);
				$(".InnerFindBox").fadeOut(400);
			}
		);
		var sexNow = "";
		$(".sexVal").each(function (i,e) {
	    	if($(".sexVal").eq(i).prop("checked")){
	    		sexNow = $(".sexVal").eq(i).val();
	    	}
	    });
		var sexvisitableNow = "";
		$(".sexvisVal").each(function (i,e) {
	    	if($(".sexvisVal").eq(i).prop("checked")){
	    		sexvisitableNow = $(".sexvisVal").eq(i).val();
	    	}
	    });
		$.ajax({
			async:false,
			type:"post",
			url:"pml_uifUpdateAction",
			data:{
				username:$("#usernameVal").val(),
				sex:sexNow,
				sexvisitable:sexvisitableNow,
				email:$("#emailVal").val(),
				phone:$("#phoneVal").val(),
				signature:$("#sign").val()
			},
			success: function (data) {
				if(data.error00 != undefined){
					alert(data.error00);
					$("#usernameVal").val(username);
					if(sex = '男'){
						$("#sexBoy").prop("checked",true);
						$("#sexGirl").prop("checked",false);
					}else{
						$("#sexGirl").prop("checked",true);
						$("#sexBoy").prop("checked",false);
					}
					if(sexvisitable = 'Y'){
						$("#sexVisY").prop("checked",true);
						$("#sexVisN").prop("checked",false);
					}else{
						$("#sexVisN").prop("checked",true);
						$("#sexVisY").prop("checked",false);
					}
					$("#emailVal").val(email);
					$("#phoneVal").val(phone);
					$("#sign").val(signature);
				}else if(data[0]!=undefined&&data[0].error!=undefined){
					alert(data[0].error);
					$("#usernameVal").val(username);
					if(sex = '男'){
						$("#sexBoy").prop("checked",true);
						$("#sexGirl").prop("checked",false);
					}else{
						$("#sexGirl").prop("checked",true);
						$("#sexBoy").prop("checked",false);
					}
					if(sexvisitable = 'Y'){
						$("#sexVisY").prop("checked",true);
						$("#sexVisN").prop("checked",false);
					}else{
						$("#sexVisN").prop("checked",true);
						$("#sexVisY").prop("checked",false);
					}
					$("#emailVal").val(email);
					$("#phoneVal").val(phone);
					$("#sign").val(signature);
				}else{
					$("#updFB").css("color","green");
					$("#updFB").text("完成！");
					$("#usernameFont").text(data[0].username);
					$("#sexFont").text(data[0].sex);
					$("#signFont").text(data[0].signature);
					username = $("#usernameVal").val();
					$(".sexVal").each(function (i,e) {
				    	if($(".sexVal").eq(i).prop("checked")){
				    		sex = $(".sexVal").eq(i).val();
				    	}
				    });
					$(".sexvisVal").each(function (i,e) {
				    	if($(".sexvisVal").eq(i).prop("checked")){
				    		sexvisitable = $(".sexvisVal").eq(i).val();
				    	}
				    });
					email = $("#emailVal").val();
					phone = $("#phoneVal").val();
					signature = $("#sign").val();
				}
			},
			error: function (data) {
				alert("网页加载失败！");
			}
		});
    });
	$("#fclick").on("click", function () {
    	$("#mImgObj").click();
        $(".floatFindBox").unbind();
        $("#imguplcancel").get(0).hidden=false;
    });
	$("#mImgObj").change(function () {
    	var imgobj = $(this).get(0).files[0];
    	var readfile = new FileReader();
    	readfile.readAsDataURL(imgobj);
    	readfile.onload=function (e) {
    		$("#fclick").get(0).hidden=true;
    		$("#bsImg").get(0).hidden=false;
    		$("#bsImg img").attr("src",e.target.result);
    		var imginfo = new Image();
    		imginfo.src = $("#bsImg img").attr("src");
    		imginfo.onload = function () {
    			var perSize = (imginfo.height)/parseInt($("#bsImg").css("height"));
    			$("#bsImg img").css("left","-"+(imginfo.width/perSize)/2+"px");
    		}
    	};
    });
	$("#imguplcancel").on("click", function () {
		$("#uplimgFB").html("");
		$("#bewVal").val("");
		$("#fclick").get(0).hidden=false;
		$("#bsImg").get(0).hidden=true;
		$("#bsImg img").removeAttr("src");
		$("#mImgObj").val("");
		$(".floatFindBox").stop().hover(function () {
			$(".InnerFindBox").show(400);
			$(this).animate({
				width:"270px"
			},400);
		}, function () {
			$("#uplimgFB").html("");
			$("#bewVal").val("");
			$("#updFB").text("");
			$(".floatFindBox").animate({
				width:"15px"
			},500);
			$(".InnerFindBox").fadeOut(400);
			$("#updif")[0].hidden = true;
	    });
        $("#imguplcancel").get(0).hidden=true;
    });
	$("#imgShare").on("click", function () {
		$("#mImgObj")[0].files[0];
		var imgReg = /^(image).+(jpeg|png|gif|bmp|dib|tiff|webp)$/i;
		if(!imgReg.test($("#mImgObj")[0].files[0].type)){
			$("#uplimgFB")[0].style.color="red";
			$("#uplimgFB")[0].innerText="只能上传类型是jpeg，png，gif，bmp，dib，tiff，webp的图片文件哦！";
			$("#fclick").get(0).hidden=false;
			$("#bsImg").get(0).hidden=true;
			$("#bsImg img").removeAttr("src");
			$("#mImgObj").val("");
			$(".floatFindBox").stop().hover(function () {
				$(".InnerFindBox").show(400);
				$(this).animate({
					width:"270px"
				},400);
			}, function () {
				$("#uplimgFB").html("");
				$("#updFB").text("");
				$(".floatFindBox").animate({
					width:"15px"
				},500);
				$(".InnerFindBox").fadeOut(400);
				$("#updif")[0].hidden = true;
		    });
    	}else{
    		$.ajaxFileUpload({
        		async:true,
        		type:"post",
        		secureuri: false,
        		url:"Pml_ImgShareUploadAction",
        		fileElementId: "mImgObj",
        		cache:false,
        		dataType:"json",
        		data:{
        			bewrite:$("#bewVal").val(),
        			picvisitable:$("#picvisVal").val()
        		},
        		success: function (data) {
        			if(data.error01!=undefined&&data.error01!=""){
	    				$("#uplimgFB")[0].style.color="red";
	    				$("#uplimgFB")[0].innerText=data.error01;
	    			}else if(data.error02!=undefined&&data.error02!=""){
	    				$("#uplimgFB")[0].style.color="red";
	    				$("#uplimgFB")[0].innerText=data.error02;
	    			}else if(data.error03!=undefined&&data.error03!=""){
	    				$("#uplimgFB")[0].style.color="red";
	    				$("#uplimgFB")[0].innerText=data.error03;
	    			}else if(data.piclink!=undefined){
	    				$("#wfCtrl").prepend("<li class='wfItem ui-widget-shadow'><img src='"+ data.piclink +"'/><div class='imgInfo'><font>"+data.username+"</font><font>likes&nbsp;"+ 0 +"</font><font>"+data.uploaddate+"</font></div></li>");
	    				$("#uplimgFB")[0].style.color="green";
	    				$("#uplimgFB")[0].innerText="已分享！";
	    				$("#bewVal").val("");
	    				$("#bsImg img").removeAttr("src");
	    				$("#fclick").get(0).hidden=false;
	    				$("#bsImg").get(0).hidden=true;
	    			}
    				$("#wfCtrl").imagesLoaded().always(function () {
		    			$(".wfInnerBox").masonry({
		    				itemSelector:".wfItem",
		    				columnWidth:50,
		    				isAnimated:true
		    			});
		    	    });
        			$(".floatFindBox").stop().hover(function () {
        				$(".InnerFindBox").show(400);
        				$(this).animate({
        					width:"270px"
        				},400);
        			}, function () {
        				$("#uplimgFB").html("");
        				$("#bewVal").val("");
        				$("#updFB").text("");
        				$(".floatFindBox").animate({
        					width:"15px"
        				},500);
        				$(".InnerFindBox").fadeOut(400);
        				$("#updif")[0].hidden = true;
        		    });
        	        $("#imguplcancel").get(0).hidden=true;
        		},
        		error: function (data) {
        			alert("网页加载失败！");
        		}
    		});
    	}
    });
	
	$.ajax({
		async:false,
		type:"post",
		url:"Pml_MainPageAction",
		data:{
			firstRe:firstResult,
			maxRe:maxResult
		},
		success:function(data){
			var flag = false;
			for(i=0;i<data.length;i++){
				$("#wfCtrl").append("<li class='wfItem ui-widget-shadow'><img src='"+ data[i].piclink +"'/><div class='imgInfo'><font>"+data[i].username+"</font><font>likes&nbsp;"+ data[i].likes +"</font><font>"+data[i].uploaddate+"</font></div></li>");
			}
		},
		error:function(data){
			alert("网页加载失败！");
		}
	});
	$("#wfCtrl").imagesLoaded().always(function () {
		$(".wfInnerBox").masonry({
			itemSelector:".wfItem",
			columnWidth:50,
			isAnimated:true
		});
    });
	
	$(window).scroll(function () {
		var firstNow = firstResult;
    	var windowH = $(this).height();
    	var documentH = $(document).height();
    	var scrollTop = $(this).scrollTop();
    	if(scrollTop/(documentH - windowH)>=0.99){
    		firstResult+=9;
    		$.ajax({
    			async:false,
    			type:"post",
    			url:"Pml_MainPageAction",
    			data:{
    				firstRe:firstResult,
    				maxRe:maxResult
    			},
    			success:function(data){
    				if(data.length==0||data==null||data==undefined){
    					firstResult=firstNow;
    				}
    				var flag = false;
    				(function (callback) {
    					var i=0;
        				for(i;i<data.length;i++){
        					$("#wfCtrl").append("<li class='wfItem ui-widget-shadow'><img src='"+ data[i].piclink +"'/><div class='imgInfo'><font>"+data[i].username+"</font><font>likes&nbsp;"+ data[i].likes +"</font><font>"+data[i].uploaddate+"</font></div></li>");
        					$(".wfInnerBox").masonry().masonry("destroy");
        					$(window).scrollTop(scrollTop);
            			}
        				(!(i<data.length)) && callback();
    				})(function callback() {
    		    		$("#wfCtrl").imagesLoaded().always(function () {
    		    			$(".wfInnerBox").masonry({
    		    				itemSelector:".wfItem",
    		    				columnWidth:50,
    		    				isAnimated:true
    		    			});
        		    		$(window).scrollTop(scrollTop);
    		    	    });
    				});
    			},
    			error:function(data){
    				alert("网页加载失败！");
    			}
    		});
    	}
    });
	
	

});
