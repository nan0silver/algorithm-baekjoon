class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean start = true;  // 단어의 첫 글자 여부

        for (char c : s.toCharArray()) {
            if (start) {
                sb.append(Character.toUpperCase(c));
            } else {
                sb.append(Character.toLowerCase(c));
            }

            // 공백이면 다음 문자가 단어 첫 글자
            start = (c == ' ');
        }

        return sb.toString();
    }
}