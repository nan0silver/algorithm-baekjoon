import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        
        int command = commands.length;
        answer = new int[command];
        
        int idx=0;
        for (int[] c : commands) {
            List<Integer> list = new ArrayList<>();
            for (int i = c[0]; i <= c[1]; i++) {
                list.add(array[i-1]);
            }
            Collections.sort(list);
            
            answer[idx++] = list.get(c[2]-1);
        }
        
        return answer;
    }
}