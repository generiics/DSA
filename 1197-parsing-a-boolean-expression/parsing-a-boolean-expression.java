class Solution {
    public char solve(char op,List<Character> value){
        if (op == '!') 
            return value.get(0) == 't' ? 'f' : 't';

        if (op == '&') 
            return value.stream().anyMatch(ch -> ch == 'f') ? 'f' : 't';

        if (op == '|') 
            return value.stream().anyMatch(ch -> ch == 't') ? 't' : 'f';

        return 't'; 
    }
    
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st=new Stack<>();
        int n=expression.length();

        for(int i=0;i<n;i++){
            char ch=expression.charAt(i);

            if(ch==',') continue;
            if(ch==')'){
                List<Character> value=new ArrayList<>();
                while(st.peek()!='('){
                    value.add(st.pop());    
                }
                st.pop();
                char op=st.pop();
                st.push(solve(op,value));
            }else{
                st.push(ch);
            }
        }
        return st.peek()=='t';
    }
}
