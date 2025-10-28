import java.util.*;
class Solution {
    static List<String> strList = new ArrayList<>();
    public int solution(String numbers) {
        
        char[] charArr = numbers.toCharArray();
        String[] strArr = new String[charArr.length];
        for (int i = 0; i < charArr.length; i++) {
            String tmp = String.valueOf(charArr[i]);
            strArr[i] = tmp;
        }
        boolean[] visited = new boolean[strArr.length];
        
        makeNums(strArr, visited, 0, "");
        
        HashSet<Integer> set = new HashSet<>();
        for (String s : strList) {
            set.add(Integer.parseInt(s));
        }
        System.out.println(set);
        
        //소수 판별
        int answer = 0;
        for (int s : set) {
            if(isPrime(s)) {
                answer++;
                System.out.println(s);
            }
        }
        
        
        return answer;
    }
    
    public void makeNums(String[] strArr, boolean[] visited,
                           int count, String str) {
        if (!str.equals("")) strList.add(str);
        if (count == strArr.length) {
            return;
        }
        for (int i = 0; i < strArr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                makeNums(strArr, visited, count+1, str+strArr[i]);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        for (int i = 2; i*i <= num; i++) {
            if (num%i == 0) return false;
        }
        return true;
    }
}