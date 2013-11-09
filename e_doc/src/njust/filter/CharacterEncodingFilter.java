package njust.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{
	private String encoding=null;
	private FilterConfig filterConfig=null;
	@Override
	public void destroy() {
		this.encoding=null;
		this.filterConfig=null;
	}
	
	@Override
	public void doFilter(ServletRequest resquest, ServletResponse response,FilterChain chain) 
			throws IOException, ServletException {
		String encoding=getEncoding();
		if(encoding!=null){
			resquest.setCharacterEncoding(encoding);
			response.setCharacterEncoding(encoding);
		}
		chain.doFilter(resquest, response);		
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		this.filterConfig=config;
		this.encoding=filterConfig.getInitParameter("encoding");
	}
	public String getEncoding(){
		return this.encoding;
	}

}
