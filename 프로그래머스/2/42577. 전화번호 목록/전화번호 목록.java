import java.util.*;
import java.io.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        Set<String> keys = new HashSet<String>(); 
        for (String p : phone_book) {
            keys.add(p);
        }
        
        for (String p: phone_book) {
            for (int i = 1; i < p.length(); i++ ) {
                String prefix = p.substring(0, i);
                if (keys.contains(prefix)) return false;
            }
        }
        
        return true;
    }
}