var divs = getClassNames('tabs_div' , 'div'); 
function getClassNames(classStr,tagName){ 
if (document.getElementsByClassName) { 
return document.getElementsByClassName(classStr) 
}else { 
var nodes = document.getElementsByTagName(tagName),ret = []; 
for(i = 0; i < nodes.length; i++) { 
if(hasClass(nodes[i],classStr)){ 
ret.push(nodes[i]) 
} 
} 
return ret; 
} 
} 
function hasClass(tagStr,classStr){ 
var arr=tagStr.className.split(/\s+/ ); //这个正则表达式是因为class可以有多个,判断是否包含 
for (var i=0;i<arr.length;i++){ 
if (arr[i]==classStr){ 
return true ; 
} 
} 
return false ; 
} 


var tab = function(element){
	var aLi=document.getElementById('leftcontent').getElementsByTagName('li');
	var aTab=getClassNames('tab','div');
	var i;
	for(i=0;i<aTab.length;i++)
	{
		if(element==aLi[i])
		{
			aTab[i].className='selected tab';
		}
		else{aTab[i].className='tab';}
	}
}
var tab2 = function(element){
	var select = document.getElementById('select');
	var aLi=document.getElementById('leftcontent').getElementsByTagName('li');
	var aTab=getClassNames('tab','div');
	var i;
	var position;
	for(i=0;i<aTab.length;i++){
		if(aTab[i].className=='selected tab'){
			aTab[i].className='tab';
			aTab[i+1].className='selected tab';
			break;
		}
	}
}
var tab3 = function(element){
	var select = document.getElementById('select');
	var aLi=document.getElementById('leftcontent').getElementsByTagName('li');
	var aTab=getClassNames('tab','div');
	var i;
	var position;
	for(i=0;i<aTab.length;i++){
		if(aTab[i].className=='selected tab'){
			aTab[i].className='tab';
			aTab[i-1].className='selected tab';
			break;
		}
	}
}
