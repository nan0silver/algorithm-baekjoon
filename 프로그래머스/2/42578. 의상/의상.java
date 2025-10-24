import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String[] cloth: clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0)+1);
        }
        int answer = 1;
        Collection<Integer> values = map.values();
        
        if (map.size() > 1) {
            for (int v : values) answer *= (v+1);
        } else {return map.get(clothes[0][1]);}
    
        return answer-1;
    }
}