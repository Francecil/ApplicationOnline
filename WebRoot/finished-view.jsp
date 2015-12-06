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
  <meta name="Generator" content="EditPlusÂ®">
  <meta name="Author" content="">
  <meta name="Keywords" content="">
  <meta name="Description" content="">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="renderer" content="webkit">
  <title>Document</title>
  <link href="<%=basePath%>css/application.css" media="all" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="<%=basePath%>scripts/jquery-1.8.0.min.js"></script>
  <script src="<%=basePath%>js/move.js" type="text/javascript"></script>
  <script src="<%=basePath%>js/tab.js" type="text/javascript"></script>
 </head>
	<body>
		<div class="header">
			<h1>Admission application system</h1>
			<div class="rightTop">
			<div>welcome,<span id="user"><s:property value="#session.User.uname"/></span></div>
			<div style="line-height:50px;"><a href="list.html"><<-back</a></div>
			</div>
		</div>
		<div class="content">
			<div class="rightcontent" style="margin:0 auto;float:none;">
				<div class="selected tab">
					<span class="title">
						<h1>STEP1</h1>
					</span>
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
							<form action="download.action" enctype="multipart/form-data" method="post">
							<div class="form-item" style="height:70px;">
								<span style="width: 20%;height: 1px;float: left;"></span>
								<div id="file" class="file-item" style="width:55%;float:left;margin-left:10px">
									<div id="btn_position" class="btn_position">
										<input type='submit' class='btn btn1' value='download...' />
									</div>
									<input type='text' name='textfield' placeholder="Health Report" disabled="disabled" id='textfield' class='txt' />
								</div>
							</div>
							<input type="hidden" name="filename" value="<s:property value="baseApplication.basicInfoApplication.fileHealthReport"/>"/>
							</form>
							<br/>
							<form action="download.action" enctype="multipart/form-data" method="post">
							<div class="form-item" style="height:70px;">
								<span style="width: 20%;height: 1px;float: left;"></span>
								<div id="file" class="file-item" style="width:55%;float:left;margin-left:10px">
									<div id="btn_position" class="btn_position">
										<input type='submit' class='btn btn1' value='download...' />
									</div>
									<input type='text' name='textfield2' placeholder="Personal Photo" disabled="disabled" id='textfield2' class='txt' />
								</div>
								<input type="hidden" name="filename" value="<s:property value="baseApplication.basicInfoApplication.filePersonalPhoto"/>"/>
							</div>
							</form>
						</div>
				</div>
				<div class="selected tab">
					<span class="title">
						<h1>STEP2</h1>
					</span>
					<form>
						<div class="formcontent" style="width:90%;">
							<div class="">
								<div class="education-title" style="clear:both;height:40px;line-height:40px;margin-top:30px;">
										<div class="Admission-date" style="border-right:1px solid #fff;">Years Attended From</div>
										<div class="End-academic" style="border-right:1px solid #fff;">Years Attended To</div>
										<div class="Graduation-school" style="border-right:1px solid #fff;">Institutions</div>
										<div class="Education-level" >Certificates Obtained or To Obtain</div>
								</div>
								<div class="table">
									<ul class="education" id="education" style="font-size:12px;">
									<s:iterator value="baseApplication.studyInfoApplication.details" var="sdetail">
										<li>
											<div class="Admission-date ed_item"><s:property value="#sdetail.startTime"/></div>
											<div class="End-academic  ed_item"><s:property value="#sdetail.endTime"/></div>
											<div class="Graduation-school ed_item"><s:property value="#sdetail.school"/></div>
											<div class="Education-level "><s:property value="#sdetail.level"/></div>
										</li>
									</s:iterator>
									</ul>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="selected tab">
					<span class="title">
						<h1>STEP3</h1>
					</span>
					<form>
						<div class="formcontent" style="width:90%;">
							<div class="">
								<div class="education-title" style="clear:both;height:40px;line-height:40px;margin-top:30px;">
										<div class="Admission-date" style="border-right:1px solid #fff;">Time From</div>
										<div class="End-academic" style="border-right:1px solid #fff;">Time To</div>
										<div class="Graduation-school ed_item" style="border-right:1px solid #fff;">Employer</div>
										<div class="Education-level " >Posts Held</div>
								</div>
								<div class="table">
									<ul class="education" id="education" style="font-size:12px;">
									<s:iterator value="baseApplication.workInfoApplication.details" var="wdetail">
										<li>
											<div class="Admission-date ed_item"><s:property value="#wdetail.startTime"/></div>
											<div class="End-academic  ed_item"><s:property value="#wdetail.endTime"/></div>
											<div class="Graduation-school ed_item"><s:property value="#wdetail.company"/></div>
											<div class="Education-level  "><s:property value="#wdetail.job"/></div>
										</li>
									</s:iterator>
									</ul>
								</div>
							</div>
						</div>
					</form>
				</div>
				<div class="selected tab">
					<span class="title">
						<h1>STEP4</h1>
					</span>
						<div class="formcontent">
							<div class="form-item textarea">
								<span>Self-introduction:</span><textarea rows="6" cols="60" ><s:property value="baseApplication.individualResumeApplication.individualResume"/></textarea>
							</div>
						</div>
						<form action="download.action" enctype="multipart/form-data" method="post">
							<div class="form-item" style="height:70px;">
								<span style="width: 20%;height: 1px;float: left;"></span>
								<div id="file" class="file-item" style="width:55%;float:left;margin-left:10px">
									<div id="btn_position" class="btn_position">
										<input type='submit' class='btn btn1' value='download...' />
									</div>
									<input type='text' name='textfield_1' placeholder="Please Upload Study Plan (doc,zip,rar <10M) " disabled="disabled" id='textfield_1' class='txt' />
								</div>
							</div>
							<input type="hidden" name="filename" value="<s:property value="baseApplication.individualResumeApplication.fileStudyPlan"/>"/>
							</form>
							<br/>
							<form action="download.action" enctype="multipart/form-data" method="post">
							<div class="form-item" style="height:70px;">
								<span style="width: 20%;height: 1px;float: left;"></span>
								<div id="file" class="file-item" style="width:55%;float:left;margin-left:10px">
									<div id="btn_position" class="btn_position">
										<input type='submit' class='btn btn1' value='download...' />
									</div>
									<input type='text' name='textfield_2' placeholder="Application Form for Scholarship (doc,zip,rar <10M) " disabled="disabled" id='textfield_2' class='txt' />
								</div>
							</div>
							<input type="hidden" name="filename" value="<s:property value="baseApplication.individualResumeApplication.fileScholarshipApplication"/>"/>
							</form>
							<br/>
							<form action="download.action" enctype="multipart/form-data" method="post">
							<div class="form-item" style="height:70px;">
								<span style="width: 20%;height: 1px;float: left;"></span>
								<div id="file" class="file-item" style="width:55%;float:left;margin-left:10px">
									<div id="btn_position" class="btn_position">
										<input type='submit' class='btn btn1' value='download...' />
									</div>
									<input type='text' name='textfield_3' placeholder="Application Form for Chinese Government (doc,zip,rar <10M) " disabled="disabled" id='textfield_3' class='txt' />
								</div>
							</div>
							<input type="hidden" name="filename" value="<s:property value="baseApplication.individualResumeApplication.fileChineseGovernmentApplication"/>"/>
							</form>
				</div>
			</div>
		</div>
 </body>
</html>
