package practice.basic;

public class AnonymousClassPractice {

	public static void main(String[] args) {
		
		System.out.println("======익명클래스 사용시===========");
		Home iv = new Home(){  //Home 클래스를 상속받은 익명 클래스.
			private String address = "남양주시";
			
			public String getAddress() {
				return this.address;
			}
		};
	
		System.out.println(iv.getAddress()); //남양주시
		
		
		
		

	}

}

//단 하나의 클래스를 상속 받거나 단 하나의 인터페이스만을구현할 수 있다. 
class Home {
	private String address = "경기도";
	public String getAddress() {
		return this.address;
	}
}
interface Working {
	abstract void work();
}