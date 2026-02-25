import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 10_000_001;
        
        Arrays.sort(tangerine);
        int[][] numofT = new int[tangerine.length][2];
        numofT[0][0] = tangerine[0];
        numofT[0][1] = 1;
        int idx = 0;
        for (int i = 1; i < tangerine.length; i++) {
            if (tangerine[i] != tangerine[i-1]) {
                numofT[++idx][0] = tangerine[i];
                numofT[idx][1] = 1;
            } else {
                numofT[idx][1] += 1;
            }
        }
        
        int[] counts = new int[idx+1];
        for (int i = 0; i <= idx; i++) {
            counts[i] = numofT[i][1];
        }
        Arrays.sort(counts);
        
        int sum = 0;
        int types = 0;
        
        for (int i = counts.length-1; i>=0; i--) {
            sum += counts[i];
            types++;
            if (sum >= k) break;
        }
        return types;
    }
}