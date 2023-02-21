import java.util.*;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] chess = {1, 1, 2, 2, 2, 8};
        int[] temp = new int[chess.length];
        for(int i=0;i<chess.length;i++) {
        	temp[i] = chess[i] - sc.nextInt();
        }
        for(int i=0;i<temp.length;i++) {
        	System.out.print(temp[i]+" ");        	
        }
        
 	}
}


