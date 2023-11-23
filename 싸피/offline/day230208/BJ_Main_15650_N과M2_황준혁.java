package offline.day230208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_Main_15650_N과M2_황준혁 {

	static int N;
	static int M;
	static boolean[] visited;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		result = new int[M];
		NM(0, 1);
		System.out.println(sb);
	}
	private static void NM(int cnt, int start) {
		if(cnt == M) {
			for(int i=0;i<result.length;i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start;i<=N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[cnt] = i;
				NM(cnt + 1, i + 1);
				visited[i] = false;
			}
		}
	}

}
