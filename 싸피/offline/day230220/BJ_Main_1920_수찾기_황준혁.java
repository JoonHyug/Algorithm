package offline.day230220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_Main_1920_수찾기_황준혁 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<A.length;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[] B = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<B.length;i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		for(int i=0;i<B.length;i++) {
			int result = 0;
			int start = 0;
			int end = A.length - 1;
			while(start <= end) {
				int mid = (start + end) / 2;
				
				if(B[i] > A[mid]) {
					start = mid + 1;
				} else if(B[i] < A[mid]) {
					end = mid - 1;
				} else {
					result = 1;
					break;
				}
			}
			sb.append(result+"\n");
		}
		System.out.println(sb.toString());
	}

}
