package programmers;

import java.util.Arrays;

public class p징검다리 {

	public static int solution(int distance, int[] rocks, int n) {
		int answer = 0;

		Arrays.sort(rocks);
		long left = 0;
		long right = distance;
		while (left <= right) {
			int mid = (int) ((left + right) / 2);
			int remove = 0;
			int temp = 0;

			for (int i = 0; i < rocks.length; i++) {
				if (rocks[i] - temp < mid) {
					remove++;
				} else {
					temp = rocks[i];
				}
			}
			if (distance - rocks[rocks.length - 1] < mid) {
				remove++;
			}
			if (remove <= n) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int distance = 25;
		int[] rocks = { 2, 14, 11, 21, 17 };
		int n = 2;
		System.out.println(solution(distance, rocks, n));

	}

}
