import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DB_Connection {

	private Connection con;
	// Connection은 연결 관련
	private Statement st;
	// Statement는 SQL실행 관련
	private ResultSet rs;
	// 쿼리 실행하고 난 결과가 담기는 곳
	// 데이터베이스 결과 집합을 표현하는
	// 표형태의 데이터
	private PreparedStatement pstmt;

	// 준비된 스테이트먼트 (Insert, Update, Delete)
	public DB_Connection() {
		// 생성자 : 객체가 생성되면 호출
		try {
			String user = "system";
			String pw = "1234";
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			// localhost == 127.0.0.1 == me
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pw);
			st = con.createStatement();
			// Creates a Statement object for sendingSQL statements to the database
			// 데이터베이스에 SQL문장을 보내기위한 Statement 객체를 생성한다.
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 오류:" + e.getMessage());
		}
	}

	public void Search() {
		String SQL = "SELECT * FROM Person";
		try {
			rs = st.executeQuery(SQL);
			// statement가 executeQuery메서드로
			// SQL쿼리를 실행한결과가 ResultSet rs에 담긴다.
			while (rs.next()) {
				int no = rs.getInt("NO");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
				double height = rs.getDouble("HEIGHT");
				System.out.printf("%d ", no);
				System.out.printf("%s ", name);
				System.out.printf("%d ", age);
				System.out.printf("%f\n", height);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void SearchByName(String input_name) {
		String SQL = "SELECT * FROM Person WHERE Name=" + "'" + input_name + "'";
		try {
			rs = st.executeQuery(SQL);

			while (rs.next()) {
				int no = rs.getInt("NO");
				String name = rs.getString("NAME");
				int age = rs.getInt("age");
				double height = rs.getDouble("HEIGHT");
				System.out.printf("%d ", no);
				System.out.printf("%s ", name);
				System.out.printf("%d ", age);
				System.out.printf("%.2f\n", height);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void InsertPerson(int no, String name, int age, double height) {
		String SQL = "Insert INTO Person(NO, NAME, AGE, HEIGHT) VALUES (?,?,?,?)";

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, no);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			pstmt.setDouble(4, height);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void UpdatePerson(String name, int age) {
		String SQL = "update Person set age = ? where name = ?";

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, age);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void DeletePerson(String name) {
		String SQL = "delete from Person where name = ?";

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
