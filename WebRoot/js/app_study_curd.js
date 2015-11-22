$(document).ready(function(){
//添加界面点击添加 数据传到后台	
  $("#studyAdd").click(function(){
	  var startTime=$('#lean_ad').val();
	  var endTime=$('#lean_edoa').val();
	  var school=$('#lean_tgs').val();
	  var level=$('#lean_el').val();
	  if(startTime.length==0||endTime.length==0||school.length==0||level.length==0){
		  alert("infomation exist null");
//		  exit(0);//throw exception exit is not design
		  throw "empty";//防止代码中断 窗口消失
	  }
	  var aid=$("input[name='study.haveApplied']").val();
	  var params = $("#step2form").serialize();
	 
		$.ajax({
			type: "post",
			url: 'study.action?startTime='+startTime+'&endTime='+endTime+'&school='+school+'&level='+level+'&aid='+aid,
			async: true,
			data: params,
			success: function(data) {
				//把数据放添加到list中
				var sid=data.studydetailID;
				 var operation="<a class='edit_2 operation'   rel='leanModal' href='#edit'>edit</a><a class='delete_2 operation'>delete</a>";
				  $("#education").append("<li id='sd"+sid+"'>" +
				  		"<div class='Admission-date ed_item'>"+startTime+"</div>"
					+"<div class='End-academic  ed_item'>"+endTime+"</div>"
					+"<div class='Graduation-school ed_item'>"+school+"</div>"
					+"<div class='Education-level ed_item'>"+level+"</div>"
					+"<div class='Operation'>"+operation+"</div>"
					+"<input name='detailID' type='hidden' value='"+sid+"'/>"
					+"</li>"
				  );
				  //数据重置
				  $("#lean_ad").val("");
				  $("#lean_edoa").val("");
				  $("#lean_tgs").val("");
				var aid =data.aid;
				if(aid!=null&&aid!=""){
				$("input[name='basic.haveApplied']").val(aid);
				$("input[name='study.haveApplied']").val(aid);
				$("input[name='work.haveApplied']").val(aid);
				$("input[name='individual.haveApplied']").val(aid);
				}
				$(document).ready(function () { 
					$('a[rel*=leanModal]').leanModal({top: 100, closeButton: ".modal_close"}); 
					});
//				alert("添加成功");
			},
			error:function(data){
				alert("保存失败");
			}
		});
	});
  //点击编辑按钮 把数据传到要修改的form
  $(document).on("click",".edit_2",function(){
	  //js语法
	  var aText = new Array();
	  var oLi=this.parentNode.parentNode;
	  var aDiv = oLi.getElementsByTagName('div');
	  var detail = $(oLi).find("input[name='detailID']").val();
	  var oSelect = document.getElementById('edit_el_form');
	  for (var i=0;i<(aDiv.length-1);i++)
	  {
			aText[i] = aDiv[i].innerText;
	  }
	  $("#edit_ad").val(aText[0]);
	  $("#edit_edoa").val(aText[1]);
	  $("#edit_tgs").val(aText[2]);
	  for(var j=0;j<oSelect.length;j++){//给select赋值  
			if(aText[i-1]==oSelect.options[j].value){  
				oSelect.options[j].selected=true;
				oSelect.value=oSelect.options[j].value;
			} 
			else oSelect.options[j].selected=false;
		}  
//      $("#edit_el").find("option[value='"+aText[3]+"']").attr("selected",true); 不能做到
      $("#editDetailID").val(detail);
	});
  //编辑界面 数据修改到后台
  $("#studyEdit").click(function(){
	  var startTime=$('#edit_ad').val();
	  var endTime=$('#edit_edoa').val();
	  var school=$('#edit_tgs').val();
	  var level=$('#edit_el_form').val();
	  if(startTime.length==0||endTime.length==0||school.length==0||level.length==0){
		  alert("infomation exist null");
//		  exit(0);//throw exception exit is not design
		  throw "empty";//防止代码中断 窗口消失
	  }
	  var sid = $('#editDetailID').val();
	  var params = $("#step2form").serialize();
		 
		$.ajax({
			type: "post",
			url: 'studyUpdate.action?startTime='+startTime+'&endTime='+endTime+'&school='+school+'&level='+level+'&sid='+sid,
			async: true,
			data: params,
			success: function(data) {
				//把数据放添加到list中
				var li_id='#sd'+sid;
				var oLi=$(li_id).children(".ed_item");//得到li的所有该class的子节点
				//oLi.next();注意这样将跳到第二个 再给其html()将赋值到第二个及之后
//				var startT=oLi.next(); //该步骤不可取
//				startT.html(startTime);
				//为防止将后面的元素也给得到 加选择器 注意next(是匹配后面所有满足条件的元素 如oLi.html(startTime); 该步骤是对四个值都赋startTime的值)
				oLi.html(startTime);//next()方法返回的是所有满足条件的节点
				var endT=oLi.next(".ed_item");//这样如选择器为.Admission-date的话就只匹配一个
				endT.html(endTime);
				var schoolT=endT.next(".ed_item");
				schoolT.html(school);
				var levelT=schoolT.next(".ed_item");
				levelT.html(level);
				 $(document).ready(function () { 
					$('a[rel*=leanModal]').leanModal({top: 100, closeButton: ".modal_close"}); 
					});
				alert("更新成功");
			},
			error:function(data){
				alert("保存失败");
			}
		});
	});
  //删除事件
  $(document).on("click",".delete_2",function(){
	
  	if(!confirm('delete really?'))return;
  	var par=this.parentNode.parentNode;
  	var inp=this.parentNode.parentNode.getElementsByTagName("input");
  	var sid=$(inp).val();
  	var params = $("#step2form").serialize();
	$.ajax({
		type: "post",
		url: 'studyDelete.action?sid='+sid,
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

