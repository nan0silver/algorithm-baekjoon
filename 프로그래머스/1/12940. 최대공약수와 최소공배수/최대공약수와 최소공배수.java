class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int a,b;
        
        if (n > m) {a =n; b=m;}
        else {a=m; b=n;}
        
        while (a%b != 0) {
            int tmp = a %b;
            a=b; b=tmp;
        }
        answer[0] = b;
        answer[1] = n*m/b;
        
        
        return answer;
    }
}