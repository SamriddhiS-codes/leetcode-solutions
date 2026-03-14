class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;

        HashMap<Integer,Integer>hashmap=new HashMap<>();
        int prefixSum=0;
        int count=0;

        hashmap.put(0,1);
        for(int i=0;i<n;i++){
            prefixSum+=nums[i];
            int remove=prefixSum-k;
            if(hashmap.containsKey(remove)){
                count+=hashmap.get(remove);

            }
            hashmap.put(prefixSum,hashmap.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}