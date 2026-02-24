class Solution {
    public int solution(int n) {
        int numOfOne = solve(n);
        
        int idx = n+1;
        while(true) {
            if (solve(idx) == numOfOne) return idx;
            else idx++;
        }
        
        
    }
    
    public int solve(int n) {
        String binary = Integer.toBinaryString(n);
        
        int numofone = 0;
        for (char b : binary.toCharArray()) {
            if (b == '1') numofone++;
        }
        return numofone;
    } 
}