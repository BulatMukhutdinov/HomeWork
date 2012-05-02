package s02e06;

public class Queue {
	Object[] data = new Object[1000];
	int size = 0;
	int num = 0;

	public Queue() {
		
	}

	public void push(Object a) {

		try {
			data[size] = a;
		} catch (QueueException e) {
			System.out.println("Exception");
		}
		size++;
	}

	public Object pop() {
		size--;
		num++;
		if (size >= 0)
			return data[num - 1];
		return null;
	}

	public int size() {

		return size;
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	public Object show(int i) {
		if (size > i && i >= 0 && size != 0)
			return data[i];
		return null;
	}

}
