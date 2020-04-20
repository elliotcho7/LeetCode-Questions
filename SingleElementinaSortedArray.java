class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start=0;
        int end=nums.length-1;
        
        while(start<=end){
            int mid=start+(end-start)/2;
            
            if(mid>0 && nums[mid]==nums[mid-1]){
                if((mid-1)%2!=0){
                    end=mid-1;
                }
                
                else{
                    start=mid+1;
                }
            }
            
            else if(mid<nums.length-1 && nums[mid]==nums[mid+1]){
                if((mid+1)%2!=0){
                    start=mid+1;
                }
                
                else{
                    end=mid-1;
                }
            }
            
            else{
                return nums[mid];
            }
        }
        
        return -1;
    }
}