package boj_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int R = 0;
	private static int G = 1;
	private static int B = 2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int houseNum = Integer.parseInt(br.readLine());

		int cost[][] = new int[houseNum][3];
		int dp[][] = new int[houseNum][3];
		for (int i = 0; i < houseNum; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][R] = cost[0][R];
		dp[0][G] = cost[0][G];
		dp[0][B] = cost[0][B];
		for (int k = 1; k < houseNum; k++) {
			for (int n = 0; n < 3; n++) {
				dp[k][n] = Math.min(dp[k - 1][(n + 1) % 3], dp[k - 1][(n + 2) % 3]) + cost[k][n];
			}
		}
		int minCost = Math.min(Math.min(dp[houseNum - 1][R], dp[houseNum - 1][G]), dp[houseNum - 1][B]);
		System.out.println(minCost);
	}

}
