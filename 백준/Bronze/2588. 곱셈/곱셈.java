import java.util.*;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        String B = sc.next();
        int bLeng = B.length();
        int[] num = new int[bLeng];
        for(int i=bLeng-1;i>=0;i--) {
        	System.out.println(A * (B.charAt(i)-'0'));
        }
        System.out.println(A * (Integer.parseInt(B)));
 	}
}


