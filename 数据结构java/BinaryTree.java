package com.zwl.List;

public class BinaryTree<T> implements BinaryTTree<T>{

	public BinaryNode<T> root;   //根结点，结点结构为二叉链表
	public BinaryTree(){         //构造空二叉树
		this.root=null;
	}
	public boolean isEmpty() {  //判断二叉树是否为空
		return this.root==null;
	}

	public int count() {
		return count(root);
	}
	
	public int count(BinaryNode<T> p){ //返回以p结点为根的子树的结点个数
		if(p==null)
			return 0;
		return 1+count(p.left)+count(p.right);
	}

	public int height() {
		return height(root);
	}

	public int height(BinaryNode<T> p){
		if(p==null)
			return 0;
		int lh=height(p.left); //返回左子树高度
		int rh=height(p.right); //返回右子树高度
		return (lh>=rh)?lh+1:rh+1; //当前子树高度为较高子树高度加1
	}
	
	public void preOrder() {
		System.out.println("先根次序遍历二叉树:  ");
		preOrder(root);
		System.out.println();
		
	}
	
	public void preOrder(BinaryNode<T> p){
		if(p!=null)
		{
			System.out.println(p.data.toString()+" ");//访问当前结点
			preOrder(p.left); //按先根次序遍历当前结点左子树，递归调用
			preOrder(p.right); //按先根次序遍历当前结点右子树，递归调用
		}
	}

	public void inOrder() {
		System.out.println("中根次序遍历二叉树 :   ");
		inOrder(root);
		System.out.println();	
	}

	public void inOrder(BinaryNode<T> p){
		if(p!=null)
		{
			inOrder(p.left);
			System.out.print(p.data.toString()+" ");
			inOrder(p.right);
		}
	}
	
	public void postOrder() {
	
		System.out.println("后根次序遍历二叉树 :   ");
		inOrder(root);
		System.out.println();
	}
	
	public void postOrder(BinaryNode<T> p){
		if(p!=null){
			postOrder(p.left);
			postOrder(p.right);
			System.out.println(p.data.toString()+" ");
		}
	}

	public void levelOrder() {
		// TODO Auto-generated method stub
		
	}

	public BinaryNode<T> search(T key) {
		return search(root,key);
	}
	
	public BinaryNode<T> search(BinaryNode<T> p,T key) {
		if(p==null||key==null)
			return null;
		if(p.data.equals(key))  //查找成功，返回找到结点
			return p;
		BinaryNode<T> find=search(p.left,key);//在左子树中查找，递归调用
		if(find==null)
			find=search(p.right,key);//左子树中未找到，在右子树中继续递归查找
		return find;
	}

	public BinaryNode<T> getParent(BinaryNode<T> node) {
	if(root==null||node==null||node==root)
		return null;
	 return getParent(root,node);
	}
	
	public BinaryNode<T> getParent(BinaryNode<T> p,BinaryNode<T> node) {
	if(p==null)
		return null;
	if(p.left==node||p.right==node)
		return p;
	BinaryNode<T> find=getParent(p.left,node);
	if(find==null)
		find=getParent(p.right,node);
		return find;
	}

	public void insertRoot(T x) {
		root=new BinaryNode<T>(x, root, null);
		
	}
	//插入元素x作为p结点的孩子，若leftChild为true,插入结点作为左孩子，否则作为右孩子
	public BinaryNode<T> insertChild(BinaryNode<T> p,T x,boolean leftChild){
		if(p==null||x==null)
			return null;
		if(leftChild)
		{
			p.left=new BinaryNode<T>(x, p.left, null);//插入x作为p的左孩子，p原左孩子变为x左孩子
			return p.left;
		}
		p.right=new BinaryNode<T>(x,null,p.right); //插入x结点作为p的右孩子
		return p.right;
	}

	

	public void removeChild(BinaryNode<T> p, boolean leftChild) {
	if(p!=null)
		if(leftChild)
			p.left=null;
		else
			p.right=null;
		
	}

	public void removeAll() {
		this.root=null;
		
	}

}
