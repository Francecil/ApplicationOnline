$(document).ready(function(){
//添加界面点击添加 数据传到后台	
  $("#workAdd").click(function(){
	  var startTime=$('#lean_ad_work').val();
	  var endTime=$('#lean_edoa_work').val();
	  var company=$('#lean_tgs_work').val();
	  var job=$('#lean_el_work').val();
	  if(startTime.length==0||endTime.length==0||company.length==0||job.length==0){
		  alert("infomation exist null");
//		  exit(0);//throw exception exit is not design
		  throw "empty";//防止代码中断 窗口消失
	  }
	  var aid=$("input[name='work.haveApplied']").val();
	  var params = $("#step3form").serialize();
	 
		$.ajax({
			type: "post",
			url: 'work.action?startTime='+startTime+'&endTime='+endTime+'&company='+company+'&job='+job+'&aid='+aid,
			async: true,
			data: params,
			success: function(data) {
				//把数据放添加到list中
				var wid=data.workdetailID;
				 var operation="<a class='edit_2 operation'   rel='leanModal' href='#edit'>edit</a><a class='delete_2 operation'>delete</a>";
				  $("#workinfo").append("<li id='wd"+wid+"'>" +
				  		"<div class='Admission-date ed_item_work'>"+startTime+"</div>"
					+"<div class='End-academic  ed_item_work'>"+endTime+"</div>"
					+"<div class='WorkInfo-company ed_item_work'>"+company+"</div>"
					+"<div class='WorkInfo-job ed_item_work'>"+job+"</div>"
					+"<div class='Operation'>"+operation+"</div>"
					+"<input name='detailID' type='hidden' value='"+wid+"'/>"
					+"</li>"
				  );
				  //数据重置
				  $("#lean_ad_work").val("");
				  $("#lean_edoa_work").val("");
				  $("#lean_tgs_work").val("");
				var aid =data.aid;
				if(aid!=null&&aid!=""){
				$("input[name='basic.haveApplied']").val(aid);
				$("input[name='study.haveApplied']").val(aid);
				$("input[name='work.haveApplied']").val(aid);
				$("input[name='individual.haveApplied']").val(aid);
				}
				$(document).ready(function () { 
					$('a[rel*=leanModal_work]').leanModal({top: 100, closeButton: ".modal_close_work"}); 
					});
//				alert("添加成功");
			},
			error:function(data){
				alert("保存失败");
			}
		});
	});
  //点击编辑按钮 把数据传到要修改的form
  $(document).on("click",".edit_2_work",function(){
	  //js语法
	  var aText = new Array();
	  var oLi=this.parentNode.parentNode;
	  var aDiv = oLi.getElementsByTagName('div');
	  var detail = $(oLi).find("input[name='detailID_work']").val();
	  var oSelect = document.getElementById('edit_el_form_work');
	  for (var i=0;i<(aDiv.length-1);i++)
	  {
			aText[i] = aDiv[i].innerText;
	  }
	  $("#edit_ad_work").val(aText[0]);
	  $("#edit_edoa_work").val(aText[1]);
	  $("#edit_tgs_work").val(aText[2]);
	  $("#edit_el_work").val(aText[3]);
      $("#editDetailID_work").val(detail);
	});
  //编辑界面 数据修改到后台
  $("#workEdit").click(function(){
	  var startTime=$('#edit_ad_work').val();
	  var endTime=$('#edit_edoa_work').val();
	  var company=$('#lean_tgs_work').val();
	  var job=$('#lean_el_work').val();
	  if(startTime.length==0||endTime.length==0||company.length==0||job.length==0){
		  alert("infomation exist null");
//		  exit(0);//throw exception exit is not design
		  throw "empty";//防止代码中断 窗口消失
	  }
	  var wid = $('#editDetailID_work').val();
	  var params = $("#step3form").serialize();
		 
		$.ajax({
			type: "post",
			url: 'workUpdate.actionstartTime='+startTime+'&endTime='+endTime+'&company='+company+'&job='+job+'&wid='+wid,
			async: true,
			data: params,
			success: function(data) {
				//把数据放添加到list中
				var li_id='#wd'+sid;
				var oLi=$(li_id).children(".ed_item_work");//得到li的所有该class的子节点
				//oLi.next();注意这样将跳到第二个 再给其html()将赋值到第二个及之后
//				var startT=oLi.next(); //该步骤不可取
//				startT.html(startTime);
				//为防止将后面的元素也给得到 加选择器 注意next(是匹配后面所有满足条件的元素 如oLi.html(startTime); 该步骤是对四个值都赋startTime的值)
				oLi.html(startTime);//next()方法返回的是所有满足条件的节点
				var endT=oLi.next(".ed_item_work");//这样如选择器为.Admission-date的话就只匹配一个
				endT.html(endTime);
				var schoolT=endT.next(".ed_item_work");
				schoolT.html(school);
				var levelT=schoolT.next(".ed_item_work");
				levelT.html(level);
				 $(document).ready(function () { 
					$('a[rel*=leanModal_work]').leanModal({top: 100, closeButton: ".modal_close_work"}); 
					});
				alert("更新成功");
			},
			error:function(data){
				alert("保存失败");
			}
		});
	});
  //删除事件
  $(document).on("click",".delete_2_work",function(){
	
  	if(!confirm('delete really?'))return;
  	var par=this.parentNode.parentNode;
  	var inp=this.parentNode.parentNode.getElementsByTagName("input");
  	var wid=$(inp).val();
  	var params = $("#step2form").serialize();
	$.ajax({
		type: "post",
		url: 'workDelete.action?wid='+wid,
		async: true,
		data: params,
		success: function(data) {
//			alert(data);
			alert("delete success");
			$(par).remove();
				
		},
		error:function(data){
			alert("delete fail");
		}
		});
  });
});

