import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int k = 0; k < n; k++ ){
            if (!visited[k]) {
                //bfs(n, k, computers);
                dfs(n, k, computers);
                answer++;
            }
        }
        return answer;
    }
    public void bfs(int n, int start, int[][] computers) {
        
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            for (int i = 0; i < n; i++) {
                if (computers[tmp][i] == 1 && i != tmp && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
    
    public void dfs(int n, int start, int[][] computers) {
        visited[start] = true;
        for (int i = 0; i < n; i++) {
            if (computers[start][i] == 1 && i != start && !visited[i]) {
                dfs(n, i, computers);
            }
        }
    }
}