package com.appgate.prueba.detector.utils;


public class SimilarityUtil {

	private static int min(int one, int two, int three) {
		int min = one;
		if (two < min) {
			min = two;
		}
		if (three < min) {
			min = three;
		}
		return min;
	}

	public static int ld(String str1, String str2) {
		int d[][]; // Matriz
		int n = str1.length();
		int m = str2.length();
		int i; // transversal str1
		int j; // transversal str2
		char ch1; // str1
		char ch2; // str2
		int temp; // Graba el mismo carácter, el incremento del valor en una determinada posición
					// de la matriz, 0 o 1
		if (n == 0) {
			return m;
		}
		if (m == 0) {
			return n;
		}
		d = new int[n + 1][m + 1];
		for (i = 0; i <= n; i++) {// Inicializa la primera columna
			d[i][0] = i;
		}
		for (j = 0; j <= m; j++) {// inicializa la primera línea
			d[0][j] = j;
		}
		for (i = 1; i <= n; i++) {// transversal str1
			ch1 = str1.charAt(i - 1);
			// Para que coincida con str2
			for (j = 1; j <= m; j++) {
				ch2 = str2.charAt(j - 1);
				if (ch1 == ch2) {
					temp = 0;
				} else {
					temp = 1;
				}
				// Izquierda +1, superior +1, esquina superior izquierda + temp toma mínimo
				d[i][j] = min(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + temp);
			}
		}
		return d[n][m];
	}

	public double sim(String str1, String str2) {
		int ld = ld(str1, str2);
		return 1 - (double) ld / Math.max(str1.length(), str2.length());
	}

}