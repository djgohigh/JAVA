package smartPhone;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		smartPhoneConnection db = new smartPhoneConnection();
		int choice = 0;
		String name = "";
		String company = "";
		int price = 0;
		String provider = "";
		int weight = 0;
		String color = "";
		String word = "";

		Scanner sc = new Scanner(System.in);
		while (true) {
			menu.menu();
			choice = sc.nextInt();
			if (choice == 1) {
				System.out.print("## ��ǰ ��ü��ȸ \n");
				db.Search();
			} else if (choice == 2) {
				System.out.print("## ��ǰ�� �˻� \n");
				System.out.print("��ǰ�� �Է�: ");
				word = sc.next();
				db.searchByName(word);
			} else if (choice == 3) {
				System.out.print("## ��ǰ DB ���� \n");
				System.out.print("��ǰ�� �Է�: ");
				name = sc.next();
				System.out.print("������ �Է�: ");
				company = sc.next();
				System.out.print("���� �Է�: ");
				price = sc.nextInt();
				System.out.print("��Ż� �Է�: ");
				provider = sc.next();
				System.out.print("���� �Է�: ");
				weight = sc.nextInt();
				System.out.print("���� �Է�: ");
				color = sc.next();
				db.insertSmartPhone(name, company, price, provider, weight, color);
			} else if (choice == 4) {
				// ����
				System.out.print("## ��ǰ ���ݼ��� \n");
				System.out.print("��ǰ�� �Է�: ");
				name = sc.next();
				System.out.print("��Ż� �Է�: ");
				provider = sc.next();
				System.out.print("���� �Է�: ");
				price = sc.nextInt();
				db.updateSmartPhone(price, name, provider);
			} else if (choice == 5) {
				System.out.print("## ��ǰ ���� \n");
				System.out.print("��ǰ�� �Է�: ");
				name = sc.next();
				System.out.print("��Ż� �Է�: ");
				provider = sc.next();
				db.deleteSmartPhone(name, provider);
			}
		}
	}
}