class Solution {
    public char solve(char op,List<Character> value){
          if (op == '!') {
        if (value.get(0) == 't') {
            return 'f';
        } else {
            return 't';
        }
    }
    if (op == '&') {
        for (char ch : value) {
            if (ch == 'f') {
                return 'f';
            }
        }
        return 't';
    }
    if (op == '|') {
        for (char ch : value) {
            if (ch == 't') {
                return 't';
            }
        }
        return 'f';
    }
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
