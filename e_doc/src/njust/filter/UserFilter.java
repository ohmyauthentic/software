package njust.filter;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import njust.User.UserSession;


public class UserFilter implements Filter {
	private FilterConfig filterConfig;      
	private HttpServletRequest request;  
	private HttpServletResponse response; 	
	@Override
	public void destroy() {
		this.filterConfig=null;

	}
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {

		this.request=(HttpServletRequest)servletRequest;
		this.response=(HttpServletResponse)servletResponse;		
		String url = request.getRequestURI();  
		// 此处截取的url为：login.jsp  
		url = url.substring(url.lastIndexOf("/") + 1, url.length());  
		try {  
			HttpSession session = request.getSession(); 
			// 获取用户登录验证信息  
			UserSession st = (UserSession) session.getAttribute("userSession");  
			if (noFileUrl(url)) {  
				// 不需要判断权限的请求如登录页面，则跳过  
				chain.doFilter(request, response);// 继续执行请求  
			} else if (st == null) {  
				PrintWriter out=response.getWriter();
				out.println(
						" <script language='javascript'>" +
						"alert('你还未登录,请先登录！'); " +
						"location.href='http://localhost:8080/PersonManage/login.jsp'" +
						"</script>"
						); 
				//response.sendRedirect(accessPath + "/login.jsp");  
				// 未登录或超时，返回登陆页面  
			} else {  
				chain.doFilter(request, response);// 继续执行请求  
				//verifyUrl(url, st);// 判断当前user是否拥有访问此url的权限  
			}  
		} catch (Exception sx) {  
			sx.printStackTrace();  
		}  
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {  
		this.filterConfig = filterConfig;  
	}  
	protected boolean noFileUrl(String url) {  
		//不需要权限验证的页面动作等  
		String exclude = "login.jsp";  
		String actionString="loginAction.action";
		//判断请求页面是否是特殊页面  
		if (exclude.indexOf(url) >= 0) {  
			return true;  
		}
		else if(actionString.indexOf(url)>=0){
			return true;
		}
		return false;  
	}  


}
