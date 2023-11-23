/**
 * 문제 해석
 * R X C 격자판
 * - 낚시왕은 처음에 0열에 위치
 * 
 * 1초 동안 일어나는 일
 * 1. 낚시왕 오른쪽으로 한칸 이동
 * 2. 낚시왕이 위치한 열의 땅과 제일 가까운 상어 잡기
 * 		=> 잡은 상어는 격자판에서 사라짐
 * 3. 상어 이동
 * 
 * 상어 이동
 * - 주어진 방향으로 속도 만큼 이동
 * - 경계를 넘는 경우 방향을 반대로 바꿔서 이동
 * - 이동 후 여러마리의 상어가 있다면 큰 사엉가 모두 잡아먹음
 * 
 * => 낚시왕이 잡은 상어의 크기 구하기
 * 
 * 문제 해결 프로세스
 * 1. 낚시왕이 오른족으로 1칸 이동
 * 	=> 1~C 만큼 이동
 * 2. 낚시왕이 위치한 열의 땅과 가장 가까운 상어 잡기
 * 	a. 낚시왕 위치한 열 기준 1 ~ R행 까지 탐색
 *  b. 상어 발견 시, 상어 크기 cnt 후, 상어 제거
 * 3. 상어 이동
 * 	a. 기존 배열에서 상어를 이동시킬 경우, 이동하지 않은 상오와 겹치는 상황이 발생
 * 		=> 임시 배열을 만들어서 해당 배열에 상어를 배치 후, 기존 배열이 임시 배열을 참조하도록 변경
 * 	1) 상어의 이동 위치 계산
 * 		=> 속력(s) 만큼 한칸씩 이동
 * 	2) 해당 위치에 상어 배치
 */

package offline.day230302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_Main_17143_낚시왕_황준혁_교수님 {

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
	static int[][] tempMap;

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
			humanMove(i);
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
		for (int i = 0; i < R; i++) {
			if (map[i][cnt] != -1) {
				result += list.get(map[i][cnt]).z;
				remove[map[i][cnt]] = true;
				map[i][cnt] = -1;
				break;
			}
		}
		sharkMove();
	}

	private static void sharkMove() {
		isMove = new boolean[M];
		for (int[] arr : map) {
			Arrays.fill(arr, -1);
		}
		for (int i = 0; i < list.size(); i++) {
			if (!remove[i]) {
				Shark s = list.get(i);
				isMove[s.no] = true;
				test(s, 0);
			}

		}
		print();
	}

	private static void test(Shark shark, int cnt) {
		if(cnt == 0) {
			if(map[shark.r][shark.c] == shark.no) {
				map[shark.r][shark.c] = -1; 
			}
		}
		System.out.printf("%c번째 상어 : %d, %d / 방향 : % d 이동 : %d/%d\n", 'A' + shark.no, shark.r, shark.c, shark.d, cnt, shark.s);
		if (cnt == shark.s) {
			if (map[shark.r][shark.c] != -1) {
				map[shark.r][shark.c] = compare(map[shark.r][shark.c], shark.no);
			}
			map[shark.r][shark.c] = shark.no;

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
		System.out.println((char) ('A' + idx1) + "과 " + (char) ('A' + idx2) + "가 싸워 " + (char) ('A' + idx) + "상어가 이김");
		return idx;
	}

}
