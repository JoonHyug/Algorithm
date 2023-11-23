package offline.day230222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1873_상호의배틀필드_황준혁 {

	static int H, W;
	static char[][] map;
	static char direction;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for(int i=0;i<map.length;i++) {
				map[i] = br.readLine().toCharArray();
			}
			int N = Integer.parseInt(br.readLine());
			char[] order = new char[N];
			String s = br.readLine();
			for(int i=0;i<s.length();i++) {
				order[i] = s.charAt(i);
			}
			direction = ' ';
			for(int i=0;i<order.length;i++) {
				test(order[i]);
			}
			
			sb.append("#"+tc).append(" ");
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");					
			}
		}
		System.out.print(sb.toString());
		
	}
	
	private static void test(char c) {
		switch(c) {
		case 'U':
			move('^');
			break;
		case 'D':
			move('v');
			break;
		case 'L':
			move('<');
			break;
		case 'R':
			move('>');
			break;
		case 'S':
			shoot();
			break;
		}
	}
	
	private static int[] tankPosition() {
		//상 : 0, 우 : 1, 하 : 2, 좌 : 3
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				switch(map[i][j]) {
				case '^':
					direction = '^';
					return new int[] {i, j};
				case '>':
					direction = '>';
					return new int[] {i, j};
				case 'v':
					direction = 'v';
					return new int[] {i, j};
				case '<':
					direction = '<';
					return new int[] {i, j};
				}
			}
		}
		return new int[] {0, 0};
	}
	
	private static void move(char dir) {
		int now[] = tankPosition();
		map[now[0]][now[1]] = dir;
		direction = dir;
		switch(dir) {
		case '^':
			if(0 <= now[0] - 1&& map[now[0] - 1][now[1]] == '.') {
				char temp = map[now[0] - 1][now[1]];
				map[now[0] - 1][now[1]] = '^';
				map[now[0]][now[1]] = temp;
			}
			break;
		case '>':
			if(now[1] + 1 < W && map[now[0]][now[1] + 1] == '.') {
				char temp = map[now[0]][now[1] + 1];
				map[now[0]][now[1] + 1] = '>';
				map[now[0]][now[1]] = temp;
			}
			break;
		case 'v':
			if(now[0] + 1 < H && map[now[0] + 1][now[1]] == '.') {
				char temp = map[now[0] + 1][now[1]];
				map[now[0] + 1][now[1]] = 'v';
				map[now[0]][now[1]] = temp;
			}
			break;
		case '<':
			if(0<= now[1] - 1 && map[now[0]][now[1] - 1] == '.') {
				char temp = map[now[0]][now[1] - 1];
				map[now[0]][now[1] - 1] = '<';
				map[now[0]][now[1]] = temp;
			}
			break;
		}
		

	}
	
	private static void shoot() {
		int now[] = tankPosition();
		switch(direction) {
		case '^':
			for(int i=now[0];i>=0;i--) {
				if(map[i][now[1]] == '#') {
					break;
				} else if(map[i][now[1]] == '*') {
					map[i][now[1]] = '.';
					break;
				}
			}
			break;
		case '>':
			for(int i=now[1];i<W;i++) {
				if(map[now[0]][i] == '#') {
					break;
				} else if(map[now[0]][i] == '*') {
					map[now[0]][i] = '.';
					break;
				}
			}
			break;
		case 'v':
			for(int i=now[0];i<H;i++) {
				if(map[i][now[1]] == '#') {
					break;
				} else if(map[i][now[1]] == '*') {
					map[i][now[1]] = '.';
					break;
				}
			}
			break;
		case '<':
			for(int i=now[1]; i >= 0; i--) {
				if(map[now[0]][i] == '#') {
					break;
				} else if(map[now[0]][i] == '*') {
					map[now[0]][i] = '.';
					break;
				}
			}
			break;
		}
	}

}
