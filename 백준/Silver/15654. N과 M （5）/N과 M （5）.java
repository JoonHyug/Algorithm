import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] array;
	static boolean[] visited;
	static int[] result;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<array.length;i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array);
		visited = new boolean[N];
		result = new int[M];
		dfs(0);
		System.out.println(sb.toString());
	}
	
	private static void dfs(int cnt) {
		if(cnt == M) {
			for(int i=0;i<M;i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[cnt] = array[i];
				dfs(cnt + 1);
				visited[i] = false;
			}
		}
		
	}

}
