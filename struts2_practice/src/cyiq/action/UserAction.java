package cyiq.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

import cyiq.bean.User;
import cyiq.dao.UserDao;
import cyiq.dao.impl.UserDaoImpl;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	
	public User getModel() {
		return user;
	}

	public String add(){
		return "add";
	}
	
	public String save(){
		UserDao userDao = new UserDaoImpl();
		if(user.getUploadFileName() != null && user.getUploadFileName().length()>0){
			String path = ServletActionContext.getServletContext().getRealPath("upload");
			File file = new File(path,user.getUploadFileName());
			try {
				FileUtils.copyFile(user.getUpload(), file);
				user.getUpload().delete();
				user.setPath(path);
				user.setFilename(user.getUploadFileName());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		userDao.save(user);
		return "tolist";
	}
	
	public String list(){
		UserDao userDao = new UserDaoImpl();
		List<User> userList = userDao.findUsersByCondition(user);
		ServletActionContext.getRequest().setAttribute("userList", userList);
		return "list";
	}
	
	public String edit(){
		Integer userID = Integer.parseInt(ServletActionContext.getRequest().getParameter("userID"));
		UserDao userDao = new UserDaoImpl();
		User newUser = userDao.findUsersById(userID);
		System.out.println(newUser);
		ValueStack valueStack = ServletActionContext.getContext().getValueStack();
		valueStack.pop();
		valueStack.push(newUser);
		String interest = newUser.getInterest();
		if(StringUtils.isNotBlank(interest)){
			System.out.println(interest);
			String[] interests = interest.split(", ");
			ServletActionContext.getRequest().setAttribute("interests", interests);
		}
		return "edit";
	}
	
	public String update(){
		UserDao userDao = new UserDaoImpl();
		if(user.getUploadFileName() != null && user.getUploadFileName().length()>0){
			String path = ServletActionContext.getServletContext().getRealPath("upload");
			File file = new File(path,user.getUploadFileName());
			try {
				FileUtils.copyFile(user.getUpload(), file);
				user.getUpload().delete();
				user.setPath(path);
				user.setFilename(user.getUploadFileName());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		userDao.update(user);
		return "tolist";
	}
	public String delete(){
		Integer userID = Integer.parseInt(ServletActionContext.getRequest().getParameter("userID"));
		UserDao userDao = new UserDaoImpl();
		userDao.delete(userID);
		return "tolist";
	}
	public String view(){
		Integer userID = Integer.parseInt(ServletActionContext.getRequest().getParameter("userID"));
		UserDao userDao = new UserDaoImpl();
		User newUser = userDao.findUsersById(userID);
		ValueStack valueStack = ServletActionContext.getContext().getValueStack();
		valueStack.pop();
		valueStack.push(newUser);
		return "view";
	}
	
	public String download(){
		Integer userID = Integer.parseInt(ServletActionContext.getRequest().getParameter("userID"));
		UserDao userDao = new UserDaoImpl();
		User newUser = userDao.findUsersById(userID);
		String realpath = newUser.getPath();
		try {
			FileInputStream fis = new FileInputStream(new File(realpath,newUser.getFilename()));
			newUser.setFilename(new String(newUser.getFilename().getBytes("UTF-8"),"ISO-8859-1"));
			newUser.setInputStreamxxx(fis);
//			以下是传统的响应返回文件流的方式
//			HttpServletResponse response = ServletActionContext.getResponse();
//			response.setContentType("application/x-msdownload");
//			response.setHeader("Content-Disposition", "attachment;filename="+new String(newUser.getFilename().getBytes("UTF-8"),"ISO-8859-1"));
//			OutputStream os = response.getOutputStream();
//			
//			byte[] b = new byte[1024];
//			int len = 0;
//			while((len=fis.read(b))!=-1){
//				os.write(b, 0, len);
//			}
//			os.flush();
//			fis.close();
//			os.close();
			ValueStack valueStack = ServletActionContext.getContext().getValueStack();
			valueStack.pop();
			valueStack.push(newUser);	//将文件流放入值栈中
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "download";
	}
}
