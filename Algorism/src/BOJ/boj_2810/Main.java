package boj_2810;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 백준 온라인 저지 문제 2810 <컵홀더>문제
 * 
 * @see https://www.acmicpc.net/problem/2810
 * @author yeeeah_j
*/
public class Main {


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		char[] array = br.readLine().toCharArray();
		
		int cnt=1;
		
		for(int i =0; i<array.length; i++){
			if(array[i]=='S'){
				cnt ++;
				
			}else if(array[i]=='L'){
				cnt ++;
				i++;
			}
		}
		if(cnt >n){
			System.out.println(array.length);
		}else
			System.out.println(cnt);
	}
}
