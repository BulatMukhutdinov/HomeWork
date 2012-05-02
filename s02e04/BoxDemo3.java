package s02e04;

public class BoxDemo3 {

	public static void main(String[] args) {
		Box<String> strBox = new Box<String>();
		strBox.add(new String("10"));
		// no cast!
		String someStr = strBox.get();
		System.out.println(someStr);
	}
}