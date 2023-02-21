#include<stdio.h>

int main() {
	int N;
	int K;
	scanf("%d", &N);
	scanf("%d", &K);
	int coins[10];
	int result = 0;

	for (int i = 0; i < N; i++) {
		scanf("%d", &coins[i]);
	}

	for (int i = N-1; i >= 0; i--) {

		while (K >= coins[i]) {
			K = K - coins[i];
			result++;
		}

	}
		
	printf("%d\n", result);
	return 0;
}