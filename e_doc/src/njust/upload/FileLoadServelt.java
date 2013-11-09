package njust.upload;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FileLoadServelt extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FileLoadServelt() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
		// 上传之后的文件保存在这个文件夹下
		String filepath = this.getServletContext().getRealPath("")+java.io.File.separator+"picture"+java.io.File.separator;
		String filename = "";
		String type="";
		ServletInputStream in = request.getInputStream();
		byte[] buf = new byte[4048];
		int len = in.readLine(buf, 0, buf.length);
		String f = new String(buf, 0, len - 1); 
		while ((len = in.readLine(buf, 0, buf.length)) != -1) {
			filename = new String(buf, 0, len);
		    int j = filename.lastIndexOf("\"");
		    int p = filename.lastIndexOf("."); 
		    type=filename.substring(p,j);   //文件类型
		    filename = System.currentTimeMillis()+type;  //文件名称
		    DataOutputStream fileStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filepath+ filename)));
		    len = in.readLine(buf, 0, buf.length); 
		    len = in.readLine(buf, 0, buf.length); 
		    while ((len = in.readLine(buf, 0, buf.length)) != -1) {
		        String tempf = new String(buf, 0, len - 1);
		        if (tempf.equals(f) || tempf.equals(f + "--")) {
		            break;    
		        }
		        else{
		        	 fileStream.write(buf, 0, len); // 写入
		        }
		    }
		    fileStream.close();
		}
		PrintWriter out=response.getWriter();
		String result = filename ;
		out.print(result);
		out.close();
		in.close();
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
