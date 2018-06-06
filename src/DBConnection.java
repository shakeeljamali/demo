
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnection {
	private static Connection con = null;
    public static Connection getConnection() {
        if (con == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return con;
    }

}
