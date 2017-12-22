package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 
 * @author yeeeah_j
 * Algospot ID : BOJ
 *
 */
public class Main {
	public static boolean[][] map;
	public static int[][] minMap;
	public static int[][] DIRECTIONS = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1 ,0 } };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		final int  x = Integer.parseInt(st.nextToken());
		final int  y = Integer.parseInt(st.nextToken());

		// 입력
		map= new boolean[y][x];
		minMap = new int[y][x];
		for (int yPointer = 0; yPointer < y; yPointer++) {
			String mapLine = br.readLine();
			for (int xPointer = 0; xPointer < x; xPointer++) {
				//System.out.print(mapLine.charAt(xPointer)-'0');
				map[yPointer][xPointer] = (mapLine.charAt(xPointer)-'0' == 0 ? true : false);
				minMap[yPointer][xPointer] = Integer.MAX_VALUE;
			}
		}
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(0, 0));
		minMap[0][0]=0;
		while (!q.isEmpty()) {
			Point current = q.poll();
			for (int[] direction : DIRECTIONS) {
				int nextX = current.x + direction[1];
				int nextY = current.y + direction[0];
				//범위안에 있는지 검사 
				if(nextX>=0 && nextX <x && nextY >=0 && nextY < y){
					//지나온 곳인지 검사 
					//System.out.println(nextX+","+nextY);
					if(map[nextY][nextX]==true){ //비어있는 공간이면y
						if(minMap[nextY][nextX] > minMap[current.y][current.x]){	// 나보다 1이라도 크면 연산해야해 
							minMap[nextY][nextX] = Math.min(minMap[nextY][nextX], minMap[current.y][current.x]);
						//	System.out.println("offerPoint"+nextY+", "+nextX);
							q.offer(new Point(nextY, nextX));
						}
					}else{ //벽이면 
						if(minMap[nextY][nextX] > minMap[current.y][current.x]+1){ 	// 나+1 보다 크면 연산 해야해 
							minMap[nextY][nextX] = Math.min(minMap[nextY][nextX], minMap[current.y][current.x]+1);
							q.offer(new Point(nextY, nextX));
						//	System.out.println(" 벽 offerPoint"+nextY+", "+nextX);

						}
					}
				}
			}
		}System.out.println(minMap[y-1][x-1]);

	}

	public static class Point {
		int x;
		int y;

		public Point(int y ,int x) {
			this.x = x;
			this.y = y;
		}
	}

}
