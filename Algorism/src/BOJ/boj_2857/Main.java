package boj_2857;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 백준 온라인 저지 2857번 <FBI>문제 풀이
 * 
 * @see https://www.acmicpc.net/submit/2857
 * @author yeeeah_j
*/
public class Main {
	
	public static void main(String[] args) throws IOException{
		final String FBI ="FBI";
		final String SPACE =" ";
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int i =1; i<=5;i++){
			if(br.readLine().contains(FBI)){
				sb.append(i).append(SPACE);
			}
		}
		
	
		System.out.println(sb.length()==0? "HE GOT AWAY!":sb.toString());
	}
}
