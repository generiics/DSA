class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited=new boolean[n];

        return dfs(source,destination,adj,visited);
    }
    public boolean dfs(int node,int destination,ArrayList<ArrayList<Integer>> adj,boolean[] visited){
        if(node==destination){
            return true;
        }
        visited[node]=true;

        for(int it:adj.get(node)){
            if(!visited[it]){
                if(dfs(it,destination,adj,visited)){
                    return true;
                }
            }
        }
        return false;
    }
}