class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int zeroNum = 0;
        int changeNum = 0;
        
        while (!s.equals("1")){
            int length = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') zeroNum++;
                else {
                    length++;
                }
            }
            s = Integer.toBinaryString(length);
            changeNum++;  
        }
        
        answer[0] = changeNum;
        answer[1] = zeroNum;
        
        return answer;
    }
}