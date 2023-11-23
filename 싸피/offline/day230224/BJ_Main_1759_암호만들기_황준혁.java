package offline.day230224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_Main_1759_암호만들기_황준혁 {

	static int L;
	static int C;
	static char[] words;
	static char[] vowles;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		words = new char[C];
		for (int i = 0; i < words.length; i++) {
			words[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(words);
		vowles = new char[] { 'a', 'e', 'i', 'o', 'u' };
		visited = new boolean[C];
		dfs(0, 0, new char[L]);
		System.out.println(sb);
	}

	private static void dfs(int cnt, int start, char[] temp) {
		if (cnt == L) {
			int vow_count = 0;
			int con_count = 0;
			for (int i = 0; i < temp.length; i++) {
				for (int j = 0; j < vowles.length; j++) {
					if (temp[i] == vowles[j]) {
						vow_count++;
					}
				}
			}
			con_count = temp.length - vow_count;
			if (vow_count >= 1 && con_count >= 2) {
				for(int i=0;i<temp.length;i++) {
					sb.append(temp[i]);
				}
				sb.append("\n");
			}
			return;
		}
		for (int i = start; i < words.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[cnt] = words[i];
				dfs(cnt + 1, i + 1, temp);
				visited[i] = false;
			}
		}
	}

}
