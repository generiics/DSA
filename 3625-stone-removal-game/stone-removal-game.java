class Solution {
    public boolean canAliceWin(int n) {
        int pick=10;
        int count=0;

        while(n>=pick){
            n-=pick;
            pick--;
            count++;
        }
        return count%2==1;

}
}