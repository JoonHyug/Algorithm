package offline.day230207;

import java.util.*;
public class Solution_1210_Ladder1_황준혁 {

	static int[][] ladder;
	static int size = 100;
	static boolean[][] visited;
	static int result;
	
	public static void search(int x, int y) {
		if(y == 0) {
			result = x-1;
			return;
		}
		if(!visited[y][x] && x + 1 <= size+2 && x - 1 >=0 && y >= 0) {
			visited[y][x] = true;
			if(ladder[y][x+1] == 1 && !visited[y][x+1]) {
				search(x+1, y);
			} else if(ladder[y][x-1] == 1 && !visited[y][x-1]) {
				search(x-1, y);
			} else if(ladder[y-1][x] == 1) {
				search(x, y-1);
			}
		}
			
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=0;tc<10;tc++) {
			int T = sc.nextInt();
			ladder = new int[size][size+2];
			for(int i=0;i<ladder.length;i++) {
				for(int j=1;j<ladder[i].length-1;j++) {
					ladder[i][j] = sc.nextInt();
				}
			}
			int start = 0;
			for(int i=0;i<size+2;i++) {
				if(ladder[size-1][i] == 2) {
					start = i;
				}
			}
			visited = new boolean[size][size+2];
			search(start, size-1);
			System.out.printf("#%d %d\n", T, result);
		}

	}

}
