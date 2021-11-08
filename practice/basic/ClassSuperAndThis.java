package practice.basic;

public class ClassSuperAndThis {

	public static void main(String[] args) {
		Car c = new Car("테슬라", 5000000, 1600);
		System.out.println(c.name);
		System.out.println(c.price);
		System.out.println(c.weight);
		System.out.println("------------------");
		Car ca = new Car();
		System.out.println(ca.name);
		System.out.println(ca.price);
		System.out.println(ca.weight);

	}

}

class Machine {
	int weight;

	public Machine() {
		System.out.println("부모의 기본생성자");
		this.weight = 1200;
	}

	public Machine(int weight) {
		System.out.println("부모 생성자");
		this.weight = weight;
	}
}

class Car extends Machine {
	String name;
	int price;

	public Car() {
		System.out.println("자식의 기본생성자");
		this.name = "모닝";
		this.price = 10000000;
		this.weight = 1000;
	}

	public Car(String name, int price, int weight) {
		super(weight); // 부모 생성자 호출
		System.out.println("자식생성자");
		this.name = name;
		this.price = price;

	}
}