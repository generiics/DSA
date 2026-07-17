class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited=new boolean[rooms.size()];
        dfs(0,rooms,visited);
        for(int i=0;i<rooms.size();i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }


    private void dfs(int node,List<List<Integer>> rooms,boolean[] visited){
        visited[node]=true;

        for(int it:rooms.get(node)){
            if(!visited[it]){
                dfs(it,rooms,visited);
            }
        }

    }
}