package offline.day230210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_Main_2164_카드2_황준혁 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1;i<=N;i++) {
			queue.add(i);
		}
		while(queue.size() != 1) {
			queue.remove();
			queue.add(queue.poll());
		}
		System.out.println(queue.peek());
	}

}
