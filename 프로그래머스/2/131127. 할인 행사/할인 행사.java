import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> need = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            need.put(want[i], number[i]);
        }

        Map<String, Integer> window = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            String item = discount[i];
            if (need.containsKey(item)) {
                window.put(item, window.getOrDefault(item, 0) + 1);
            }
        }

        if (isMatch(need, window)) answer++;

        for (int i = 1; i <= discount.length - 10; i++) {
            String out = discount[i - 1];     // 빠지는 것
            String in  = discount[i + 9];     // 들어오는 것

            if (need.containsKey(out)) {
                window.put(out, window.get(out) - 1);
                if (window.get(out) == 0) window.remove(out);
            }
            if (need.containsKey(in)) {
                window.put(in, window.getOrDefault(in, 0) + 1);
            }

            if (isMatch(need, window)) answer++;
        }

        return answer;
    }

    private boolean isMatch(Map<String, Integer> need, Map<String, Integer> window) {
        for (String key : need.keySet()) {
            if (window.getOrDefault(key, 0) != need.get(key)) return false;
        }
        return true;
    }
}