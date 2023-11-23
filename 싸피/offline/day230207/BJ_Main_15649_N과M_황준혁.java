package offline.day230207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_Main_15649_N과M_황준혁 {
	static int N;
	static int M;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);
		result = new int[M];
		visited = new boolean[N];
		NM(0);
		System.out.println(sb.toString());
	}
	
	public static void NM(int cnt) {
		if(cnt == M) {
			for(int i=0;i<result.length;i++) {
				sb.append(result[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[cnt] = i+1;
				NM(cnt + 1);
				visited[i] = false;
			}
		}
	}

}
