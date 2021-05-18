package Solution.October;


public class October2 { // 쿼드 압축 후 개수 세기

	public int[] solution(int[][] arr) {
		int[] answer = new int[2];
		StringBuilder sb = new StringBuilder();
		quad(0, 0, arr.length, arr, sb);

		int cnt1 = 0, cnt2 = 0;
		for (int i = 0; i < sb.length(); i++)
			if (sb.charAt(i) == '0')
				cnt1++;
			else if (sb.charAt(i) == '1')
				cnt2++;

		answer[0] = cnt1;
		answer[1] = cnt2;
		return answer;
	}

	public void quad(int row, int col, int n, int[][] arr, StringBuilder result) {
		// row, col = 0
		// n = 8

		if (check(row, col, n, arr) == 0) {
			result.append("0");
			return;
		} else if (check(row, col, n, arr) == 1) {
			result.append("1");
			return;
		}
		if (n == 1) {
			result.append(Integer.toString(arr[row][col]));
			return;
		}

		n = n / 2;
		quad(row, col, n, arr, result);
		quad(row, col + n, n, arr, result);
		quad(row + n, col, n, arr, result);
		quad(row + n, col + n, n, arr, result);

		return;
	}

	public int check(int row, int col, int n, int[][] arr) {

		int k = 0;
		int kk = 0;
		for (int i = row; i < row + n; i++) {
			for (int j = col; j < col + n; j++) {
				if (0 == arr[i][j])
					k++;
				else
					kk++;
			}

		} // for

		if (k == n * n)
			return 0;
		else if (kk == n * n)
			return 1;

		return -1;

	}

}
