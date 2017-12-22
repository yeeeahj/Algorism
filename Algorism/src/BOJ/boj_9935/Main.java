package boj_9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 문제 9935 <문자열 폭발> 
 * 
 * @see https://www.acmicpc.net/problem/9935
 * @author yeeeah_j
*/
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] array = br.readLine().toCharArray();
		char[] boom = br.readLine().toCharArray();
		char[] stack = new char[array.length];
		int tos = -1;

		for (int i = 0; i < array.length; i++) {
			stack[++tos] = array[i];

			boolean isBoom = true;
			for (int j = 0; j < boom.length; j++) {
				if (stack[tos - j] != boom[boom.length - j - 1]) {
					isBoom = false;
					break;
				}
			}
			if (isBoom) {
				tos -= boom.length;
			}

		}
		StringBuilder sb = new StringBuilder();
		for (int k = 0; k <= tos; k++) {
			sb.append(stack[k]);
		}

		System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
	}
}
