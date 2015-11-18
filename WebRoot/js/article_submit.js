$(document).ready(function(){
	$("#formbtn").click(function(){
		var title=$('#title').val();
		if(title==null||title.trim()==""){alert("please fill title");return;}
		var content=$('#content').val();
		if(content==null||content.trim()==""){alert("please fill content");return;}
		var uploader = $('#uploader').pluploadQueue();
        if (uploader.files.length > 0) {
            // When all files are uploaded submit form
            uploader.bind('StateChanged', function() {
                if (uploader.files.length === (uploader.total.uploaded + uploader.total.failed)) {
//                    $('form')[0].submit();
                }
                else return;//add
            });
            uploader.start();
        } else {
        	if(!confirm('检测到您未上传图片,是否继续提交?'))return;
//        	else  $('form')[0].submit();
		}
        var params = $('#formId').serialize();
		$.ajax({
			type: "post",
			url: "admin-submit.action",
			async: false,
			data: params,
			success: function(data) {
				//把数据放添加到list中
//				alert("添加成功");
				alert("添加成功");
				window.location='showlist.action' ;
			},
			error:function(data){
				alert("保存失败");
			}
		});
	});
});

