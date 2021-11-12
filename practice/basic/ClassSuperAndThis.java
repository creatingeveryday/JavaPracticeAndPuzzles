package practice.basic;

import java.util.Vector;

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
		
		System.out.println("-----------------");
		Cat c1 = new Cat("naty",135);
		Cat c2 = new Cat("naty",135);
		Cat c3 = new Cat("naty",135);
		
		Dog d1 = new Dog();
		System.out.println(c1.name);
		System.out.println(c1.id);
		System.out.println(c1.address);
		System.out.println(Cat.age+"살");
		System.out.println(c1.catCount +"마리");
		System.out.println(c2.catCount +"마리");
		System.out.println(Animal.count +"마리");
		
		System.out.println("-----------------");
		
		Card card = new Card("HEART", 10);
		System.out.println(card);
		
		System.out.println("-----------------");
		
		Car t = new Car();
//		FireEngine f = (FireEngine) t;  // 실행시  ClassCastException 발생. 
		Car f = new FireEngine(); //가능  형변환 생략.
		FireEngine f2 = (FireEngine)f; //가능.
		System.out.println(t instanceof FireEngine);  //false
		System.out.println(t instanceof Car);  //ture
		System.out.println(t instanceof Object);  //ture
		System.out.println("-----");
		
		Vector<String> v = new Vector<String>();
		v.add("tv");
		v.add("tv");
//		v.add(55);
		v.add("computer");
		System.out.println(v);
		System.out.println(v.get(2));
		System.out.println(v.remove("tv"));
		System.out.println(v);
		
		Fighter warrior = new Fighter();
		Monster mon = new Monster();
		warrior.attack(new Monster());
		warrior.attack(new Monster());
		warrior.attack(new Monster());
		System.out.println(warrior.count);
	}

}
interface Movable{
	public abstract void move(int x, int y);
}
interface Attackable{
	public abstract void attack(Fightable f);
}

interface Fightable extends Movable, Attackable{
	
}
class Monster implements Fightable{
	String name;
	static int count;
	public Monster() {
		this.name = "Monster"+ count++;
	}
	
	public void move(int x, int y) {
		System.out.println(""+x+y+"로 이동했다. ");
	}
	public void attack(Fightable f) {
		System.out.println(""+f+"를 공격했다.");
	}
	public String toString() {
		return this.name;
	}
}

class Fighter implements Fightable{
	String name;
	static int count;
	public Fighter() {
		this.name = "Outer"+ count++;
	}
	 public void move(int x, int y) {
		System.out.println(""+x+y+"로 이동했다. ");
	}
	public void attack(Fightable f) {
		System.out.println(this.name+"가 "+f+"를 공격했다.");
	}
	public String toString() {
		return this.name;
	}
}


abstract class Player{
	boolean pause;
	int currentPos;
	public Player() {
		pause = false;
		currentPos = 0;
		
	}
	abstract void play(int pos);
	abstract void stop();
	void play(){
		play(currentPos);
	}
	void pause() {
		if(pause) {
			pause = false;
			play(currentPos);
		}else {
			pause = true;
			stop();
		}
	}
} //player class end 


class Card {
	final int NUMBER;
	final String KIND;
	static int width = 100;
	static int heigt = 250;
	
	public Card() {
		this("HEART",1);
	}
	public Card(String kind,int num) {
		KIND = kind;
		NUMBER = num;
	}
	@Override
	public String toString() {	
		return KIND +" " + NUMBER;
	}
	
	
}

class Animal{
	static int count; //생성된 인스턴스의 개수 (자손포함)
	public Animal() {
		++count;
	}
}

class Cat extends Animal{
	static int age;
	int catCount;
	String name;
	int id;
	String address;
	static {//static 초기화 블럭에서는 조건문 반복문 예외처리구문등 자유롭게 사용하여 초기화작업수행가능.
		age=3;
	}
	{ // 인스턴스 초기화 블럭 : 주로 모든 생성자에서 공통으로 수행되어야 하는 코드를 넣는다. 
//		++Animal.count;
		++catCount;
		
		
	}
	
	public Cat() { //생성자 초기화 작업은 인스턴스초기화 블럭보다 나중에 수행된다. 
		
	}
	public Cat(String name, int id) {
		this(name,id,"Seoul");
		age=7;
	}
	public Cat(String name,int id, String address) {
		this.name = name;
		this.id = id;
		this.address = address;
	}
}

class Dog extends Animal{
	public Dog() {
		System.out.println("강아지를 발견");
		
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

class FireEngine extends Car{
	void water() {
		System.out.println("물을 뿌렸습니다.");
	}
}

class Ambulance extends Car{
	void siren() {
		System.out.println("사이렌을 울립니다.");
	}
}