package boj_5397;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(testCase-- >0) {
			String password = br.readLine();
			Stack<Character> stack = new Stack<>();
			Stack<Character> stackTmp = new Stack<>();

			for(int i =0; i <password.length(); i++) {
				char word = password.charAt(i);
				
				if(word =='<') {
					if(!stack.isEmpty()) {
						stackTmp.push(stack.pop());
					}
				}else if(word =='>') {
					if(!stackTmp.isEmpty()) {
						stack.push(stackTmp.pop());
					}
					
				}else if(word == '-') {
					if(!stack.isEmpty()) {
						stack.pop();
					}
				}else {
					stack.push(word);
				}
			}
			int size = stack.size();
			for(int j =0; j <size; j++) {
				stackTmp.push(stack.pop());
			}
			int tmpsize = stackTmp.size();
			for(int j =0; j <tmpsize; j++) {
				sb.append(stackTmp.pop());
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
