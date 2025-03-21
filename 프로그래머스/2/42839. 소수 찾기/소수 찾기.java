import java.util.*;

class Solution {
    static Set<Integer> numberSet = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        countAllNumbers("", numbers);
        
        //System.out.println(numberSet);
        for (int tmp : numberSet) {
            if (isPrime(tmp)) answer++;
        }
        
        
        return answer;
    }
    
    public static void countAllNumbers(String prefix, String remaining){
        if (!prefix.isEmpty()){
            numberSet.add(Integer.parseInt(prefix));
        }
        
        for (int i = 0; i < remaining.length(); i++) {
            countAllNumbers(
                prefix+remaining.charAt(i),
                remaining.substring(0, i)+remaining.substring(i+1)
            );
        }
    }
    
    public boolean isPrime(int target){
        if (target < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(target); i++) {
            if (target % i == 0) return false;
        }
        return true;
    }
}