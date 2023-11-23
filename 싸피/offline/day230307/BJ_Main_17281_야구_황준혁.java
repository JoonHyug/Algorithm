package offline.day230307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_Main_17281_야구_황준혁 {

	static int N;
	static int[] player;
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
		player = new int[9];
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
		int last = 0;
		for(int k=0;k<N;k++) {
			lastHitter = last;
			for (int a = 0; a < temp.length; a++) {
				player[a] = array[k][temp[a]];
			}
			hap += game();
			last = lastHitter;
		}
		max = Math.max(max, hap);
	}

	private static int game() {
		//0 : 1루, 1 : 2루, 2 : 3루
		boolean[] ground = new boolean[3];
		int score = 0;
		// 이전 이닝에서 친 사람의 다음 사람부터 시작
		
		int out = 0;
		int idx = lastHitter;
		while (out != 3) {
			if (player[idx] == 0) {
				out++;
			} else if(player[idx] == 1) {
				if(ground[2]) {
					score++;
					ground[2] = false;
				}
				if(ground[1]) {
					ground[2] = true;
					ground[1] = false;
				}
				if(ground[0]) {
					ground[1] = true;
					ground[0] = false;
				}
				ground[0] = true;
				
			} else if(player[idx] == 2) {
				for(int i=1;i<ground.length;i++) {
					if(ground[i]) {
						score++;
						ground[i] = false;
					}
				}
				if(ground[0]) {
					ground[0] = false;
					ground[2] = true;					
				}
				ground[1] = true;					
				
			} else if(player[idx] == 3) {
				for(int i= 0;i<ground.length;i++) {
					if(ground[i]) {
						score++;
						ground[i] = false;
					}
				}
				ground[2] = true;
			} else if(player[idx] == 4) {
				for(int i=0;i<ground.length;i++) {
					if(ground[i]) {
						score++;
						ground[i] = false;
					}
				}
				score++;
			}
			idx = (idx + 1)%9;
		}
		lastHitter = idx;
		return score;
	}
	

}
