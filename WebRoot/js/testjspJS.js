function ajaxSubmit() {
   	$.ajax({
   		async:true,
   		type:"post",
   		url:"AJaXTextActoin",
   		data:{
   			inp1:$("#inp1").val(),
   			inp2:$("#inp2").val(),
   			inp3:$("#inp3").val()
   		},
   		success:function(data){
   			for(i=0;i<data.length;i++){
   	   			$("#divv").append("<img src='" + data[i].piclink + "'/>");
   			}
   		},
   		error:function(data){
   			alert("数据返回失败");
   		}
   	});
}