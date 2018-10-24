$(function () {
	$(".login_box").animate({
		marginLeft: "80px"
	},1500,function(){
		$("#textBox").fadeIn();
	});
	var loginFlag = $("#loginFlag").val();
	var logupFlag = $("#logupFlag").val();
	
	if(loginFlag==="false"){
		$(".login_box").show();
		$("#logup_box").hide();
	}else if(loginFlag==="true"){
		$(".login_box").hide();
		$("#logup_box").show();
	}
	
	var checkMod = $(".checkMod")[0];//返回原生JavaScript元素对象
	var paddingBox = $(".modInnerBox")[0];
	var clickFloatBox = $(".modClickBox")[0];
	var boxCtrl = $(".login_boxCtrl")[0];
	var loginbox = $(".login_box")[0];
	var cfBoxLift=0;
	var checkSuccess=false;
	clickFloatBox.onmousedown=function () {
		if($("#POE").val()==""){
			$(".modFB").eq(0).text("手机或邮箱不能为空！");
		}else if($("#PW").val()==""){
			$(".modFB").eq(0).text("密码不能为空！");
		}else{
			document.onmousemove=function (ev) {
				cfBoxLift=ev.clientX-checkMod.offsetLeft-loginbox.offsetLeft-boxCtrl.offsetLeft-(clickFloatBox.offsetWidth/2);
				if(cfBoxLift>=238){
					document.onmousemove=null;
					clickFloatBox.onmousedown=null;
					clickFloatBox.style.left=238+"px";
					paddingBox.style.width=280+"px";
					$("#checkOk").show();
					checkSuccess=true;
					$(".modFB").eq(0).text("");
				}else if(cfBoxLift<=0){
					clickFloatBox.style.left=0+"px";
					paddingBox.style.width=0+"px";
				}else{
					clickFloatBox.style.left=cfBoxLift+"px";
					paddingBox.style.width=cfBoxLift+"px";
					$("#checkOk").hide();
				}
			}
		}
	}
	document.onmouseup=function (){
		document.onmousemove=null;
		if(cfBoxLift>=238){
			clickFloatBox.style.left=238+"px";
			paddingBox.style.width=280+"px";
			$("#checkOk").show();
			checkSuccess=true;
			$(".modFB").eq(0).text("");
		}else{
			clickFloatBox.style.left=0+"px";
			paddingBox.style.width=0+"px";
			$("#checkOk").hide();
		}
	}
	
	$("#needCheck").submit(function () {
		if($("#POE").val()==""){
			$(".modFB").eq(0).text("手机或邮箱不能为空！");
			return false;
		}else if($("#PW").val()==""){
			$(".modFB").eq(0).text("密码不能为空！");
			return false;
		}else{
			if(!checkSuccess){
				$(".modFB").eq(0).text("请先完成滑动验证！");
				console.log($(".modFB").eq(0).val());
				return false;
			}else{
				console.log("true");
				return true;
			}
		}
    });
	$("#logupNeedCheck").submit(function () {
    	if($("#sexM")[0].checked==false&&$("#sexFM")[0].checked==false){
    		$(".upFB").eq(0).text("请选择你的性别！");
    		return false;
    	}else if($("#Phone").val()==""){
    		$(".upFB").eq(0).text("手机号码不能为空！");
    		return false;
    	}else if($("#Email").val()==""){
    		$(".upFB").eq(0).text("邮箱不能为空！");
    		return false;
    	}else if($("#pw").val()==""){
    		$(".upFB").eq(0).text("密码不能为空！");
    		return false;
    	}
    });
});

function checkMod() {
	if(!checkSuccess){
		$(".modFB").eq(0).text("请先完成滑动验证！");
		console.log($(".modFB").eq(0));
		alert($(".modFB").eq(0))
		return false;
	}else{
		console.log("true");
		return true;
	}	
}
function logupFunc() {
	$(".login_box").hide();
	$("#logup_box").show();
	$(".userInfo1 input").eq(0).val("");
	$(".userInfo1 input").eq(1).val("");
	$(".modFB").eq(0).text("");
}
function loginFunc() {
	$(".login_box").show();
	$("#logup_box").hide();
	$(".userInfo input").eq(0).val("");
	$(".userInfo input").eq(1).val("");
	$(".userInfo input").eq(2).val("");//.eq(index)返回jQuery对象，能使用jQuery方法；
	$(".userInfo_s input").get(0).checked=false;//.get(index)返回原生JavaScript只能使用原生JavaScript方法和DOM方法。
	$(".userInfo_s input").get(1).checked=false;
	$(".upFB").eq(0).text("");
}