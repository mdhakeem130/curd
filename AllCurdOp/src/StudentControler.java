

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class StudentControler
 */
@WebServlet("/StudentControler")
public class StudentControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("dopost method");
		String par1=request.getParameter("name");
		String par2=request.getParameter("age");
		String par3=request.getParameter("mobile");
		
		System.out.println("name :"+par1);
		System.out.println("age :"+par2);
		System.out.println("mobile :"+par3);
		
		StudentDAOImp obje=new StudentDAOImp();
		String insertflage=obje.insert(par1,par2,par3);
		System.out.println(insertflage);
		
		request.setAttribute("stuatus", "Record added Successfully");
		RequestDispatcher dispatch=request.getRequestDispatcher("index.jsp");
		dispatch.forward(request, response);
	}

}
