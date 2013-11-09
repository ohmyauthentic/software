package njust.Bean;

import java.util.List;

import njust.PO.User;
import njust.User.UserManage;

public class UserlistImpl implements Userlist {
	public PageBean queryForPage(int pageSize, int page) {
		UserManage userManage=new UserManage();
		@SuppressWarnings("unchecked")
		List<User> list=userManage.findAll();
		int allRow = list.size();//总记录数
		int totalPage = PageBean.countTotalPage(pageSize, allRow);//总页数
		final int offset = PageBean.countOffset(pageSize, page);
		final int length = pageSize; //每页记录数
		final int currentPage = PageBean.countCurrentPage(page);
		String hql="from User";
		List<User> userlist= userManage.queryForPage(hql, offset, length);  //"一页"的记录
		//System.out.print(list.get(0).get)
		//把分页信息保存到Bean中
		PageBean pageBean = new PageBean();
		pageBean.setPageSize(pageSize);
		pageBean.setCurrentPage(currentPage);
		pageBean.setAllRow(allRow);
		pageBean.setTotalPage(totalPage);
		pageBean.setList(userlist);
		return pageBean;
	}
    
}
