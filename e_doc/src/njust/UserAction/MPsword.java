package njust.UserAction;

import njust.User.AdminManage;

import com.opensymphony.xwork2.ActionContext;

public class MPsword {
	private String oldpassword;
	private String newpassword1;
	private String newpassword2;
	public String getOldpassword() {
		return oldpassword;
	}
	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	public String getNewpassword1() {
		return newpassword1;
	}
	public void setNewpassword1(String newpassword1) {
		this.newpassword1 = newpassword1;
	}
	public String getNewpassword2() {
		return newpassword2;
	}
	public void setNewpassword2(String newpassword2) {
		this.newpassword2 = newpassword2;
	}
	
	public String execute() throws Exception{
		try{
			
			String username= (String) ActionContext.getContext().getSession().get("username");
			System.out.println(newpassword1);
			System.out.println(username);
			AdminManage adminManage=new AdminManage();
			adminManage.ModifyPassword(username, newpassword1);
			return "success";
		}catch (Exception e) {
			return "error";
		}
	}
}
