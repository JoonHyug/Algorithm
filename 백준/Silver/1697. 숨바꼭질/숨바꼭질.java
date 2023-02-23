import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	static int max = 100001;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int K = Integer.parseInt(NM[1]);
		
		bfs(N, K);
	}
	
	private static void bfs(int start, int K) {
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[max];
		int[] count = new int[max];
		queue.add(start);
		visited[start] = true;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			if(now == K) {
				break;
			}
			int[] move = {now + 1, now - 1, now * 2};
			for(int i : move) {
				if(0<= i && i < max) {
					if(!visited[i]) {
						visited[i] = true;
						count[i] = count[now] + 1;
						queue.add(i);
					}					
				}
			}
		}
		System.out.println(count[K]);
	}

}