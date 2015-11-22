var getcontent=function(element){
	var aText = new Array();
	var oLi = element.parentNode.parentNode;
	var aDiv = oLi.getElementsByTagName('div');
	for (var i=0;i<(aDiv.length-1);i++)
	{
		//if(navigator.appName.indexOf("Explorer") > -1)         
			aText[i] = aDiv[i].innerText;
		//else
		//	aText[i] = aDiv[i].itextContent;
	}
	var oLean = document.getElementById('edit');
	var aInput = oLean.getElementsByTagName('input');
	var oSelect = document.getElementById('edit_el');
	for (var i=1;i<(aInput.length-1);i++)
	{
		aInput[i].value = aText[i-1];
	};
	for(var j=0;j<oSelect.length;j++){//给select赋值  
		if(aText[i-1]==oSelect.options[j].value){  
			oSelect.options[j].selected=true;
			oSelect.value=oSelect.options[j].value;
		} 
		else oSelect.options[j].selected=false;
	}  
	
	var index;
	var oUl = document.getElementById('education');
	var oLi2 = oUl.getElementsByTagName('li');
	for(var i=0;i<oLi2.length;i++)
	{
		if(oLi2[i]==oLi)
		{
			index=i;
		};
	};
	$("#li-id").attr("value",index);
}

var edit =function(){
	var aText2 = new Array();
	aText2[0]=$("#edit_ad").val();
	aText2[1]=$("#edit_edoa").val();
	aText2[2]=$("#edit_tgs").val();
	var oSelect = document.getElementById('edit_el');
	aText2[3]=oSelect.value;
	var oId=$("#li-id").val();
	var oUl = document.getElementById('education');
	var oLi2 = oUl.getElementsByTagName('li');
	var aDiv = oLi2[oId].getElementsByTagName('div');
	for(var i=0;i<aDiv.length-1;i++){
		aDiv[i].innerHTML=aText2[i];
	};
	$("#li-id").attr("value","");
}