package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class p17143_낚시왕 {

	static class Shark {
		int no; //��� ��ȣ
		int r; // ����� ��
		int c; // ����� ��
		int s; // �ӷ�
		int d; // �̵� ����, 1 : ��, 2 : �Ʒ�, 3 : ������, 4 : ����
		int z; // ũ��

		public Shark(int no, int r, int c, int s, int d, int z) {
			super();
			this.no = no;
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	static int[][] map;
	static int R, C, M;
	static List<Shark> list;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		map = new int[R][C];
		for(int[] arr : map) {
			Arrays.fill(arr, -1);			
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			list.add(new Shark(i, r, c, s, d, z));
			map[r][c] = i;
		}
		result = 0;
		for(int i=0;i<C;i++) {
			humanMove(i);
		}
		System.out.println(result);

	}
	
	private static void print() {
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				System.out.print(map[i][j] == -1 ? "x" : map[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println("=====================");
	}

	private static void humanMove(int cnt) {
		print();
		for(int i=0;i<R;i++) {
			if(map[i][cnt] != -1) {
				result += list.get(map[i][cnt]).z;
				list.set(map[i][cnt], null);
//				list.remove(map[i][cnt]);
				break;
			}
		}
		sharkMove();
	}
	
	private static void sharkMove() {
		for(int i=0;i<list.size();i++) {
			if(list.get(i) != null) {
				Shark s = list.get(i);
				test(s, 0);
				map[s.r][s.c] = -1;				
			}
			
		}
	}
	
	private static void test(Shark shark, int cnt) {
		Shark sh = shark;
		if(cnt == sh.s) {
			list.set(sh.no, sh);
			if(map[sh.r][sh.c] != -1) {
				map[sh.r][sh.c] = compare(map[sh.r][sh.c], sh.no);				
			} else {
				map[sh.r][sh.c] = sh.no;
			}
			return;
		}
		
		
		switch(sh.d) {
		//��
		case 1:
			if(0 > sh.r-1) {
				sh.d = 2;
				test(sh, cnt);
			} else {
				sh.r--;
				test(sh, cnt+1);
			}
			break;
		//�Ʒ�
		case 2:
			if(sh.r+1 > R) {
				sh.d = 1;
				test(sh, cnt);
			} else {
				sh.r++;
				test(sh, cnt+1);
			}
			break;
		//������
		case 3:
			if(sh.c+1 > C) {
				sh.d = 4;
				test(sh, cnt);
			} else {
				sh.c++;
				test(sh, cnt+1);
			}
			break;
		//����
		case 4:
			if(0 > sh.c-1) {
				sh.d = 3;
				test(sh, cnt);
			} else {
				sh.c--;
				test(sh, cnt + 1);
			}
			break;
		}
	}
	
	private static int compare(int idx1, int idx2) {
		int idx = 0;
		if(list.get(idx1).z > list.get(idx2).z) {
			idx = idx1;
			list.set(idx2, null);
//			list.remove(idx2);
		} else {
			idx = idx2;
			list.set(idx1, null);
//			list.remove(idx1);
		}
		return idx;
	}
	

	
	

}

