package offline.day230302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_Main_17143_낚시왕_황준혁 {

	static class Shark {
		int no; // 상어 번호
		int r; // 상어의 행
		int c; // 상어의 열
		int s; // 속력
		int d; // 이동 방향, 1 : 위, 2 : 아래, 3 : 오른쪽, 4 : 왼쪽
		int z; // 크기

		public Shark(int no, int r, int c, int s, int d, int z) {
			super();
			this.no = no;
			this.r = r;
			this.c = c;
			if(d<=2) s %= (2*R-2);
			//방향이 좌우 일 때 최적화
			else s %= (2*C-2);
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	static int[][] map;
	static int R, C, M;
	static List<Shark> list;
	static int result;
	static boolean[] remove;
	static boolean[] isMove;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		map = new int[R][C];
		for (int[] arr : map) {
			Arrays.fill(arr, -1);
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			list.add(new Shark(i, r, c, s, d, z));
			map[r][c] = i;
		}
		result = 0;
		remove = new boolean[M];
		for (int i = 0; i < C; i++) {
//			print();
			humanMove(i);
			sharkMove();
		}
		System.out.println(result);

	}

	private static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] == -1 ? "x" : (char) ('A' + map[i][j]));
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("=====================");
	}

	private static void humanMove(int cnt) {
		//땅이 0 이니까 땅에서 가까운 상어를 찾기 위해 0부터 반복문
		for (int i = 0; i < R; i++) {
			//-1이 아닌 칸은 상어가 있는 칸
			if (map[i][cnt] != -1) {
				result += list.get(map[i][cnt]).z;
				remove[map[i][cnt]] = true;
				map[i][cnt] = -1;
				break;
			}
		}
	}

	private static void sharkMove() {
		isMove = new boolean[M];
		for (int i = 0; i < list.size(); i++) {
			if (!remove[i]) {
				Shark s = list.get(i);
				isMove[s.no] = true;
				test(s, 0);
			}

		}
//		print();
	}

	private static void test(Shark shark, int cnt) {
		if(cnt == 0) {
			if(map[shark.r][shark.c] == shark.no) {
				map[shark.r][shark.c] = -1; 
			}
		}
//		System.out.printf("%c번째 상어 : %d, %d / 방향 : % d 이동 : %d/%d 크기 : %d\n", 'A' + shark.no, shark.r, shark.c, shark.d, cnt, shark.s, shark.z);
		//한칸에 여러마리의 상어가 올 경우 처리 안되는듯
		if (cnt == shark.s) {
			if (map[shark.r][shark.c] != -1 && isMove[map[shark.r][shark.c]]) {
				map[shark.r][shark.c] = compare(map[shark.r][shark.c], shark.no);
			} else {
				map[shark.r][shark.c] = shark.no;				
			}

			return;
		}

		switch (shark.d) {
		// 위
		case 1:
			if (0 > shark.r - 1) {
				shark.d = 2;
				test(shark, cnt);
			} else {
				shark.r--;
				test(shark, cnt + 1);
			}
			break;
		// 아래
		case 2:
			if (shark.r + 1 >= R) {
				shark.d = 1;
				test(shark, cnt);
			} else {
				shark.r++;
				test(shark, cnt + 1);
			}
			break;
		// 오른쪽
		case 3:
			if (shark.c + 1 >= C) {
				shark.d = 4;
				test(shark, cnt);
			} else {
				shark.c++;
				test(shark, cnt + 1);
			}
			break;
		// 왼쪽
		case 4:
			if (0 > shark.c - 1) {
				shark.d = 3;
				test(shark, cnt);
			} else {
				shark.c--;
				test(shark, cnt + 1);
			}
			break;
		}
	}

	private static int compare(int idx1, int idx2) {
		int idx = 0;
		if (list.get(idx1).z > list.get(idx2).z) {
			idx = idx1;
			remove[idx2] = true;
		} else {
			idx = idx2;
			remove[idx1] = true;
		}
//		System.out.println((char) ('A' + idx1) + ", " + (char) ('A' + idx2) + "가 싸워 " + (char) ('A' + idx) + "상어가 이김");
		return idx;
	}

}