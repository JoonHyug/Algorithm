package programmers;

import java.util.Stack;

public class p주식가격 {
	
    public static int[] solution(int[] prices) {
        int[] answer = {};
        Stack<int[]> stack = new Stack<>();
        int idx = 1;
        int i = 0;
        stack.push(new int[] {prices[i], idx});
        
        while(!stack.isEmpty()) {
        	if(stack.peek()[0] < prices[i]) {
        		stack.pop();
        	}
        	i++;
        	idx++;
        }
        
        return answer;
    }

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 2, 3};
		System.out.println(solution(prices));
		
	}

}
