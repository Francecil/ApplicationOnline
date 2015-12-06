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
  <script type="text/javascript" src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
  <script src="<%=basePath%>js/move.js" type="text/javascript"></script>
  <script src="<%=basePath%>js/tab.js" type="text/javascript"></script>
  <script src="<%=basePath%>laydate/laydate.js" type="text/javascript"></script>
  <script src="<%=basePath%>js/jquery.leanModal.min.js" type="text/javascript"></script>
  <script type="text/javascript" src="<%=basePath%>js/ajaxfileUpload.js" ></script>
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
					<form id="step1form" enctype="multipart/form-data">
						<div class="formcontent">
							<div class="form-item">
								<span>Name:</span><input class="forminput" name="basic.basicInfoApplication.name" type="text" value="<s:property value="baseApplication.basicInfoApplication.name"/>" />
							</div>
							<div class="form-item">
								<span>Sex:</span>
								<input class="sex" type="radio" id="sexmale" name="basic.basicInfoApplication.sex" value="male" checked/><span class="sex_cont" >Male</span>
								<input class="sex" type="radio" id="sexfemale" name="basic.basicInfoApplication.sex" value="female" /><span class="sex_cont" >Female</span>
								<script type="text/javascript">
								 $(document).ready(function(){
									var sex="<s:property value="baseApplication.basicInfoApplication.sex"/>";
									if(sex=="female"){
										$("#sexfemale").attr("checked",'true');
									}
								 });
								</script>
							</div>
							<div class="form-item">
								<span>Email:</span><input class="forminput" value="<s:property value="baseApplication.basicInfoApplication.email"/>" name="basic.basicInfoApplication.email" type="text" />
							</div>
							<div class="form-item">
								<span>Nationality:</span><input class="forminput" value="<s:property value="baseApplication.basicInfoApplication.nationality"/>" name="basic.basicInfoApplication.nationality" type="text" />
							</div>
							<div class="form-item">
								<span>Place of birth:</span><input class="forminput" value="<s:property value="baseApplication.basicInfoApplication.birthPlace"/>" name="basic.basicInfoApplication.birthPlace" type="text" />
							</div>
							<div class="form-item">
								<span>Date of birth:</span><input class="forminput laydate-icon" id="birthDay" value="<s:property value="baseApplication.basicInfoApplication.birthDay"/>" name="basic.basicInfoApplication.birthDay" type="text" />
							</div>
							<div class="form-item">
								<span>Marital Status:</span>
								<input class="sex" id="maritalStatusUnmarried" type="radio" name="basic.basicInfoApplication.maritalStatus" value="Unmarried" checked/><span class="sex_cont" >Unmarried</span>
								<input class="sex" id="maritalStatusMarried" type="radio" name="basic.basicInfoApplication.maritalStatus" value="Married" /><span class="sex_cont" >Married</span>
								<script type="text/javascript">
								 $(document).ready(function(){
									var marital="<s:property value="baseApplication.basicInfoApplication.maritalStatus"/>";
									if(marital=="Married"){
										$("#maritalStatusMarried").attr("checked",'true');
									}
								 });
								</script>
							</div>
							<div class="form-item">
								<span>Passport No.:</span><input class="forminput" value="<s:property value="baseApplication.basicInfoApplication.passportNo"/>" name="basic.basicInfoApplication.passportNo" type="text" />
							</div>
							<div class="form-item">
								<span>Occupation:</span><input class="forminput" value="<s:property value="baseApplication.basicInfoApplication.occupation"/>" name="basic.basicInfoApplication.occupation" type="text" />
							</div>
							<div class="form-item">
								<span>Tel:</span><input class="forminput" value="<s:property value="baseApplication.basicInfoApplication.tel"/>" name="basic.basicInfoApplication.tel" type="text" />
							</div>
							<div class="form-item">
								<span>Religion:</span><input class="forminput" value="<s:property value="baseApplication.basicInfoApplication.religion"/>" name="basic.basicInfoApplication.religion" type="text" />
							</div>
							<div class="form-item">
							<span >Scholarship Applied:</span>
							<input class="applicationType" id="fullApplicationType" type="radio" name="basic.basicInfoApplication.applicationType" value="FULL Scholarship" checked/><span class="ship_cont" >Full Scholarship</span>
							<input class="applicationType" id="partialApplicationType" type="radio" name="basic.basicInfoApplication.applicationType" value="Partial Scholarship" /><span class="ship_cont" >Partial Scholarship</span>
							</div>
							<div class="form-item checkbox-item" style="display: none">
							<input class="checkboxType" name="basic.scholarshipType" id="checkboxScholarshipType1" type="checkbox" value="Tuition" /><span class="checkbox_cont" style="text-align:left;">Tuition</span>
							<input class="checkboxType" name="basic.scholarshipType" id="checkboxScholarshipType2" type="checkbox" value="Accommodation" /><span class="checkbox_cont" style="text-align:left;">Accommodation</span>
							<input class="checkboxType" name="basic.scholarshipType" id="checkboxScholarshipType3" type="checkbox" value="Medical Care" /><span class="checkbox_cont" style="text-align:left;">Medical Care</span>
							<input class="checkboxType" name="basic.scholarshipType" id="checkboxScholarshipType4" type="checkbox" value="Learning Materials" /><span class="checkbox_cont" style="text-align:left;">Learning Materials</span>
							</div>
							<script type="text/javascript">
								 $(document).ready(function(){
									var applicationType="<s:property value="baseApplication.basicInfoApplication.applicationType"/>";
									if(applicationType!="FULL Scholarship"){
										$("#partialApplicationType").attr("checked",'true');
										$(".checkbox-item").css("display","block");
										var strs= new Array(); //定义一数组 
										strs=applicationType.split("#"); //字符分割 
										for (var i=0;i<strs.length ;i++ ) 
										{ 
											if($("#checkboxScholarshipType1").val()==strs[i])
											$("#checkboxScholarshipType1").attr("checked",'true');
											if($("#checkboxScholarshipType2").val()==strs[i])
											$("#checkboxScholarshipType2").attr("checked",'true');
											if($("#checkboxScholarshipType3").val()==strs[i])
											$("#checkboxScholarshipType3").attr("checked",'true');
											if($("#checkboxScholarshipType4").val()==strs[i])
											$("#checkboxScholarshipType4").attr("checked",'true');
										}
									}
								 });
								 $(document).ready(function(){
									  $("#fullApplicationType").click(function(){
										  $(".checkbox-item").css("display","none");
									  });
									  $("#partialApplicationType").click(function(){
										  $(".checkbox-item").css("display","block");
									  });
								  });
								</script>
							<div class="form-item">
								<span>Permanent Address:</span><input class="forminput" value="<s:property value="baseApplication.basicInfoApplication.permanentAddress"/>" name="basic.basicInfoApplication.permanentAddress" type="text" />
							</div>
							<div class="form-item">
								<span>Mailing Address:</span><input class="forminput" value="<s:property value="baseApplication.basicInfoApplication.mailingAddress"/>" name="basic.basicInfoApplication.mailingAddress" type="text" />
							</div>
							<div class="form-item">
								<span>Chinese Proficiency:</span>
								<select id="languageChineseLevel" name="basic.basicInfoApplication.languageChineseLevel" class="studyCheckbox" >
								<option value="Excellent">Excellent</option>
								<option value="Good">Good</option>
								<option value="Fair">Fair</option>
								<option value="Poor">Poor</option>
								<option value="None">None</option>
								</select>
								<script type="text/javascript">
								 $(document).ready(function(){
									var languageChineseLevel="<s:property value="baseApplication.basicInfoApplication.languageChineseLevel"/>";
									$("#languageChineseLevel").val(languageChineseLevel);
								 });
								</script>
							</div>
							<div class="form-item">
								<span>Level of HSK test:</span>
								<input class="forminput" value="<s:property value="baseApplication.basicInfoApplication.languageChineseShow"/>" placeholder="Level of HSK test or other certificates which can show your Chinese level"  name="basic.basicInfoApplication.languageChineseShow" type="text" />
							</div>
							<div class="form-item">
								<span>English Proficiency:</span>
								<select id="languageEnglishLevel" name="basic.basicInfoApplication.languageEnglishLevel" class="studyCheckbox" >
								<option value="Excellent">Excellent</option>
								<option value="Good">Good</option>
								<option value="Fair">Fair</option>
								<option value="Poor">Poor</option>
								<option value="None">None</option>
								</select>
								<script type="text/javascript">
								 $(document).ready(function(){
									var languageEnglishLevel="<s:property value="baseApplication.basicInfoApplication.languageEnglishLevel"/>";
									$("#languageEnglishLevel").val(languageEnglishLevel);
								 });
								</script>
							</div>
							<div class="form-item">
								<span style="width:25%">Can be taught in English:</span>
								<input class="English-Taught" type="radio" name="basic.basicInfoApplication.languageEnglishIsTaught" value="Yes" checked/><span class="chinese_cont" style="text-align:left;width:8%;">Yes</span>
								<input class="English-Taught" type="radio" id="languageEnglishNoTaught" name="basic.basicInfoApplication.languageEnglishIsTaught" value="No"/><span class="chinese_cont" style="text-align:left;width:8%;">No</span>
								<script type="text/javascript">
								 $(document).ready(function(){
									var languageEndlishIsTaught="<s:property value="baseApplication.basicInfoApplication.languageEndlishIsTaught"/>";
									if(languageEndlishIsTaught=="No"){
										$("#languageEnglishNoTaught").attr("checked",'true');
									}
								 });
								</script>
							</div>
							<div class="form-item">
								<span>Other Languages:</span>
								<input class="forminput" value="<s:property value="baseApplication.basicInfoApplication.languageOther"/>" name="basic.basicInfoApplication.languageOther" type="text" />
							</div>
							<div class="form-item">
								<span >Proposed Study:</span>
								<select id="studyProposedType" class="studyCheckbox" name="basic.basicInfoApplication.studyProposedType">
								<option value="Bachelor's Degree Candidate">Bachelor's Degree Candidate</option>
								<option value="Master's Degree Candidate">Master's Degree Candidate</option>
								<option value="Doctor's Degree Candidate">Doctor's Degree Candidate</option>
								<option value="Chinese Language Student">Chinese Language Student</option>
								<option value="General Language Student">General Language Student</option>
								<option value="Senior Language Student">Senior Language Student</option>
								</select>
								<script type="text/javascript">
								 $(document).ready(function(){
									var studyProposedType="<s:property value="baseApplication.basicInfoApplication.studyProposedType"/>";
									$("#studyProposedType").val(studyProposedType);
								 });
								</script>
							</div>
							<div class="form-item">
								<span >Subject or Field:</span>
								<input class="forminput" value="<s:property value="baseApplication.basicInfoApplication.studySubjectField"/>" name="basic.basicInfoApplication.studySubjectField" type="text" />
							</div>
							<div class="form-item">
								<span >Preference:</span>
								<input class="forminput"  value="<s:property value="baseApplication.basicInfoApplication.studyPreferenceInstitutionsOne"/>"placeholder="Preference of Institutions of Higher Edycation in China" name="basic.basicInfoApplication.studyPreferenceInstitutionsOne" type="text" />
							</div>
							<div class="form-item">
								<span>Preference:</span>
								<input class="forminput" value="<s:property value="baseApplication.basicInfoApplication.studyPreferenceInstitutionsTwo"/>"placeholder="Preference of Institutions of Higher Edycation in China" name="basic.basicInfoApplication.studyPreferenceInstitutionsTwo" type="text" />
							</div>
							<div class="form-item">
								<span>Preference:</span>
								<input class="forminput" value="<s:property value="baseApplication.basicInfoApplication.studyPreferenceInstitutionsThree"/>" placeholder="Preference of Institutions of Higher Edycation in China" name="basic.basicInfoApplication.studyPreferenceInstitutionsThree" type="text" />
							</div>
							<div class="form-item">
								<span>Duration From:</span><input class="forminput laydate-icon" id="studyDurationFrom" value="<s:property value="baseApplication.basicInfoApplication.studyDurationFrom"/>" name="basic.basicInfoApplication.studyDurationFrom" type="text" />
							</div>
							<div class="form-item">
								<span>Duration To:</span><input class="forminput laydate-icon" id="studyDurationTo" value="<s:property value="baseApplication.basicInfoApplication.studyDurationTo"/>" name="basic.basicInfoApplication.studyDurationTo" type="text" />
							</div>
							<div class="form-item" style="height:70px;">
								<span style="width: 20%;height: 1px;float: left;"></span>
								<div id="file" class="file-item" style="width:55%;float:left;margin-left:10px">
									<div id="btn_position" class="btn_position">
										<input type='button' class='btn btn1' value='browse...' />
									</div>
									<input type='text' name='textfield' placeholder="Please Upload Health Report File(pdf,doc,zip,rar <10M)" disabled="disabled" id='textfield' class='txt' />
									<input type="file" name="uploads1" class="file" id="s1f1" size="28" onchange="document.getElementById('textfield').value=this.value ;" />
								</div>
							</div>
							<br/>
							<div class="form-item" style="height:70px;">
								<span style="width: 20%;height: 1px;float: left;"></span>
								<div id="file" class="file-item" style="width:55%;float:left;margin-left:10px">
									<div id="btn_position" class="btn_position">
										<input type='button' class='btn btn1' value='browse...' />
									</div>
									<input type='text' name='textfield2' placeholder="Please Upload Personal Photo(size:626px*413px <10M) " disabled="disabled" id='textfield2' class='txt' />
									<input type="file" name="uploads1" class="file" id="s1f2" size="28" onchange="document.getElementById('textfield2').value=this.value ;" />
								</div>
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
										<div class="Admission-date" style="border-right:1px solid #fff;">Years Attended From</div>
										<div class="End-academic" style="border-right:1px solid #fff;">Years Attended To</div>
										<div class="Graduation-school" style="border-right:1px solid #fff;">Institutions</div>
										<div class="Education-level" style="border-right:1px solid #fff;">Certificates Obtained or To Obtain</div>
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
										<div class="Admission-date" style="border-right:1px solid #fff;">Time From</div>
										<div class="End-academic" style="border-right:1px solid #fff;">Time To</div>
										<div class="WorkInfo-company" style="border-right:1px solid #fff;">Employer</div>
										<div class="WorkInfo-job" style="border-right:1px solid #fff;">Posts Held</div>
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
							<div class="form-item" style="height:70px;">
								<span style="width: 20%;height: 1px;float: left;"></span>
								<div id="file" class="file-item" style="width:55%;float:left;margin-left:10px">
									<div id="btn_position" class="btn_position">
										<input type='button' class='btn btn1' value='browse...' />
									</div>
									<input type='text' name='textfield_1' placeholder="Please Upload Study Plan (doc,zip,rar <10M) " disabled="disabled" id='textfield_1' class='txt' />
									<input type="file" name="uploads4" class="file" id="s4f1" size="28" onchange="document.getElementById('textfield_1').value=this.value ;" />
								</div>
							</div>
							<br/>
							<div class="form-item" style="height:70px;">
								<span style="width: 20%;height: 1px;float: left;"></span>
								<div id="file" class="file-item" style="width:55%;float:left;margin-left:10px">
									<div id="btn_position" class="btn_position">
										<input type='button' class='btn btn1' value='browse...' />
									</div>
									<input type='text' name='textfield_2' placeholder="Application Form for Scholarship (doc,zip,rar <10M) " disabled="disabled" id='textfield_2' class='txt' />
									<input type="file" name="uploads4" class="file" id="s4f2" size="28" onchange="document.getElementById('textfield_2').value=this.value ;" />
								</div>
							</div>
							<br/>
							<div class="form-item" style="height:70px;">
								<span style="width: 20%;height: 1px;float: left;"></span>
								<div id="file" class="file-item" style="width:55%;float:left;margin-left:10px">
									<div id="btn_position" class="btn_position">
										<input type='button' class='btn btn1' value='browse...' />
									</div>
									<input type='text' name='textfield_3' placeholder="Application Form for Chinese Government (doc,zip,rar <10M) " disabled="disabled" id='textfield_3' class='txt' />
									<input type="file" name="uploads4" class="file" id="s4f3" size="28" onchange="document.getElementById('textfield_3').value=this.value ;" />
								</div>
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
					<li><span class="lean_name">Years Attended From:</span><input class="laydate-icon lean_" id="edit_ad"/></li>
					<li><span class="lean_name">Years Attended To:</span><input class="laydate-icon lean_" id="edit_edoa"/></li>
					<li><span class="lean_name">Institutions:</span><input class="lean_" id="edit_tgs"/></li>
					<li>
						<span class="lean_name">Certificates Obtained or To Obtain:</span>
						
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
					<li><span class="lean_name">Years Attended From:</span><input class="laydate-icon lean_" id="lean_ad"/></li>
					<li><span class="lean_name">Years Attended To:</span><input class="laydate-icon lean_" id="lean_edoa"/></li>
					<li><span class="lean_name">Institutions:</span><input class="lean_" id="lean_tgs"/></li>
					<li>
						<span class="lean_name">Certificates Obtained or To Obtain:</span>
						
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
					<li><span class="lean_name_work">Time From:</span><input class="laydate-icon lean_work" id="edit_ad_work"/></li>
					<li><span class="lean_name_work">Time To:</span><input class="laydate-icon lean_work" id="edit_edoa_work"/></li>
					<li><span class="lean_name_work">Employer:</span><input class="lean_work" id="edit_tgs_work"/></li>
					<li><span class="lean_name_work">Posts Held:</span><input class="lean_work" id="edit_tgs_work"/></li>
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
					<li><span class="lean_name_work">Time From:</span><input class="laydate-icon lean_work" id="lean_ad_work"/></li>
					<li><span class="lean_name_work">Time To:</span><input class="laydate-icon lean_work" id="lean_edoa_work"/></li>
					<li><span class="lean_name_work">Employer:</span><input class="lean_work" id="lean_tgs_work"/></li>
					<li><span class="lean_name_work">Posts Held:</span><input class="lean_work" id="lean_el_work"/></li>
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
		laydate({
			elem: '#birthDay',//目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
			event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
		laydate({
			elem: '#studyDurationFrom',//目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
			event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
		laydate({
			elem: '#studyDurationTo',//目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
			event: 'focus' //响应事件。如果没有传入event，则按照默认的click
		});
	</script>
	<script type="text/javascript">
		$("#leftcontent").height($("#rightcontent").css("height"));
	</script>
 </body>
</html>
