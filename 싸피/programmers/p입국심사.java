package programmers;

import java.util.Arrays;

public class p입국심사 {
	public static long solution(int n, int[] times) {
		Arrays.sort(times);
		long start = 0;
		long end = times[times.length - 1] * (long)n;
		long mid = 0;	
		while (start <= end) {
			mid = (start + end) / 2;
			long temp = 0;
			for(int i=0;i<times.length;i++) {
				temp += mid/times[i];
			}
			if (temp < n) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start;
	}

	public static void main(String[] args) {
		int[] temp = { 7, 10 };
		System.out.println(solution(6, temp));

	}

}
