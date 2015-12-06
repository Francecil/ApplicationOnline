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

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

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
private Map<String,Object> dataMap;
public String upload() {
    try {
    	System.out.println("这是上传方法");
    	path = ServletActionContext.getServletContext().getRealPath(
    	        File.separator + "WEB-INF" + File.separator + "file");
    	HttpServletRequest request = ServletActionContext.getRequest();
    	String type=request.getParameter("type");
    	System.out.println("flag:"+type);
        // 将Struts2自动封装的文件名赋给要写入的文件 这个可以得到具体文件名
    	if("s1".equals(type)){
    		for(int i=0;i<uploads1.size();i++){
        		File storageFile = new File(path + "//" + uploads1FileName.get(i));
                copy(uploads1.get(i), storageFile);//绑定的upload 上传时是先把文件放在tomcat的缓冲区
        	}
    	}
    	else if("s4".equals(type)){
    		for(int i=0;i<uploads4.size();i++){
        		File storageFile = new File(path + "//" + uploads4FileName.get(i));
                copy(uploads4.get(i), storageFile);//绑定的upload 上传时是先把文件放在tomcat的缓冲区
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