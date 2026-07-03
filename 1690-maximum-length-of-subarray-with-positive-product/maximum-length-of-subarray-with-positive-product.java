class Solution {
    public int getMaxLen(int[] nums) {
        int pos=0;
        int neg=0;
        int ans=0;
        for(int num:nums){
            if(num>0){
                pos=pos+1;
            
            if(neg>0){
                neg=neg+1;
            }else{
                neg=0;
            }
        }else if(num<0){
            int oldpos=pos;
            int oldneg=neg;

            if(oldneg>0){
                pos=oldneg+1;
            }else{
                pos=0;
            }
            neg=oldpos+1;
        }
        else{
            pos=0;
            neg=0;
        }
        ans=Math.max(ans,pos);
        }
        return ans;
    }
}