package offline.day230306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


/**
 * 1. 배열 안에서 가로로 M칸 만큼 값을 더한 모든 값을 리스트에 저장 =>(각각의 원소와 그 전체의 합을 저장할 수 있는 클래스 구현)
 * => 행을 한줄씩 잘라보면서 확인하면 될듯 => 각각의 합이 C를 넘을 경우는 원소들 중 C를 넘지 않는 범위에서 큰 값 순서대로 저장
 * 2. 배열을 내림차순으로 정렬한 뒤 합이 C보다 작거나 같은 것을 기준으로 내림차순 정렬 3. C를 넘지않는 가장 큰 값을 2개 선택하여
 * 계산
 */
public class Solution_2115_벌꿀채취 {

	static int N, M, C;
	static int[][] map;
	static List<Honey> list;

	static class Honey implements Comparable<Honey> {
		int hap;
		int result;
		int[] element;
		int x;
		int y;

		public Honey(int hap, int result, int[] element, int x, int y) {
			super();
			this.hap = hap;
			this.result = result;
			this.element = element;
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Honey o) {
			return o.result - this.result;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			list = new ArrayList<>();
			search();
			Collections.sort(list);
			int sum = 0;
			int cnt = 0;
			int x = -1;
			int y = -1;
			for (int i = 0; i < list.size(); i++) {
				if (cnt == 2)
					break;
				if (list.get(i).y == y && (x - M < list.get(i).x || list.get(i).x < x + M))
					continue;
				x = list.get(i).x;
				y = list.get(i).y;
				sum += list.get(i).result;
				cnt++;
			}
			sb.append("#" + tc + " ").append(sum).append("\n");
//			for (int i = 0; i < list.size(); i++) {
//				System.out.print(
//						list.get(i).hap + ", " + list.get(i).result + " : " + Arrays.toString(list.get(i).element));
//				System.out.println(" 시작좌표 : " + list.get(i).x + ", " + list.get(i).y);
//			}
		}
		System.out.println(sb);
	}

	private static void search() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j <= map[i].length - M; j++) {
				int hap = 0;
				int[] temp = new int[M];
				int idx = 0;
				for (int a = j; a < j + M; a++) {
					hap += map[i][a];
					temp[idx++] = map[i][a];
				}
				if (hap > C) {
					int[] temp2 = temp.clone();
					int[] temp3 = temp.clone();
					Arrays.sort(temp2);
					Arrays.sort(temp3);
					int sum = 0;
					for (int t = temp2.length - 1; t >= 0; t--) {
						if (sum + temp2[t] <= C) {
							sum += temp2[t];
						} else {
							temp2[t] = 0;
						}
					}
					sum = 0;
					for (int t = 0; t < temp3.length; t++) {
						if (sum + temp3[t] <= C) {
							sum += temp3[t];
						} else {
							temp3[t] = 0;
						}
					}
					int hap1 = 0;
					int hap2 = 0;
					for (int t = 0; t < M; t++) {
						hap1 += temp2[t];
						hap2 += temp3[t];
					}
					if(hap1 < hap2) {
						hap = hap2;
						temp = temp3.clone();
					} else if(hap1 > hap2) {
						hap = hap1;
						temp = temp2.clone();
					} else {
						int cal1 = 0;
						int cal2 = 0;
						for(int a=0;a<temp2.length;a++) {
							cal1 += Math.pow(temp2[a], 2);
						}
						for(int a=0;a<temp3.length;a++) {
							cal2 += Math.pow(temp3[a], 2);
						}
						if(cal1 >= cal2) {
							hap = hap1;
							temp = temp2.clone();
						} else {
							hap = hap2;
							temp = temp3.clone();
						}
					}
				}
				int result = 0;
				for (int a = 0; a < temp.length; a++) {
					result += Math.pow(temp[a], 2);
				}
				list.add(new Honey(hap, result, temp, j, i));
			}
		}
	}

}
