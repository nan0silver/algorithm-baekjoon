import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int answer = set.size();
        
        if (answer >= nums.length/2) {
            answer = nums.length/2;
        }
        
        return answer;
    }
}