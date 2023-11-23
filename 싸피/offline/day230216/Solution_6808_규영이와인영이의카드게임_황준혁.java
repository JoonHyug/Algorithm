package offline.day230216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6808_규영이와인영이의카드게임_황준혁 {

	static int[] arr1; // 규영이
	static int[] arr2; // 인영이
	static boolean[] card;
	static boolean[] visited;
	static int win;
	static int lose;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			card = new boolean[18 + 1];
			arr1 = new int[9];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr1.length; i++) {
				int temp = Integer.parseInt(st.nextToken());
				arr1[i] = temp;
				card[temp] = true;
			}
			arr2 = new int[9];
			int a = 0;
			for (int j = 1; j < card.length; j++) {
				if (!card[j]) {
					arr2[a++] = j;
				}

			}
			win = 0;
			lose = 0;
			visited = new boolean[9];
			dfs(0, 0, 0);
			System.out.printf("#%d %d %d\n", tc, win, lose);
		}
	}

	private static void dfs(int cnt, int sum1, int sum2) {
		if (cnt == 9) {
			if(sum1 > sum2) {
				win++;
			} else {
				lose++;
			}
			return;
		}
		for (int i = 0; i < 9; i++) {
			if(!visited[i]) {
				visited[i] = true;
				if (arr1[cnt] > arr2[i]) {
					dfs(cnt + 1, sum1 + arr1[cnt] + arr2[i], sum2);
				} else {
					dfs(cnt + 1, sum1, sum2 + arr1[cnt] + arr2[i]);
				}
				visited[i] = false;
			}
		}
	}

}
