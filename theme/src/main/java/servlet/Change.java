package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddInfo;
import model.BasicInfo;
import model.ChangeLogic;

/**
 * Servlet implementation class Change
 */
@WebServlet("/Change")
public class Change extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Change() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<AddInfo> aList=new ArrayList<>();
		
		request.setCharacterEncoding("utf-8");
		request.setAttribute("aList",aList);
		request.setAttribute("errorMsg", "no list");
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/change.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String search=request.getParameter("search");
		
		if(search != null && search.length() !=0) {
			String title=request.getParameter("search");
			String name= request.getParameter("search");

			BasicInfo basicinfo=new BasicInfo(title,name);
			ChangeLogic cLogic=new ChangeLogic();
			
			List aList=cLogic.execute(basicinfo);
			request.setAttribute("aList",aList);
		}else {
			request.setAttribute("errorMsg", "no list");
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/change.jsp");
		dispatcher.forward(request, response);
	}

}
