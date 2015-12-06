package com.france.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.france.bean.BaseApplication;
import com.france.bean.BasicInfoApplication;
import com.france.bean.IndividualResumeApplication;
import com.france.service.UserService;
import com.france.util.ConvertUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller("fileAction")
public class FileAction extends ActionSupport {

/**
	 * 
	 */
	private static final long serialVersionUID = -8854632284342567059L;


private static final int BUFFER_SIZE = 10 * 1024; //byte[10*1024] 每次写10k的数据


/**
 * 需要上传的文件
 */
private List<File> uploads1 ;  
private List<File> uploads4 ;  
/**
 * 上传文件的类型
 */
private List<String> uploads1ContentType;
private List<String> uploads4ContentType;

/**
 * 文件名
 */
private List<String> uploads1FileName;
private List<String> uploads4FileName;

/**
 * 上传之后的文件名
 */
private String storageFileName;

/**
 * 文件上传的路径
 */
public String path;

/**
 * 新文件上传
 * 
 * @return
 */
@Resource
private UserService userService;
private Map<String,Object> dataMap;
public String upload() {
    try {
    	System.out.println("这是上传方法");
    	path = ServletActionContext.getServletContext().getRealPath(
    	        File.separator + "WEB-INF" + File.separator + "file");
    	HttpServletRequest request = ServletActionContext.getRequest();
    	String type=request.getParameter("type");
    	String aid=request.getParameter("aid");
    	String status=request.getParameter("status");
    	System.out.println("type:"+type+"  aid:"+aid);
    	BaseApplication app=userService.getSingleApplicationByUID(-1, Integer.valueOf(aid));
    	BasicInfoApplication basic=app.getBasicInfoApplication();
    	IndividualResumeApplication individual=app.getIndividualResumeApplication();
        // 将Struts2自动封装的文件名赋给要写入的文件 这个可以得到具体文件名
    	if("s1".equals(type)){
    		if(uploads1==null||uploads1.size()==0)return "uploadSuccess";
    		int fileIndex=0;
    		for(int i=0;i<status.length();i++){
    			if(status.charAt(i)=='0'){
    				System.out.println("第"+(i+1)+"个没有上传文件");
    				continue;
    			}
    			String saveName=ConvertUtil.getUUID()+uploads1FileName.get(fileIndex);
    			if(i==0){
                    basic.setFileHealthReport(saveName);
    			}else{
    				basic.setFilePersonalPhoto(saveName);
    			}
    			
    			File storageFile = new File(path + "//" + saveName);
                copy(uploads1.get(fileIndex), storageFile);//绑定的upload 上传时是先把文件放在tomcat的缓冲区
                userService.updateBasicApplication(basic);
                fileIndex++;
        	}
    	}
    	else if("s4".equals(type)){
    		if(uploads4==null||uploads4.size()==0)return "uploadSuccess";
    		int fileIndex=0;
    		for(int i=0;i<status.length();i++){
    			if(status.charAt(i)=='0'){
    				System.out.println("第"+(i+1)+"个没有上传文件");
    				continue;
    			}
    			String saveName=ConvertUtil.getUUID()+uploads4FileName.get(fileIndex);
    			if(i==0){
    				individual.setFileStudyPlan(saveName);
    			}else if(i==1){
    				individual.setFileScholarshipApplication(saveName);
    			}
    			else {
    				individual.setFileChineseGovementApplication(saveName);
    			}
        		File storageFile = new File(path + "//" + saveName);
                copy(uploads4.get(fileIndex), storageFile);//绑定的upload 上传时是先把文件放在tomcat的缓冲区
                userService.updateIndividualApplication(individual);
                fileIndex++;
        	}
    	}
        return "uploadSuccess";
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "uploadError";
}

/**
 * 上传文件的主要方法
 * 
 * @param src
 * @param dst
 * @return
 */
public boolean copy(File src, File dst) {
    try {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new BufferedInputStream(new FileInputStream(src),
                    BUFFER_SIZE);
            out = new BufferedOutputStream(new FileOutputStream(dst),
                    BUFFER_SIZE);
            byte[] buffer = new byte[BUFFER_SIZE];
            while (in.read(buffer) > 0) {
                out.write(buffer);
            }
        } finally {
            if (null != in) {
                in.close();
            }
            if (null != out) {
                out.close();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return true;
}

public List<File> getUploads4() {
	return uploads4;
}

public void setUploads4(List<File> uploads4) {
	this.uploads4 = uploads4;
}

public List<String> getUploads4ContentType() {
	return uploads4ContentType;
}

public void setUploads4ContentType(List<String> uploads4ContentType) {
	this.uploads4ContentType = uploads4ContentType;
}

public List<String> getUploads4FileName() {
	return uploads4FileName;
}

public void setUploads4FileName(List<String> uploads4FileName) {
	this.uploads4FileName = uploads4FileName;
}

public String getStorageFileName() {
    return storageFileName;
}

public void setStorageFileName(String storageFileName) {
    this.storageFileName = storageFileName;
}


public String getPath() {
    return path;
}

public void setPath(String path) {
    this.path = path;
}

public Map<String, Object> getDataMap() {
	return dataMap;
}

public void setDataMap(Map<String, Object> dataMap) {
	this.dataMap = dataMap;
}

public List<File> getUploads1() {
	return uploads1;
}

public void setUploads1(List<File> uploads1) {
	this.uploads1 = uploads1;
}

public List<String> getUploads1ContentType() {
	return uploads1ContentType;
}

public void setUploads1ContentType(List<String> uploads1ContentType) {
	this.uploads1ContentType = uploads1ContentType;
}

public List<String> getUploads1FileName() {
	return uploads1FileName;
}

public void setUploads1FileName(List<String> uploads1FileName) {
	this.uploads1FileName = uploads1FileName;
}

}