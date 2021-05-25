# monthly-code-challenge-s1


## bfs : 큐

    
    LinkedList<Integer> que = new LinkedList<Integer>();
    que.add()
    que.poll()
    

## {1,5} <-> {5,1}


    
    ArrayList<Integer>[] node = new ArrayList[n + 1]; // 1~n
    for (int i = 1; i <= n; i++) {
        node[i] = new ArrayList<Integer>();
    }
    for (int[] e : edges) {
        node[e[0]].add(e[1]);
        node[e[1]].add(e[0]);
    }

## 조합 : 경우의 수


    
    comb[0][0] = 1;
    for (int i = 1; i < a.length + 1; i++) {
        comb[i][0] = 1; // 0! = 1
        for (int j = 1; j < a.length + 1; j++) {
            comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j]; // 조합 경우의 수
        }
    }

## 시간 초과



    이중 for 문
    방법1 : continue, break 조건들을 추가하기
    방법2 : index + 1 해주기
    => 최대한 조금만 돌게 만들어주자
