package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p2630 {

	static int[][] arr;
	static int blue;
	static int white;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0;i<arr.length;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<arr[i].length;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cut(0, 0, N);
		sb.append(white+"\n");
		sb.append(blue);
		System.out.println(sb.toString());
	}
	
	private static void cut(int x, int y, int size) {
		int sum = 0;
		for(int i=y, yMax = y+size;i<yMax;i++) {
			for(int j=x, xMax = x+size;j<xMax;j++) {
				sum += arr[i][j];
			}
		}
		
		if(sum == size * size) {
			blue++;
		} else if(sum == 0) {
			white++;
		} else {
			int half = size/2;
			cut(x, y, half);
			cut(x+half, y, half);
			cut(x, y+half, half);
			cut(x+half, y+half, half);
		}
	}

}
