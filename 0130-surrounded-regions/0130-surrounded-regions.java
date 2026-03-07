class Solution {
    int n,m;
    int dir[][]={{0,1},{0,-1},{1,0},{-1,0}};
    public void dfs(char[][] board,int r,int c){
        if(r<0 || r>=n || c<0 || c>=m || board[r][c]!='O'){
            return;
        }
        board[r][c]='T';
        for(int d[]: dir){
            dfs(board,r+d[0],c+d[1]);
        }


    }
    public void solve(char[][] board) {
        n=board.length;
        m= board[0].length;
        if(n==0){
            return;
        }
        for(int i=0;i<n;i++){
            dfs(board,i,0);
            dfs(board,i,m-1);
        }
        for(int j=0;j<m;j++){
            dfs(board,0,j);
            dfs(board,n-1,j);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'T') board[i][j] = 'O';
            }
        }
        
    }
}