package tree;

import node.Node;
/**
 * 二叉树存储结构结点定义
 * @author Administrator
 *
 */
public class BinTreeNode implements Node {

	/**
	 * 数据域
	 */
	private Object data;
	
	/**
	 * 父结点
	 */
	private BinTreeNode parent;
	
	/**
	 * 左孩子
	 */
	private BinTreeNode lChild;
	
	/**
	 * 右孩子
	 */
	private BinTreeNode rChild;
	
	/**
	 * 以该结点为根的子树的高度
	 */
	private int height;
	
	/**
	 * 该结点子孙数（包括结点本身）
	 */
	private int size;
	
	public BinTreeNode() {
		this(null);
	}
	
	public BinTreeNode(Object e) {
		data = e;
		height = 0;
		size = 1;
		parent = lChild = rChild = null;
	}
	
	@Override
	public Object getData() {
		return data;
	}

	@Override
	public void setData(Object obj) {
		data = obj;
	}
	
	/**
	 * 判断是否有父亲
	 * @return
	 */
	public boolean hasParent() {
		return parent != null;
	}
	
	/**
	 * 判断是否有左孩子
	 * @return
	 */
	public boolean hasLChild() {
		return lChild != null;
	}
	
	/**
	 * 判断是否有右孩子
	 * @return
	 */
	public boolean hasRChild() {
		return rChild != null;
	}
	
	/**
	 * 判断是否为叶子结点
	 * @return
	 */
	public boolean isLeaf() {
		return !hasLChild() && !hasRChild();
	}
	
	/**
	 * 判断是否为某结点的左孩子
	 */
	public boolean isLChild() {
		return (hasParent()) && this == parent.lChild;
	}
	
	/**
	 * 判断是否为某结点的右孩子
	 * @return
	 */
	public boolean isRChild() {
		return (hasParent()) && this == parent.rChild;
	}
	
	/**
	 * 取结点的高度，即以该结点为根的树的高度
	 * @return
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * 更新当前结点及其祖先的高度
	 */
	public void updateHeight() {
		//新高度初始化为0，高度等于左右子树高度加1中的大者
		int newH = 0;
		if(hasLChild()) {
			newH = Math.max(newH, 1 + getLChild().getHeight());
		}
		if(hasRChild()) {
			newH = Math.max(newH, 1 + getRChild().getHeight());
		}
		//高度没有变化则直接返回
		if(newH == height) {
			return;
		}
		//否则更新高度
		height = newH;
		if(hasParent()) {
			//递归更新祖先的高度
			getParent().updateHeight();
		}
	}
	
	/**
	 * 取以该结点为根的树的结点数
	 * @return
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * 更新当前结点及其祖先的子孙数
	 */
	public void updateSize() {
		//初始化为1，结点本身
		size = 1;
		if(hasLChild()) {
			//加上左子树规模
			size += getLChild().getSize();
		}
		if(hasRChild()) {
			//加上右子树规模
			size += getRChild().getSize();
		}
		if(hasParent()) {
			//递归更新祖先的规模
			getParent().updateSize();
		}
	}
	
	/**
	 * 取父结点
	 * @return
	 */
	public BinTreeNode getParent() {
		return parent;
	}
	
	/**
	 * 断开和父结点的关系
	 */
	public void sever() {
		if(!hasParent()) {
			return;
		}
		if(isLChild()) {
			parent.lChild = null;
		}else {
			parent.rChild = null;
		}
		//更新父结点及其祖先高度
		parent.updateHeight();
		//更新父结点及其祖先规模
		parent.updateSize();
		parent = null;
	}
	
	/**
	 * 取左孩子
	 * @return
	 */
	public BinTreeNode getLChild() {
		return lChild;
	}
	
	/**
	 * 设置当前结点的左孩子，返回原左孩子
	 * @param lc
	 * @return
	 */
	public BinTreeNode setLChild(BinTreeNode lc) {
		BinTreeNode oldLC = this.lChild;
		if(hasLChild()) {
			//断开当前左孩子与结点的关系
			lChild.sever();
		}
		if(lc != null) {
			//断开lc与其父结点的关系
			lc.sever();
			//确定父子关系
			this.lChild = lc;
			lc.parent = this;
			//更新当前结点及其祖先高度
			this.updateHeight();
			//更新当前结点及其祖先规模
			this.updateSize();
		}
		//返回原左孩子
		return oldLC;
	}
	
	/**
	 * 取右孩子
	 * @return
	 */
	public BinTreeNode getRChild() {
		return rChild;
	}

	/**
	 * 设置当前结点的右孩子，返回原右孩子
	 * @param rc
	 * @return
	 */
	public BinTreeNode setRChild(BinTreeNode rc) {
		BinTreeNode oldRC = this.rChild;
		if(hasRChild()) {
			//断开当前右孩子与结点的关系
			rChild.sever();
		}
		if(rc != null) {
			//断开lc与其父结点的关系
			rc.sever();
			//确定父子关系
			this.rChild = rc;
			rc.parent = this;
			//更新当前结点及其祖先高度
			this.updateHeight();
			//更新当前结点及其祖先规模
			this.updateSize();
		}
		//返回右孩子
		return oldRC;
	}
	
}
