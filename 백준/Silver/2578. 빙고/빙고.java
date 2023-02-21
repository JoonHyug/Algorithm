import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [][]bingo = new int[5][5];
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				bingo[i][j] = sc.nextInt();
			}
		}
		int cnt = 0;
		int []A = new int [5*5];
		for(int i=0;i<5*5;i++) {
			A[i] = sc.nextInt();
		}
		for(int k=0;k<5*5;k++) {
			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					if(bingo[i][j] == A[k]) {
						bingo[i][j] = 0;
					}
					if(check(bingo)) {
						i = 5;
						System.out.println(k + 1);
						k = 25;
						break;
					}
					
				}
			}
		}
	}
	public static boolean check(int [][]bingo) {
		ArrayList<Integer> arr = new ArrayList<>();
		int a = 0;
		int b = 0;
		for(int i=0;i<5;i++) {
			int row = 0;
			int col = 0;
			for(int j=0;j<5;j++) {
				if(i == j) {
					a += bingo[i][j];
				}
				if(i + j == 4) {
					b += bingo[i][j];
				}
				row += bingo[i][j];
				col += bingo[j][i];
			}
			arr.add(row);
			arr.add(col);
		}
		arr.add(a);
		arr.add(b);
		int cnt = 0;
		for(int i=0;i<arr.size();i++) {
			if(arr.get(i) == 0) cnt++;
		}
		if(cnt >= 3) return true;
		return false;
	}

}
