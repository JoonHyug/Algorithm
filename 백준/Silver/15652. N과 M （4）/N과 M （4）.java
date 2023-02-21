import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static int[] array;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[M];
		dfs(0, 1);
		System.out.println(sb.toString());
	}
	private static void dfs(int cnt, int start) {
		if(cnt == M) {
			for(int i : array) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start;i<=N;i++) {
			array[cnt] = i;
			dfs(cnt + 1, i);
		}
	}

}