import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] arr;
	static int[] result;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<arr.length;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		result = new int[M];
		Arrays.sort(arr);
		dfs(0, 0);
		System.out.println(sb.toString());
		
	}
	private static void dfs(int cnt, int start) {
		if(cnt == M) {
			for(int i=0;i<result.length;i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start;i<arr.length;i++) {
			result[cnt] = arr[i];
			dfs(cnt + 1, i);
		}
	}

}