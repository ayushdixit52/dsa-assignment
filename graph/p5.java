package graph;

import java.util.*;

class p5 {
    public static void main(String[] args) {
        int n=6;
        int[][] mat=new int[n][n];
        Map<Integer,List<Integer>> g=new HashMap<>();

        add(mat,g,0,1);
        add(mat,g,0,2);
        add(mat,g,1,3);
        add(mat,g,2,3);
        add(mat,g,3,4);
        add(mat,g,4,5);

        System.out.println(isConnected(g,n));

        remove(mat,g,3,4);

        System.out.println(bfs(g,0,5));
    }

    static void add(int[][] mat,Map<Integer,List<Integer>> g,int u,int v){
        mat[u][v]=mat[v][u]=1;
        g.putIfAbsent(u,new ArrayList<>());
        g.putIfAbsent(v,new ArrayList<>());
        g.get(u).add(v);
        g.get(v).add(u);
    }

    static void remove(int[][] mat,Map<Integer,List<Integer>> g,int u,int v){
        mat[u][v]=mat[v][u]=0;
        g.get(u).remove(Integer.valueOf(v));
        g.get(v).remove(Integer.valueOf(u));
    }

    static boolean isConnected(Map<Integer,List<Integer>> g,int n){
        Set<Integer> vis=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        q.add(0); vis.add(0);
        while(!q.isEmpty()){
            int u=q.poll();
            for(int v:g.getOrDefault(u,new ArrayList<>())){
                if(!vis.contains(v)){
                    vis.add(v);
                    q.add(v);
                }
            }
        }
        return vis.size()==n;
    }

    static int bfs(Map<Integer,List<Integer>> g,int s,int t){
        Queue<Integer> q=new LinkedList<>();
        int[] dist=new int[6];
        Arrays.fill(dist,-1);
        q.add(s); dist[s]=0;

        while(!q.isEmpty()){
            int u=q.poll();
            if(u==t) return dist[u];
            for(int v:g.getOrDefault(u,new ArrayList<>())){
                if(dist[v]==-1){
                    dist[v]=dist[u]+1;
                    q.add(v);
                }
            }
        }
        return -1;
    }
}
