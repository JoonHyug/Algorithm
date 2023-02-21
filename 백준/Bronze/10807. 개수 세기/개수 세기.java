import java.util.*;

public class Main {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] temp = new int[N];
		for(int i=0;i<N;i++) {
			temp[i] = sc.nextInt();
		}
		int v = sc.nextInt();
		int count = 0;
		for(int i=0;i<temp.length;i++) {
			if(v == temp[i]) {
				count++;
			}
		}
		System.out.println(count);
 	}
}


