$(document).ready(function(){
  $(".save").click(function(){
//	  alert("hello");
	  var stepID=$(this).attr("id");
	  var stepform="#"+stepID+"form";
	  var params = $(stepform).serialize();
//	  $("input[name='basic.step']").val(stepID[4]);
//	  $("input[name='study.step']").val(stepID[4]);
//	  $("input[name='work.step']").val(stepID[4]);
//      $("input[name='individual.step']").val(stepID[4]);
//	  if(stepID[4]=='2'){
////		  alert($("div[class='Admission-date ed_item']").text());
//		  alert(JSON.stringify(params));
//	  }
//	  return;
		$.ajax({
			type: "post",
			url: 'save.action',
			async: true,
			data: params,
			success: function(data) {
//				alert(data);

//				alert(JSON.stringify(data));
				alert("保存成功");
				var aid =data.aid;
//				alert(aid);
//				alert($("input[name='basic.haveApplied']").val());
				if(aid!=null&&aid!=""){
				$("input[name='basic.haveApplied']").val(aid);
				$("input[name='study.haveApplied']").val(aid);
				$("input[name='work.haveApplied']").val(aid);
				$("input[name='individual.haveApplied']").val(aid);
				}
				
			},
			error:function(data){
				alert("保存失败");
			}
		});
	});
  $("#finish").click(function(){
	  var params = $('#step4form').serialize();
//	  alert("finish");
	  var aid=$("input[name='basic.haveApplied']").val();
	  if(aid==null||aid==""||aid.length==0){
		  alert("please complete first view");
		  return;
	  }
		$.ajax({
			type: "post",
			url: 'finish.action?aid='+aid,
			async: true,
			data: params,
			success: function(data) {
				var status = data.status;
				if(status=="success"){
				alert("finish ok");
				window.location='userlist.action' ; //原页面跳转
				}
				else {
					var child = data.child;
					alert("第"+child+"个子申请未完成");
				}
			},
			error:function(data){
				alert("提交失败，请重新登录");
			}
		});
	});
});
