package FESTIVAL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @author yeeeah_j Algosopt ID:FESTIVAL
 */
public class Main {
	public final static String SPACE = " ";
	public static int[] payArray;
	public static double minAverage;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		DecimalFormat form = new DecimalFormat("#.00000000000");

		while (testCase-- > 0) {
			st = new StringTokenizer(br.readLine(), SPACE);
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			// 날짜별 대여비용 입력
			payArray = new int[N];
			st = new StringTokenizer(br.readLine(), SPACE);
			for (int i = 0; i < N; i++) {
				payArray[i] = Integer.parseInt(st.nextToken());
				// System.out.print(payArray[i]);

			}

			// L개의 평균이 최소가 되는 Index, Min, Average

			minAverage = Double.MAX_VALUE;
			for (int festivalSize = L; festivalSize < N; festivalSize++) {
				for (int i = 0; i < N - festivalSize + 1; i++) {
					float sum = 0;
					for (int j = i; j < i + festivalSize; j++) {
						sum += payArray[j];
					}
					double average = sum / festivalSize;
					// System.out.println(average);
					if (minAverage > average) {
						minAverage = average;
					}
				}
			}
			sb.append(form.format(minAverage)).append("\n");
		}
		System.out.println(sb.toString());
	}

}
