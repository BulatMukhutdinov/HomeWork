package s02e10;

import java.util.Scanner;

public class BoyerMooreHorspool {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str1, str2;
		str1 = in.nextLine();
		str2 = in.nextLine();
		char[] s = str1.toCharArray(), t = str2.toCharArray();
		int a[] = new int[256];
		for (int i = 0; i < 256; i++) {
			a[i] = t.length;
		}
		for (int i = t.length - 1; i >= 0; i--) {
			a[t[i]] = i + 1;
		}
		int i = 0, q = 1;
		while (q != t.length + 1 && i != s.length - t.length + 1) {
			if (t[t.length - q] == s[i + t.length - q]) {
				q++;
			} else {
				i += a[s[i + t.length - q]];
				q = 1;
			}
		}
		if (i == s.length - t.length + 1)
			i = -1;
		System.out.println(i);
	}
}