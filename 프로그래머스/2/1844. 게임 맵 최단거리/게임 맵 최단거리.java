import java.util.*; 

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] answer = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0});
        visited[0][0] = true;
        
        answer[0][0] = 1;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1];
            
            if (x == n-1 && y == m-1){
                return answer[x][y];
            }
            
            for (int i= 0; i < 4; i++) {
                int nx = x +dx[i];
                int ny = y +dy[i];
                
                if (nx >=0 && nx < n && ny >=0 && ny < m&& maps[nx][ny]==1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    answer[nx][ny] = answer[x][y] + 1;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
        
    
        return -1;
    }
}