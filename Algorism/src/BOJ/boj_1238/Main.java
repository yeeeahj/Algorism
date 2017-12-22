package boj_1238;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 문제 1238 <파티> 문제
 * 
 * @see https://www.acmicpc.net/problem/1238
 * @author yeeeah_j
 */
public class Main {
	static int[] distanceR;
	static boolean[] isVisited;

	static class Compare implements Comparator<Edge> {

		@Override
		public int compare(Edge e1, Edge e2) {
			// TODO Auto-generated method stub
			return Integer.compare(e1.cost, e2.cost);
			// 오름차순으로 정렬
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		Edge temp;
		ArrayList<Edge>[] list = new ArrayList[N + 1];
		distanceR = new int[N + 1];
		for (int k = 1; k < N + 1; k++) {
			list[k] = new ArrayList();
			distanceR[k] = 0;
		}

		// 입력
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[s].add(new Edge(e, c));
		}

		/*
		 * 입력확인 for(int p=1; p< N+1;p++){ for(int o=0; o <list[p].size();o++){
		 * System.out.println(list[p].get(o).end +" ,"+list[p].get(o).cost); } }
		 */
		// 각 학생별 거리를 구해야 하므로 i 는 시작점
		for (int i = 1; i < N + 1; i++) {
			// 출발지점이 달라질때마다 초기화 되야하는 변수는 이안에 !
			int[] distance = new int[N + 1];
			isVisited = new boolean[N + 1];
			for (int k = 1; k < N + 1; k++) {
				distance[k] = Integer.MAX_VALUE;
			}

			distance[i] = 0;
			Compare cmp = new Compare();
			PriorityQueue<Edge> q = new PriorityQueue(cmp);
			q.offer(new Edge(i, 0));

			while (!q.isEmpty()) {
				Edge current = q.poll();
				if (isVisited[current.end])
					continue;
				isVisited[current.end] = true;

				for (int j = 0; j < list[current.end].size(); j++) {
					temp = list[current.end].get(j);
					if (distance[temp.end] > distance[current.end] + temp.cost) {
						distance[temp.end] = distance[current.end] + temp.cost;
						q.offer(new Edge(temp.end, distance[temp.end]));
					}
				}

			}
			if (i == X) { 									// i가 목적지 일때 돌아가는거리를 저장하기 위함
				for (int p = 1; p < N + 1; p++) {
					distanceR[p] =distanceR[p]+ distance[p];
				}
			} else {										// i가 아니면 경로에 해당하는 가는거리 만 저장하면 됨
				distanceR[i] += distance[X];
			}

		}
		int disMax = -1;
		for (int dis : distanceR) {
			disMax = Integer.max(disMax, dis);
		}
		System.out.println(disMax);

	}

	static public class Edge {
		int end;
		int cost;

		public Edge(int e, int c) {
			this.end = e;
			this.cost = c;
		}
	}

}
