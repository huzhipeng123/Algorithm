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
	 * preOrderTraverse 方法以一棵树的根结点 rt 以及链接表 list 作为参数。如
果 rt 为空直接返回，否则 p 指向 rt，并先序遍历以 p 为根的树。在 preOrderTraverse 内层循
环中，沿着根结点 p 一直向左走，沿途访问经过的根结点，并将这些根结点的非空右子树入
栈，直到 p 为空。此时应当取出沿途最后碰到的非空右子树的根，即栈顶结点（以 p 指向），
然后在外层循环中继续先序遍历这棵以 p 指向的子树。如果堆栈为空，则表示再没有的右子
树需要遍历，此时结束外层循环，完成整棵树的先序遍历。如果以 rt 为根的树的结点数为 n，
由于每个结点访问且仅被访问一次，并且每个结点最多入栈一次和出栈一次，因此
preOrderTraverse 的时间复杂度 T(n) = Ο(n)。
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
				//右子树根结点入栈
				if(p.hasRChild()) {
					s.push(p.getRChild());
				}
				p = p.getLChild();
			}
			//右子树根退栈遍历右子树
			if(!s.isEmpty()) {
				p = (BinTreeNode)s.pop();
			}
		}
	}
	
	
	/**
	 * 中序遍历二叉树
	 * @return
	 */
	public Iterator inOrder() {
		LinkedList list = new LinkedListDLNode();
		inOrderTraverse(this.root, list);
		return list.elements();
	}

	/**
	 * 中序遍历的非递归算法
	 * @param root2
	 * @param list
	 */
	private void inOrderTraverse(BinTreeNode root, LinkedList list) {
		if(root == null) {
			return;
		}
		BinTreeNode p = root;
		Stack s = new StackSLinked();
		while(p != null || s.isEmpty()) {
			//一直向左走
			while(p != null) {
				//将根结点入栈
				s.push(p);
				p = p.getLChild();
			}
			if(!s.isEmpty()) {
				p = (BinTreeNode) s.pop();
				list.insertLast(p);
				p = p.getRChild();
			}
		}
	}
}
