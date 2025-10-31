class Solution {
    public String solution(String[] seoul) {
        String answer = "김서방은 ";
        int idx=0;
        for (String i : seoul) {
            if (i.equals("Kim")) {
                answer += idx;
                break;
            }
            idx++;
        }
        return answer+"에 있다";
    }
}