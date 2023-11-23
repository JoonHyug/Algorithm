package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p11723 {
	private boolean[] temp;
	public void add(int X) {
		temp[X] = true;
	}
	public void remove(int X) {
		temp[X] = false;
	}
	public int check(int X) {
		if(temp[X]) return 1;
		return 0;
	}
	public void toggle(int X) {
		temp[X] = !temp[X];
	}
	public void all() {
		for(int i=1;i<temp.length;i++) {
			temp[i] = true;
		}
	}
	public void empty() {
		for(int i=1;i<temp.length;i++) {
			temp[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		p11723 set = new p11723();
		int T = Integer.parseInt(br.readLine());
		set.temp = new boolean[21];
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int value = 0;
			switch(st.nextToken()) {
			case "add":
				value = Integer.parseInt(st.nextToken());
				set.add(value);
				break;
			case "remove":
				value = Integer.parseInt(st.nextToken());
				set.remove(value);
				break;
			case "check":
				value = Integer.parseInt(st.nextToken());
				sb.append(set.check(value)).append('\n');
				break;
			case "toggle":
				value = Integer.parseInt(st.nextToken());
				set.toggle(value);
				break;
			case "all":
				set.all();
				break;
			case "empty":
				set.empty();
				break;
			}
		}
		System.out.println(sb);
	}

}
