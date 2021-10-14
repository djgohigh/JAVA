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
				System.out.print("## 제품 전체조회 \n");
				db.Search();
			} else if (choice == 2) {
				System.out.print("## 제품명 검색 \n");
				System.out.print("제품명 입력: ");
				word = sc.next();
				db.searchByName(word);
			} else if (choice == 3) {
				System.out.print("## 제품 DB 삽입 \n");
				System.out.print("제품명 입력: ");
				name = sc.next();
				System.out.print("제조사 입력: ");
				company = sc.next();
				System.out.print("가격 입력: ");
				price = sc.nextInt();
				System.out.print("통신사 입력: ");
				provider = sc.next();
				System.out.print("무게 입력: ");
				weight = sc.nextInt();
				System.out.print("색상 입력: ");
				color = sc.next();
				db.insertSmartPhone(name, company, price, provider, weight, color);
			} else if (choice == 4) {
				// 수정
				System.out.print("## 제품 가격수정 \n");
				System.out.print("제품명 입력: ");
				name = sc.next();
				System.out.print("통신사 입력: ");
				provider = sc.next();
				System.out.print("가격 입력: ");
				price = sc.nextInt();
				db.updateSmartPhone(price, name, provider);
			} else if (choice == 5) {
				System.out.print("## 제품 삭제 \n");
				System.out.print("제품명 입력: ");
				name = sc.next();
				System.out.print("통신사 입력: ");
				provider = sc.next();
				db.deleteSmartPhone(name, provider);
			}
		}
	}
}