package practice.basic;

public class InterfacePractice {

	public static void main(String[] args) {
		//인터페이스를 이용해 선언과 구현을 분리해 캡슐화,코드중복제거,관리가 편해질 수 있다. 
		A a = new A();
		a.autoPlay(new B());
		//a.autoPlay(new C()); // C클래스를 사용하려면 A클래스의 내용을 변경해야함. 
		
		System.out.println("====인터페이스 활용후  : 인터페이스 I를 구현한 클래스를 동적으로 제공받음. =====");
		
		A_new newA = new A_new();
		newA.autoPlay(new B());
		newA.autoPlay(new C()); //A클래스의 내용 변경 없이 새로운 C클래스도 사용가능. 
		
		//InstanceManager 제3의 클래스 활용.
		System.out.println("==InstanceManager클래스를 이용해 인터페이스 구현할 클래스를 제공받아 사용 ==");
		A_new2 a2 = new A_new2();
		a2.methodA();
		//main 메서드 안에서도 A클래스 관련해서 내용수정 필요 없음. 
		//나중에 B가 아닌 다른 클래스의 인스턴스로 변경되어도 getInstance의 내용만 변경하면 됨. 
		//JDBC 이런식으로 작동?
		
		I.jump(); //인터페이스의 스테틱  메서드 
		
		
		
	}

}
interface I {
	public abstract void play();
	
	//예외 : 나중에 추가 변경사항이 생겼을 때 : static method 
	//추가로 간단한 기능 구현가능? 
	public static void jump() {
		System.out.println("점프!!");
	}
	
	//예외 : 나중에 추가변경사항이 생겼을때 : default method
	//추상 메서드가 아니므로 디폴트 메서득사 새로 추가되어도 해당 인터페이스를 구현한 기존 클래스를 변경하지 않아도됨.
	public default void newMethod() {
		System.out.println("newMethod 변경추가됨.");
	}
}

class Parent {
	public void newMethod() {
		System.out.println("Parent의 newMethod");  //디폴트 메서드와 조상클래스의 메서드간 충돌시 조상클래스가 상속되어 적용.
	}
}


class InstanceManager{
	public static I getInstance() {
		return new B();   // <- 반환하는 객체만  변경해주면 됨. 
	}
}

class A_new2{ //개선
	void methodA(){
		I i = InstanceManager.getInstance();
		i.play();
		i.newMethod();  //디폴트메서드 추가 
		System.out.println(i.toString());
		
	}
}

class A {
	void autoPlay(B b) {
		b.play();
		
		
	}
}
// A클래스를 개선작업한 클래스 작성. A->I->B관계로 변경 
class A_new{  //개선 
	void autoPlay(I i ) {
		i.play();
		
	}
}



class B extends Parent implements I{
	public void play() {
		System.out.println("Play in B Class");
	}
	
	public String toString() {
		return "class B";
	}
}

class C implements I{
	public void play() {
		System.out.println("Play in C Class");
	}
	public String toString() {
		return "class C";
	}
}

