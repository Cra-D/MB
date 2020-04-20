package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Table;
import dao.TableDao;

/**
 * Servlet implementation class ExcuteSQLServlet
 */
@WebServlet("/ExcuteSQLServlet")
public class ExcuteSQLServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcuteSQLServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
 
		Connection db=(Connection)request.getSession().getAttribute("db");
 
		TableDao dao = new TableDao();
		int page=0;//用户请求页面，响应后即为当前页
		Table table = new Table();
		String sql = request.getParameter("SQLArea");
		System.out.println("sql="+sql);
		try {
			dao.getConn(db);
			try{
				page = Integer.parseInt(request.getParameter("page"));
				}catch(Exception e){
					page=0;
				}
			if(page<=0)page=0;
		table = 	dao.getObject(sql, page);
			
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("dataCount="+table.getDatalist().size());
		request.setAttribute("dataCount", table.getDatalist().size());
		request.setAttribute("currentPage",page==0?1:page);
		request.setAttribute("columnList", table.getColumnlist());		
		request.setAttribute("dataList", table.getDatalist());
		request.getRequestDispatcher("dbmanager.jsp").forward(request, response);
		/**
		 * 1、forward方法只能重定向到同一个Web应用中的某一个资源，重定向后浏览器URL不变。

     sendRedirect方法可重定向到任何URL，URL没有任何的限制 可以是外部的一个资源，重定向后浏览器URL改变。

2  foward的 request.getRequestDispatcher("*.jsp").forward( request, response)      request，response跟着传递 但是sendRedirect的参数只能通过url的方式传递 即在url后面添加参数

3 servlet中request.setAttribute()方法只能通过request.getRequestDispatcher("*.jsp").forward( request, response)专递出去

4 sendRedirect的url有相对路径(*.jsp 即所处位置的路径)和 当前路径 (/login.jsp  即当前应用路劲)的区别 forward无法处理
 
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
