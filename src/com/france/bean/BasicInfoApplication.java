package com.france.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="BasicInfo")
public class BasicInfoApplication implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6758297495451199907L;
	private int basicInfoID;
	private String name;
	private String sex;
	private String email;
	private String permanentAddress;//永久地址
	private String mailingAddress;//通信地址
	private String languageChineseLevel;
	private String languageChineseShow;
	private String languageEnglishLevel;
	private String languageEndlishIsTaught;
	private String languageOther;
	private String studyProposedType;
	private String studySubjectField;
	private String studyPreferenceInstitutionsOne;
	private String studyPreferenceInstitutionsTow;
	private String studyPreferenceInstitutionsThree;
	private String studyDurationFrom;
	private String studyDurationTo;
	private String nationnality;//国籍
	private String birthPlace;//出生地
	private String birthDay;//生日
	private String maritalStatus;//婚姻状况
	private String healthStatus;//健康状况
	private String healthReport;//体检号
	private String passportNo;//护照号码
	private String religion;//宗教信仰
	private String tel;//电话
	private String occupation;//职业
	private String fileHealthReport;//体检报告
	private String filePersonalPhoto;//2寸照片
	private BaseApplication baseApplication;
	private String applicationType;
	@Id//映射OID
	@GeneratedValue(strategy = GenerationType.IDENTITY)//指定OID的生成策略
	@Column(name = "basicInfoID", unique = true, nullable = true)
	public int getBasicInfoID() {
		return basicInfoID;
	}
	public void setBasicInfoID(int basicInfoID) {
		this.basicInfoID = basicInfoID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@OneToOne
	public BaseApplication getBaseApplication() {
		return baseApplication;
	}
	public void setBaseApplication(BaseApplication baseApplication) {
		this.baseApplication = baseApplication;
	}
	public String getApplicationType() {
		return applicationType;
	}
	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getMailingAddress() {
		return mailingAddress;
	}
	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}
	public String getLanguageChineseLevel() {
		return languageChineseLevel;
	}
	public void setLanguageChineseLevel(String languageChineseLevel) {
		this.languageChineseLevel = languageChineseLevel;
	}
	public String getLanguageChineseShow() {
		return languageChineseShow;
	}
	public void setLanguageChineseShow(String languageChineseShow) {
		this.languageChineseShow = languageChineseShow;
	}
	public String getLanguageEnglishLevel() {
		return languageEnglishLevel;
	}
	public void setLanguageEnglishLevel(String languageEnglishLevel) {
		this.languageEnglishLevel = languageEnglishLevel;
	}
	public String getLanguageEndlishIsTaught() {
		return languageEndlishIsTaught;
	}
	public void setLanguageEndlishIsTaught(String languageEndlishIsTaught) {
		this.languageEndlishIsTaught = languageEndlishIsTaught;
	}
	public String getLanguageOther() {
		return languageOther;
	}
	public void setLanguageOther(String languageOther) {
		this.languageOther = languageOther;
	}
	public String getStudyProposedType() {
		return studyProposedType;
	}
	public void setStudyProposedType(String studyProposedType) {
		this.studyProposedType = studyProposedType;
	}
	public String getStudySubjectField() {
		return studySubjectField;
	}
	public void setStudySubjectField(String studySubjectField) {
		this.studySubjectField = studySubjectField;
	}
	public String getStudyPreferenceInstitutionsOne() {
		return studyPreferenceInstitutionsOne;
	}
	public void setStudyPreferenceInstitutionsOne(
			String studyPreferenceInstitutionsOne) {
		this.studyPreferenceInstitutionsOne = studyPreferenceInstitutionsOne;
	}
	public String getStudyPreferenceInstitutionsTow() {
		return studyPreferenceInstitutionsTow;
	}
	public void setStudyPreferenceInstitutionsTow(
			String studyPreferenceInstitutionsTow) {
		this.studyPreferenceInstitutionsTow = studyPreferenceInstitutionsTow;
	}
	public String getStudyPreferenceInstitutionsThree() {
		return studyPreferenceInstitutionsThree;
	}
	public void setStudyPreferenceInstitutionsThree(
			String studyPreferenceInstitutionsThree) {
		this.studyPreferenceInstitutionsThree = studyPreferenceInstitutionsThree;
	}
	public String getStudyDurationFrom() {
		return studyDurationFrom;
	}
	public void setStudyDurationFrom(String studyDurationFrom) {
		this.studyDurationFrom = studyDurationFrom;
	}
	public String getStudyDurationTo() {
		return studyDurationTo;
	}
	public void setStudyDurationTo(String studyDurationTo) {
		this.studyDurationTo = studyDurationTo;
	}
	public String getNationnality() {
		return nationnality;
	}
	public void setNationnality(String nationnality) {
		this.nationnality = nationnality;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getHealthStatus() {
		return healthStatus;
	}
	public void setHealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}
	public String getHealthReport() {
		return healthReport;
	}
	public void setHealthReport(String healthReport) {
		this.healthReport = healthReport;
	}
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getFileHealthReport() {
		return fileHealthReport;
	}
	public void setFileHealthReport(String fileHealthReport) {
		this.fileHealthReport = fileHealthReport;
	}
	public String getFilePersonalPhoto() {
		return filePersonalPhoto;
	}
	public void setFilePersonalPhoto(String filePersonalPhoto) {
		this.filePersonalPhoto = filePersonalPhoto;
	}
	
}
