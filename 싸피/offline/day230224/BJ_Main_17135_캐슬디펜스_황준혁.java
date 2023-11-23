package offline.day230224;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_Main_17135_캐슬디펜스_황준혁 {

	final static int archer = 3;

	static List<int[]> list = new ArrayList<>();
	static int N, M, D;
	static int result;
	static int max;
	static List<int[]> enemy;
	static List<Integer> ready;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0, new int[archer]);
//        for (int i = 0; i < list.size(); i++) {
//            for(int j=0;j<list.get(i).length;j++) {
//                System.out.print(list.get(i)[j]+" ");
//            }
//            System.out.println();
//        }
		max = 0;
		for (int i = 0; i < list.size(); i++) {
			result = 0;
			searchEnemy(map);
			while (!enemy.isEmpty()) {
				attack(list.get(i));
//				System.out.println(result);
				move();
				max = Math.max(max, result);
			}
//			System.out.println("===========================");
		}
		System.out.println(max);
	}

	private static void dfs(int cnt, int start, int[] temp) {
		if (cnt == 3) {
			list.add(temp.clone());
			return;
		}
		for (int i = start; i < M; i++) {
			temp[cnt] = i;
			dfs(cnt + 1, i + 1, temp);
		}
	}

	private static void deleteEnemy(int x, int y) {
		PriorityQueue<int[]> dist = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o2[1] - o1[1];
				return o1[0] - o2[0];
			}
		});
		for (int i = 0; i < enemy.size(); i++) {
			int temp = Math.abs(enemy.get(i)[0] - x) + Math.abs(enemy.get(i)[1] - y);
			dist.add(new int[] { temp, i });
		}
//		System.out.println(x+", "+y);
//		for(int[] i : dist) {
//			System.out.println("["+x+"번째 궁수]  적의 인덱스 : "+i[1]+", 적과의 거리 : "+i[0]);
//		}
		for(int i=0;i<dist.size();i++) {
			if(dist.peek()[0] <= D) {
				if(ready.size() < 3 && !ready.contains(dist.peek()[1])) {
					ready.add(dist.poll()[1]);
					return;
				}
				dist.poll();
			}
		}
	}

	// 거리가 D이하인 적 중에서 가장 가까운 적
	// 적이 여럿일 경우 가장 왼쪽에 있는 적을 공격
	// 같은 적이 여러 궁수에게 공격당할 수 있다.
	private static void attack(int[] archerPosition) {
		ready = new ArrayList<>();
		if (enemy.size() != 0) {
//			for(int i=0;i<enemy.size();i++) {
//				System.out.println(Arrays.toString(enemy.get(i)));
//			}
			boolean[] visited = new boolean[enemy.size()];
			for (int a = 0; a < archerPosition.length; a++) {
				deleteEnemy(archerPosition[a], N);
			}
//			System.out.println(ready);
			int count = 0;
			ready.sort(Comparator.naturalOrder());
			for (int i = 0; i < ready.size(); i++) {
				if (!visited[ready.get(i)]) {
					visited[ready.get(i)] = true;
					int idx = ready.get(i);
					enemy.remove(idx - count++);
					result++;
				}
			}
		}
	}

	private static void searchEnemy(int[][] map) {
		enemy = new ArrayList<>();
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (map[y][x] == 1) {
					enemy.add(new int[] { x, y });
				}
			}
		}
	}

	private static void move() {
		for(int i=0;i<enemy.size();i++) {
			int[] temp = enemy.get(i);
			if (temp[1] + 1 < N) {
				temp[1] += 1;
				enemy.add(i, temp);
				enemy.remove(i+1);
			} else {
				enemy.remove(i--);
			}
		}
//		for(int i=0;i<enemy.size();i++) {
//			System.out.println(Arrays.toString(enemy.get(i)));
//		}
	}

}
