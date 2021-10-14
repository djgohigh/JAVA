package smartPhone;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class smartPhoneConnection {

	private Connection con;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pstmt;

	public smartPhoneConnection() {
		try {
			String user = "system";
			String pw = "1234";
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pw);
			st = con.createStatement();
		} catch (Exception e) {
			System.out.println("데이터베이스 연결 오류:" + e.getMessage());
		}
	}

	public void Search() {
		String SQL = "SELECT * FROM SMARTPHONE";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				String name = rs.getString("NAME");
				String company = rs.getString("COMPANY");
				int price = rs.getInt("PRICE");
				String provider = rs.getString("PROVIDER");
				int weight = rs.getInt("WEIGHT");
				String color = rs.getString("COLOR");
				System.out.printf("제품명 : %s \n", name);
				System.out.printf("제조사 : %s \n", company);
				System.out.printf("가격 : %d \n", price);
				System.out.printf("통신사 : %s \n", provider);
				System.out.printf("무게 : %d \n", weight);
				System.out.printf("색상 : %s \n", color);
				System.out.printf("** \n");
				System.out.printf("** \n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void searchByName(String word) {
		String SQL = "SELECT * FROM SMARTPHONE WHERE NAME LIKE" + "'%" + word + "%'";
		try {
			rs = st.executeQuery(SQL);

			while (rs.next()) {
				String name = rs.getString("NAME");
				String company = rs.getString("COMPANY");
				int price = rs.getInt("PRICE");
				String provider = rs.getString("PROVIDER");
				int weight = rs.getInt("WEIGHT");
				String color = rs.getString("COLOR");
				System.out.printf("제품명 : %s \n", name);
				System.out.printf("제조사 : %s \n", company);
				System.out.printf("가격 : %d \n", price);
				System.out.printf("통신사 : %s \n", provider);
				System.out.printf("무게 : %d \n", weight);
				System.out.printf("색상 : %s \n", color);
				System.out.printf("** \n");
				System.out.printf("** \n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertSmartPhone(String name, String company, int price, String provider, int weight, String color) {
		String SQL = "INSERT INTO SMARTPHONE(NAME, COMPANY, PRICE, PROVIDER, WEIGHT, COLOR) VALUES (?,?,?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, name);
			pstmt.setString(2, company);
			pstmt.setInt(3, price);
			pstmt.setString(4, provider);
			pstmt.setInt(5, weight);
			pstmt.setString(6, color);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateSmartPhone(int price, String name, String provider) {
		String SQL = "UPDATE SMARTPHONE SET PRICE = ? WHERE NAME = ? AND PROVIDER = ?";

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setInt(1, price);
			pstmt.setString(2, name);
			pstmt.setString(3, provider);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteSmartPhone(String name, String provider) {
		String SQL = "DELETE FROM SMARTPHONE WHERE NAME = ? AND PROVIDER = ?";

		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, name);
			pstmt.setString(2, provider);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
