import java.util.Scanner;

public class JAVA_DB_TEST {

	public static void main(String[] args) {
		DB_Connection db = new DB_Connection();
		// DB_Connection객체 생성하면 생성자 내부에서 연결한다.
		int choice = 0;
		int no = 0;
		String name = "";
		int age = 0;
		double height = 0;

		Scanner sc = new Scanner(System.in);
		while (true) {
			MenuClass.menu();
			choice = sc.nextInt();
			if (choice == 1) {
				db.Search();
			} else if (choice == 2) {
				System.out.print("이름 입력:");
				name = sc.next();
				db.SearchByName(name);
			} else if (choice == 3) {
				// 데이터 삽입(추가)
				System.out.print("번호 입력:");
				no = sc.nextInt();
				System.out.print("이름 입력:");
				name = sc.next();
				System.out.print("나이 입력:");
				age = sc.nextInt();
				System.out.print("키 입력:");
				height = sc.nextDouble();
				db.InsertPerson(no, name, age, height);
			} else if (choice == 4) {
				// 수정
				System.out.print("이름 입력: ");
				name = sc.next();
				System.out.print("나이 입력: ");
				age = sc.nextInt();
				db.UpdatePerson(name, age);
			} else if (choice == 5) {
				System.out.print("이름 입력");
				name = sc.next();
				db.DeletePerson(name);
			}
		}
	}
}
