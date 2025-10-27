import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int total = progresses.length;
        for (int i =0; i < total; i++) {
            int tmp = 100 - progresses[i];
            int cal = tmp/speeds[i];
            if (tmp % speeds[i] != 0) cal++;
            
            dq.offer(cal);
        }
        
        for (int i = 0; i < total; i++) {
            int poll = dq.poll(); 
            int count = 1;
            while(!dq.isEmpty() && dq.peek() <= poll ) {
                count++; i++;
                dq.poll();
            }
            answer.add(count);
        }
        return answer;
    }
}