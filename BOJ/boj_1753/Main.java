package boj_1753;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1753번 <최단경로 문제>
 * 
 * @see https://www.acmicpc.net/problem/1753
 * @author yeeeah_j
 * 
 * 
 *         다익스트라 알고리즘 문제는 가중치가 음의값을 가질 수 없다고 가정한다. 음의값이 있다면 벨반-포드 알고리즘으로 해결해야한다.
 * 			n의 범위떄문에 배열을만들면 안됨! 런타임에러남 => 주석처리한부분 
 * 			arrayList 와 우선순위 큐를 이용하여 구현! 
 * 			개빡친다 ㅎ 오늘 목표세개엿뉸데 ㅎ-ㅎ
 * 
 * 			
 */
public class Main {
	
	static class Compare implements Comparator<Point>{

		@Override
		public int compare(Point p1, Point p2) {
			// TODO Auto-generated method stub
			return Integer.compare(p1.weight, p2.weight);
			//x가더크면 양수 /== 0/ y가더크면 음수를 반환 
			//지금이 오름차순 
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		ArrayList<Point>[] list ;
		int[] distance;
		boolean[] check;

		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		list = new ArrayList[v+1];
		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList();
		}
		check = new boolean[v + 1];
		distance = new int[v + 1];

		// 입력
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			int w = Integer.parseInt(st.nextToken());
			list[s].add(new Point(l,w));
		}
		
		// 최단거리를 전부 최댓값으로 초기화
		for (int j = 0; j < v + 1; j++) {
			distance[j] = Integer.MAX_VALUE;
		}

		Compare cmp = new Compare();
		PriorityQueue<Point> q = new PriorityQueue(cmp);
		
		// 시작점 설정
		//check[start] = true; // 와일문안에서 해줄꺼야 
		distance[start] = 0;
		q.offer(new Point(start,0));
		
		while(!q.isEmpty()){
			Point p = q.poll();
			if(check[p.vertex]) continue;
			check[p.vertex] =true;
			
			for(int i=0;i<list[p.vertex].size();i++){ 
				Point temp = list[p.vertex].get(i);
				if(distance[temp.vertex]>distance[p.vertex]+temp.weight){
					distance[temp.vertex]=distance[p.vertex]+temp.weight;
					q.add(new Point(temp.vertex, distance[temp.vertex]));
					
				}
			}
		}
		
/*
		for (int j = 0; j < v + 1; j++) {
			if (!check[j] && maps[start][j] != 0) { //
				distance[j] = maps[start][j];
			}
		}

		// 탐색 시작

		for (int j = 1; j < v - 1; j++) {
			// 최솟값 찾기
			int min = Integer.MAX_VALUE;
			int minIndex = -1;

			for (int k = 1; k < v + 1; k++) {
				if (!check[k] && distance[k] != Integer.MAX_VALUE) { // 아래에서
																		// distance를
																		// 갱신하기
																		// 때문에
																		// distance로
																		// 비교해야한다.
					if (min > maps[start][k]) {
						min = maps[start][k];
						minIndex = k;
					}
				}
			}
			// 최소값인 곳 check하기
			check[minIndex] = true;
			// s->k s->any->k 둘중 더 가까운값 넣기
			for (int k = 1; k < v + 1; k++) {
				if (!check[k] && maps[minIndex][k] != 0) { // 가는 길이 없다면 비교할 필요가
															// 없다.
					if (distance[k] > distance[minIndex] + maps[minIndex][k]) {
						distance[k] = distance[minIndex] + maps[minIndex][k];
					}
				}

			}

		}
*/
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int j = 1; j < v + 1; j++) {
			if (distance[j] != Integer.MAX_VALUE) {
				sb.append(distance[j]).append("\n");

			} else {
				sb.append("INF").append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	static class Point{
		int vertex;
		int weight;
		public Point(int vertex,int weight){
			this.vertex = vertex;
			this.weight = weight;
		}
	}
}
