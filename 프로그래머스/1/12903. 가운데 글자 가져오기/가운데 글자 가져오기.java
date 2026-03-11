import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int length = s.length();
        if (length %2 == 0) {
            answer = answer + s.charAt(length/2-1) + s.charAt(length/2);
        } else {
            answer = answer+ s.charAt(length/2);
        }
        return answer;
    }
}