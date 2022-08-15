class Solution {
    
    int [] parent;
    public int[] findRedundantConnection(int[][] edges) {
        
        Unionfind uf = new Unionfind(edges.length+1);
        for(int [] edge : edges){
            if(!uf.union(edge[0],edge[1])){
                return edge;
            }
        }
        return new int[]{};        
    }
    
}

class Unionfind{
    
    int [] parent;
    int [] rank;
    
    Unionfind(int n){
        
        parent = new int[n];
        for(int i=0;i < n;i++) parent[i] = i;
        rank = new int[n];
         
    }
    
    int find(int x){
        
        while(x!=parent[x]){
            parent[x] = parent[parent[x]];
            x = parent[x];
         }
        
        return parent[x];
    }
    
     
    
    public boolean union(int x, int y) {
        int xr = find(x), yr = find(y);
        if (xr == yr) {
            return false;
        } else if (rank[xr] < rank[yr]) {
            parent[xr] = yr;
        } else if (rank[xr] > rank[yr]) {
            parent[yr] = xr;
        } else {
            parent[yr] = xr;
            rank[xr]++;
        }
        return true;
    }
    
    boolean union2(int x, int y){
        
        int px = find(x);
        int py = find(y);
        if(px==py)
            return false;
        else if(rank[px] >= rank[py]){
            parent[y] = x;
            rank[x] +=1;
        }else{
            parent[x]=y;
            rank[y] += 1;
        }
        
        return true;
    }
    
}