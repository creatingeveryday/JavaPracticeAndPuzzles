package practice.basic;

import java.util.ArrayList;

public class Generics_Practice {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(10);
		list.add(20);
		list.add("30"); //Object 타입 add 문제 없음.
//		Integer i  = (Integer)list.get(2);  //컴파일러의 한계: 컴파일단계에서 에러를 못잡아냄.실행시 에러발생.
		System.out.println("=========Generics 도입 후 ==========");
		//실행시 발생되는 에러를  어떻게하면 컴파일 에러로 미리 잡아낼 수 있을까라는 고민에서 Generics가 도입되었다.
		ArrayList<Object> list3 = new ArrayList<Object>(); // 오브젝트타입객체를 다룰때. 
		ArrayList<Integer> list2 = new ArrayList(); //생성자에 지네릭스 생략가능.(참조변수타입으로부터추정.)
		list2.add(10);
		list2.add(20);
//		list2.add("30"); // 컴파일 에러 발생
		System.out.println(list2);
		
		System.out.println("============Generics 활용 ==================");
		Box<Fruit> fruitBox = new Box<Fruit>();
		Box<Apple> appleBox = new Box<Apple>();
		Box<Grape> grapeBox = new Box<Grape>();
		Box<Toy> toyBox = new Box<Toy>();
		
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		//fruitBox.add(new Toy()); //에러. 
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		
		grapeBox.add(new Grape());
		
		toyBox.add(new Toy());
		System.out.println(fruitBox);
		System.out.println(appleBox);
		System.out.println(grapeBox);
		System.out.println(toyBox);

	}

}

class Fruit 			{ public String toString() { return "Fruit";} }
class Apple extends Fruit { public String toString() { return "Apple";} }
class Grape extends Fruit { public String toString() { return "Grape";} }
class Toy					 { public String toString() { return "Toy";} }
class Box<T> {
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) {list.add(item); }
	T get(int i) {return list.get(i);}
	int size() {return list.size();}
	public String toString() {return list.toString();}
}
