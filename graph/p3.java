package graph;

import java.util.*;

class p3 {
    static class Edge{
        String v; int w;
        Edge(String v,int w){this.v=v;this.w=w;}
    }

    public static void main(String[] args) {
        Map<String,List<Edge>> g=new HashMap<>();
        add(g,"A","B",5,true);
        add(g,"B","C",3,false);
        add(g,"A","D",7,false);
        add(g,"D","E",2,true);
        add(g,"C","E",4,true);

        System.out.println(reachable(g,"A"));

        System.out.println(bfs(g,"A","E"));
    }

    static void add(Map<String,List<Edge>> g,String u,String v,int w,boolean one){
        g.putIfAbsent(u,new ArrayList<>());
        g.putIfAbsent(v,new ArrayList<>());
        g.get(u).add(new Edge(v,w));
        if(!one) g.get(v).add(new Edge(u,w));
    }

    static Set<String> reachable(Map<String,List<Edge>> g,String s){
        Set<String> vis=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        q.add(s); vis.add(s);
        while(!q.isEmpty()){
            String u=q.poll();
            for(Edge e:g.get(u)){
                if(!vis.contains(e.v)){
                    vis.add(e.v);
                    q.add(e.v);
                }
            }
        }
        return vis;
    }

    static List<String> bfs(Map<String,List<Edge>> g,String s,String t){
        Queue<String> q=new LinkedList<>();
        Map<String,String> p=new HashMap<>();
        Set<String> vis=new HashSet<>();
        q.add(s); vis.add(s);

        while(!q.isEmpty()){
            String u=q.poll();
            if(u.equals(t)) break;
            for(Edge e:g.get(u)){
                if(!vis.contains(e.v)){
                    vis.add(e.v);
                    p.put(e.v,u);
                    q.add(e.v);
                }
            }
        }

        List<String> path=new ArrayList<>();
        for(String at=t;at!=null;at=p.get(at)) path.add(at);
        Collections.reverse(path);
        return path;
    }
}
