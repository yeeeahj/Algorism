package boj_1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] triangle = new int[n][n];
		int[][] dp = new int[n][n];
		StringTokenizer st;
		String line;
		int maxValue = 0;
		for (int i = 0; i < n; i++) {
			line = br.readLine();
			st = new StringTokenizer(line, " ");
			for (int j = 0; j < i + 1; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());

				if (i == 0) {
					dp[i][j] = triangle[i][j];
				} else if (j == 0) {
					dp[i][j] = dp[i - 1][j] + triangle[i][j];
					if (i == n - 1) {
						maxValue = dp[i][j];
					}
				} else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
					if (i == n - 1) {
						maxValue = Math.max(maxValue, dp[i][j]);
					}
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
					if (i == n - 1) {
						maxValue = Math.max(maxValue, dp[i][j]);
					}
				}
			}
		}
		System.out.println(maxValue);
	}

}
