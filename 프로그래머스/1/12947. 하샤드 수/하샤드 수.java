class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int tmp = 0;
        int copy = x;
        while (copy != 0) {
            tmp += copy%10;
            copy /= 10;
        }
        
        if (x % tmp != 0) answer = false;
        return answer;
    }
}