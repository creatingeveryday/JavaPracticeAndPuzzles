package practice.basic;

public class Thread_Practice {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new ThreadA());
		Thread t2 = new Thread(new ThreadB());
		
		t1.start();
		t2.start();
		
//		try {
//			t1.join(); // main 쓰레드가 th1 작업이 끝날때 까지 기다린다. 
//			t2.join(); // main 쓰레드가 th1 작업이 끝날때 까지 기다린다. 
//		} catch (InterruptedException e) {
//			
//			e.printStackTrace();
//		}
		System.out.println("메인");
		System.out.println(Thread.currentThread().getName()); //main 메서드가 종료되도 다른 쓰레드가 있으면 프로그램은 종료되지 않음.
		
		System.out.println("===========================");
		
		
		
	}

}

class ThreadA implements Runnable{
	public void run() {
		for(int i =0; i<500;i++)
			System.out.print("|");
	}
}
class ThreadB implements Runnable{
	public void run() {
		for(int i =0; i<500;i++)
			System.out.print("-");
	}
}
