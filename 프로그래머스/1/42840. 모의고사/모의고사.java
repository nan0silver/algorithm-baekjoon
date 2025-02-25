import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] score = new int[3];

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (answers[i] == patterns[j][i % patterns[j].length]){
                    score[j]++;
                }
            }
        }

        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));

        int bestScoreStudent = 0;
        for (int s : score){
            if (s == maxScore) bestScoreStudent++;
        }

        int[] answer = new int[bestScoreStudent];
        int index = 0;
        for (int i = 0; i < 3; i++){
            if (score[i] == maxScore) {
                answer[index++] = i+1;
            }
        }
        return answer;
    }
}