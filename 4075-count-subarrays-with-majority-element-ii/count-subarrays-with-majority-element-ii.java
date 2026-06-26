class Solution {
    static long count;
    public long countMajoritySubarrays(int[] nums, int target) {
        int n=nums.length;
        count=0;
        int[] prefix=new int[n+1];
        prefix[0]=0;

        for(int i=0;i<n;i++){
            int score;
            if(nums[i]==target){
                score=1;
            }else{
                score=-1;
            }
            prefix[i+1]=prefix[i]+score;
        }

        mergeSort(prefix,0,prefix.length-1);
        return count;
    }
    public void mergeSort(int[] nums,int low,int high){
        if(low>=high){
            return;
        }
        int mid=(low+high)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }

    public void merge(int[] nums,int low,int mid,int high){
        int[] temp=new int[high-low+1];
        int i=low;
        int j=mid+1;
        int k=0;

        while(i<=mid && j<=high){
            if(nums[i]<nums[j]){
                count+=(high-j+1);
                temp[k]=nums[i];
                k++;
                i++;
            }else{
                temp[k]=nums[j];
                k++;
                j++;
            }
        }
        while(i<=mid){
            temp[k]=nums[i];
            k++;
            i++;
        }
        while(j<=high){
            temp[k]=nums[j];
            k++;
            j++;
        }
        for(int x=low;x<=high;x++){
            nums[x]=temp[x-low];
        }
    }
}