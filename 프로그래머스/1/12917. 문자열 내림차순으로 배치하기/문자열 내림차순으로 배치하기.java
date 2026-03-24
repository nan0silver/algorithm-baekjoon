import java.util.*;
class Solution {
    public String solution(String s) {
        
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);
        
        StringBuilder sb = new StringBuilder(new String(charArr));
        String answer = sb.reverse().toString();
        return answer;
    }
}