

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentEditController
 */
@WebServlet("/StudentEditController")
public class StudentEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentEditController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("studentEditController doget");
		String id=request.getParameter("id");
		System.out.println(id);
		
		StudentDAOImp StudentDAOImp= new StudentDAOImp();
		
		StudentBeam StudentBeam =StudentDAOImp.viewStudent(id);
		request.setAttribute("beam", StudentBeam);
		request.setAttribute("opion", "edit option is as below");
		
		System.out.println("stu age"+StudentBeam.getAge());
		System.out.println( "stu id"+StudentBeam.getId());
		System.out.println ( "stu name"+StudentBeam.getName());
		System.out.println( "stu mobile"+StudentBeam.getMobile());
		
		RequestDispatcher dispatch1=request.getRequestDispatcher("editstudent.jsp");
		dispatch1.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("student edit  do post");
	}

}
