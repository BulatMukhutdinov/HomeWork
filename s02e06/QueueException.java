package s02e06;

@SuppressWarnings("serial")
public class QueueException extends RuntimeException  {

	public void cause(){
		System.out.println("Queue is empty");
	}
}
