package programmers;

import java.util.PriorityQueue;

public class p더맵게 {
	
	public static int solution(int[] scovile, int K) {
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i : scovile) {
			pq.add(i);
		}
		while(!(pq.peek() >= K)) {
			int a = pq.poll();
			if(pq.size() == 0) {
				answer = -1;
				break;
			}
			int b = pq.poll();
			int mix = a + (b*2);
			pq.add(mix);
			answer++;
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		System.out.println(solution(scoville, 7));
	}

}
