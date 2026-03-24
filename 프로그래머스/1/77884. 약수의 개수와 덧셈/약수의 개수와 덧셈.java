class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int k = left; k <= right; k++) {
            if (yacksoo(k) %2 == 1) {
                answer -= k;
            }
            else answer += k;
        }
        
        return answer;
    }
    
    public int yacksoo(int num) {
        int result = 0;
        for (int i = 1; i < Math.sqrt(num); i++) {
            if (num%i == 0) result++;
            
        }
        result *= 2;
        if (num % Math.sqrt(num) == 0) result++;
        return result;
    }
}