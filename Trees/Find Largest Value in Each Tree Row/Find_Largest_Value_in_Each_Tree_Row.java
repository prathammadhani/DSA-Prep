// Problem Name: LC - 515. Find Largest Value in Each Tree Row
// Problem Link: https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/

// BFS Approach
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null)
            return new ArrayList<Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            int mx = Integer.MIN_VALUE;
            for (int i = 0; i < sz; i++) {
                TreeNode node = q.poll();
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                mx = Math.max(mx, node.val);
            }
            ans.add(mx);
        }
        return ans;
    }
}

// DFS Approach
class Solution {
    List<Integer> ans;
    public void dfs(TreeNode node,int depth){
        if(node==null) return;
        if(depth==ans.size()) ans.add(node.val);
        else ans.set(depth, Math.max(ans.get(depth),node.val));
        dfs(node.left,depth+1);
        dfs(node.right,depth+1);
    }
    public List<Integer> largestValues(TreeNode root) {
        ans = new ArrayList<Integer>();
        dfs(root,0);
        return ans;
    }
} 