package njust.UserAction;

import njust.Bean.PageBean;
import njust.Bean.Userlist;
import njust.Bean.UserlistImpl;

public class UserlistAction {
	private Userlist userList;
	private PageBean pageBean;
	private int page=1;//设置页面默认值
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String execute() throws Exception{
		userList=new UserlistImpl();			
		this.pageBean=userList.queryForPage(5, page);
		return "success";
	}
}
