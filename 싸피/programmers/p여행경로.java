package programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class p여행경로 {
	
	static class Node implements Comparable<Node>{
		String now;
		String next;
		public Node(String now, String next) {
			super();
			this.now = now;
			this.next = next;
		}
		@Override
		public int compareTo(Node o) {
			return this.next.compareTo(o.next);
		}
	}
	private static void dfs(String[][] tickets, int cnt) {
		if(cnt == tickets.length) {
			return;
		}
	}
	
	private static List<String> search(String[][] tickets) { 
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] visited = new boolean[tickets.length];
		queue.add(new Node("", "ICN"));
		List<String> list = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			list.add(node.next);
			for(int i=0;i<tickets.length;i++) {
				if(node.next.equals(tickets[i][0]) && !visited[i]) {
					visited[i] = true;
					queue.add(new Node(tickets[i][0], tickets[i][1]));
				}
			}
		}
		return list;
	}
	
    public static String[] solution(String[][] tickets) {
    	List<String> list = search(tickets);
        String[] answer = new String[list.size()];
        int idx = 0;
        for(String s : list) {
//        	System.out.println(s);
        	answer[idx++] = s;
        }
//        System.out.println(list);
        return answer;
    }

	public static void main(String[] args) {
		String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		String[][] tickets3 = {{"ICN", "AAA"}, {"ICN", "CCC"}, {"CCC", "DDD"}, {"AAA", "BBB"}, {"AAA", "BBB"}, {"DDD", "ICN"}, {"BBB", "AAA"}};
		System.out.println(Arrays.toString(solution(tickets1)));
		System.out.println(Arrays.toString(solution(tickets2)));
		System.out.println(Arrays.toString(solution(tickets3)));
		//["ICN", "CCC", "DDD", "ICN", "AAA", "BBB", "AAA", "BBB"]
		
	}

}
