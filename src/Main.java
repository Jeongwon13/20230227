import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Main {

	public static void main(String[] args) {
		
		String title = "TEST2";
		String writerId = "newlec";
		String content = "hahaha";
		String files = "";
		
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String sql = "INSERT INTO notice (	" +
				"	title," +
				"	writer_id," +
				"	content," +
				"	files" +
				") VALUES (?,?,?,?)";
			
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,"user1","1234");
	//	Statement st = con.createStatement();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, writerId);
		st.setString(3, content);
		st.setString(4, files);
		
		int result = st.executeUpdate();
		System.out.println(result);
		
		
		st.close();
		con.close();
		
	}

}

