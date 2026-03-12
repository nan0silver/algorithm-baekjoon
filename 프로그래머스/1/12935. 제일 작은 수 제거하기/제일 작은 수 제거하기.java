import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = new int[arr.length-1];
        if (arr.length == 1) {
            return new int[]{-1};
        }
        
        int small = Arrays.stream(arr).min().getAsInt();
        
        int idx = 0;
        for (int a : arr) {
            if (a != small) answer[idx++] = a;
        }
        
        return answer;
    }
}