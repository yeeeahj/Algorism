package boj_10988;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * ���� �¶��� ���� ���� 10988 <�縰������� Ȯ��>
 * 
 * @see https://www.acmicpc.net/probolem/10988
 * @author yeeeah_j
*/public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		System.out.println(word);
		int size = word.length();
		boolean palen = true;
		;
		for (int i = 0; i < size / 2; i++) {
			if (word.charAt(i) != word.charAt(size - i - 1)) {
				palen = false;
				break;
			}
		}
		if (palen)
			System.out.println("1");
		else
			System.out.println("0");
	}

}
