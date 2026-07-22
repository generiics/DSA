class Solution {
    public String decodeString(String s) {
       Stack<Integer> count=new Stack<>();
       Stack<StringBuilder> sb=new Stack<>();
       StringBuilder curr=new StringBuilder();
       int num=0;
       for(char ch:s.toCharArray()){
        if(Character.isDigit(ch)){
            num=num*10+(ch-'0');
        }
        else if(ch=='['){
        count.push(num);
        sb.push(curr);
        num=0;
        curr=new StringBuilder();
        }
       
       else if(ch==']'){
         int repeat=count.pop();
         StringBuilder prev=sb.pop();
        while(repeat-->0){
            prev.append(curr);
        }
        curr=prev;
       }
       else{
        curr.append(ch);
       }
    }
    return curr.toString();
}

}