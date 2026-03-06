import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String tmp = s;
        for (int i = 0; i < s.length(); i++) {
            if (isRight(tmp)) answer++;
            
            tmp = tmp.substring(1)+ tmp.substring(0,1);
        }
        
        return answer;
    }
    
    public boolean isRight(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (char c : str.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(c);
            } else {
                if (c == ']' && stack.getLast() == '[') stack.pollLast();
                else if (c == '}' && stack.getLast() == '{') stack.pollLast();
                else if (c == ')' && stack.getLast() == '(') stack.pollLast();
                else stack.add(c);
            }
        }
        
        if (stack.isEmpty()) return true;
        else return false;
    }
}