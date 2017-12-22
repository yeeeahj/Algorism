package boj_9933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 온라인 저지 9933번 <민균이의 비밀번호> 문제
 * 
 * @see https://www.acmicpc.net/problem/9933
 * @author yeeeah_j
 */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		String[] passwords = new String[cnt];

		for (int i = 0; i < cnt; i++) {
			passwords[i] = br.readLine();
		}

		for (int i = 0; i < cnt; i++) {
			int size = passwords[i].length();
			for (int j = 0; j < cnt; j++) {
				if (i == j && passwords[i].length() != passwords[j].length())
					break;
				boolean isPass = true;
				for (int k = 0; k < size; k++) {
					if (passwords[j].charAt(size - 1 - k) != passwords[i].charAt(k)) {
						isPass = false;
						break;
					}
				}
				if(isPass){
					System.out.println(size+ " "+passwords[i].charAt(size/2));
					return;
				}
			}
		}

	}

}
