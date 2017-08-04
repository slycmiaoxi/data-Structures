package com.zwl.List;

public class BinaryTree<T> implements BinaryTTree<T>{

	public BinaryNode<T> root;   //����㣬���ṹΪ��������
	public BinaryTree(){         //����ն�����
		this.root=null;
	}
	public boolean isEmpty() {  //�ж϶������Ƿ�Ϊ��
		return this.root==null;
	}

	public int count() {
		return count(root);
	}
	
	public int count(BinaryNode<T> p){ //������p���Ϊ���������Ľ�����
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
		int lh=height(p.left); //�����������߶�
		int rh=height(p.right); //�����������߶�
		return (lh>=rh)?lh+1:rh+1; //��ǰ�����߶�Ϊ�ϸ������߶ȼ�1
	}
	
	public void preOrder() {
		System.out.println("�ȸ��������������:  ");
		preOrder(root);
		System.out.println();
		
	}
	
	public void preOrder(BinaryNode<T> p){
		if(p!=null)
		{
			System.out.println(p.data.toString()+" ");//���ʵ�ǰ���
			preOrder(p.left); //���ȸ����������ǰ������������ݹ����
			preOrder(p.right); //���ȸ����������ǰ������������ݹ����
		}
	}

	public void inOrder() {
		System.out.println("�и�������������� :   ");
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
	
		System.out.println("���������������� :   ");
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
		if(p.data.equals(key))  //���ҳɹ��������ҵ����
			return p;
		BinaryNode<T> find=search(p.left,key);//���������в��ң��ݹ����
		if(find==null)
			find=search(p.right,key);//��������δ�ҵ������������м����ݹ����
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
	//����Ԫ��x��Ϊp���ĺ��ӣ���leftChildΪtrue,��������Ϊ���ӣ�������Ϊ�Һ���
	public BinaryNode<T> insertChild(BinaryNode<T> p,T x,boolean leftChild){
		if(p==null||x==null)
			return null;
		if(leftChild)
		{
			p.left=new BinaryNode<T>(x, p.left, null);//����x��Ϊp�����ӣ�pԭ���ӱ�Ϊx����
			return p.left;
		}
		p.right=new BinaryNode<T>(x,null,p.right); //����x�����Ϊp���Һ���
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
