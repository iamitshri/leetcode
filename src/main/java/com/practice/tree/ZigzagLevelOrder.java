package com.practice.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        boolean flag=true;
        List<Integer> lst;
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)
            return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(true){

            lst = new ArrayList<Integer>();
            Stack<TreeNode> newStack = new Stack<TreeNode>();
            while(!stack.isEmpty()){

                TreeNode node = stack.pop();
                lst.add(node.val);

                if(flag){

                    if(node.left!=null)
                        newStack.push(node.left);

                    if(node.right!=null)
                        newStack.push(node.right);

                }else{
                    if(node.right!=null)
                        newStack.push(node.right);

                    if(node.left!=null)
                        newStack.push(node.left);
                }
            }

            result.add(lst);
            if(newStack.isEmpty())
                break;
            flag=!flag;
            stack = newStack;
        }
        return result;
    }
}
