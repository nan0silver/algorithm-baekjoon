import java.util.*;

class Solution {
    public String solution(String s) {
        String[] strArray = s.split(" ");
        int length = strArray.length;
        int[] intArray = new int[length];
        for (int i = 0; i < length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        Arrays.sort(intArray);
        String answer = intArray[0] + " " + intArray[length-1];
        return answer;
    }
}