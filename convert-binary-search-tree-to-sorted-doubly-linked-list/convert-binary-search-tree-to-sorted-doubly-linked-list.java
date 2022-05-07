/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node head;
    Node ll;
    void append(Node node){
            
        if(ll==null){
            node.left=node;
            node.right=node;
            ll = head = node;
            return;
        }
            Node temp = ll.right; // next
            
            ll.right=node; // new node becomes next
            node.left=ll; // new node's left become ll
            
            node.right = temp; // new node's right goes to temp
            temp.left=node;
            
            ll = node;
        }
    
        void inorder(Node root){
            if(root==null)
                return;
           
            Node left = root.left;
            Node right = root.right;
            inorder(left);
            append(root);
            inorder(right);
        }
    
    public Node treeToDoublyList(Node root) {
        
        inorder(root);
        return head;
    }
}