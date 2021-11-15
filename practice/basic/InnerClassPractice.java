package practice.basic;



public class InnerClassPractice {

	public static void main(String[] args) {
		System.out.println("==static class===");
		System.out.println(Test.StaticInner.cv);
		System.out.println(Test.cvOut);
//		System.out.println(Test.LocalInner.CONST); // 지역내부클래스는 메서드 내에서만 접근가능
		Test.StaticInner si = new Test.StaticInner(); //외부클래스 먼저 생성하지 않아도 스태틱 내부클래스 인스턴스 생성가능.
		
		System.out.println("===instance class=======");
		System.out.println(Test.InstanceInner.cv);
		Test t = new Test();
		Test.InstanceInner li = t.new InstanceInner(); // 인스턴스내부클래스는 외부 클래스 먼저 생성해야지 가능.
		
		System.out.println(t.ivOut);
		System.out.println(t.cvOut);
		
		
	}

}

class Test{
	int ivOut = 55;
	static int cvOut = 200;
	InstanceInner ii = new InstanceInner();
	static StaticInner si = new StaticInner();
//	static StaticInner si2 = new InstanceInner(); // static 멤버는 인스턴스 멤버 사용 불가능. 
	
	class InstanceInner{
		int iv = ivOut;
		
		//static int cv =100;
		 final static int cv = 100;
	}
	
	static class StaticInner{
		int iv = 110;
//		int iv2 = ivOut; // static 내부클래스에서는 외부 클래스의 인스턴스 멤버에 접근할 수 없다.
		static int cv =90;
		 final static int cvf = 7;
		
		
	}
	
	void mymethod() {
		class LocalInner{
			int iv =50;
//			static cv = 5;
			final static int CONST =300;
		}
	}
}
