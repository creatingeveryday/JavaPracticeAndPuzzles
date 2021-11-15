package practice.basic;

import java.util.Scanner;
import java.util.Vector;

public class AddressMangement {

	public static void main(String[] args) {
		AddressBook book = null;
		Scanner s = new Scanner(System.in);

		System.out.print("사용할 언어를 선택해 주세요(한국어 0, English 1)");
		int inputLang = s.nextInt();
		if (inputLang == 0) {
			book = new AddressBookKor();
		} else if (inputLang == 1) {
			book = new AddressBookEng();
		}

		while (true) {
			book.displayMenu();
			int selectMenu = s.nextInt();

			if (0 == selectMenu) {
				book.addRecord(); // 이름 ,전화번호
				continue;
			}

			if (1 == selectMenu) {
				book.getRecord();// "찾으려는 값"
				continue;
			}
			if (2 == selectMenu) {
				book.delRecord();// "삭제하려는 값"
				continue;
			}

			if (3 == selectMenu) {
				System.out.println(3);
				break;
			} else {
				System.out.println("다시 입력해주세요.");
				continue;
			}

		} // while

	}// main

}

class Entity {
	String name;
	String tel;

	public Entity() {
	}

	public Entity(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}

}

abstract class AddressBook {
	Vector phoneBook = new Vector();

	abstract void addRecord();

	abstract void getRecord();

	abstract void delRecord();

	abstract void displayMenu();
}

class AddressBookKor extends AddressBook {

	@Override
	void displayMenu() {
		System.out.println("[메 뉴]");
		System.out.println("0. 새 내용을 추가");
		System.out.println("1. 검색");
		System.out.println("2. 삭제");
		System.out.println("3. 종료");
		System.out.print("메뉴를 선택하세요 : ");

	}

	@Override
	void addRecord() {
		Scanner s = new Scanner(System.in);
		System.out.print("이름을 입력하세요.>");
		String name = s.nextLine().trim();
		System.out.print("전화번호를 입력하세요.(010-0000-0000)>");
		String phoneNum = s.nextLine().trim();
		phoneBook.add(new Entity(name, phoneNum));
		

	}

	@Override
	void getRecord() {
		Scanner s = new Scanner(System.in);
		int count = 0;

		System.out.print("찾고싶은 이름 또는 전화번호를 입력하세요.>");
		String value = s.nextLine().trim();
		for (int i = 0; i < phoneBook.size(); i++) {
			Object o = phoneBook.get(i);
			String name = "";
			String tel = "";
			if (o instanceof Entity) {
				Entity e = (Entity) o;
				name = e.name;
				tel = e.tel;
			}
			if (value.equalsIgnoreCase(name) || value.equalsIgnoreCase(tel)) {
				System.out.println(name + ": " + tel);
				count++;
			}
		} // for
		
		if(count==0) System.out.println("찾을 수 없습니다. 다시 시도하세요.");
		
	}

	@Override
	void delRecord() {
		Scanner s = new Scanner(System.in);
		int count = 0;
		
		System.out.print("삭제하려는 이름을 입력하세요.>");
		String value = s.nextLine().trim();
		
		for (int i = 0; i < phoneBook.size(); i++) {
			Object o = phoneBook.get(i);
			String name = "";
			if (o instanceof Entity) {
				Entity e = (Entity) o;
				name = e.name;
			}
			if (value.equalsIgnoreCase(name)) {
				System.out.println(name+"이 삭제됬습니다.");
				phoneBook.remove(i);
				count++;
			}
		} // for
		
		if(count==0) System.out.println("삭제하려는 이름을 찾을 수 없습니다. 다시 시도해보세요.");
		

	}

}

class AddressBookEng extends AddressBook {

	@Override
	void displayMenu() {
		System.out.println("[MENU]");
		System.out.println("0. Add new record");
		System.out.println("1. Search");
		System.out.println("2. Delete");
		System.out.println("3. Quit");
		System.out.print("Select Menu : ");
		

	}

	@Override
	void addRecord() {
		
		Scanner s = new Scanner(System.in);
		System.out.print("Enter name...>");
		String name = s.nextLine().trim();
		System.out.print("Enter phone number... (010-0000-0000)>");
		String phoneNum = s.nextLine().trim();
		phoneBook.add(new Entity(name, phoneNum));
		

	}

	@Override
	void getRecord() {
		Scanner s = new Scanner(System.in);
		int count = 0;

		System.out.print("Do you want to find? Enter name, phoneNumber...>");
		String value = s.nextLine().trim();
		for (int i = 0; i < phoneBook.size(); i++) {
			Object o = phoneBook.get(i);
			String name = "";
			String tel = "";
			if (o instanceof Entity) {
				Entity e = (Entity) o;
				name = e.name;
				tel = e.tel;
			}
			if (value.equalsIgnoreCase(name) || value.equalsIgnoreCase(tel)) {
				System.out.println(name + ": " + tel);
				count++;
			}
		} // for
		
		if(count==0) System.out.println("Oh, Please Try again. I can't find anything.");
		

	}

	@Override
	void delRecord() {
		Scanner s = new Scanner(System.in);
		int count = 0;
		
		System.out.print("Do you want to delete? Please Enter name>");
		String value = s.nextLine().trim();
		for (int i = 0; i < phoneBook.size(); i++) {
			Object o = phoneBook.get(i);
			String name = "";
			if (o instanceof Entity) {
				Entity e = (Entity) o;
				name = e.name;
			}
			if (value.equalsIgnoreCase(name)) {
				phoneBook.remove(i);
				System.out.println(name+"is deleted.");
				count++;
			}
		} // for
		
		if(count==0) System.out.println("Oh, Please Try again. I can't delete anything.");
		

	}

}
