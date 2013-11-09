package njust.UserAction;

import com.opensymphony.xwork2.ActionContext;

public class LogoutAction {
	public String execute() throws Exception{
		ActionContext ac = ActionContext.getContext();
		ac.getSession().clear();
		return "success";
	}
}
