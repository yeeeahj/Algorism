package boj_11721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();

		int cycle = input.length() / 10;
		for (int i = 0; i < cycle; i++) {
			int startIndex = i * 10;
			sb.append(input.substring(startIndex, startIndex + 10)).append("\n");
		}
		sb.append(input.substring(cycle * 10, input.length()));
		System.out.println(sb.toString());
	}
}