package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p1954 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] temp = new int[N][N];
			int[] dx = {1, 0, -1, 0};
			int[] dy = {0, 1, 0, -1};
			int x = 0;
			int y = 0;
			int move = 0;
			for(int i=1;i<=N*N;i++) {
				temp[y][x] = i;
				int ny = y + dy[move];
				int nx = x + dx[move];
				if(0 > ny || ny >= N || 0 > nx || nx >= N || temp[ny][nx] != 0) {
					move = (move+1) % 4;
				}
				x = x + dx[move];
				y = y + dy[move];
			}
			System.out.println("#" + tc );
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(temp[i][j] + " ");
				}
				System.out.println();
			}
		}
		
	
	}

}
