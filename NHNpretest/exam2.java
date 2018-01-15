import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class exam2 {
	

	public static void main(String[] args) throws IOException {
		String SPACE = " ";
		char[][] map;
		StringTokenizer st;
		StringBuilder result = new StringBuilder();
		int[][] DIRECTIONS = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int mapSize = Integer.parseInt(br.readLine());

		map = new char[mapSize][mapSize];

		for (int x = 0; x < mapSize; x++) {
			st = new StringTokenizer(br.readLine(), SPACE);
			for (int y = 0; y < mapSize; y++) {
				map[x][y] = st.nextToken().charAt(0);
			}
		}

		char tileType;
		for (int x = 0; x < mapSize; x++) {

			for (int y = 0; y < mapSize; y++) {
				int resultTmp = 0;
				if (map[x][y] == '0') {
					result.append("-1");
				} else {
					tileType = map[x][y];
					for (int direction = 0; direction < DIRECTIONS.length; direction++) {
						int nextX = x + DIRECTIONS[direction][0];
						int nextY = y + DIRECTIONS[direction][1];
						if (nextX >= 0 && nextX < mapSize && nextY >= 0 && nextY < mapSize) {
							if (tileType == map[nextX][nextY]) {
								resultTmp += Math.pow(2, direction);
							}
						}
					}
					resultTmp = resultTmp + 16 * ((int) tileType - 'A');
					if (resultTmp < 10) {
						result.append(SPACE).append(resultTmp);
					} else {
						result.append(resultTmp);
					}
				}
				if (y == mapSize - 1) {
					result.append("\n");
				} else {
					result.append(SPACE);
				}
			}
		}
		System.out.println(result.toString());
	}

}
