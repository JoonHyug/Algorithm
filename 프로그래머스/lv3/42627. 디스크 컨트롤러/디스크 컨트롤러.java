import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
	
	public static int solution(int[][] jobs) {
		int answer = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		Queue<int[]> queue = new ArrayDeque<>();
		for(int i=0;i<jobs.length;i++) {
			pq.add(jobs[i]);
		}
		int time = 0;
        //pq가 빌때까지
		while(!pq.isEmpty()) {
            //pq 순회를 위한 사이즈
			int size = pq.size();
			for(int i=0;i<size;i++) {
                //pq에서 값을 하나씩 poll하면서 들어갈 수 있는지 확인
				int[] disk = pq.poll();
                //요청시간이 현재 시간보다 작거나 같으면
                //마침 들어갈 수 있는 시간이거나 이미 지나간 시간대(들어갈 수 있음)
				if(disk[0] <= time) {
                    //시간에 디스크의 작업 시간 만큼 추가
					time+=disk[1];
                    //하나의 디스크가 걸린 시간을 구하고
					answer += time - disk[0];
					break;
				} else {
                    //요청 시간이 아니라면 queue에 추가
					queue.add(disk.clone());					
				}
			}
            //큐 순회를 위한 size
			int q_size = queue.size();
			for(int i=0;i<q_size;i++) {
                //queue에 들어있던 값들을 다시 pq에 추가
				pq.add(queue.poll());
			}
            //위의 pq의 사이즈와 연산이 끝난 pq의 사이즈가 같다면
            //작업이 한개도 진행되지 않은것이기 때문에 시간을 증가
			if(size == pq.size()) {
				time++;
			}
//			System.out.println(answer +", "+time);
		}
//		System.out.println(answer +", "+time);
//		while(!pq.isEmpty()) {
//			System.out.println(Arrays.toString(pq.poll()));
//		}
        //평균 구하기
		return answer/jobs.length;
	}

	// public static void main(String[] args) {
	// 	int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
	// 	System.out.println(solution(jobs));
	// }

}
