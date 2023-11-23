package offline.day230307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_Main_17281_야구_황준혁2 {

	static int N;
	static Queue<Integer> queue;
	static int lastHitter;
	static List<int[]> list;
	static int max;
	static int[][] array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		array = new int[N][9];
		for (int i = 0; i < array.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		queue = new ArrayDeque<>();
		permu(1, new int[9], new boolean[9]);
		System.out.println(max);

	}

	private static void permu(int cnt, int[] temp, boolean[] visited) {
		if (cnt == 9) {
			
			int t = temp[0];
			temp[0] = temp[3];
			temp[3] = t;
			findMax(temp);
			t = temp[0];
			temp[0] = temp[3];
			temp[3] = t;
			return;
		}
		for (int i = 1; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp[cnt] = i;
				permu(cnt + 1, temp, visited);
				visited[i] = false;
			}
		}
	}

	private static void findMax(int[] temp) {
		int hap = 0;
		int last = -1;
		for(int k=0;k<N;k++) {
			lastHitter = last;
			queue.clear();
			for (int a = 0; a < temp.length; a++) {
				queue.add(array[k][temp[a]]);
			}
			hap += game();
			last = lastHitter;
		}
		max = Math.max(max, hap);
	}

	private static int game() {
		// 0을 3개 채워놓고 poll하면서 다시 add 해주는식으로 3개를 유지
		// 1은 사람
		Queue<Integer> ground = new ArrayDeque<>();
		for (int i = 0; i < 3; i++) {
			ground.add(0);
		}
		int count = 0;
		int score = 0;
		// 이전 이닝에서 친 사람의 다음 사람부터 시작
		for (int i = 0; i < lastHitter; i++) {
			queue.add(queue.poll());
		}
		int out = 0;
		while (out != 3) {
			int hitter = queue.poll();
			count++;
			if (hitter == 0) {
				out++;
			} else {
				ground.add(1);
				if (ground.poll() == 1) {
					score++;
				}
				for (int i = 0; i < hitter - 1; i++) {
					ground.add(0);
					if (ground.poll() == 1) {
						score++;
					}
				}
			}
			queue.add(hitter);
		}
		lastHitter = count % 9;
		return score;
	}

}
