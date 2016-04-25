package cyiq.bean;

import java.io.File;
import java.io.InputStream;
import java.util.Date;

public class User {
	private Integer userID;
	private String loginName;
	private String loginPwd;
	private String userName;
	private String sex;
	private String birthday;
	private String education;
	private String telephone;
	private String interest;	//多个值
	private String remark;
	private String path;
	private String filename;
	//文件是否上传
	private String isUpload;
	//文件上传
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	//下载
	private InputStream inputStreamxxx;
	
	public InputStream getInputStreamxxx() {
		return inputStreamxxx;
	}
	public void setInputStreamxxx(InputStream inputStreamxxx) {
		this.inputStreamxxx = inputStreamxxx;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getIsUpload() {
		return isUpload;
	}
	public void setIsUpload(String isUpload) {
		this.isUpload = isUpload;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", loginName=" + loginName
				+ ", loginPwd=" + loginPwd + ", userName=" + userName
				+ ", sex=" + sex + ", birthday=" + birthday + ", education="
				+ education + ", telephone=" + telephone + ", interest="
				+ interest + ", remark=" + remark + ", path=" + path
				+ ", filename=" + filename + ", isUpload=" + isUpload
				+ ", upload=" + upload + ", uploadContentType="
				+ uploadContentType + ", uploadFileName=" + uploadFileName
				+ "]";
	}
	
	
}
