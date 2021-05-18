package Solution.October;


public class October1 { // 3진법 뒤집기

	public int solution(int n) {
		int answer = 0;
		int[] tmp = new int[100000001];

		for (int i = 0; i < tmp.length; i++)
			tmp[i] = -1;

		int cnt = 0;
		while (n >= 1) {
			tmp[cnt] = n % 3;
			n = n / 3;
			cnt++;
		}

		int sum = 0, index = 0;
		;
		for (int i = cnt; i >= 0; i--) {
			if (tmp[i] > -1) {
				sum += tmp[i] * (Math.pow(3, index));
				index++;
			}
		}

		answer = sum;
		return answer;
	}

	public void ternary(int n, StringBuilder str) {
		if (n == 1) {
			str.append("1");
			return;
		}
		str.append(Integer.toString(n % 3));
		ternary(n / 3, str);
	}

}
