import java.util.*;
class Solution {
    public List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        
        int[] p1 = {1, 2, 3, 4, 5}; //5
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5}; //8
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; //10
        
        int numsOfProblems = answers.length;
        int a1=0, a2=0, a3=0;
        
        for (int i = 0; i < numsOfProblems; i++) {
            if (answers[i] == p1[i%5]) a1++;
            if (answers[i] == p2[i%8]) a2++;
            if (answers[i] == p3[i%10]) a3++;
        }
        
        int max = Math.max(a1, Math.max(a2, a3));
        
        if (a1 == max) answer.add(1);
        if (a2 == max) answer.add(2);
        if (a3 == max) answer.add(3);
        
        
        return answer;
    }
}