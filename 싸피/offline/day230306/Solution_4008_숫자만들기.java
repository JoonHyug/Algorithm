package offline.day230306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4008_숫자만들기 {

	static int N;
	static int[] cal; // +, -, *, /
	static int[] num;
	static int min, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			cal = new int[4];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < cal.length; i++) {
				cal[i] = Integer.parseInt(st.nextToken());
			}
			num = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < num.length; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			dfs(1, 1, num[0]);
			int result = max - min;
//			System.out.println(max+", "+min);
			sb.append("#" + tc + " ").append(result).append("\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int cnt, int start, int sum) {
		if (cnt == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		for (int i = start; i < num.length; i++) {
			for (int j = 0; j < cal.length; j++) {
				if(cal[j] > 0) {
					cal[j]--;
					if (j == 0)
						dfs(cnt + 1, i + 1, sum + num[i]);
					if (j == 1)
						dfs(cnt + 1, i + 1, sum - num[i]);
					if (j == 2)
						dfs(cnt + 1, i + 1, sum * num[i]);
					if (j == 3)
						dfs(cnt + 1, i + 1, sum / num[i]);
					cal[j]++;					
				}
			}
		}
	}

}
