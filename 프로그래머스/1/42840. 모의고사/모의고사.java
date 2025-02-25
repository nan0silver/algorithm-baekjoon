import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int score1 = 0, score2=0, score3=0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student1[i%5]) score1++;
            if (answers[i] == student2[i%8]) score2++;
            if (answers[i] == student3[i%10]) score3++;
        }

        int maxScore = Math.max(score1, Math.max(score2, score3));
        ArrayList<Integer> winners = new ArrayList<>();

        if (score1 == maxScore) winners.add(1);
        if (score2 == maxScore) winners.add(2);
        if (score3 == maxScore) winners.add(3);

        return winners.stream().mapToInt(i -> i).toArray();
    }
}