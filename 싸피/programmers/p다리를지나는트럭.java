package programmers;

import java.util.*;

public class p다리를지나는트럭 {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<int[]> ingQueue = new LinkedList<>();
        Queue<Integer> truckQueue = new LinkedList<>();
        for(int i : truck_weights) {
        	truckQueue.add(i);
        }
        int max = 0;
        int move = 0;
        while(!truckQueue.isEmpty()) {
        	int hap = 0;
        	for(int t=0;t<ingQueue.size();t++) {
        		int[] temp = ingQueue.poll();
        		hap += temp[0];
        		ingQueue.add(new int[] {temp[0], temp[1]});	
        	}
        	while(truckQueue.peek() + hap <= weight) {
        		hap += truckQueue.peek();
        		ingQueue.add(new int[] {truckQueue.poll(), 0});
        		for(int i=0;i<ingQueue.size();i++) {
        			int[] temp = ingQueue.poll();
        			ingQueue.add(new int[] {temp[0], temp[1]+1});
        		}        		
        		move++;
        		if(truckQueue.isEmpty()) {
        			break;
        		}
        	}
        	int cnt = 0;
        	while(true) {
        		if(ingQueue.peek()[1] >= bridge_length) {
        			ingQueue.poll();
        		}
        		if(ingQueue.isEmpty()) {
        			break;
        		}
        		int[] temp = ingQueue.poll();
    			ingQueue.add(new int[] {temp[0], temp[1]+1});
    			if(cnt % ingQueue.size() == 0) {
    				move++;
    			}
    			cnt++;
        	}
//        	System.out.println(ingQueue.peek()[0]+", "+ingQueue.peek()[1]);
        }
//        System.out.println(move);
        return move+1;
    }
	
	public static void main(String[] args) {
		int a1 = 2;
		int b1 = 10;
		int[] temp1 = {7, 4, 5, 6};
		int a2 = 100;
		int b2 = 100;
		int[] temp2 = {10};
		int a3 = 100;
		int b3 = 100;
		int[] temp3 = {10,10,10,10,10,10,10,10,10,10};
		System.out.println(solution(a1, b1, temp1));
		System.out.println(solution(a2, b2, temp2));
		System.out.println(solution(a3, b3, temp3));
	}
}
