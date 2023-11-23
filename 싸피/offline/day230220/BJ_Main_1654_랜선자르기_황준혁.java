package offline.day230220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_Main_1654_랜선자르기_황준혁 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[K];
		for(int i=0;i<arr.length;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		long start = 1;
		long end = arr[arr.length-1];
		long mid = 0;
		while(start <= end) {
			int cnt = 0;
			mid = (start + end) / 2;
			for(long i : arr) {
				cnt += i / mid;
			}
			if(cnt >=  N) {
				start = mid + 1;
			} else{
				end = mid - 1;
			}
		}
		System.out.println(end);
	}

}
