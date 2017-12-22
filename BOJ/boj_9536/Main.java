package boj_9536;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.LinkedList;
/**
 * 백준 온라인 저지 9536번 (여우는 어떻게 울지?) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/9536
 * @author yeeeah_j
 */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		final String LAST = "what does the fox say?";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		

		while (testCase-- > 0) {
			StringBuilder sb = new StringBuilder();
			String[] sounds = br.readLine().split(" ");
			String line;
			while (!((line = br.readLine()).equals(LAST))) {
				for (int j = 0; j < sounds.length; j++) {
					if (sounds[j].equals(line.split(" ")[2])) {
						sounds[j] = "";
					}
				}

			}
			for (int j = 0; j < sounds.length; j++) {
				if (sounds[j].length() != 0) {
					if (j == sounds.length - 1) {
						sb.append(sounds[j]);
					} else {
						sb.append(sounds[j]).append(" ");
					}
				}
			}

			System.out.println(sb.toString());

		}
		br.close();
	}

}
