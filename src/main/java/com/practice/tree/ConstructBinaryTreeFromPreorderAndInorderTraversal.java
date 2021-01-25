package com.practice.tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return helper(0,preorder.length-1,preorder,inorder);
    }
    int index=0;

    TreeNode helper(int low, int high, int []preorder, int []inorder){
        if(low>high){
            return null;
        }
        int v = preorder[index++];
        TreeNode root  = new TreeNode(v);
        int pos = findIndex(inorder,v);
        root.left  = helper(low,pos-1,preorder,inorder);
        root.right = helper(pos+1,high,preorder,inorder);
        return root;
    }

    int findIndex(int []inorder, int target ){
        //return Arrays.binarySearch(inorder,target);
        for(int i=0;i<inorder.length;i++){
            if(target==inorder[i])
                return i;
        }
        return -1;
    }
}
