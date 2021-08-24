package com.practice.Tree;// non-recursive java program for inorder traversal
import java.util.Stack;

/* Class containing left and right child of 
current com.practice.Tree.TreeNode and key value*/
class TreeNode
{
    int data;
    TreeNode left, right;

    public TreeNode(int item)
    {
        data = item;
        left = right = null;
    }
}

/* Class to print the inorder traversal */
class BinaryTree
{
    TreeNode root;
    void inorder()
    {
        if (root == null)
            return;


        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode curr = root;

        // traverse the tree 
        while (curr != null || s.size() > 0)
        { 

			/* Reach the left most com.practice.Tree.TreeNode of the
			curr com.practice.Tree.TreeNode */
            while (curr != null)
            { 
				/* place pointer to a tree com.practice.Tree.TreeNode on
				the stack before traversing 
				the com.practice.Tree.TreeNode's left subtree */
                s.push(curr);
                curr = curr.left;
            }

            /* Current must be NULL at this point */
            curr = s.pop();

            System.out.print(curr.data + " "); 

			/* we have visited the com.practice.Tree.TreeNode and its
			left subtree. Now, it's right 
			subtree's turn */
            curr = curr.right;
        }
    }

    public static void main(String args[])
    { 

		/* creating a binary tree and entering 
		the TreeNodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(-5);
        tree.root.right = new TreeNode(25);
        tree.root.left.left = new TreeNode(-10);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(36);
        tree.inorder();

    }
} 
