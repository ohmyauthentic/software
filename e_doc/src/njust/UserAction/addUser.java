package njust.UserAction;

import njust.User.LoginAndRegist;

import com.opensymphony.xwork2.ActionContext;

public class addUser {
	private String username;
	private String password1;
	private String password2;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	public String execute() throws Exception{
		System.out.println(username);
		if(!password1.equals(password2)){
			ActionContext.getContext().put("tip", "两次密码输入不一致！");
			return "error";
		}
		LoginAndRegist lr=new LoginAndRegist();
	    String mess=lr.regist(username, password1); 
	    if(mess.equals("exist")){
	    	ActionContext.getContext().put("tip", "该用户已存在！");
			return "error";
	    }
	    else {  	
	    	return "success";
	    }
	}

}
