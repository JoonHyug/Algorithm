package offline.day230207;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1208_Flatten_황준혁 {
	static int dump;
	static int[] height;
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1;tc<=10;tc++) {
			dump = sc.nextInt();
			height = new int[100];
			for(int i=0;i<100;i++) {
				height[i] = sc.nextInt();
			}
			check(0);
			System.out.printf("#%d %d\n", tc, result);
		}
		
	}
	
	public static void check(int cnt) {
		Arrays.sort(height);
		if(dump == cnt) {
			result = height[height.length-1] - height[0];
			return; 
		}
		height[0] += 1;
		height[height.length-1] -= 1;
		check(cnt + 1);
	}

}
