package Solution.November;

public class November3 {// 스타 수열
	public int solution(int[] a) { // a 최대 크기 500,000
		// a의 모든 부분 수열중에서
		// 스타 수열을 찾자!

		// 스타 수열 조건
		// 길이 2n (0, 2, 4....
		// 조건1: 인접한 원소끼리 집합을 이룰 때 공통원소가 존재
		// 교집합의 원소의 개수 = 1개 이상이라고 명시되어 있지만 결국 2개씩!! 묶기 때문에 1~2개임 ***
		// [ 1 , 2 , 1 , 2 , 1 , 2 ] 일 때 교집합 원소의 개수 2 => (1과 2)
		// 조건2: 인접한 원소 집합 값이 서로 달라야 돼 {0,1}, {1,2} => 0!=1, 1!=2

		int max = 0;
		for (int val : a)
			max = Math.max(val, max); // a의 원소중 가장 큰 값을 찾는다.

		int[] nc = new int[max + 1]; // 0부터 max까지 각 숫자의 카운트를 배열에 넣는다
		for (int val : a)
			nc[val]++;

		int answer = 0; // 집합의 개수 (원소 2개씩 집합을 만들때 교집합 원소가 있어야 돼)
		for (int common = 0; common < nc.length; common++) { // 교집합 원소

			if (nc[common] == 0 || answer >= nc[common]) // 숫자 카운트가 집합의 개수 보다 작으면 의미 없음
				continue;

			int tmp = 0;
			boolean check = false; // 교집합 원소에서 인덱스 -1을 중점으로 집합을 만들지만 조건이 되지 않아 인덱스 +1로 집합을 만들경우 
									// 그 다음 교집합 원소에서 중복이 되지 않도록 체크 예 {0,2,0,2}
			for (int i = 0; i < a.length; i++) {

				if (a[i] != common) {
					check = false;
					continue;
				} else {

					if (!check && i - 1 >= 0 && a[i - 1] != common) {
						tmp++;
						check = false;
					} else if (i + 1 < a.length && a[i + 1] != common) {
						tmp++;
						i++; // 어차피 i+1는 교집합 원소가 아니므로.. 만약 이연산이 없으면 시간 초과가 됨! (for문을 적게 돈다)
						check = true;
					}
				}

				if (tmp >= nc[common]) {
					tmp = nc[common];
					break;

				}

			} // for i
			answer = Math.max(tmp, answer);
		}

		return answer * 2; // 2개씩 묶기 때문에 2를 곱하기
	}
}
