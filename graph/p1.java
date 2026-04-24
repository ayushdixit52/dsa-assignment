package graph;
import java.util.*;

class p1 {
    public static void main(String[] args) {
        Map<String, List<String>> g = new HashMap<>();
        add(g,"Alice","Bob");
        add(g,"Alice","Charlie");
        add(g,"Bob","David");
        add(g,"Charlie","Eve");
        add(g,"David","Eve");

        System.out.println(g.get("Alice"));

        System.out.println(g.get("Bob").contains("Eve"));

        System.out.println(bfs(g,"Alice","Eve"));
    }

    static void add(Map<String,List<String>> g,String u,String v){
        g.putIfAbsent(u,new ArrayList<>());
        g.putIfAbsent(v,new ArrayList<>());
        g.get(u).add(v);
        g.get(v).add(u);
    }

    static List<String> bfs(Map<String,List<String>> g,String s,String t){
        Queue<String> q=new LinkedList<>();
        Map<String,String> p=new HashMap<>();
        Set<String> vis=new HashSet<>();
        q.add(s); vis.add(s);

        while(!q.isEmpty()){
            String cur=q.poll();
            if(cur.equals(t)) break;
            for(String nei:g.get(cur)){
                if(!vis.contains(nei)){
                    vis.add(nei);
                    p.put(nei,cur);
                    q.add(nei);
                }
            }
        }

        List<String> path=new ArrayList<>();
        for(String at=t;at!=null;at=p.get(at)) path.add(at);
        Collections.reverse(path);
        return path;
    }
}
