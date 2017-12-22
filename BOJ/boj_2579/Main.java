package boj_2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int stairNum = Integer.parseInt(br.readLine());

		int stair[] = new int[stairNum];
		int dp[] = new int[stairNum];

		for (int i = 0; i < stairNum; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}

		dp[0] = stair[0];
		dp[1] = Math.max(dp[0], 0) + stair[1];
		dp[2] = Math.max(stair[1], dp[0]) + stair[2];

		for (int j = 3; j < stairNum; j++) {
			dp[j] = Math.max(dp[j - 2], dp[j - 3] + stair[j - 1]) + stair[j];
		}
		
		System.out.println(dp[stairNum - 1]);
	}
}