package swea;
import java.util.*;
import java.io.*;

public class p1209 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int k = 0;k<10;k++) {
			int test_case = sc.nextInt();
			int [][]arr = new int[100][100];
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int a = 0, b = 0;
			ArrayList temp = new ArrayList();
			for(int i = 0;i<100;i++) {
				int rhap = 0;
				int chap = 0;
				for(int j=0;j<100;j++) {
					if(i == j) {
						a += arr[i][j];
					}
					if(i + j == 99) {
						b += arr[i][j];
					}
					rhap += arr[i][j];
					chap += arr[j][i];
				}
				temp.add(rhap);
				temp.add(chap);
			}
			temp.add(a);
			temp.add(b);
			temp.sort(Comparator.reverseOrder());
			System.out.println("#"+test_case+" "+temp.get(0));
		}
		}
		

}
