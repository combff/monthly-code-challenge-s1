package Solution.November;

public class November2 { // 이진변환 반복하기
	public int[] solution(String s) {
		int[] answer = { 0, 0 };

		while (s.length() > 0) {
			if (s.equals("1"))
				break;

			int cnt = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '1')
					cnt++;
			}
			answer[1] += s.length() - cnt;

			StringBuilder sb = new StringBuilder();
			binary(cnt, sb);
			s = sb.toString();
			answer[0]++;
		} // while
		return answer;
	}

	public void binary(int n, StringBuilder sb) {

		if (n == 1) {
			sb.append(1);
			return;
		}
		sb.append(n % 2);
		binary(n / 2, sb);
		return;

	}
}
