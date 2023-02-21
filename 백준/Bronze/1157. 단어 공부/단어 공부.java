import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int [] c = new int[26];
		char [] temp = str.toCharArray();
		for(char i : temp) {
			if(i-'a' < 0) {
				c[i-'A']++;
			}
			else {
				c[i-'a']++;
			}
		}
		int max = 0;
		for(int i=0;i<c.length;i++) {
//			System.out.printf("%c : %d\n", (char)('A'+i), c[i]);
			if(max < c[i]) {
				max = c[i];
			}
		}
		int cnt = 0;
		int idx = 0;
		for(int i=0;i<c.length;i++) {
			if(max == c[i]) {
				cnt++;
				idx = i;
			}
		}
		if(cnt > 1) {
			System.out.println("?");
		}
		else {
			System.out.println((char)('A'+idx));
		}
	}

}
