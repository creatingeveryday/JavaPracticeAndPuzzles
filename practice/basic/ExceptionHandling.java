package practice.basic;

import java.io.File;

public class ExceptionHandling {

	public static void main(String[] args) {
		int[] arr = new int[0];
		Throwable t;
		
		// 예외 처리 목적: 비정상 종료를 막고 정상적인 실행상태를 유지하기 위해서.
		
		
		try {
			
			File f = createFile("");
			System.out.println(f.getName()+"파일이 성공적으로 생성되었습니다.");
			Child c = new Child();
			c.method2();
//			System.out.println(arr[1]);
//			System.out.println(1/0);
			
			Exception e = new Exception("고의로 발생시킴.");// 고의로 예외 클래스의 객체를 만든다음.
			throw e; //키워드 throw를 이용해서 예외 발생가능.
//			throw new Exception("고의로 발생시켰다.");  //한줄로도 표현가능.
			
			
		// 처리하고자하는 예외와 같은 타입의 참조변수 선언.
		// 예외가 발생하면 발생한 예외에 해당하는 클래스가 생성되며,해당클래스로 instanceof 연산한 결과 값이 true인 catch블럭을 만나면 예외가 처리됨.
		// catch블록과 생성된 예외 객체 일치시, 참조변수에 생성된 예외 객체 주소값이 저장되고 참조변수를 통해 예외 객체의 정보에 접근할 수 있게된다.
		} catch (ArithmeticException | ArrayIndexOutOfBoundsException ae) {
			System.out.println("@ae 처리");
			System.out.println(ae.getMessage());
			ae.printStackTrace(); //조상 예외클래스에 선언된 멤버만 사용가능.
			
			
			
		} catch (Exception e) { //모든 예외의 최고조상. 모든 예외처리가능.
			if (e instanceof ArrayIndexOutOfBoundsException)
				System.out.println("true");
			
			System.out.println("getMessage(): "+e.getMessage());
			System.out.println("toString(): "+e.toString());
			e.printStackTrace();
			
		} finally {
			System.out.println("@finally");
		}
		
		
	}
	
	static File createFile(String filename) throws Exception {
		if(filename==null || filename.equals(""))
			throw new Exception("유효하지않은 파일이름입니다.");
		File f = new File(filename);
		f.createNewFile();
		return f;
	}
	
	

}

class Parent1 {
	void method() throws Exception  {  //throws 키워드로 메서드내에서 발생할 수 있는 예외를 표시할 수 있다. 견고한 코드 구축에 도움이되는 기능.
		System.out.println("부모메서드에서 자신을 호출한 메서드에게 예외 전달,떠넘기기,(처리되는게아니다.)");
		throw new Exception("부모메서드에서 발생");
	}
}

class Child extends Parent1{
	void method() throws Exception {
		System.out.println("자식메서드에서 자신을 호출한 메서드에게 예외 전달,떠넘기기(전달만 할뿐 처리되는게 아니다.)");
		throw new Exception("자식메서드에서 발생");
	}
	
	void method2() throws Exception{  //결과적으로 예외가 처리되어 main메서드로 예외를 전달하지 않음.
		try {
			throw new Exception("method2에서 날림.");
		}catch(Exception e){
			System.out.println("method2에서 예외가 처리됨.");
			e.printStackTrace();
		}
	}
}



