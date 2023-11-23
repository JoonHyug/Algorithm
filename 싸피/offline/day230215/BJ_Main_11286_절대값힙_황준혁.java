package offline.day230215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BJ_Main_11286_절대값힙_황준혁 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
			if(o1[0] == o2[0]) return o1[1] - o2[1];
			return o1[0] - o2[0];
		});
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0) {
				pq.add(new int[] {Math.abs(num), num});
			} else {
				if(!pq.isEmpty()) {
					sb.append(pq.poll()[1]);					
				} else {
					sb.append(0);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
