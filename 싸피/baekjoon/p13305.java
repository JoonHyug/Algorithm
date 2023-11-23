package baekjoon;

import java.util.*;

public class p13305 {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] distance = new long[N-1];
		long[] gas = new long[N];
		for(int i=0;i<distance.length;i++) {
			distance[i] = sc.nextInt();
		}
		for(int i=0;i<gas.length;i++) {
			gas[i] = sc.nextInt();
		}
		long min = gas[0];
		for(int i=0;i<gas.length;i++) {
			gas[i] = Math.min(gas[i], min);
			min = gas[i];
		}
		long answer = 0;
		for(int i=0;i<distance.length;i++) {
			answer += gas[i] * distance[i];
		}
		System.out.println(answer);
	}

}
