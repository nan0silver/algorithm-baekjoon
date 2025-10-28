import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int length = sizes.length;
        int[] longArr = new int[length];
        int[] shortArr = new int[length];
        
        for (int i = 0; i < length; i++) {
            longArr[i] = Math.max(sizes[i][0], sizes[i][1]);
            shortArr[i] = Math.min(sizes[i][0], sizes[i][1]);
        }
        int max = Arrays.stream(longArr).max().getAsInt();
        int min = Arrays.stream(shortArr).max().getAsInt();
        return max*min;
    }
}