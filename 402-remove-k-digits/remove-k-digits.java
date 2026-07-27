class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder ans=new StringBuilder();

        for(int i=0;i<num.length();i++){
            char ch=num.charAt(i);

            while(ans.length()>0 && k>0 && ans.charAt(ans.length()-1)>ch){
                ans.deleteCharAt(ans.length()-1);
                k--;
            }
            if(ans.length()>0 || ch!='0'){
                ans.append(ch);
            }

        }
        while(ans.length()>0 && k>0){
            ans.deleteCharAt(ans.length()-1);
            k--;
        }
        if(ans.length()==0){
            return "0";
        }
        return ans.toString();
    }
}