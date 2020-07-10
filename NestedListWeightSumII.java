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
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int res = 0;
        int prevLevelSum = 0;
        
        LinkedList<NestedInteger> queue = new LinkedList<>();
        
        for(NestedInteger element: nestedList){
            queue.add(element);
        }
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            int currLevelSum = 0;
            
            for(int i=0;i<size;i++){
                NestedInteger currElement = queue.remove();
                
                if(currElement.isInteger()){
                    currLevelSum += currElement.getInteger();
                }
                
                else{
                    for(NestedInteger element: currElement.getList()){
                        queue.add(element);
                    }
                }
            }
            
            prevLevelSum += currLevelSum;
            res+=prevLevelSum;
        }
        
        return res;
    }
}