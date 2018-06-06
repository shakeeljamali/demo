

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String name=request.getParameter("name");
		String roll=request.getParameter("rollno");
		if(request.getParameter("method")!=null){
			String method=request.getParameter("method");
			if(method.equals("getAllRecrods"))
			{
				DBManager obj = new DBManager();
				List<Student> students=obj.getAllEmployees();
				Gson gson=new Gson();
				pw.write(gson.toJson(students));
				System.out.println(gson.toJson(students));
				
			}
			if(method.equals("addRecord")){
				DBManager.addEmployee(name, roll);
				
			}
			
		}
		
		
		
		
		
		
		
	}

}
