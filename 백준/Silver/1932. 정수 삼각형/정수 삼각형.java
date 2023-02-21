import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static ArrayList<Integer>[] triangle;
	static int N;
	static int result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		triangle = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			triangle[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				triangle[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		int[][] temp = new int[N][N+1];
		for(int i=0;i<N;i++) {
			for(int j=1;j<=i+1;j++) {
				temp[i][j] = triangle[i].get(j-1);
				if(i-1 >= 0 && j-1 >= 0) {
					temp[i][j] = Math.max(
							temp[i][j] + temp[i-1][j], 
							temp[i][j] + temp[i-1][j-1]);
				}
			}
		}
		int result = 0;
		for(int i=0;i<N+1;i++) {
			result = Math.max(result,  temp[N-1][i]);
		}
		System.out.println(result);
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N+1; j++) {
//				System.out.print(temp[i][j]+" ");
//			}
//			System.out.println();
//		}
		
	}
}