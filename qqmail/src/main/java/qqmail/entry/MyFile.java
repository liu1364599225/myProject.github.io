package qqmail.entry;

import java.util.Date;

//文件的实体类用于在线功能模块
public class MyFile {
     private int fileId;//文件的id
     private String fileName;//文件的名字
     private String filePath;//文件的路径
     private Date uploadDate;//上传文件的日期
     private int userId;//上传该文档的用户
     
     public MyFile(){
    	 
     }
     
     public MyFile(String fileName, String filePath, Date uploadDate, int userId) {
		super();
		this.fileName = fileName;
		this.filePath = filePath;
		this.uploadDate = uploadDate;
		this.userId = userId;
     }


	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "File [fileId=" + fileId + ", fileName=" + fileName
				+ ", filePath=" + filePath + ", uploadDate=" + uploadDate
				+ ", userId=" + userId + "]";
	}
}
