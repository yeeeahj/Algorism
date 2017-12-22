package boj_9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		int dp[] = new int[11];

		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 4;
		for (int i = 3; i < 11; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		while (testCase-- > 0) {
			int n = Integer.parseInt(br.readLine());

			sb.append(dp[n-1]).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
}
