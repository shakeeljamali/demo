import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class DBManager {
	static int row=0;
	public static Integer addEmployee(String name,String roll) {
		try{
			Connection con=(Connection) DBConnection.getConnection();
			PreparedStatement preparedStatement=(PreparedStatement) con.prepareStatement("insert into student_info (name,rollno) values(?,?)");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, roll);
			row=preparedStatement.executeUpdate();
		}catch(Exception e){
		e.printStackTrace();
		}
		return row;
	}
	public List<Student> getAllEmployees() {
		List<Student> students= new ArrayList<Student>();
		ResultSet rs = null;
		try{
			Connection con=(Connection) DBConnection.getConnection();
			PreparedStatement preparedStatement=(PreparedStatement) con.prepareStatement("select * from student_info");
			 rs=preparedStatement.executeQuery();
			 while(rs.next()){
				 Student s = new Student();
				 s.setStudentId(rs.getInt(1));
				 s.setName(rs.getString(2));
				 s.setRollNo(rs.getString(3));
				 students.add(s);
			 }
		}catch(Exception e){
			e.printStackTrace();
		}
		return students;
	}
}
