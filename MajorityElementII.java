class Solution {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> res=new ArrayList<>();
        HashMap<Integer, Integer> map=new HashMap<>();
        
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue()>nums.length/3){
                res.add(entry.getKey());
            }
        }
        
        return res;
    }
}