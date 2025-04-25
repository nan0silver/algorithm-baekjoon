class Solution {
    boolean solution(String s) {

        int pCount = 0;
        int yCount = 0;
        for (char ch : s.toCharArray()){
            if (ch == 'P' || ch == 'p') pCount++;
            if (ch == 'Y' || ch == 'y') yCount++;
        }

        return (pCount==yCount) ? true : false;
    }
}