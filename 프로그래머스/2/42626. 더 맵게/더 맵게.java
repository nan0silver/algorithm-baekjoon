import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int s : scoville) {
            queue.offer(s);
        }
        
        int count = 0;
        while (queue.size() >= 2 && queue.peek() < K ) {
            int top = queue.poll();
            int second = queue.poll();

            queue.add(top + second*2);
            count++;
        }
        if (queue.peek() < K) return -1;
        return count;
    }
}