class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                st.push(sb.length());

            }else if(ch==')'){
                int start=st.pop();
                int left=start;
                int right=sb.length()-1;

                while(left<right){
                    char temp=sb.charAt(left);
                    sb.setCharAt(left,sb.charAt(right));
                    sb.setCharAt(right,temp);
                    left++;
                    right--;
                }
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();

    }
}