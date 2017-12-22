package boj_1753;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * ���� �¶��� ���� 1753�� <�ִܰ�� ����>
 * 
 * @see https://www.acmicpc.net/problem/1753
 * @author yeeeah_j
 * 
 * 
 *         ���ͽ�Ʈ�� �˰��� ������ ����ġ�� ���ǰ��� ���� �� ���ٰ� �����Ѵ�. ���ǰ��� �ִٸ� ����-���� �˰������� �ذ��ؾ��Ѵ�.
 * 			n�� ���������� �迭������� �ȵ�! ��Ÿ�ӿ����� => �ּ�ó���Ѻκ� 
 * 			arrayList �� �켱���� ť�� �̿��Ͽ� ����! 
 * 			����ģ�� �� ���� ��ǥ�������H�� ��-��
 * 
 * 			
 */
public class Main {
	
	static class Compare implements Comparator<Point>{

		@Override
		public int compare(Point p1, Point p2) {
			// TODO Auto-generated method stub
			return Integer.compare(p1.weight, p2.weight);
			//x����ũ�� ��� /== 0/ y����ũ�� ������ ��ȯ 
			//������ �������� 
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

		// �Է�
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			int w = Integer.parseInt(st.nextToken());
			list[s].add(new Point(l,w));
		}
		
		// �ִܰŸ��� ���� �ִ����� �ʱ�ȭ
		for (int j = 0; j < v + 1; j++) {
			distance[j] = Integer.MAX_VALUE;
		}

		Compare cmp = new Compare();
		PriorityQueue<Point> q = new PriorityQueue(cmp);
		
		// ������ ����
		//check[start] = true; // ���Ϲ��ȿ��� ���ٲ��� 
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

		// Ž�� ����

		for (int j = 1; j < v - 1; j++) {
			// �ּڰ� ã��
			int min = Integer.MAX_VALUE;
			int minIndex = -1;

			for (int k = 1; k < v + 1; k++) {
				if (!check[k] && distance[k] != Integer.MAX_VALUE) { // �Ʒ�����
																		// distance��
																		// �����ϱ�
																		// ������
																		// distance��
																		// ���ؾ��Ѵ�.
					if (min > maps[start][k]) {
						min = maps[start][k];
						minIndex = k;
					}
				}
			}
			// �ּҰ��� �� check�ϱ�
			check[minIndex] = true;
			// s->k s->any->k ���� �� ���� �ֱ�
			for (int k = 1; k < v + 1; k++) {
				if (!check[k] && maps[minIndex][k] != 0) { // ���� ���� ���ٸ� ���� �ʿ䰡
															// ����.
					if (distance[k] > distance[minIndex] + maps[minIndex][k]) {
						distance[k] = distance[minIndex] + maps[minIndex][k];
					}
				}

			}

		}
*/
		// ���
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
