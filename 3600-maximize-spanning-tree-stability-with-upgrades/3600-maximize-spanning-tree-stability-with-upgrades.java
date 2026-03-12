class Solution {

    class DSU {
        int[] parent, rank;
        int comp;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            comp = n;
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return false;

            if (rank[pa] < rank[pb]) parent[pa] = pb;
            else if (rank[pb] < rank[pa]) parent[pb] = pa;
            else {
                parent[pb] = pa;
                rank[pa]++;
            }

            comp--;
            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {
        int left = 0, right = 200000;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (can(mid, n, edges, k)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    private boolean can(int target, int n, int[][] edges, int k) {
        DSU dsu = new DSU(n);
        int upgrades = 0;

        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if (must == 1) {
                if (s < target) return false;
                if (!dsu.union(u, v)) return false; 
            }
        }

        List<int[]> normal = new ArrayList<>();
        List<int[]> upgrade = new ArrayList<>();

        for (int[] e : edges) {
            if (e[3] == 1) continue;

            if (e[2] >= target) normal.add(e);
            else if (e[2] * 2 >= target) upgrade.add(e);
        }

        for (int[] e : normal) {
            dsu.union(e[0], e[1]);
        }

        for (int[] e : upgrade) {
            if (dsu.union(e[0], e[1])) {
                upgrades++;
                if (upgrades > k) return false;
            }
        }

        return dsu.comp == 1;
    }
}