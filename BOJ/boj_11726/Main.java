package boj_11726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		int n =  Integer.parseInt(br.readLine());
		int[] dp = new int[n+1]; 
		if(n == 1 || n ==2){
			System.out.println(n);
		}else{
			dp[1]= 1;
			dp[2] = 2;
			for(int i = 3; i <=n;i++){
				dp[i] = dp[i-1]+ dp[i-2];
				dp[i] = dp[i] % 10007;
			}
			System.out.println(dp[n]);
		}
	}

}
