import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * ���ǻ���
 * import �����ֱ�
 * main �Լ��� throws �ϱ� 
 * �Է� 
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
			
			if (queue.contains(tmp)) {	// �ָӴ� �ȿ� �ߺ��Ǵ� �������� �ִ��� �˻� 
				queue.remove(tmp);
				queue.offer(tmp);
			} else {					
				if (queue.size() < 3) {	// 3�� �̻����� �ƴ��� �˻� 
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
