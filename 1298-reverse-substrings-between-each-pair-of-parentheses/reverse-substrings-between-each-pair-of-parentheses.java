class Solution {
    public String reverseParentheses(String s) {
        int n=s.length();
        Stack<Integer> st=new Stack<>();
        int[] pos=new int[n];

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                st.push(i);
            }else if(s.charAt(i)==')'){
                int j=st.pop();
                pos[i]=j;
                pos[j]=i;
            }
        }
        StringBuilder res=new StringBuilder();
        int dir=1;
        for(int i=0;i<n;i+=dir){
            if(s.charAt(i)=='(' || s.charAt(i)==')'){
                i=pos[i];
                dir=-dir;
            }else{
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    

    }
}