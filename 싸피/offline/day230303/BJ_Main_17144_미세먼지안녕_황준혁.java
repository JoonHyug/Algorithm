/**
 * 1. 공기 청정기 위치 찾기
 * 	-> 클래스로 만들어서 위 아래의 좌표를 기록해놓으면 편할듯
 * 		-> 가장 윗행, 아랫행과 두 칸이상 떨어져 있다.
 * 2. 각 미세먼지들 위치 찾기
 * 3. 각각의 미세먼지들을 bfs로 사방으로 퍼트림
 * 	-> 막혀있거나 공기청정기로는 퍼트리지 못함
 * 		-> 미세먼지가 있던 칸이 아닌 확산되는 칸에는 퍼지는데 이때는 미세먼지의 값이 합쳐진다. 
 */

package offline.day230303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_Main_17144_미세먼지안녕_황준혁 {

	static int R, C, T;
	static int[][] map;
	static List<Node> list;
	static Node up; // 반시계
	static Node down; // 시계
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static class Node {
		int x, y, value;

		public Node(int x, int y, int value) {
			super();
			this.x = x;
			this.y = y;
			this.value = value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];

		up = new Node(0, 0, 0);
		down = new Node(0, 0, 0);
		list = new ArrayList<>();

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < R; i++) {
			if (map[i][0] == -1) {
				up.x = 0;
				up.y = i;
				down.x = 0;
				down.y = i + 1;
				break;
			}
		}

		for (int t = 0; t < T; t++) {
			findDust();
			for (int i = 0; i < list.size(); i++) {
				bfs(list.get(i));
				print();
			}
			// 공기청정기 순회
			moveUpAir();
			moveDownAir();

		}

		System.out.println(sumDust());
	}

	private static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("=======================");
	}
	
	private static void findDust() {
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				if(map[i][j] > 0) list.add(new Node(j, i, map[i][j]));
			}
		}
	}

	private static void bfs(Node now) {
		int count = 0;
		for (int d = 0; d < 4; d++) {
			int nx = now.x + dx[d];
			int ny = now.y + dy[d];
			if (0 <= nx && nx < C && 0 <= ny && ny < R && map[ny][nx] >= 0) {
				count++;
				map[ny][nx] += now.value / 5;
				map[now.y][now.x] -= now.value / 5;
			}
		}

	}

	private static int sumDust() {
		int sum = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] > 0)
					sum += map[i][j];
			}
		}
		return sum;
	}

	// y : 0~up.y 까지, 반시계
	private static void moveUpAir() {
		//좌
		for(int y=up.y;y>=1;y--) {
			if(map[y][0] == -1) continue;
			else map[y][0] = map[y-1][0];
		}
		//상
		for(int x=1;x<C;x++) {
			map[0][x-1] = map[0][x];
		}
		//우
		for(int y=0;y<up.y;y++) {
			map[y][C-1] = map[y+1][C-1];
		}
		//하
		for(int x=C-1;x>=1;x--) {
			if(map[up.y][x-1] == -1) {
				map[up.y][x] = 0;
			} else {
				map[up.y][x] = map[up.y][x-1];				
			}
		}
		print();

	}

	// y : down.y~R 까지, 시계
	private static void moveDownAir() {
		//좌
		for(int y=down.y;y<R-1;y++) {
			if(map[y][0] == -1) continue;
			else map[y][0] = map[y+1][0];
		}
		//하
		for(int x=0;x<C-1;x++) {
			map[R-1][x] = map[R-1][x+1];
		}
		//우
		for(int y=R-1;y>down.y;y--) {
			map[y][C-1] = map[y-1][C-1];
		}
		//상
		for(int x=C-1;x>1;x++) {
			if(map[down.y][x-1] == -1) {
				map[down.y][x] = 0;
			} else {
				map[down.y][x] = map[down.y][x-1];				
			}
		}
		print();
	}
}
