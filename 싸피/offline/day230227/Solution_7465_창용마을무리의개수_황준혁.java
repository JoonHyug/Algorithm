package offline.day230227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_7465_창용마을무리의개수_황준혁 {
	
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			arr = new int[N+1];
			makeSet(N);
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			boolean[] temp = new boolean[N+1];
			for(int i=1;i<=N;i++) {
				temp[find(i)] = true;
			}
			int count = 0;
			for(int i=0;i<temp.length;i++) {
				if(temp[i]) count++;
			}
			HashSet<Integer> set = new HashSet<>();
			for(int i=1;i<=N;i++) {
				set.add(find(i));
			}
			
			System.out.printf("#%d %d\n", tc, count);
		}
	}
	
	private static void makeSet(int N) {
		for(int i=1;i<=N;i++) {
			arr[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a == arr[a]) return a;
		arr[a] = find(arr[a]);
		return find(arr[a]);
	}
	
	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		arr[rootB] = rootA; 
	}

}
