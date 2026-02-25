import java.util.*;
class Solution {
    public long solution(int[] arr) {
        
        Arrays.sort(arr);
        long tmp = arr[arr.length-1];
        while (true) {
            int i;
            for (i = 0; i < arr.length; i++) {
                if (tmp%arr[i] != 0) break;
            }
            if (i == arr.length) break;
            tmp++;
        }
        return tmp;
    }
}