package njust.Bean;

import java.util.List;

public class PageBean {
	
	private int pageSize;
	private int allRow;
	private int currentPage;
	private int totalPage;
	private List list;
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getAllRow() {
		return allRow;
	}
	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public PageBean() {	}
	
	public static int countTotalPage(int pageSize,int allRow){
		if(allRow%pageSize==0){
			return allRow/pageSize;
		}
		else return allRow/pageSize+1;
	}
	public static int countOffset(int pageSize,int page){
		return (page-1)*pageSize;
	
	}
	public static int countCurrentPage(int page){
		return page;
	}

}
