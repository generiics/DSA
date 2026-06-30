class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
       List<List<Integer>>  ans=new ArrayList<>();
       HashMap<Integer,Integer> map=new HashMap<>();
       for(int num:nums){
        int row=map.getOrDefault(num,0);
        if(row==ans.size()){
            ans.add(new ArrayList<>());

        }
        ans.get(row).add(num);
        map.put(num,row+1);
       }
       return ans;
    }
}