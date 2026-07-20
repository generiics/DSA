class Solution {
    int n,m;
    boolean[][]  vis;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n=grid2.length;
        m=grid2[0].length;
         vis=new boolean[n][m];
         int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid2[i][j]==1 && !vis[i][j]){
                    if(dfs(i,j,grid1,grid2))
                    count++;
                }
            }
        }
        return count;
    }
    private boolean dfs(int i,int j,int[][] grid1,int[][] grid2){
        if(i<0|| j<0||i>=n ||j>=m){
            return true;
        }
        if(grid2[i][j]==0 || vis[i][j]){
            return true;
        }
        vis[i][j]=true;
        boolean subIsland=true;
        if(grid1[i][j]==0){
            subIsland=false;
        }
        subIsland &= dfs(i + 1, j, grid1, grid2);
        subIsland &= dfs(i - 1, j, grid1, grid2);
        subIsland &= dfs(i, j + 1, grid1, grid2);
        subIsland &= dfs(i, j - 1, grid1, grid2);

        return subIsland;

    }

}