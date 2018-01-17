package boj_11399;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> waiting = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int waitingTime =0; 
		int sum = 0;
		
		while (n-- > 0) {
			waiting.add(Integer.parseInt(st.nextToken()));
		}
		
		waiting.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 > o2 ? 1 : -1;
				// ascending order
			}
		});
		
		for (int j = 0; j < waiting.size(); j++) {
			waitingTime += waiting.get(j);
			sum += waitingTime;
		}
		
		System.out.println(sum);
	}
}