<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
  <link href="./css/application.css" media="all" rel="stylesheet" type="text/css">
  <script type="text/javascript" src="./scripts/jquery-1.8.0.min.js"></script>
  <script src="./js/move.js" type="text/javascript"></script>
  <script src="./js/tab.js" type="text/javascript"></script>
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
					<form>
						<div class="formcontent">
							<div class="form-item">
								<span>USERNAME:</span><input class="forminput" name="username" type="text" value="<s:property value="baseApplication.basicInfoApplication.name"/>" />
							</div>
							<div class="form-item">
								<span>SEX:</span>
								<s:set name="sex" value="baseApplication.basicInfoApplication.sex"></s:set>
								<s:if test='#sex=="male"'>
								<input class="sex" type="radio" name="sex" value="male" checked/><span class="sex_cont" >Male</span>
								<input class="sex" type="radio" name="sex" value="female" /><span class="sex_cont" >Female</span>
								</s:if >
								<s:elseif test='#sex=="female"'>
								<input class="sex" type="radio" name="sex" value="male" /><span class="sex_cont" >Male</span>
								<input class="sex" type="radio" name="sex" value="female" checked/><span class="sex_cont" >Female</span>
								</s:elseif>
								<s:else>
								<input class="sex" type="radio" name="sex" value="male" /><span class="sex_cont" >Male</span>
								<input class="sex" type="radio" name="sex" value="female"/><span class="sex_cont" >Female</span>
								</s:else>
							</div>
							<div class="form-item">
								<span>TYPE:</span><input class="forminput" value="<s:property value="baseApplication.basicInfoApplication.applicationType"/>" name="applicationtype" type="text" />
							</div>
							<div class="form-item">
								<span>EMAIL:</span><input class="forminput" value="<s:property value="baseApplication.basicInfoApplication.email"/>" name="email" type="text" />
							</div>
							<div class="form-item textarea">
								<span>ADDRESS:</span><textarea rows="6" cols="60" ><s:property value="baseApplication.basicInfoApplication.address"/></textarea>
							</div>
						</div>
					</form>
				</div>
				<div class="selected tab">
					<span class="title">
						<h1>STEP2</h1>
					</span>
					<form>
						<div class="formcontent" style="width:90%;">
							<div class="">
								<div class="education-title" style="clear:both;height:40px;line-height:40px;margin-top:30px;">
										<div class="Admission-date" style="border-right:1px solid #fff;">Admission date</div>
										<div class="End-academic" style="border-right:1px solid #fff;">End date of academic</div>
										<div class="Graduation-school" style="border-right:1px solid #fff;">The graduation school</div>
										<div class="Education-level" >Education level</div>
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
						<div class="formcontent">
							<div class="form-item textarea">
								<span>Career situation:</span><textarea rows="6" cols="60" ><s:property value="baseApplication.workInfoApplication.workInfo"/></textarea>
							</div>
						</div>
					</form>
				</div>
				<div class="selected tab">
					<span class="title">
						<h1>STEP4</h1>
					</span>
					<form>
						<div class="formcontent">
							<div class="form-item textarea">
								<span>Self-introduction:</span><textarea rows="6" cols="60" ><s:property value="baseApplication.individualResumeApplication.individualResume"/></textarea>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
 </body>
</html>
