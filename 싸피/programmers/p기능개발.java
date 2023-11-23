package programmers;

import java.util.*;

public class p기능개발 {

	public static int[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		Queue<Integer> pqueue = new LinkedList<Integer>();
		Queue<Integer> squeue = new LinkedList<Integer>();		
		for (int i = 0; i < progresses.length; i++) {
			pqueue.add(progresses[i]);
			squeue.add(speeds[i]);			
		}
		while (!pqueue.isEmpty()) {
			for (int i = 0; i < pqueue.size(); i++) {
				int temp = pqueue.poll() + squeue.peek();
				pqueue.add(temp);
				squeue.add(squeue.poll());
			}
			if (pqueue.peek() >= 100) {
				int cnt = 0;
				while (!pqueue.isEmpty() && pqueue.peek() >= 100) {
					pqueue.poll();
					squeue.poll();
					cnt++;
				}
				a.add(cnt);
			}
		}
		int[] answer = new int[a.size()];
		int idx = 0;
		for(int i : a) {
			answer[idx++] = i;
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] p = { 93, 30, 55 };
		int[] s = { 1, 30, 5 };
		System.out.println(Arrays.toString(solution(p, s)));
		int[] p1 = {95, 90, 99, 99, 80, 99};
		int[] s1 = {1, 1, 1, 1, 1, 1};
		System.out.println(Arrays.toString(solution(p1, s1)));
	}

}
