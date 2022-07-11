package com.tree.question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class EvaluateTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public static boolean evaluateTree(TreeNode root) {
	        
	        if(root.left == null) {
	            return root.val == 1;
	        }
	        if(root.right == null){
	            return root.val == 1;
	        }
	        
	        if(root.val == 2) {
	           root.val =  (evaluateTree(root.left) || evaluateTree(root.right)) ? 1 : 0 ;
	        }
	         if(root.val == 3) {
	           root.val =  (evaluateTree(root.left) && evaluateTree(root.right)) ? 1 : 0 ;
	        }
	         return root.val == 1;
	        
	    }

}


//  Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

