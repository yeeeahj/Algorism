package boj_11720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		String inputString = br.readLine();
		int sum = 0;
		for (int i = 0; i < num; i++) {
			sum += inputString.charAt(i) - '0';
		}
		System.out.println(sum);
	}
}