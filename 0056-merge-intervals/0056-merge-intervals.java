class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        List<int[]>ans=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        for(int i=0;i<n;i++){
            if(ans.isEmpty() || intervals[i][0]>ans.get(ans.size()-1)[1]){
                ans.add(intervals[i]);
            }
            else{
                ans.get(ans.size()-1)[1]=Math.max(ans.get(ans.size()-1)[1],intervals[i][1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}