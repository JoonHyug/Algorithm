package programmers;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class p디스크컨트롤러 {
	
	public static int solution(int[][] jobs) {
		int answer = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		Queue<int[]> queue = new ArrayDeque<>();
		for(int i=0;i<jobs.length;i++) {
			pq.add(jobs[i]);
		}
		int time = 0;
		while(!pq.isEmpty()) {
			int size = pq.size();
			for(int i=0;i<size;i++) {
				int[] disk = pq.poll();
				if(disk[0] <= time) {
					time+=disk[1];
					answer += time - disk[0];
					break;
				} else {
					queue.add(disk.clone());					
				}
			}
			int q_size = queue.size();
			for(int i=0;i<q_size;i++) {
				pq.add(queue.poll());
			}
			if(size == pq.size()) {
				time++;
			}
//			System.out.println(answer +", "+time);
		}
//		System.out.println(answer +", "+time);
//		while(!pq.isEmpty()) {
//			System.out.println(Arrays.toString(pq.poll()));
//		}
		return answer/3;
	}

	public static void main(String[] args) {
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		System.out.println(solution(jobs));
	}

}
