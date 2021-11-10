package practice.basic;

public class ClassSuperAndThis {

	 static public void main(String[] arg) {
		Car c = new Car("테슬라", 5000000, 1600);
		System.out.println(c.name);
		System.out.println(c.price);
		System.out.println(c.weight);
		System.out.println(c);
		System.out.println("------------------");
		Car ca = new Car();
		System.out.println(ca.name);
		System.out.println(ca.price);
		System.out.println(ca.weight);
		System.out.println(ca);
		
		Machine m = new Machine();
		System.out.println(m);
		
		Machine ma = new Machine();
		Machine mau = null;
		Car car = null;
		
//		car = (Car)ma;  // 조상타입객체를 자손타입 참조변수로 접근하면 컴파일 오류 발생. 
		
		
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
	@Override
	public String toString() {
		return "Machine 클래스" +weight;
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
	@Override
	public String toString() {
		
		return "Car클래스입니다. "+ name +", "+ price +","+weight;
	}
	
	void bbang() {
		System.out.println("빵빵빵");
	}
}