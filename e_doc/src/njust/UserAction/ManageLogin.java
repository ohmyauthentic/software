package njust.UserAction;

import njust.User.AdminManage;
import com.opensymphony.xwork2.ActionContext;

public class ManageLogin {
	private String username;
	private String password;
	private AdminManage adminManage;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String execute() throws Exception{
		System.out.println(username);
		adminManage=new AdminManage();
		String mess=adminManage.login(username, password); 
		if(mess.equals("noexist")){ 
			ActionContext.getContext().put("tip", "该用户不存在！");
			return "error";
		} 
		else if(mess.equals("passerror")){
			ActionContext.getContext().put("tip", "密码输入错误！");
			return "error";
		}
		else{
			ActionContext.getContext().getSession().put("username", username);
		    return "success";
		}	
	}

}
