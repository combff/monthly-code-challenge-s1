
public class September2 { // 삼각 달팽잉

	public int[] solution(int n) {
		int[][] arr = new int[n][n];

		int sum = 0;
		for (int i = 1; i <= n; i++)
			sum += i;

		int[] answer = new int[sum];
		int check = 1, step = 0;
		int col = 0, row = n - 1, k = 0;

		while (check <= sum) {
			for (int i = k; i < k + (n - step); i++) {
				arr[i][col] = check++;
			}

			if (check > sum)
				break;

			col++;
			step++;
			for (int i = col; i < col + (n - step); i++) {
				arr[row][i] = check++;
			}

			if (check > sum)
				break;

			row--;
			step++;
			for (int i = 0; i < n - step; i++) {
				arr[row - i][col + (n - step) - i - 1] = check++;
				k = row - i;
			}

			k++;
			step++;
		} // while

		int index = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] > 0) {
					answer[index] = arr[i][j];
					index++;
				}

			}
		}
		return answer;
	}

}
