package baekjoon;

import java.util.*;
public class p1546 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		double avg = 0;
		int max = 0;
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		for(int i=0;i<arr.length;i++) {
			avg += (double)arr[i]/max*100;
		}
		
		System.out.printf("%.6f\n", avg / N);

	}

}
