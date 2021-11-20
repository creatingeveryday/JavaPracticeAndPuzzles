package practice.basic;

public class TryWithResources {

	public static void main(String[] args) {
		try (CloseableResource cr = new CloseableResource()){
			cr.exceptionWork(false);
		}catch(WorkException e) {
			e.printStackTrace();
		}catch(CloseException e) {
			e.printStackTrace();
		}
		System.out.println();
		
		try(CloseableResource cr = new CloseableResource()){
			cr.exceptionWork(true);
		}catch(WorkException e) {
			e.printStackTrace();
		}catch(CloseException e) {
			e.printStackTrace();
		}
		System.out.println();
		

	}

}

class CloseableResource implements AutoCloseable{
	
	public void exceptionWork(boolean exception) throws WorkException{
		System.out.println("exceptionWork("+exception+")가 호출됨.");
		
		if(exception)
			throw new WorkException("workException발생!");
	}
	
	@Override
	public void close() throws CloseException {
		System.out.println("close()가 호출됨");
		throw new CloseException("CloseException 발생! ");
		
	}
	
}

class WorkException extends Exception {
	public WorkException(String msg) {
		super(msg);
	}
}

class CloseException extends Exception {
	public CloseException(String msg) {
		super(msg);
	}
}
