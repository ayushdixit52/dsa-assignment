package graph;

import java.util.*;

class p4 {
    public static void main(String[] args) {
        int[][] g={
            {1,1,0,0,0},
            {1,1,0,0,1},
            {0,0,1,0,1},
            {0,0,0,1,1}
        };

        System.out.println(dfsIslands(g));
        System.out.println(bfsIslands(g));
    }

    static int dfsIslands(int[][] g){
        int n=g.length,m=g[0].length,c=0;
        boolean[][] vis=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(g[i][j]==1 && !vis[i][j]){
                    dfs(g,vis,i,j);
                    c++;
                }
            }
        }
        return c;
    }

    static void dfs(int[][] g,boolean[][] vis,int i,int j){
        int n=g.length,m=g[0].length;
        if(i<0||j<0||i>=n||j>=m||g[i][j]==0||vis[i][j]) return;
        vis[i][j]=true;
        dfs(g,vis,i+1,j);
        dfs(g,vis,i-1,j);
        dfs(g,vis,i,j+1);
        dfs(g,vis,i,j-1);
    }

    static int bfsIslands(int[][] g){
        int n=g.length,m=g[0].length,c=0;
        boolean[][] vis=new boolean[n][m];
        int[][] d={{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(g[i][j]==1 && !vis[i][j]){
                    Queue<int[]> q=new LinkedList<>();
                    q.add(new int[]{i,j});
                    vis[i][j]=true;
                    while(!q.isEmpty()){
                        int[] cur=q.poll();
                        for(int[] k:d){
                            int ni=cur[0]+k[0],nj=cur[1]+k[1];
                            if(ni>=0&&nj>=0&&ni<n&&nj<m&&g[ni][nj]==1&&!vis[ni][nj]){
                                vis[ni][nj]=true;
                                q.add(new int[]{ni,nj});
                            }
                        }
                    }
                    c++;
                }
            }
        }
        return c;
    }
}
