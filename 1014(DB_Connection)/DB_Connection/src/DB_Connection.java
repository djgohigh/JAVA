import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DB_Connection {

	private Connection con;
	// Connection�� ���� ����
	private Statement st;
	// Statement�� SQL���� ����
	private ResultSet rs;
	// ���� �����ϰ� �� ����� ���� ��
	// �����ͺ��̽� ��� ������ ǥ���ϴ�
	// ǥ������ ������
	private PreparedStatement pstmt;

	// �غ�� ������Ʈ��Ʈ (Insert, Update, Delete)
	public DB_Connection() {
		// ������ : ��ü�� �����Ǹ� ȣ��
		try {
			String user = "system";
			String pw = "1234";
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			// localhost == 127.0.0.1 == me
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pw);
			st = con.createStatement();
			// Creates a Statement object for sendingSQL statements to the database
			// �����ͺ��̽��� SQL������ ���������� Statement ��ü�� �����Ѵ�.
		} catch (Exception e) {
			System.out.println("�����ͺ��̽� ���� ����:" + e.getMessage());
		}
	}

	public void Search() {
		String SQL = "SELECT * FROM Person";
		try {
			rs = st.executeQuery(SQL);
			// statement�� executeQuery�޼����
			// SQL������ �����Ѱ���� ResultSet rs�� ����.
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
