package JUMPGAME;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] map;
	public static boolean[][] cache;
	public static int mapSize ;
	final public static  String SPACE = " ";

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st ; 
		StringBuilder sb = new StringBuilder();
		while (testCase-- > 0) {
			mapSize = Integer.parseInt(br.readLine());
			
			//map ют╥б
			map = new int[mapSize][mapSize];
			cache = new boolean[mapSize][mapSize];
			for (int y = 0; y < mapSize; y++) {
				st = new StringTokenizer(br.readLine(),SPACE);
				for (int x = 0; x < mapSize; x++) {
					map[y][x]= Integer.parseInt(st.nextToken());
					//System.out.print(map[y][x]);
				}
				//System.out.println();
			}
			String isSuccess = (jump(0,0) == true ? "YES" : "NO"); 
			sb.append(isSuccess).append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static boolean jump(int x, int y){
	//	System.out.println("now : "+ y +","+x +"jump size "+ map[y][x]);
		if(x == mapSize - 1 && y == mapSize - 1){
			return true;
		}
		
		int nextX = x + map[y][x];
		int nextY = y + map[y][x];
		boolean isSuccessX = false;
		boolean isSuccessY = false;
		if(nextX >= 0 && nextX < mapSize && (cache[y][nextX] == false) ){
			cache[y][nextX] = true;
			isSuccessX = jump(nextX, y);
		}
		if (nextY >= 0 && nextY < mapSize && (cache[nextY][x] == false)){
			cache[nextY][x] = true;
			isSuccessY = jump(x, nextY);
		}
	//	System.out.println(isSuccessX || isSuccessY);
		return isSuccessX || isSuccessY;
		
		
	}

}
