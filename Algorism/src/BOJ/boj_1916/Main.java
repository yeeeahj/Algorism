package boj_1916;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 문제 1916 <최소비용구하기> 문제
 * 
 * @see https://www.acmicpc.net/problem/1916
 * @author yeeeah_j
 */
public class Main {
	static int[] distance;
	static boolean[] isVisited;
	
	static  class Compare implements Comparator<Bus>{

		@Override
		public int compare(Bus b1, Bus b2) {
			// TODO Auto-generated method stub
			return Integer.compare(b1.cost, b2.cost);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int city = Integer.parseInt(br.readLine());
		int bus = Integer.parseInt(br.readLine());

		// 인접리스트 선언 및 초기화
		ArrayList<Bus>[] station ;
		station = new ArrayList[city+1];
		distance = new int[city+1];
		isVisited = new boolean[city+1];
		

		for (int j = 1; j < city + 1; j++) {
			station[j] = new ArrayList<>();
			distance[j] = Integer.MAX_VALUE;
		}
		
		// 입력
		for (int i = 1; i < bus + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			station[s].add(new Bus( e, c));
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		//출발점 설정
		int start =Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		distance[start]=0;
		
		Compare cmp = new Compare();
		PriorityQueue<Bus> q = new PriorityQueue(cmp);
		q.offer(new Bus(start,0));
		
		while(!q.isEmpty()){
			Bus b = q.poll();
			if(isVisited[b.endB]) continue;
			isVisited[b.endB] =true;
			
			for(int i =1; i <station[b.endB].size() +1;i++){
				Bus temp = station[b.endB].get(i-1);
				if(distance[temp.endB] > distance[b.endB]+ temp.cost){
					distance[temp.endB] = distance[b.endB]+ temp.cost;
					q.offer(new Bus(temp.endB,distance[temp.endB]));
				}
			}
		}
		System.out.println(distance[end]);	
	}
	
	static public class Bus {
		int endB;
		int cost;

		public Bus( int e, int c) {
			this.endB = e;
			this.cost = c;
		}
	}
}
