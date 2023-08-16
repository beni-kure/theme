package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BasicInfo;

/**
 * Servlet implementation class Ending
 */
@WebServlet("/Ending")
public class Ending extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ending() {
        super();
        // TODO Auto-generated constructor stub
    }

	//題材を受け取ってcompへ
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String title=request.getParameter("title");
		String name= request.getParameter("name");
		
		BasicInfo basicinfo=new BasicInfo(title,name);
		
		request.setAttribute("basicinfo", basicinfo);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/comp.jsp");
		dispatcher.forward(request, response);
	}

}
