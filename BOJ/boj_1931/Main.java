package boj_1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		final String SPACE =" ";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int conferenceNum = Integer.parseInt(br.readLine());
		ArrayList<Conference> conferenceList= new ArrayList<>();
		StringTokenizer st ;
		int startT ; int endT;
		while(conferenceNum-- >0) {
			st = new StringTokenizer(br.readLine(), SPACE);
			startT = Integer.parseInt(st.nextToken());
			endT = Integer.parseInt(st.nextToken());
			conferenceList.add(new Conference(startT,endT));
		}
		
		Collections.sort(conferenceList);
		
		int currentTime = 0;
		Conference currentConf =null;
		int result = 0;
		for(int i =0; i <conferenceList.size(); i++) {
			currentConf = conferenceList.get(i);
			if(currentTime >currentConf.startTime) {
				continue;
			}else {
				if(currentConf.startTime == currentConf.endTime) {
					currentTime = currentConf.endTime ;
				}else {
					currentTime = currentConf.endTime;
				}
				result++;
			}
		}
		System.out.println(result);
	}

	static private class Conference implements Comparable<Conference>{
		int startTime;
		int endTime;
		
		public Conference(int startTime, int endTime) {
			this.startTime = startTime;
			this.endTime = endTime;
		}


		@Override
		public int compareTo(Conference o) {
			// TODO Auto-generated method stub
			if(this.endTime == o.endTime) {
				return  this.startTime > o.startTime ? 1: -1;
			}else {
				return this.endTime > o.endTime ? 1: -1;
			}
		}
	}
}
