// Problem Name: LC - 515. Find Largest Value in Each Tree Row
// Problem Link: https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/

// BFS Approach
class Solution {
public:
    vector<int> largestValues(TreeNode* root) {
        vector<int> ans;
        if(!root) return ans;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            int sz = q.size();
            int mx = INT_MIN;
            for(int i = 0;i<sz;i++){
                TreeNode* node = q.front();
                q.pop();
                if(node->left) q.push(node->left);
                if(node->right) q.push(node->right);
                mx = max(mx,node->val);
            }
            ans.push_back(mx);
        }
        return ans;
    }
};

// DFS Approach
class Solution {
public:
    vector<int> ans;
    void dfs(TreeNode* node,int depth){
        if(!node) return;
        if(depth==ans.size()) ans.push_back(node->val);
        else ans[depth] = max(ans[depth],node->val);
        dfs(node->left,depth+1);
        dfs(node->right,depth+1);
    }
    vector<int> largestValues(TreeNode* root) {
        dfs(root,0);
        return ans;
    }
};