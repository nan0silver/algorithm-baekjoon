class Solution {
    public int solution(int n) {
        int answer = 0;
        int left = 1; int right = 1;
        while (left <= n) {
            int tmp = sum(left, right);
            if (tmp < n) right++;
            else if (tmp == n) {
                answer++;
                left++; 
            } else {
                left++;
            }
            
        }
        return answer;
    }
    public int sum(int a, int b) {
        if (a == b) return a;
        else {
            int result = 0;
            for (int i = a; i <= b; i++) {
                result += i;
            }
            return result;
        }
    }
}