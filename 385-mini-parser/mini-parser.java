/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        if(s.charAt(0)!='['){
            return new NestedInteger(Integer.parseInt(s));
        }
        Stack<NestedInteger> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='['){
                stack.push(new NestedInteger());
            }
            else if (ch==']'){
                NestedInteger curr=stack.pop();

                while(stack.isEmpty()){
                    return curr;
                }
                stack.peek().add(curr);
            }
            else if(ch=='-' ||Character.isDigit(ch)){
                int j=i;
                while(j<s.length() && (s.charAt(j) == '-' || Character.isDigit(s.charAt(j)))){
                    j++;
                }
                int num=Integer.parseInt(s.substring(i,j));
                 stack.peek().add(new NestedInteger(num));
            
            i=j-1;
            }
        }
        return new NestedInteger();
    }
}