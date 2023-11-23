package offline.day230210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_1225_암호생성기_황준혁 {

	static Queue<Integer> queue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 0; tc < 10; tc++) {
			StringBuilder sb = new StringBuilder();
			queue = new LinkedList<Integer>();
			int T = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			check();
			for (int i = 0; i < 8; i++) {
				sb.append(queue.poll() + " ");
			}
			System.out.printf("#%d %s\n", T, sb.toString());
		}
	}

	private static void check() {
		while (true) {
			for (int i = 1; i <= 5; i++) {
				int temp = queue.poll() - i;
				if (temp <= 0) {
					queue.add(0);
					return;
				}
				queue.add(temp);

			}
		}
	}

}
