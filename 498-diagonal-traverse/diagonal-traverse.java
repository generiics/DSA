class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;

        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int key=i+j;

                map.putIfAbsent(key,new ArrayList<>());
                map.get(key).add(mat[i][j]);
            }
        }
        int[] ans=new int[m*n];
        int idx=0;
        boolean reverse=true;
        for(int key=0;key<=m+n-2;key++){
            List<Integer> list=map.get(key);

            if(reverse){
                Collections.reverse(list);
            }
             for (int num : list) {
                ans[idx++] = num;
            }

            reverse = !reverse;
        }
        return ans;
    }
}