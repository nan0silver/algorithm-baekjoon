import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (queue.peekLast() != arr[i]) {
                queue.offer(arr[i]);
            }
        }
        
        int size = queue.size();
        answer = new int[size];
        for (int i = 0; i < size; i++) {
            answer[i] = queue.poll();
        }
        

        return answer;
    }
}