package com.practice.tree;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root,p,q);
    }

    TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)
            return root;

        TreeNode l = lca(root.left,p,q);
        TreeNode r = lca(root.right,p,q);

        if((l!=null || r!=null ) && (root==p || root==q)){
            return root;
        }

        if((l==p || l==q) && (r==p || r==q)){
            return root;
        }
        if(l!=null)
            return l;

        if(r!=null)
            return r;

        return root==p || root==q ? root: null;

    }
}
