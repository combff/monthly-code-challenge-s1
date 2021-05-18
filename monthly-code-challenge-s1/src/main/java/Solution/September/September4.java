package Solution.September;

public class September4 { // 짝수 행 세기

	public int solution(int[][] a) {

		int[][] comb = new int[a.length + 2][a.length + 2]; // row, col

		comb[0][0] = 1;
		for (int i = 1; i < a.length + 1; i++) {
			comb[i][0] = 1; // 0! = 1
			for (int j = 1; j < a.length + 1; j++) {
				comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j]; // 조합 경우의 수
			}
		}

		for (int i = 0; i < comb.length; i++) {
			for (int j = 0; j < comb[i].length; j++) {
				System.out.print(comb[i][j] + " ");
			}
			System.out.println("");
		}

		System.out.println("-----------");

		int[] csum = new int[a[0].length];
		for (int i = 0; i < a[0].length; i++) { // col
			for (int j = 0; j < a.length; j++) { // row
				csum[i] += a[j][i]; // 각 col sum
			}
		}

//		for(int i=0;i<csum.length;i++)
//			System.out.println("csum :" + csum[i]);

		long[][] dp = new long[a.length + 1][a[0].length + 1];
		for (int i = 1; i < a[0].length; i++) { // col 계산할 때마다 기존 col-1 의 값을 곱하기 때문에
			
			for (int j = 0; j <= a.length; j++) { // row
				
				int m = j; // 짝수행
				int n = a.length - m; // 홀수행
				for (int k = 0; k < csum[i]; k++) { // 각 col마다 합계 = 가능한 1의 개수

					if (m < k || n < (csum[i]-k))
						continue;
					if ((m + csum[i] - 2 * k) < 0 || (m + csum[i] - 2 * k) > a.length+1) 
						continue;
					
						

					System.out.print("r : ");
					System.out.println(m + csum[i] - 2 * k);
					System.out.print("c : ");
					System.out.println(i);
					
					System.out.println(m);
					System.out.println(k);
					System.out.println(n);
					System.out.println(csum[i] - k);
					System.out.print("val : ");
					System.out.println(comb[m][k] * comb[n][csum[i] - k]);
					System.out.println("       ");
					
					if (i-1 == 0) 
						dp[m + csum[i] - 2 * k][0] = comb[a.length][j] ;	
//					else
						dp[m + csum[i] - 2 * k][i] += (dp[m + csum[i] - 2 * k][i - 1] * comb[m][k] * comb[n][csum[i] - k]); // 짝수행의																									// csum
																															// -2k
				}
//				System.out.println("");
			}
		}

		System.out.println("----------");
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println("");
		}

//		System.out.println(dp[0][0]);
		return 0;

	}

}
