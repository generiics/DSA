class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
      HashMap<Integer,List<Integer>> map=new HashMap<>();
      int total=0;
      int maxkey=0;

      for(int i=0;i<nums.size();i++){
        for(int j=0;j<nums.get(i).size();j++){
            int key=i+j;

            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(0,nums.get(i).get(j));
            total++;
            maxkey = Math.max(maxkey, key);
        }
      } 
       int[] ans = new int[total];
        int idx = 0; 

         for (int key = 0; key <= maxkey; key++) {

            if (!map.containsKey(key)) {
                continue;
            }

            List<Integer> list = map.get(key);

            for (int num : list) {
                ans[idx++] = num;
            }
        }

        return ans;
    }
}