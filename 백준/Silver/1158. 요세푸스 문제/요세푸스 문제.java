import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1;i<=N;i++) {
			queue.add(i);
		}
		sb.append("<");
		while(queue.size() != 0) {
			for(int i=0;i<K;i++) {
				if(i == K-1) {
					if(queue.size() == 1) {
						sb.append(queue.poll());
					} else {
						sb.append(queue.poll()+", ");						
					}
				} else {
					queue.add(queue.poll());					
				}
			}
		}
		sb.append(">");
		System.out.println(sb.toString());
		
	}

}