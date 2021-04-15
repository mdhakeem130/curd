

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateStudentController
 */
@WebServlet("/UpdateStudentController")
public class UpdateStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentController() {
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
		System.out.println("studentupdateController do post");
		
		String name= request.getParameter("name");
		String age=request.getParameter("age");
		String mobile=request.getParameter("mobile");
		String id=request.getParameter("id");
		
		
		StudentBeam obje=new StudentBeam();
		obje.setAge(age);
		obje.setId(id);
		obje.setName(name);
		obje.setMobile(mobile);
		
		System.out.println("stu age"+obje.getAge());
		System.out.println( "stu id"+obje.getId());
		System.out.println ( "stu name"+obje.getName());
		System.out.println( "stu mobile"+obje.getMobile());
		

		StudentDAOImp StudentDAOImp= new StudentDAOImp();
		
		String status =StudentDAOImp.updateStudent(obje);
		if(status.trim().equals("Success"))
		{
			request.setAttribute("updateStatus", "row has been updated sussesfully");
		}
		else
		{
			request.setAttribute("updateStatus", "row has been failed ");
	
		}
		request.setAttribute("opion", "edit option is as below");
		
		ArrayList all_details;
		StudentDAOImp objej=new StudentDAOImp();
		all_details=objej.getAllDetails();
		
		System.out.println("number of recods in the array List: "+all_details.size());
		
		request.setAttribute("details",all_details);

		
		
		RequestDispatcher dispatch1=request.getRequestDispatcher("viewAll.jsp");
		dispatch1.forward(request, response);
	}

}
