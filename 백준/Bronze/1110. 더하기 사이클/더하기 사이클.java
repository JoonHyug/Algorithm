import java.util.*;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a = (N%100)/10;
        int b = N%10;
        int i=0;
        int temp = 0;
        while(true) {
        	temp = (a + b)%10;
        	a = b;
        	b = temp;
        	i++;
        	String sum = Integer.toString(a) + Integer.toString(b);
        	if(Integer.parseInt(sum) == N) {
        		break;
        	} 	
        }
        System.out.println(i);
 	}
}