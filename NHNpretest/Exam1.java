import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 주의사항
 * import 적어주기
 * main 함수에 throws 하기 
 * 입력 
 * 
 * 
 * 
*/
public class Exam1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Queue<String> queue = new LinkedList<String>();
		StringBuilder sb = new StringBuilder();
		String tmp;

		while (st.hasMoreTokens()) {
			tmp = st.nextToken();
			
			if (queue.contains(tmp)) {	// 주머니 안에 중복되는 아이템이 있는지 검사 
				queue.remove(tmp);
				queue.offer(tmp);
			} else {					
				if (queue.size() < 3) {	// 3개 이상인지 아닌지 검사 
					queue.offer(tmp);	
				} else {
					sb.append(queue.poll()).append("\n");
					queue.offer(tmp);
				}
			}
		}
		System.out.println(sb.length() == 0 ? "0" : sb.toString());
	}

}
