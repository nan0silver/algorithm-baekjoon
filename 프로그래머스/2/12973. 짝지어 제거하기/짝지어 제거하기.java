class Solution
{
    public int solution(String s)
    {
        int n = s.length();
        char[] stack = new char[n];
        int top =0;
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if (top > 0 && stack[top-1] == c) {
                top--;
            } else {
                stack[top++] = c;
            }
        }
        return top == 0 ? 1 : 0;
    }
}