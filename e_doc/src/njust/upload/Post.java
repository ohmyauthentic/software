package njust.upload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import njust.PO.Topic;
import njust.PO.User;
import njust.Sessionfactory.HibernateSessionFactory;

public class Post extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User  user;
	/**
	 * Constructor of the object.
	 */
	public Post() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		HttpSession session=request.getSession();
		Session session1=HibernateSessionFactory.getSession();	
		Transaction tx=session1.beginTransaction();
		
		String type=null,topic_name=null,word_description=null,file_url=null,pic_urlString=null;
		topic_name=request.getParameter("topic_name");
		type=request.getParameter("type");
		word_description=request.getParameter("content");
		file_url=session.getAttribute("file_url").toString();
		pic_urlString=session.getAttribute("pic_url").toString();
		response.getWriter().println(topic_name);
		response.getWriter().println(type);
		response.getWriter().println(word_description);
		response.getWriter().println(file_url);
		response.getWriter().println(pic_urlString);
		response.getWriter().println(file_url.length());
	
		Query query;
		try {
			String sqlString="from User as u where u.username=?";
			query=session1.createQuery(sqlString);
			query.setParameter(0, "zheng");
			List<User> list=query.list();
			user=list.get(0);
		    response.getWriter().println(list.get(0).getUsername());
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	    Topic topic=new Topic();
		topic.setTopicId((new Date()).toString());
		topic.setUser(user);
		topic.setTopicName(topic_name);
		topic.setType(type); 
		topic.setWordDescription(word_description);
		topic.setPicUrl(pic_urlString);
		topic.setTopicUrl(file_url);
		topic.setDownloadNum(0);
		topic.setHate(0);
		topic.setLove(0);
		topic.setPublishTime(new Timestamp(0));

		try {  
			session1.save(topic);  
			tx.commit();
			response.getWriter().println("发帖成功");
		} catch (Exception e) {  
			tx.rollback();  
			e.printStackTrace();  
		}finally{  
			session1.close();  
		}
		
		
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}
	

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
