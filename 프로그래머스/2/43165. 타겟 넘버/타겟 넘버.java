class Solution {
    static int length=0, count=0;
    public int solution(int[] numbers, int target) {
        
        length = numbers.length;
        
        
        dfs(0, 0, numbers, target);
    
        return count;
    }
    public void dfs(int index, int sum, int[] numbers, int target) {
        if (index == length) {
            if (sum == target) {count++;}
            //System.out.println(sum);
            return;
        }
        //System.out.println(sum);
        
        dfs(index+1, sum+numbers[index], numbers, target);
        dfs(index+1, sum-numbers[index], numbers, target);
    }
}