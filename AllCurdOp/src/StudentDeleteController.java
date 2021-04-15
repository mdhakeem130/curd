

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentDeleteController
 */
@WebServlet("/StudentDeleteController")
public class StudentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("StudentDeleteController : doget");
		
		String id =request.getParameter("id");
		
		System.out.println("StudentDeleteController : doget id : " + id);
		StudentDAOImp obje=new StudentDAOImp();
		String interglage=obje.deleteById(id);
		
		if(interglage.equals("Success"))
		{
			interglage="Rows delete Successfully";
		}
		else 
		{
			interglage="Failed while Delettion";
		}
		request.setAttribute("updateflage",interglage);
		ArrayList all_details;
		all_details =obje.getAllDetails();
		System.out.println("number of recods in the array list:" +all_details.size());
		

		request.setAttribute("details",all_details);
		RequestDispatcher dispatch1=request.getRequestDispatcher("viewAll.jsp");
		dispatch1.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
