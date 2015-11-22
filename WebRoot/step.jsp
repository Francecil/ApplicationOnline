<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!doctype html>
<html lang="en">
 <head>
  <meta charset="UTF-8">
  <meta name="Generator" content="EditPlus®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="renderer" content="webkit">
  <title>Document</title>

  <link href="<%=basePath%>css/application.css" media="all" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="./js/jquery-1.11.1.min.js"></script>
  <script src="<%=basePath%>js/move.js" type="text/javascript"></script>
  <script src="<%=basePath%>js/tab.js" type="text/javascript"></script>
  <script src="<%=basePath%>laydate/laydate.js" type="text/javascript"></script>
  <script src="<%=basePath%>js/jquery.leanModal.min.js" type="text/javascript"></script>
  <script src="<%=basePath%>js/step-save.js" type="text/javascript"></script>
  <script src="<%=basePath%>js/app_study_curd.js" type="text/javascript"></script>
  <script src="<%=basePath%>js/app_work_curd.js" type="text/javascript"></script>
 </head>
	<body>
		<div class="header">
			<h1>Online Application System</h1>
			<div class="rightTop">
			<div>welcome,<span id="user"><s:property value="#session.User.uname"/></span></div>
			<div style="line-height:50px;"><a href="<%=basePath%>userlist.action"><<-back</a></div>
			</div>
		</div>
		<div class="content">
			<div class="leftcontent" id="leftcontent">
				<ul>
					<div id="select" style="position:absolute; right:0px; top:0px;"></div>
					<li onClick="move('select', {top:0});tab(this)">Basic information</li>
					<li onClick="move('select', {top:100});tab(this)">Education situation</li>
					<li onClick="move('select', {top:200});tab(this)">Career situation</li>
					<li onClick="move('select', {top:300});tab(this)">Self-introduction</li>
				</ul>
			</div>
			<div class="rightcontent" id="rightcontent">
				<div class="selected tab">
					<span class="title">
						<h1>STEP1</h1>
					</span>
					<form id="step1form">
						<div class="formcontent">
							<div class="form-item">
								<span>USERNAME:</span><input class="forminput" name="basic.basicInfoApplication.name" type="text" value="<s:property value="baseApplication.basicInfoApplication.name"/>" />
							</div>
							<div class="form-item">
								<span>SEX:</span>
								<s:set name="sex" value="baseApplication.basicInfoApplication.sex"></s:set>
								<s:if test='#sex=="male"'>
								<input class="sex" type="radio" name="basic.basicInfoApplication.sex" value="male" checked/><span class="sex_cont" >Male</span>
								<input class="sex" type="radio" name="basic.basicInfoApplication.sex" value="female" /><span class="sex_cont" >Female</span>
								</s:if >
								<s:elseif test='#sex=="female"'>
								<input class="sex" type="radio" name="basic.basicInfoApplication.sex" value="male" /><span class="sex_cont" >Male</span>
								<input class="sex" type="radio" name="basic.basicInfoApplication.sex" value="female" checked/><span class="sex_cont" >Female</span>
								</s:elseif>
								<s:else>
								<input class="sex" type="radio" name="basic.basicInfoApplication.sex" value="male" /><span class="sex_cont" >Male</span>
								<input class="sex" type="radio" name="basic.basicInfoApplication.sex" value="female"/><span class="sex_cont" >Female</span>
								</s:else>
							</div>
							<div class="form-item">
								<span>EMAIL:</span><input class="forminput" value="<s:property value="baseApplication.basicInfoApplication.email"/>" name="basic.basicInfoApplication.email" type="text" />
							</div>
							<div class="form-item">
							<span>TYPE:</span>
							<s:set name="atype" value="baseApplication.basicInfoApplication.applicationType"></s:set>
							<select  name="basic.basicInfoApplication.applicationType" class="forminput" style="height:30px;width:322px;">
								<!-- ing  selected = "selected" -->
								<s:if test='#atype=="TYPE2"'>
								<option value="TYPE1">TYPE1</option>
								<option value="TYPE2" selected = "selected">TYPE2</option>
								<option value="TYPE3">TYPE3</option>
								</s:if >
								<s:elseif test='#atype=="TYPE3"'>
								<option value="TYPE1">TYPE1</option>
								<option value="TYPE2" >TYPE2</option>
								<option value="TYPE3" selected = "selected">TYPE3</option>
								</s:elseif >
								<s:else>
								<option value="TYPE1" selected = "selected">TYPE1</option>
								<option value="TYPE2" >TYPE2</option>
								<option value="TYPE3">TYPE3</option>
								</s:else >
							</select>
							</div>
							<div class="form-item textarea">
								<span>ADDRESS:</span><textarea  name="basic.basicInfoApplication.address" rows="6" cols="60" ><s:property value="baseApplication.basicInfoApplication.address"/></textarea>
							</div>
						</div>
						<input name="basic.haveApplied" type="hidden" value="<s:property value="baseApplication.applyId"/>"/>
						<input name="basic.step" type="hidden" value="1"/>
						<div class="formbutton">
							<input type="button" class="btn back" value="back" disabled="disabled"/>
							<input type="button" class="btn next" value="next" onclick="move('select', {top:100});tab2(this)"/>
							<input id="step1" type="button" class="btn save" value="save"/>
						</div>
					</form>
				</div>
				<div class="tab">
					<span class="title">
						<h1>STEP2</h1>
					</span>
					<form id="step2form">
						<div class="formcontent" style="width:90%;">
							<div class="">
								<a rel="leanModal" href="#new" style="float:right;line-height:30px;" onclick="">NEW</a>
								<div class="education-title" style="clear:both;height:40px;line-height:40px;margin-top:30px;">
										<div class="Admission-date" style="border-right:1px solid #fff;">Admission date</div>
										<div class="End-academic" style="border-right:1px solid #fff;">End date of academic</div>
										<div class="Graduation-school" style="border-right:1px solid #fff;">The graduation school</div>
										<div class="Education-level" style="border-right:1px solid #fff;">Education level</div>
										<div class="Operation">Operation</div>
										
								</div>
								<div class="table">
									<ul class="education" id="education" style="font-size:12px;">
									<s:iterator value="baseApplication.studyInfoApplication.details" var="sdetail">
										<li id="sd<s:property value="#sdetail.sdetailID"/>">
											<div class="Admission-date ed_item"><s:property value="#sdetail.startTime"/></div>
											<div class="End-academic  ed_item"><s:property value="#sdetail.endTime"/></div>
											<div class="Graduation-school ed_item"><s:property value="#sdetail.school"/></div>
											<div class="Education-level ed_item"><s:property value="#sdetail.level"/></div>
											<div class="Operation">
												<a class='edit_2 operation'   rel='leanModal' href='#edit'>edit</a>
												<a class='delete_2 operation'>delete</a>
											</div>
											<input name='detailID' type='hidden' value='<s:property value="#sdetail.sdetailID"/>'/>
										</li>
									</s:iterator>
									</ul>
								</div>
							</div>
						</div><div class="clear"></div>
						<div class="clear"></div>
						<div class="formbutton">
							<input type="button" class="btn back" value="back" onclick="move('select', {top:0});tab3(this)"/>
							<input type="button" class="btn" value="next" onclick="move('select', {top:200});tab2(this)"/>
							<input id="step2" type="button" class="btn save" value="save"/>
						</div>
						<input name="study.step" type="hidden" value="2"/>
						<input name="study.haveApplied" type="hidden" value="<s:property value="baseApplication.applyId"/>"/>
					</form>
				</div>
				<div class="tab">
					<span class="title">
						<h1>STEP3</h1>
					</span>
					<form id="step3form">
						<div class="formcontent_work" style="width:90%;">
							<div class="">
								<a rel="leanModal_work" href="#new_work" style="float:right;line-height:30px;" onclick="">NEW</a>
								<div class="workinfo-title" style="clear:both;height:40px;line-height:40px;margin-top:30px;">
										<div class="Admission-date" style="border-right:1px solid #fff;">Admission date</div>
										<div class="End-academic" style="border-right:1px solid #fff;">End date of academic</div>
										<div class="WorkInfo-company" style="border-right:1px solid #fff;">Company</div>
										<div class="WorkInfo-job" style="border-right:1px solid #fff;">Job</div>
										<div class="Operation">Operation</div>
										
								</div>
								<div class="table">
									<ul class="workinfo" id="workinfo" style="font-size:12px;">
									<s:iterator value="baseApplication.workInfoApplication.details" var="wdetail">
										<li id="sd<s:property value="#wdetail.wdetailID"/>">
											<div class="Admission-date ed_item_work"><s:property value="#wdetail.startTime"/></div>
											<div class="End-academic  ed_item_work"><s:property value="#wdetail.endTime"/></div>
											<div class="WorkInfo-company ed_item_work"><s:property value="#wdetail.company"/></div>
											<div class="WorkInfo-job ed_item_work"><s:property value="#wdetail.job"/></div>
											<div class="Operation">
												<a class='edit_2_work operation'   rel='leanModal_work' href='#edit_work'>edit</a>
												<a class='delete_2_work operation'>delete</a>
											</div>
											<input name='detailID_work' type='hidden' value='<s:property value="#wdetail.wdetailID"/>'/>
										</li>
									</s:iterator>
									</ul>
								</div>
							</div>
						</div><div class="clear"></div>
						<div class="clear"></div>
						<div class="formbutton">
							<input type="button" class="btn back" value="back" onclick="move('select', {top:0});tab3(this)"/>
							<input type="button" class="btn" value="next" onclick="move('select', {top:200});tab2(this)"/>
							<input id="step3" type="button" class="btn save" value="save"/>
						</div>
						<input name="work.step" type="hidden" value="3"/>
						<input name="work.haveApplied" type="hidden" value="<s:property value="baseApplication.applyId"/>"/>
					</form>
				</div>
				<div class="tab">
					<span class="title">
						<h1>STEP4</h1>
					</span>
					<form id="step4form">
						<div class="formcontent">
							<div class="form-item textarea">
								<span>Self-introduction:</span><textarea id="individual.individualResumeApplication.individualResume" name="individual.individualResumeApplication.individualResume" rows="6" cols="60" ><s:property value="baseApplication.individualResumeApplication.individualResume"/></textarea>
							</div>
						</div>
						<div class="formbutton">
							<input type="button" class="btn back" value="back" onclick="move('select', {top:200});tab3(this)"/>
							<input id="finish" type="button" class="btn" value="finish"/>
							<input id="step4" type="button" class="btn save" value="save" />
						</div>
						<input name="individual.step" type="hidden" value="4"/>
						<input name="individual.haveApplied" type="hidden" value="<s:property value="baseApplication.applyId"/>"/>
					</form>
				</div>
			</div>
		</div>
	<div id="edit" class="leanmodal" style="display:none; position: fixed; opacity: 1; z-index: 11000; left: 50%; margin-left: -330px; top: 200px;">
		<input id="li-id" style="display:none;" value=""/>
		<div class="lean_header">
			<span class="title" style="float:left;color:#3190eb">EDIT</span><span class="modal_close">CLOSE</span>
		</div>
		<div class="lean_content">
			<form>
				<ul class="lean_form">
					<li><span class="lean_name">Admission date:</span><input class="laydate-icon lean_" id="edit_ad"/></li>
					<li><span class="lean_name">End date of academic:</span><input class="laydate-icon lean_" id="edit_edoa"/></li>
					<li><span class="lean_name">The graduation school:</span><input class="lean_" id="edit_tgs"/></li>
					<li>
						<span class="lean_name">Education level:</span>
						
						<select id="edit_el_form" class="lean_" style="padding:0;width:322px;">
							<option value="Primary education">Primary education</option>
							<option value="Secondary academic education">Secondary academic education</option>
							<option value="High school degree">High school degree</option>
							<option value="Bachelor degree or above">Bachelor degree or above</option>
						</select>
					</li>
					<input id="editDetailID" type="hidden" value=""/>
				</ul>
				<input id="studyEdit" type="button" class="btn modal_close" value="save" />
			</form>
		</div>
	</div>
	<div id="new" class="leanmodal" style="display:none; position: fixed; opacity: 1; z-index: 11000; left: 50%; margin-left: -330px; top: 200px;">
		<div class="lean_header">
			<span class="title" style="float:left;color:#3190eb">NEW</span><span class="modal_close">CLOSE</span>
		</div>
		<div class="lean_content">
			<form>
				<ul class="lean_form">
					<li><span class="lean_name">Admission date:</span><input class="laydate-icon lean_" id="lean_ad"/></li>
					<li><span class="lean_name">End date of academic:</span><input class="laydate-icon lean_" id="lean_edoa"/></li>
					<li><span class="lean_name">The graduation school:</span><input class="lean_" id="lean_tgs"/></li>
					<li>
						<span class="lean_name">Education level:</span>
						
						<select id="lean_el" class="lean_" style="padding:0;width:322px;">
							<option value="Primary education" >Primary education</option>
							<option value="Secondary academic education">Secondary academic education</option>
							<option value="High school degree">High school degree</option>
							<option value="Bachelor degree or above">Bachelor degree or above</option>
						</select>
					</li>
				</ul>
				<input id="studyAdd" type="button" class="btn modal_close" value="save"  />
			</form>
		</div>
	</div>
	<div id="lean_overlay"></div>
	<script>
		$(document).ready(function () { 
		$('a[rel*=leanModal]').leanModal({top: 100, closeButton: ".modal_close"}); 
		});
	</script>
	<script>
		laydate({
			elem: '#lean_ad',//目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
			event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
		laydate({
			elem: '#lean_edoa',//目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
			event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
		laydate({
			elem: '#edit_ad',//目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
			event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
		laydate({
			elem: '#edit_edoa',//目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
			event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
	</script>
	<div id="edit_work" class="leanmodal_work" style="display:none; position: fixed; opacity: 1; z-index: 11000; left: 50%; margin-left: -330px; top: 200px;">
		<input id="li-id_work" style="display:none;" value=""/>
		<div class="lean_header">
			<span class="title_work" style="float:left;color:#3190eb">EDIT</span><span class="modal_close_work">CLOSE</span>
		</div>
		<div class="lean_content_work">
			<form>
				<ul class="lean_form_work">
					<li><span class="lean_name_work">Admission date:</span><input class="laydate-icon lean_work" id="edit_ad_work"/></li>
					<li><span class="lean_name_work">End date of academic:</span><input class="laydate-icon lean_work" id="edit_edoa_work"/></li>
					<li><span class="lean_name_work">Company:</span><input class="lean_work" id="edit_tgs_work"/></li>
					<li><span class="lean_name_work">Job:</span><input class="lean_work" id="edit_tgs_work"/></li>
					<input id="editDetailID_work" type="hidden" value=""/>
				</ul>
				<input id="workEdit" type="button" class="btn modal_close_work" value="save" />
			</form>
		</div>
	</div>
	<div id="new_work" class="leanmodal_work" style="display:none; position: fixed; opacity: 1; z-index: 11000; left: 50%; margin-left: -330px; top: 200px;">
		<div class="lean_header_work">
			<span class="title_work" style="float:left;color:#3190eb">NEW</span><span class="modal_close_work">CLOSE</span>
		</div>
		<div class="lean_content_work">
			<form>
				<ul class="lean_form_work">
					<li><span class="lean_name_work">Admission date:</span><input class="laydate-icon lean_work" id="lean_ad_work"/></li>
					<li><span class="lean_name_work">End date of academic:</span><input class="laydate-icon lean_work" id="lean_edoa_work"/></li>
					<li><span class="lean_name_work">Company:</span><input class="lean_work" id="lean_tgs_work"/></li>
					<li><span class="lean_name_work">Job:</span><input class="lean_work" id="lean_el_work"/></li>
				</ul>
				<input id="workAdd" type="button" class="btn modal_close_work" value="save"  />
			</form>
		</div>
	</div>
	<div id="lean_overlay_work"></div>
	<script>
		$(document).ready(function () { 
		$('a[rel*=leanModal_work]').leanModal({top: 100, closeButton: ".modal_close_work"}); 
		});
	</script>
	<script>
		laydate({
			elem: '#lean_ad_work',//目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
			event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
		laydate({
			elem: '#lean_edoa_work',//目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
			event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
		laydate({
			elem: '#edit_ad_work',//目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
			event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
		laydate({
			elem: '#edit_edoa_work',//目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
			event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
	</script>
 </body>
</html>
