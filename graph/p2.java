package graph;

import java.util.*;

class p2 {
    public static void main(String[] args) {
        Map<String,List<String>> g=new HashMap<>();
        add(g,"CS101","CS102");
        add(g,"CS101","CS201");
        add(g,"CS102","CS202");
        add(g,"MATH101","CS201");

        System.out.println(hasCycle(g));

        System.out.println(prereq(g,"CS202"));

        System.out.println(topo(g));
    }

    static void add(Map<String,List<String>> g,String u,String v){
        g.putIfAbsent(u,new ArrayList<>());
        g.putIfAbsent(v,new ArrayList<>());
        g.get(u).add(v);
    }

    static boolean hasCycle(Map<String,List<String>> g){
        Set<String> vis=new HashSet<>();
        Set<String> rec=new HashSet<>();
        for(String n:g.keySet()) if(dfs(g,n,vis,rec)) return true;
        return false;
    }

    static boolean dfs(Map<String,List<String>> g,String u,Set<String> vis,Set<String> rec){
        if(rec.contains(u)) return true;
        if(vis.contains(u)) return false;
        vis.add(u); rec.add(u);
        for(String v:g.get(u)) if(dfs(g,v,vis,rec)) return true;
        rec.remove(u);
        return false;
    }

    static Set<String> prereq(Map<String,List<String>> g,String target){
        Map<String,List<String>> rev=new HashMap<>();
        for(String u:g.keySet()){
            for(String v:g.get(u)){
                rev.putIfAbsent(v,new ArrayList<>());
                rev.get(v).add(u);
            }
        }
        Set<String> res=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        q.add(target);
        while(!q.isEmpty()){
            String cur=q.poll();
            if(!rev.containsKey(cur)) continue;
            for(String p:rev.get(cur)){
                if(res.add(p)) q.add(p);
            }
        }
        return res;
    }

    static List<String> topo(Map<String,List<String>> g){
        Map<String,Integer> indeg=new HashMap<>();
        for(String u:g.keySet()){
            indeg.putIfAbsent(u,0);
            for(String v:g.get(u)) indeg.put(v,indeg.getOrDefault(v,0)+1);
        }
        Queue<String> q=new LinkedList<>();
        for(String k:indeg.keySet()) if(indeg.get(k)==0) q.add(k);

        List<String> res=new ArrayList<>();
        while(!q.isEmpty()){
            String u=q.poll();
            res.add(u);
            for(String v:g.getOrDefault(u,new ArrayList<>())){
                indeg.put(v,indeg.get(v)-1);
                if(indeg.get(v)==0) q.add(v);
            }
        }
        return res;
    }
}
