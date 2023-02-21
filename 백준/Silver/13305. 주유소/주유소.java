import java.util.*;

public class Main {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] distance = new int[N-1];
		int[] gas = new int[N];
		for(int i=0;i<distance.length;i++) {
			distance[i] = sc.nextInt();
		}
		for(int i=0;i<gas.length;i++) {
			gas[i] = sc.nextInt();
		}
		int min = gas[0];
		for(int i=0;i<gas.length;i++) {
			gas[i] = Math.min(gas[i], min);
			min = gas[i];
		}
		int answer = 0;
		for(int i=0;i<distance.length;i++) {
			answer += gas[i] * distance[i];
		}
		System.out.println(answer);
	}

}
