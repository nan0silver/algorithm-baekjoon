import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int sum = brown+yellow;
        
        for (int i = sum-1; i >= Math.sqrt(sum); i--) {
            if (sum%i==0) {
                int j = sum/i;
                if (2*i + 2*j - 4 == brown) answer = new int[]{i, j};
            }
        }
        return answer;
    }
}