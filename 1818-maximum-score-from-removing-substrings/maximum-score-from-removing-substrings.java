class Solution {
    public int maximumGain(String s, int x, int y) {
       int n=s.length();
       int score=0;
       String maxSub=(x>=y)?"ab":"ba"; 
       String minSub=(x>=y)?"ba":"ab";
       
       String first=remove(s,maxSub);
       int l=first.length();
       int remain=n-l;
       score+=(remain/2)*Math.max(x,y);

       String second=remove(first,minSub);
       remain=l-second.length();
       score+=(remain/2)*Math.min(x,y);
       return score;
    }

    public String remove(String s, String target) {

    Stack<Character> st = new Stack<>();

    char first = target.charAt(0);
    char second = target.charAt(1);

    for (char ch : s.toCharArray()) {

        if (!st.isEmpty() && st.peek() == first && ch == second) {
            st.pop();          // remove first character
        } else {
            st.push(ch);
        }
    }

    StringBuilder sb = new StringBuilder();

    while (!st.isEmpty()) {
        sb.append(st.pop());
    }

    return sb.reverse().toString();
}
}