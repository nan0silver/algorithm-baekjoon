import java.io.*;
import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        Long[] arr = new Long[10];
        int idx = 0;
        while(n != 0) {
            arr[idx++] = n%10;
            n = n/10;
        }
        Arrays.sort(arr, 0, idx, Collections.reverseOrder());
        
        answer = arr[0];
        for (int i = 1; i < idx; i++) {
            answer = answer*10 + arr[i];
        }
        return answer;
    }
}