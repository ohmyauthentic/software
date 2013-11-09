package njust.UserAction;

import njust.PO.User;
import njust.User.UserManage;
import com.opensymphony.xwork2.ActionContext;

public class UPsword {
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
			User user=(User) ActionContext.getContext().getSession().get("user");
			String username=user.getUsername();
			UserManage userManage=new UserManage();
			userManage.ModifyPassword(username, newpassword1);
			return "success";
		}catch (Exception e) {
			return "error";
		}
	}
}
