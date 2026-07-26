class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int temp:asteroids){
            while(!st.isEmpty() && temp<0 && st.peek()>0){
               int  sum=temp+st.peek();

                if(sum<0){
                    st.pop();
                }else if(sum>0){
                    temp=0;
                }else{
                    st.pop();
                    temp=0;
                }
            }
            if(temp!=0){
                st.push(temp);
            }
        }
        int[] ans = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
}