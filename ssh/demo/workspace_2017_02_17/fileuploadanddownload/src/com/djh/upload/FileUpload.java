package com.djh.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileUpload extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	private File ppt;					//文件路径 【FileName】
	private String pptContentType;		//文件类型 【FileName】ContentType
	private String pptFileName;			//文件名 【FileName】FileName

	public File getPpt() {
		return ppt;
	}

	public void setPpt(File ppt) {
		this.ppt = ppt;
	}

	public String getPptContentType() {
		return pptContentType;
	}

	public void setPptContentType(String pptContentType) {
		this.pptContentType = pptContentType;
	}

	public String getPptFileName() {
		return pptFileName;
	}

	public void setPptFileName(String pptFileName) {
		this.pptFileName = pptFileName;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(ppt + "\n" + pptContentType + "\n" + pptFileName);
		int beginIndex = pptFileName.lastIndexOf(".");							//获取文件扩展名
		String extend = pptFileName.substring(beginIndex, pptFileName.length());
		
		System.out.println(extend);
		
		ServletContext servletContext = ServletActionContext.getServletContext();
		
		String path = servletContext.getRealPath("/files/" + pptFileName);
		
		FileOutputStream fos = new FileOutputStream(path);
		FileInputStream fis = new FileInputStream(ppt);
		
		//start to upload
		byte buf[] = new byte[1024];
		int len = 0;
		while((len = fis.read(buf)) != -1){
			fos.write(buf, 0, len);
		}
		fis.close();
		fos.close();
		System.out.println(path);
		return SUCCESS;
	}
}
