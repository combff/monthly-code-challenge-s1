package Solution.September;
import java.util.HashSet;
import java.util.Set;

public class September1 { //2개 뽑아서 더하기
	
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

		Set<Integer> set = new HashSet<Integer>(); //set 중복 없음
		for(int i=0;i<numbers.length-1;i++) {
			for(int j=i+1; j<numbers.length; j++) {
				set.add(numbers[i] + numbers[j]);
			}
		}
		
		answer = set.stream().sorted().mapToInt(Integer::intValue).toArray(); 
		return answer;
	}

}
