package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBOper;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	 	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获取表单连接类型、
		String dbtype = request.getParameter("dbtype");
		//获取表单连接数据库
		//String hostname = request.getParameter("hostname");
		//获取URL
		String url = request.getParameter("url");
		
		
		// 获取表单用户名
		String username = request.getParameter("username");
		// 获取表单用户密码
		String userpass = request.getParameter("password");
		
 
		String sql="";
		DBOper db = new DBOper();
		// 连接数据库
		Connection conn = null;
		try {
			conn = db.getConn(dbtype,url,username,userpass);
			  if(conn!=null){
					 
			       out.println("<script language='javascript'>alert(\"Connection successful!\");</script>");
			   	request.getSession().setAttribute("db",conn); 
			    
				// 获取Session
				HttpSession session = request.getSession();
				// 将用户名保存到Session中
				session.setAttribute("username", username);
				// 获取用户登录时间，并保存到Session中
				SimpleDateFormat dateFormat = new SimpleDateFormat(
						"yyyy-MM-dd hh:mm:ss");
				String logtime = dateFormat.format(new Date());
				session.setAttribute("logtime", logtime);
				  
			//	response.sendRedirect(request.getContextPath()+"/dbmanager.jsp?flag=0");
				 response.sendRedirect(request.getContextPath()+"/dbmanager.jsp");
		      
		   }
		   else
			   {out.print("<script language='javascript'>alert(\"Connection Fail!\");</script>");}
		
	
		}catch (Exception e) {
			out.print("<script language='javascript'>alert(\"Connection Fail!\");</script>");
			e.printStackTrace();
		}
	
	
	}

}
