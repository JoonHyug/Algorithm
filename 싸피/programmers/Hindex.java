package programmers;

import java.util.Arrays;

public class Hindex {

	public static int solution(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);
		int h = 0;
		for(int i=0;i<citations.length;i++) {
			h = citations.length - i;
			
			if(citations[i] >= h) {
				answer = h;
				break;
			}
		}
		return answer;
	}
	
	public static void main(String[] args) {
		int[] temp = {3, 0, 6, 1, 5};
		System.out.println(solution(temp));
	}

}
