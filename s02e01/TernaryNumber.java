package s02e01;

public class TernaryNumber extends Number {

	private static final long serialVersionUID = 1L;
	static int num = 0;
	static int pos = 0;
	static boolean mines;
	private String number;

	TernaryNumber(String number) {
		this.number = number;
	}

	public static String inTernary(String str) {
		String str1 = "";
		int num = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				while (i < str.length() && Character.isDigit(str.charAt(i))) {
					num = num * 10 + (str.charAt(i) - '0');
					i++;
				}

				str1 = str1 + translation(num);
				num = 0;
				i--;
			} else {
				str1 = str1 + str.substring(i, i + 1);
			}
		}
		return str1;
	}

	public static int ternary(int a) {
		int b = 0, k = 1;
		while (a / 3 > 0) {
			b = b + a % 3 * k;
			a = a / 3;
			k = k * 10;
		}
		b = b + a * k;
		return b;
	}

	public static int translation(int a) {
		int k = 0, number = 0;
		String str = Integer.toString(a);
		for (int i = 0; i < str.length(); i++) {
			number = (int) (number + a % 10 * Math.pow(3, k));
			k++;
			a = a / 10;
		}
		return number;
	}

	public static double calc(String s) {
		double sum = 0;
		if (s.charAt(pos) == '-') {
			pos++;
			sum = -mul(s);
		} else {
			sum = mul(s);
		}

		while (pos < s.length()
				&& (s.charAt(pos) == '+' || s.charAt(pos) == '-')) {
			if (s.charAt(pos++) == '+') {
				sum += mul(s);
			} else {
				sum -= mul(s);
			}

		}
		return sum;

	}

	public static double mul(String s) {
		double mul = parse(s);
		while (pos < s.length()
				&& (s.charAt(pos) == '*' || s.charAt(pos) == '/')) {
			if (s.charAt(pos++) == '*') {
				mul *= parse(s);
			} else {
				mul /= parse(s);
			}
		}
		return mul;
	}

	public static double parse(String s) {
		if (pos < s.length() && s.charAt(pos) == '(') {
			pos++;
			double d = calc(s);
			pos++;
			return d;
		}

		StringBuilder sb = new StringBuilder();

		while (pos < s.length() && s.charAt(pos) >= '0' & s.charAt(pos) <= '9') {
			sb.append(s.charAt(pos));
			pos++;
		}

		return Double.valueOf(sb.toString());

	}

	public double doubleValue() {
		double a;
		a = Double.parseDouble(this.number);
		return a;
	}

	public float floatValue() {
		float a;
		a = (float) Double.parseDouble(this.number);
		return a;
	}

	public int intValue() {
		int a;
		a = Integer.parseInt(this.number);
		return a;
	}

	public long longValue() {
		long a;
		a = Integer.parseInt(this.number);
		return a;
	}
}
