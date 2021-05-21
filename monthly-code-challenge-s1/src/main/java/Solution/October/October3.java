package Solution.October;

import java.util.ArrayList;
import java.util.LinkedList;

public class October3 { // 트리 트리오 중간 값

	public int solution(int n, int[][] edges) {
		int answer = 0;

		ArrayList<Integer>[] node = new ArrayList[n + 1]; // 1~n
		for (int i = 1; i <= n; i++) {
			node[i] = new ArrayList<Integer>();
		}
		for (int[] e : edges) {
			node[e[0]].add(e[1]);
			node[e[1]].add(e[0]);
		}

		//////////////////////////////////////////////
		
		// 중간값이란, 순서대로 나열했을 때 가운데 위치한 값 (평균은 모두 더한 후 n으로 나눈 값)
		// 해당 트리는 모든 거리가 1이므로
		// 결과1 : 지름(max 거리) 1개인 경우 -1을 하면 돼
		// 결과2 : 지름(max 거리) 2개 이상인 경우 max 출력

		// 트리 지름이란 리프 노트를 찾는 것 => 리프노드와 리프노드 간의 거리(max)
		// 우선 첫번째, 임의의 노드를 지정해서 리프노트를 찾는다. (가장 먼거리) => 첫번째 리프노드 찾기

		int[] res1 = new int[n + 1];
		res1 = bfs(node, 1, n); // 임의의 점(1)
		int max1 = 0;
		for (int val : res1)
			max1 = Math.max(val, max1);

		int leaf1 = 0;
		for (int i = 1; i <= n; i++) {
			if (max1 == res1[i])
				leaf1 = i; // 첫번째 leaf 노드 찾기
		}

		////////////////////////////////////////////////
		int[] res2 = new int[n + 1];
		res2 = bfs(node, leaf1, n); 
		int max2 = 0;
		for (int val : res2)
			max2 = Math.max(val, max2);

		int cnt = 0;
		int leaf2 = 0;
		for (int i = 1; i <= n; i++) {
			if (max2 == res2[i]) {
				cnt++;
				leaf2 = i; //두번째 leaf 노드 찾기
			}
			if (cnt > 1)
				return max2;
		}

		// 만약 leaf1을 기준으로 또 다른 leaf2 노드를 찾을 때
		// 지름이 2개 이상 나온 경우 (max값 2개 이상 존재) max 를 출력하면 되지만
		// 1개가 나온 경우 leaf2 에서 한번 더 leaf 노드를 찾아봐야 한다 ***
		// leaf2 에서 max가 여러개 나올 수도 있기 때문이다
		// 예를 들어
		// leaf1 -> leaf2 : max 4
		// leaf2 -> leaf1 : max 4  당연히 똑같겠죠?
		// leaf2 -> leaf3,4.... 여러 개  : max 4
		// 그렇다면, output = 4
		// 하지만 leaf2 에서도 leaf1 이렇게 하나만 나오면
		// leaf1와 leaf2의 max -1 = output = 3 
		///////////////////////////////////////////////////

		int[] res3 = new int[n + 1];
		res3 = bfs(node, leaf2, n); //leaf2를 기준으로 다시 한번 더 찾기
		
		cnt = 0;
		for (int val : res3) {
			if (val == max2) { 
				cnt++;
			}
			if (cnt > 1) //max 지름이 2개 이상인 경우
				return max2;
		}

		return max2 - 1;
	}

	public int[] bfs(ArrayList<Integer>[] node, int start, int n) {

		LinkedList<Integer> que = new LinkedList<Integer>();
		boolean visit[] = new boolean[n + 1]; // 1~n
		int[] res = new int[n + 1];

		que.add(start);
		while (!que.isEmpty()) {

			int k = que.poll(); // 5
			visit[k] = true;
			if (start != k)
				res[k]++;

			for (int i = 0; i < node[k].size(); i++) {
				if (!visit[node[k].get(i)]) {
					que.add(node[k].get(i));
					visit[node[k].get(i)] = true;
					res[node[k].get(i)] = res[k];
				}
			}
		} // while

		return res;
	}

}
