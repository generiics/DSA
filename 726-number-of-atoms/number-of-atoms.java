class Solution {
    public String countOfAtoms(String formula) {
        Stack<HashMap<String,Integer>> st=new Stack<>();
        st.push(new HashMap<>());
        int i=0;
        int n=formula.length();
        while(i<n){
            if(formula.charAt(i)=='('){
                st.push(new HashMap<>());
                i++;
            }
            else if(formula.charAt(i)==')'){
                HashMap<String,Integer> curr=st.pop();
                i++;
                StringBuilder sb=new StringBuilder();

                while(i<n && Character.isDigit(formula.charAt(i))){
                    sb.append(formula.charAt(i));
                    i++;

                }
                int temp=1;
                if(sb.length()>0){
                    temp=Integer.parseInt(sb.toString());
                }
                for(String atom:curr.keySet()){
                    curr.put(atom,curr.get(atom)*temp);
                }
                HashMap<String, Integer> parent = st.peek();

                for (String atom : curr.keySet()) {
                parent.put(atom,parent.getOrDefault(atom, 0) + curr.get(atom));
                }
            }
            else {

                StringBuilder atom = new StringBuilder();
                atom.append(formula.charAt(i));
                i++;

                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    atom.append(formula.charAt(i));
                    i++;
                }

                StringBuilder sb = new StringBuilder();

                while (i < n && Character.isDigit(formula.charAt(i))) {
                    sb.append(formula.charAt(i));
                    i++;
                }

                int count = 1;
                if (sb.length() > 0) {
                    count = Integer.parseInt(sb.toString());
                }

                HashMap<String, Integer> map = st.peek();

                map.put(atom.toString(),
                        map.getOrDefault(atom.toString(), 0) + count);
            }
        }
        TreeMap<String, Integer> sortedMap = new TreeMap<>(st.peek());

        StringBuilder ans = new StringBuilder();

        for (String atom : sortedMap.keySet()) {
            ans.append(atom);

            if (sortedMap.get(atom) > 1) {
                ans.append(sortedMap.get(atom));
            }
        }

        return ans.toString();
        
    }
}