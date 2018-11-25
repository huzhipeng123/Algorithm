package tree.impl;
/**
 * 二叉树的实现类
 */

import iterator.Iterator;
import list.LinkedList;
import list.impl.LinkedListDLNode;
import stack.Stack;
import stack.impl.StackSLinked;
import strategy.Strategy;
import tree.BinTreeNode;

public class BinaryTreeLinked {
	
	/**
	 * 根结点
	 */
	private BinTreeNode root;

	private Strategy strategy;

	/**
	 * 输出迭代器对象，先序遍历二叉树的结果
	 * @return
	 */
	public Iterator preOrder() {
		LinkedList list = new LinkedListDLNode();
		preOrderTraverse(this.root, list);
		return list.elements();
	}
	
	/**
	 * 先序遍历的非递归算法
	 * @param root2
	 * @param list
	 */
	private void preOrderTraverse(BinTreeNode root, LinkedList list) {
		if(root == null) {
			return;
		}
		BinTreeNode p = root;
		Stack s = new StackSLinked();
		while(p != null) {
			//向左走到尽头
			while(p != null) {
				//访问根
				list.insertLast(p);
				
			}
		}
	}
	
}
