class Solution {
    public int[] findNsr(int[] height){
        int n=height.length;
        Stack<Integer> st=new Stack<>();
        int[] nsr=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && height[st.peek()]>=height[i]){
                st.pop();

            }
            if(st.isEmpty()){
                nsr[i]=n;
            }else{
                nsr[i]=st.peek();
            }
            st.push(i);
        }
        return nsr;

    }
    public int[] findNsl(int[] height){
        int n=height.length;
        Stack<Integer> st=new Stack<>();
        int[] nsl=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && height[st.peek()]>=height[i]){
                st.pop();

            }
            if(st.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=st.peek();
            }
            st.push(i);
        }
        return nsl;

    }
    public int findMax(int[] height){
        int[] nsr = findNsr(height);
        int[] nsl = findNsl(height);
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            int width = nsr[i] - nsl[i] - 1;
            int area = width * height[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
              return 0;
             }
        int n=matrix.length;
        int m=matrix[0].length;
        int[] height=new int[m];
        int maxArea=0;
        for(int i=0;i<m;i++){
            height[i]=(matrix[0][i]=='1')?1:0;
        }
        maxArea =findMax(height);
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='0'){
                    height[j]=0;
                }else{
                    height[j]++;
                }
            }
            maxArea=Math.max(maxArea,findMax(height));
        }
        return maxArea;
    }
}