package programmers;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class p프린터 {

	
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<priorities.length;i++) {
        	pq.add(priorities[i]);
        }
        while(!pq.isEmpty()) {
        	for(int i=0;i<priorities.length;i++) {
        		if(priorities[i] == pq.peek()) {
        			if(i == location) {
        				return answer + 1;
        			}
        			answer++;
        			pq.poll();
        		}
        	}
        }
        return -1;
    }
    
	public static void main(String[] args) {
		int[] temp = {2, 1, 3, 2};
//		System.out.println(solution(temp, 2));
		System.out.println("=====================");
		int[] temp2 = {1, 1, 9, 1, 1, 1};
		System.out.println(solution(temp2, 0));
	}

}
