package s02e09;

import java.util.Scanner;

public class Vagner {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1, s2, str1, str2;
		s1 = in.nextLine();
		s2 = in.nextLine();
		int q = 1;
		int n = s1.length(), m = s2.length();
		int[][] d = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			d[i][0] = i;
		}
		for (int i = 0; i <= m; i++) {
			d[0][i] = i;
		}
		for (int i = 1; i <= n; i++) {
			str1 = s1.substring(0, i);
			for (int j = 1; j <= m; j++) {
				str2 = s2.substring(0, j);

				if (str1.charAt(i - 1) == str2.charAt(j - 1))
					q = 0;

				d[i][j] = Math.min(Math.min(d[i - 1][j], d[i][j - 1]),
						d[i - 1][j - 1]) + q;
			}
			q = 1;

		}

	/*	for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				System.out.print(d[i][j] + " ");	//Вывод матрицы
			}
			System.out.println();
		}*/
		System.out.println(d[n][m]);
	}

}