package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BasicInfo;
import model.SearchLogic;

/**
 * Servlet implementation class Top
 */
@WebServlet("/Top")
public class Top extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Top() {
        super();
        // TODO Auto-generated constructor stub
    }

	//入力情報受け取り、mainへ渡す
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		request.setCharacterEncoding("utf-8");
		String title=request.getParameter("title");
		String sex=request.getParameter("sex");
		String genre=request.getParameter("genre");
		String freeword=request.getParameter("freeword");
		String color=request.getParameter("color");
		String pattern=request.getParameter("pattern");
		BasicInfo basicinfo=new BasicInfo(title,sex,genre,freeword,color,pattern);
		
		SearchLogic sLogic=new SearchLogic();
		List[] List=sLogic.execute(basicinfo);
		
		List<String> tList=selectList(List,0);
		List<String> nList=selectList(List,1);
		session.setAttribute("basicinfo", basicinfo);
		session.setAttribute("tList", tList);
		session.setAttribute("nList", nList);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}
	public static List<String> selectList(List<String>[] lists, int index) {
        return lists[index];
    }

}
