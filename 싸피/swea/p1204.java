package swea;
import java.util.*;
import java.io.FileInputStream;

public class p1204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0;t<T;t++) {
			int test_case = sc.nextInt();
			int []arr = new int[101];
			for(int i=0;i<1000;i++) {
				int a = sc.nextInt();
				arr[a] += 1;
			}
			int high = 0;
			int index = 0;
			ArrayList temp = new ArrayList();
			for(int i=0;i<arr.length;i++) {
				if(arr[i] >= high) {
					high = arr[i];
					index = i;
//					temp.add(i);
				}
			}
//			temp.sort(Comparator.naturalOrder());
//			System.out.println("#"+test_case+" "+temp.get(temp.size()-1));
			System.out.println("#"+test_case+" "+index);
			
		}
	}
}
