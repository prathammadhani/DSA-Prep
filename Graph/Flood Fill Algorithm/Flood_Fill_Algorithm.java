// Problem Name: LC - 733. Flood Fill/Flood fill Algorithm
// Problem Link: https://leetcode.com/problems/flood-fill/, https://www.geeksforgeeks.org/problems/flood-fill-algorithm1856/1

// BFS Approach
class Solution {
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };
    public void bfs(int sr,int sc,int[][] image,int[][] ans,int oldColor,int color){
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(sr,sc));
        ans[sr][sc] = color;
        while(!q.isEmpty()){
            Pair node = q.poll();
            int x = (int) node.getKey();
            int y = (int) node.getValue();
            for(int k = 0;k<4;k++){
                int row = x + dx[k];
                int col = y + dy[k];
                if(row>=0 && row<image.length && col>=0 && col<image[0].length && image[row][col] == oldColor && ans[row][col] != color) {
                    ans[row][col] = color;
                    q.add(new Pair(row,col));
                }
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        int[][] ans = image;
        bfs(sr, sc, image, ans, oldColor, color);
        return ans;
    }
}

// DFS Approach
class Solution {
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };
    public void dfs(int row,int col,int[][] image,int[][] ans,int oldColor,int color){
       ans[row][col] = color;
       for(int k = 0;k<4;k++){
            int newRow = row + dx[k];
            int newCol = col + dy[k];
            if(newRow>=0 && newRow<image.length && newCol>=0 && newCol<image[0].length && image[newRow][newCol] == oldColor && ans[newRow][newCol] != color) {
                dfs(newRow,newCol,image,ans,oldColor,color);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        int[][] ans = image;
        dfs(sr, sc, image, ans, oldColor, color);
        return ans;
    }
}