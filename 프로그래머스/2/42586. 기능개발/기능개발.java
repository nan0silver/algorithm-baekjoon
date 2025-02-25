import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> al_answer = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int p = progresses[i];
            int s = speeds[i];
            int day = (int) Math.ceil((100.0-p)/s);
            queue.offer(day);
        }

        int max = queue.poll();
        int num=1;
        while(!queue.isEmpty()){
            if (queue.peek() <= max){
                queue.poll();
                num++;
            } else {
                al_answer.add(num);
                max = queue.poll();
                num = 1;
            }
        }
        al_answer.add(num);
        answer = al_answer.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}