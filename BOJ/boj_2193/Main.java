package boj_2193;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int unit = Integer.parseInt(br.readLine());
		if (unit == 1 || unit == 0) {
			System.out.println("1");
		}else{
			long pinary[] = new long[unit];
			pinary[0] = 1;
			pinary[1] = 1;
			for (int i = 2; i < unit; i++) {
				pinary[i] = pinary[i - 1] + pinary[i - 2];
			}
			System.out.println(pinary[unit - 1]);
		}
	}
}
