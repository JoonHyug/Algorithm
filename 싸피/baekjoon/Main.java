package baekjoon;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=N;i>0;i--) {
			for(int j=0;j<N-i;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<(i*2)-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=2;i<=N;i++) {
			for(int j=0;j<N-i;j++) {
				System.out.print(" ");
			}
			for(int j=0;j<(i*2)-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
