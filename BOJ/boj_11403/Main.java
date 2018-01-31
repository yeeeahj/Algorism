package boj_11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final String SPACE = " ";
	private static boolean[][] isVisited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer>[] map = new ArrayList[n];
		isVisited = new boolean[n][n];
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			map[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine(), SPACE);
			for (int j = 0; j < n; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					map[i].add(j);
				}
			}
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for (int k = 0; k < n; k++) {
			// 7번의 bfs // 어떻게 하면 메모리제인션이 가능할까?
			queue.offer(k);
			while (!queue.isEmpty()) {
				int currentPoint = queue.poll();
				for (int p = 0; p < map[currentPoint].size(); p++) {
					int nextPoint = map[currentPoint].get(p);
					if (isVisited[k][nextPoint] ==false) {
						queue.offer(nextPoint);
						isVisited[k][nextPoint] = true;
					}
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(isVisited[i][j]==true)
					System.out.print(1+" ");
				else {
					System.out.print(0+" ");
				}
			}
			System.out.println();
		}
	}
}
