package boj_11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int moneyKinds = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		int[] moneyList = new int[moneyKinds];
		for (int i = 0; i < moneyKinds; i++) {
			moneyList[i] = Integer.parseInt(br.readLine());
		}

		int num = 0;
		int j = moneyKinds - 1;
		while (goal > 0) {
			if (goal < moneyList[j]) {
				j--;
			} else {
				goal -= moneyList[j];
				num++;
			}
		}
		System.out.println(num);
	}
}