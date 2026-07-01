class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq=new int[10];

        for(int i=0;i<digits.length;i++){
            freq[digits[i]]++;
        }
        List<Integer> list=new ArrayList<>();

        for(int i=100;i<999;i+=2){
            if(i%2!=0) continue;
            int first=i/100;
            int second=(i/10)%10;
            int third=i%10;

            int[] temp=freq.clone();

            temp[first]--;
            temp[second]--;
            temp[third]--;

            if(temp[first]>=0 && temp[second]>=0 && temp[third]>=0){
                list.add(i);
            }
        }
        int[] arr=new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
}