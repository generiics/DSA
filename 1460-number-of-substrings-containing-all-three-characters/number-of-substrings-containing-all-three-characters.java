class Solution {
    public int numberOfSubstrings(String s) {
        int left=0;
        int right=0;
        int count=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while(right<s.length()){
            char ch=s.charAt(right);

            map.put(ch,map.getOrDefault(ch,0)+1);

            while(map.size()==3){
                count+=s.length()-right;
                char leftch=s.charAt(left);

                map.put(leftch,map.get(leftch)-1);
                if(map.get(leftch)==0) {
                    map.remove(leftch);
                }
                left++;
            }
            right++;
        }
        return count;
        
        
    }
}