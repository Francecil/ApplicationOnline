$(document).ready(function(){
  $(".save").click(function(){
//	  alert("hello");
	  var stepID=$(this).attr("id");
	  //alert(stepID);
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
			url: 'save.action?step='+stepID[4],
			async: true,
			data: params,
			success: function(data) {
				var aid;
				if(data==null||data.aid==null){
					aid=$("input[name='basic.haveApplied']").val();
				}
				else{
					aid=data.aid;
				}
				
				if(aid!=null&&aid!=""){
				$("input[name='basic.haveApplied']").val(aid);
				$("input[name='study.haveApplied']").val(aid);
				$("input[name='work.haveApplied']").val(aid);
				$("input[name='individual.haveApplied']").val(aid);
			    }
				if(stepID == "step1"){
					var status = "";
					if($("#s1f1").val()==""){
						status+="0";
					}
					else{
						status+="1";
					}
					if($("#s1f2").val()==""){
						status+="0";
					}
					else{
						status+="1";
					}
					var files = ['s1f1','s1f2'];
					ajaxFileUpload(files,"s1",aid,status);
					$("#aaaa").css("backgroundColor","rgb(193,210,240)");
				    }
				else if(stepID == "step2"){
					$("#bbbb").css("backgroundColor","rgb(193,210,240)");
				    }
				else if(stepID == "step3"){
					$("#cccc").css("backgroundColor","rgb(193,210,240)");
				    }
				else if(stepID == "step4"){
					var status = "";
					if($("#s4f1").val()==""){
						status+="0";
					}
					else{
						status+="1";
					}
					if($("#s4f2").val()==""){
						status+="0";
					}
					else{
						status+="1";
					}
					if($("#s4f3").val()==""){
						status+="0";
					}
					else{
						status+="1";
					}
					var files = ['s4f1','s4f2','s4f3'];
					ajaxFileUpload(files,"s4",aid,status);
					$("#dddd").css("backgroundColor","rgb(193,210,240)");
				    }
				alert("保存成功");
			},
			error:function(data){
				alert("保存失败");
			}
		});
	});
  $("#finish").click(function(){
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
  function ajaxFileUpload(filelist,type,aid,status) {
      var elementIds=type; //flag为id、name属性名
      $.ajaxFileUpload({
          url: 'fileAction-upload.action?type='+type+'&aid='+aid+'&status='+status, 
          type: 'post',
          secureuri: false, //一般设置为false
          fileElementId: filelist, // 上传文件的id、name属性名
          dataType: 'json', //返回值类型，一般设置为json、application/json
          elementIds: elementIds, //传递参数到服务器
          success: function(data, status){
          },
          error: function(data, status, e){ 
              alert(e);
          }
      });
      //return false;
  }
});
