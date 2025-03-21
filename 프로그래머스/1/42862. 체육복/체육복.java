import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        for (int l : lost) lostSet.add(l);
        
        Set<Integer> reserveSet = new HashSet<>();
        for (int r : reserve) reserveSet.add(r);
        
        for (int i : reserve){
            if (lostSet.contains(i)){
                lostSet.remove(i);
                reserveSet.remove(i);
            }
        }
        
        boolean[] partLession = new boolean[n+1];
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (lostSet.contains(i)) { //도난당한 학생이라면
                if (reserveSet.contains(i-1)) {
                    answer++;
                    reserveSet.remove(i-1);
                } else if (reserveSet.contains(i+1) && i+1<=n){
                    answer++;
                    reserveSet.remove(i+1);
                }
            } else {
                answer++;
            }
        }
        
        
        return answer;
    }
}