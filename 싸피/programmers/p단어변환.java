package programmers;

public class p단어변환 {

	static int answer = 0;

	public static int solution(String begin, String target, String[] words) {
		answer = 0;
		dfs(begin, target, words, 0, new boolean[words.length]);
		return answer;
	}

	private static void dfs(String begin, String target, String[] words, int cnt, boolean[] visited) {
		if(begin.equals(target)) {
			answer = cnt;
			return;
		}
		for(int i=0;i<words.length;i++) {
			if(!visited[i]) {
				int w = 0;
				for(int j=0;j<begin.length();j++) {
					if(begin.charAt(j) == words[i].charAt(j)) {
						w++;
					}
				}
				if(w == begin.length() -1) {
					visited[i] = true;
					dfs(words[i], target, words, cnt + 1, visited);
					visited[i] = false;
				}				
			}
		}
	}

	public static void main(String[] args) {
		String[] words1 = { "hot", "dot", "dog", "lot", "log", "cog" };
		String[] words2 = { "hot", "dot", "dog", "lot", "log" };
		System.out.println(solution("hit", "cog", words1));
		System.out.println(solution("hit", "cog", words2));
	}

}
