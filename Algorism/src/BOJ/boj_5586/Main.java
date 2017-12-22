package boj_5586;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 백준 온라인 저지 5586 <JOI 와 IOI>문제풀이
 * 
 * @SEE https://www.acmicpc.net/submit/5586
 * @author yeeeah_j
*/
public class Main {
	public static void main(String[] args) throws IOException {
	
		int jcount = 0;
		int icount = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s = br.readLine().toCharArray();
		
		for (int i = 1; i <= s.length - 2; i++) {
			if(s[i]=='O' && s[i+1]=='I'){
				if(s[i-1]=='J'){
					jcount++;
					i++;
				}else if(s[i-1]=='I'){
					icount++;
					i++;
				}
			}
		}
		System.out.println(jcount+"\n"+icount );
	}
}
