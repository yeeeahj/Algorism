package boj_10987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 	백준 온라인 저지 문제 10987 <모음의 개수 > 
 * 
 * @see https://www.acmicpc.net/problem/10987
 * @author yeeeah_j
*/
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();
		int index = 0;
		int mCnt = 0;
		while (word.length() > index) {
			switch (word.charAt(index)) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				mCnt++;
				break;
			default:
			}
			index++;
		}
		System.out.println(mCnt);

	}
}
