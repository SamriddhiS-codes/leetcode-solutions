class Solution {
    private long nCr(int n,int r){
        long result=1;
        for(int i=0;i<r;i++){
            result*=(n-i);
            result/=(i+1);
        }
        return result;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>ans=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            List<Integer>temp= new ArrayList<>();
            for(int j=1;j<=i;j++){
                long value=nCr(i-1,j-1);
                temp.add((int)value);
            }
            ans.add(temp);
        }
        return ans;
    }
}