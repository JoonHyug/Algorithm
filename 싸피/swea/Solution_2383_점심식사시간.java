/**
 * 1. 한 계단에는 3명밖에 못들어감, 계단은 무조건 2개
 * 	- 계단을 빠져나가는 시간인 K만큼이 지나야 통과하는 큐를 만듬
 * 		- 큐의 크기는 3으로 고정 
 * 2. 도착했더라도 3명이 이미 들어가있으면 입구에서 대기해야함
 * 	- 도착하는 순서대로 큐를 만들어 관리
 * 3. 모든 사람은 동시에 움직임
 * 4. 모든 사람이 계단을 통과하는데 걸리는 최단 시간을 구하기
 * 
 * 풀이
 * 1. 사람의 위치와 계단의 위치를 파악하고 각 계단에서 모든 사람까지의 거리를 구하기
 * 2. 2개의 map을 만들고 각 계단 별로 모든 사람에 대한 거리를 줄여나가면서 서로 연산
 * 
 * K가 큰 순서대로 사람들을 선정?
 * 
 * 각 계단별로 부분집합을 만들어 모든 경우 중 가장 짧은 시간
 * 
 */

package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_2383_점심식사시간 {
	
	static int N;
	static int[][] map;
	static boolean[] subVisited;
	static List<List<Integer>> subset;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			List<int[]> human = new ArrayList<>();
			List<int[]> stairs = new ArrayList<>();
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i=0;i<map.length;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<map[i].length;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						human.add(new int[] {j, i});
					} else if(map[i][j] >= 2) {
						stairs.add(new int[] {j, i, map[i][j]});
					}
				}
			}
			
			
			
			subVisited = new boolean[human.size()];
			subset = new ArrayList<>();
			subSet(0, human.size());
			
			int[] dist_1 = new int[human.size()];
			for (int i = 0; i < dist_1.length; i++) {
				dist_1[i] = Math.abs(human.get(i)[0] - stairs.get(0)[0]) + Math.abs(human.get(i)[1] - stairs.get(0)[1]);
			}
			int[] dist_2 = new int[human.size()];
			for (int i = 0; i < dist_2.length; i++) {
				dist_2[i] = Math.abs(human.get(i)[0] - stairs.get(1)[0]) + Math.abs(human.get(i)[1] - stairs.get(1)[1]);
			}
			System.out.println(Arrays.toString(dist_1));
			System.out.println(Arrays.toString(dist_2));
			
			int min = Integer.MAX_VALUE;
			for(int s = 0;s<subset.size();s++) {
				boolean[] check = new boolean[human.size()];
				for(int stair = 0;stair<stairs.size();stair++) {
					for(int i=0;i<subset.get(s).size();i++) {
						if(!check[subset.get(s).get(i)]) {
							check[subset.get(s).get(i)] = true;
							dist_1[subset.get(s).get(i)]--;
							if(dist_1[subset.get(s).get(i)] == 0) {
								
							}
//							int[] now = stairs.get(stair);
//							int x = now[0];
//							int y = now[1];
//							int k = now[2];
//							int[] h = human.get(subset.get(s).get(i));
							
						}
					}
				}
			}
			
			sb.append("#");
			sb.append(0);
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	private static void subSet(int cnt, int size) {
		if(cnt == size) {
			List<Integer> temp = new ArrayList<>();
			for(int i=0;i<subVisited.length;i++) {
				if(subVisited[i]) {
					temp.add(i);
				}
			}
			if(temp.size() != 0) {
				subset.add(temp);				
			}
			return;
		}
		subSet(cnt + 1, size);
		subVisited[cnt] = true;
		subSet(cnt + 1, size);
		subVisited[cnt] = false;
		
	}

}
