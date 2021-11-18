package practice.basic;

public class ExceptionHandling {

	public static void main(String[] args) {
		int[] arr = new int[0];
		Throwable t;
		// 예외 처리 목적: 비정상 종료를 막고 정상적인 실행상태를 유지하기 위해서.
		try {
			System.out.println(arr[1]);
			System.out.println(1/0);
			
			
			
			
		// 처리하고자하는 예외와 같은 타입의 참조변수 선언.
		// 예외가 발생하면 발생한 예외에 해당하는 클래스가 생성되며,해당클래스로 instanceof 연산한 결과 값이 true인 catch블럭을 만나면 예외가 처리됨.
		// catch블록과 생성된 예외 객체 일치시, 참조변수에 생성된 예외 객체 주소값이 저장되고 참조변수를 통해 예외 객체의 정보에 접근할 수 있게된다.
		} catch (ArithmeticException ae) {
			System.out.println("@ae 처리");
			System.out.println(ae.getMessage());
			
			
		} catch (Exception e) { //모든 예외의 최고조상. 모든 예외처리가능.
			if (e instanceof ArrayIndexOutOfBoundsException)
				System.out.println("true");
			System.out.println("@e 처리");
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		} finally {
			System.out.println("@finally");
		}

	}

}
