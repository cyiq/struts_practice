package cyiq.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cyiq.bean.User;
import cyiq.dao.UserDao;
import cyiq.dao.impl.UserDaoImpl;

public class LoginAction extends ActionSupport implements ModelDriven<User>{
	private User user = new User();
	
	public User getModel() {
		
		return user;
	}
	public String home(){
		UserDao userDao = new UserDaoImpl();
		User newUser = userDao.login(user);
		if(newUser == null || newUser.equals("")){
			this.addFieldError("error", "用户名不存在或密码错误");
			return "input";
		}
		ServletActionContext.getContext().getSession().put("userName", newUser.getUserName());
 		return "home";
	}

}
