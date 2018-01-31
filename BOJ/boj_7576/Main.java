package boj_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static final String SPACE = " ";
	public static final int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static int[][] box;
	public static int[][] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), SPACE);
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		box = new int[row][col];
		isVisited = new int[row][col];

		for (int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine(), SPACE);
			for (int j = 0; j < col; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				isVisited[i][j] = 0;
			}
		}
		Queue<Point> queue = new LinkedList<Point>();
		int minDay = 0;
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (box[r][c] == 1 && isVisited[r][c] == 0) {
					queue.offer(new Point(r, c));
					isVisited[r][c] = 1;
				}
			}
		}
		while (!queue.isEmpty()) {
			Point current = queue.poll();
			for (int[] direction : DIRECTIONS) {
				int nextX = current.col + direction[0];
				int nextY = current.row + direction[1];
				if (0 <= nextX && nextX < col && 0 <= nextY && nextY < row) {
					if (box[nextY][nextX] == 0) {
						if (isVisited[nextY][nextX] == 0) {
							queue.offer(new Point(nextY, nextX));
							isVisited[nextY][nextX] = isVisited[current.row][current.col] + 1;
							minDay = Math.max(minDay, isVisited[nextY][nextX]);
						}
					}
				}
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (box[i][j] == 0 && isVisited[i][j] == 0) {
					System.out.println("-1");
					return;
				}
			}
		}
		System.out.println(minDay - 1);
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