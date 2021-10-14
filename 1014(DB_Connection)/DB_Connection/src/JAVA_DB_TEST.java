import java.util.Scanner;

public class JAVA_DB_TEST {

	public static void main(String[] args) {
		DB_Connection db = new DB_Connection();
		// DB_Connection��ü �����ϸ� ������ ���ο��� �����Ѵ�.
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
				System.out.print("�̸� �Է�:");
				name = sc.next();
				db.SearchByName(name);
			} else if (choice == 3) {
				// ������ ����(�߰�)
				System.out.print("��ȣ �Է�:");
				no = sc.nextInt();
				System.out.print("�̸� �Է�:");
				name = sc.next();
				System.out.print("���� �Է�:");
				age = sc.nextInt();
				System.out.print("Ű �Է�:");
				height = sc.nextDouble();
				db.InsertPerson(no, name, age, height);
			} else if (choice == 4) {
				// ����
				System.out.print("�̸� �Է�: ");
				name = sc.next();
				System.out.print("���� �Է�: ");
				age = sc.nextInt();
				db.UpdatePerson(name, age);
			} else if (choice == 5) {
				System.out.print("�̸� �Է�");
				name = sc.next();
				db.DeletePerson(name);
			}
		}
	}
}
