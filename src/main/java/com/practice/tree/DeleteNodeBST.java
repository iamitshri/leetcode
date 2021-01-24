package com.practice.tree;

public class DeleteNodeBST {

    public TreeNode deleteNode(TreeNode root, int key) {

        if(root==null)
            return null;

        if(key == root.val){
            TreeNode  temp=null;
            TreeNode   newRoot=null;
            // root deleted
            if(root.left!=null && root.right==null){
                return root.left;
            }else if(root.left==null && root.right==null){
                return null;

            }else if(root.left==null && root.right!=null){
                return root.right;
            }
            else if(root.left!=null){
                newRoot = root.left;
                temp = newRoot.right;
                newRoot.right = root.right ;
                TreeNode n = root.right;
                while(n.left!=null){
                    n = n.left;
                }
                n.left = temp;
                return newRoot;
            }

        }else if(key <= root.val){
            root.left =  deleteNode(root.left,key);
        }else if(key > root.val){
            root.right = deleteNode(root.right,key);
        }

        return root;
    }
}
