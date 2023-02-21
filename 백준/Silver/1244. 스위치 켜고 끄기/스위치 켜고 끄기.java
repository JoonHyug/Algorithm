import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] switchs;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		switchs = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<switchs.length;i++) {
			switchs[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			change(s, num);
		}
		for(int i=1;i<switchs.length;i++) {
			System.out.print(switchs[i]+" ");
			if(i % 20 == 0) {
				System.out.println();
			}
		}
	}
	private static void change(int s, int num) {
		//남자
		if(s == 1) {
			for(int i=1;i<switchs.length;i++) {
				if(i % num == 0) {
					if(switchs[i] == 1) switchs[i] = 0;
					else switchs[i] = 1;
				}
			}
		} 
		//여자
		else if(s == 2) {
			int cnt = 0;
			for(int i=1;i<switchs.length/2;i++) {
				if(num-i > 0 && num+i < switchs.length) {
					if(switchs[num-i] != switchs[num+i]) {
						break;
					} else {
						cnt++;
					}
				}
			}
			for(int i = num-cnt;i<=num+cnt;i++) {
				if(switchs[i] == 1) switchs[i] = 0;
				else switchs[i] = 1;
			}
		}
	}

}