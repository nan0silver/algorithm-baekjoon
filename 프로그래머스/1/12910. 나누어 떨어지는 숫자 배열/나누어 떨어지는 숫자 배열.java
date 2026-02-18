import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        
        int size = 0;
        for (int a : arr) {
            if (a % divisor == 0) {
                list.add(a);
                size++;
            }
        }
        
        int[] answer;
        if (size > 0) {answer = list.stream().mapToInt(i -> i).toArray();}
        else {answer = new int[]{-1};}
        
    
        
        return answer;
    }
}