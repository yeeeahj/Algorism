package boj_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final String SPACE = " ";
	public static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	private static int[][] field;
	private static boolean[][] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine(), SPACE);
			int M = Integer.parseInt(st.nextToken()); // 10
			int N = Integer.parseInt(st.nextToken()); // 8
			int K = Integer.parseInt(st.nextToken());
			field = new int[M][N];
			isVisited = new boolean[M][N];
			for (int k = 0; k < M; k++) {
				for (int n = 0; n < N; n++) {
					field[k][n] = 0;
					isVisited[k][n] = false;
				}
			}

			int x;
			int y;
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), SPACE);
				x = Integer.parseInt(st.nextToken()); // 10
				y = Integer.parseInt(st.nextToken()); // 8
				field[x][y] = 1;
			}

			Queue<Point> queue = new LinkedList<>();
			int areaCount = 0;
			for (int k = 0; k < M; k++) {
				for (int n = 0; n < N; n++) {
					if (field[k][n] == 1 && isVisited[k][n] == false) {
						areaCount++;
						queue.offer(new Point(k, n));
						isVisited[k][n] = true;

						while (!queue.isEmpty()) {
							Point current = queue.poll();
							for (int[] direction : DIRECTIONS) {
								int nextX = current.row + direction[0];
								int nextY = current.col + direction[1];
								if (0 <= nextX && nextX < M && 0 <= nextY && nextY < N) {
									if (field[nextX][nextY] == 1) {
										if (isVisited[nextX][nextY] == false) {
											queue.offer(new Point(nextX, nextY));
											isVisited[nextX][nextY] = true;
										}
									}
								}
							}
						}
					}
				}
			}
			System.out.println(areaCount);
		}
	}

	static class Point {
		int row;
		int col;

		public Point(int r, int c) {
			this.row = r;
			this.col = c;
		}
	}
}