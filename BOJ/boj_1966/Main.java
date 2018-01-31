package boj_1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Queue<Document> queue = new LinkedList<Document>();
		PriorityQueue<Document> priorityQueue = new PriorityQueue<>(new Comparator<Document>() {

			@Override
			public int compare(Document o1, Document o2) {
				// TODO Auto-generated method stub
				if (o1.num > o2.num)
					return -1;
				else
					return 1;
			}

		});

		while (testCase-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int arraySize = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < arraySize; i++) {
				Document d = new Document(Integer.parseInt(st.nextToken()), i);

				queue.offer(d);
				priorityQueue.offer(d);
			}
			int count = 0;
			for (int i = 0; i < arraySize; i++) {

				Document pqd = priorityQueue.poll();
				for (int j = 0; j < arraySize; j++) {
					Document qd = queue.poll();

					if (pqd.num == qd.num) {
						count++;
						if (qd.index == m) {
							sb.append(count).append("\n");
							// continue 쓰면 좋겟다
						}
						break;
					} else {
						queue.offer(qd);
					}
				}
			}
		}
		System.out.println(sb.toString());
	}

	static class Document {
		int index;
		int num;

		Document(int num, int index) {
			this.num = num;
			this.index = index;
		}

	}
}
