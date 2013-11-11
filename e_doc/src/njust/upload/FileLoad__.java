package njust.upload;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FileLoad__ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor of the object.
	 */
	public FileLoad__() {
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

	/*	
		*/
			
		HttpSession session=request.getSession();
		// �ϴ�֮����ļ�����������ļ�����
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
		    type=filename.substring(p,j);   //�ļ�����
		    filename = System.currentTimeMillis()+type;  //�ļ����
		    DataOutputStream fileStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filepath+ filename)));
		  
		   session.setAttribute("file_url", filepath + filename);
		    
		    len = in.readLine(buf, 0, buf.length); 
		    len = in.readLine(buf, 0, buf.length); 
		    while ((len = in.readLine(buf, 0, buf.length)) != -1) {
		        String tempf = new String(buf, 0, len - 1);
		        if (tempf.equals(f) || tempf.equals(f + "--")) {
		            break;    
		        }
		        else{
		        	 fileStream.write(buf, 0, len); // д��
		        }
		    }
		    fileStream.close();
		}
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
