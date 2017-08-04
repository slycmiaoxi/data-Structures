package com.zwl.tree;

import com.zwl.List.BinaryNode;
import com.zwl.List.BinaryTree;

public class BinarySortTree<T extends Comparable<T>> extends BinaryTree<T> {

	public BinarySortTree(){
              super();
	}
	
	public BinarySortTree(Integer values[]){
		
	}
	
	public BinaryNode<T> search(T key){
		if(key==null)
			return null;
		  BinaryNode<T> p=this.root;
		   while(p!=null&&p.data.compareTo(key)!=0){
			   if(key.compareTo(p.data)<0)
				   p=p.left;
			   else
				   p=p.right;
		   }
		   return p;
	}
	
	public void insert(T x){   
		if(x==null)
			return;
		 if(this.root==null)
			root=new BinaryNode<T>(x);
		 else{
			 BinaryNode p=root,parent=null;
			 while(p!=null){
			   parent=p;
			    if(x.compareTo((T) p.data)==0)
			    	return;
			      if(x.compareTo((T) p.data)<0)
			    	 p=p.left;
			      else
			    	  p=p.right;
			 }
			 p=new BinaryNode<T>(x);
			 if(x.compareTo((T) parent.data)<0)
				 parent.left=p;
			 else
				 parent.right=p;
		 }
	}
	
	public BinaryNode<T> remove(T x){ //删除元素为x的结点，返回删除结点，若没删除则返回null
		if(root==null||x==null) //空二叉树或者要删除的元素为空都不能删除
			return null;		
	}
	
	//在以p为根的子树中删除元素为x的结点，parent是p的父母结点，返回删除结点，递归算法
	public BinaryNode<T> remove(T x,BinaryNode<T> p,BinaryNode<T> parent){
		if(p==null)  //删除的结点为空，不能删除
			return null;
		if(x.compareTo(p.data)<0)  
			return remove(x,p.left,p); //在p的左子树中删除x，递归调用
		if(x.compareTo(p.data)>0)
			return remove(x,p.right,p); //在p的右子树中删除x，递归调用
		if(p.left!=null&&p.right!=null) //找到待删除结点p，p是2度结点
		{
			 BinaryNode<T> insucc=p.right; //p在中根次序下的后继结点
			 while(insucc.left!=null) //不断循环，直到找到后继结点，并且该后继结点无左孩子
				 insucc=insucc.left;
			 p.data=insucc.data;      //以后继结点替换掉找到的p值
			 return remove(p.data,p.right,p);//不断递归上述过程，替换掉后面的结点至重新变成二叉树			  
		}
		 if(parent==null) //p是1度或叶子结点，删除根结点，即p==root
		 {
			 if(p.left!=null)
				 root=p.left;
			 else
				 root=p.right;
			 return p;
		 }
		if(p==parent.left) //p是1度或者叶子结点，p是parent的左孩子
			if(p.left!=null)
				parent.left=p.left;
			else
				parent.right=p.right;
		else                //p是parent的右孩子
			if(p.left!=null)
				parent.right=p.left;
			else
				parent.right=p.right;
		return p;
	}
	
	public static void main(String args[]){
		BinarySortTree<Integer> bstree=new BinarySortTree<Integer>();
		 int[] values={54,18,66,87,36,12,54,81,15,76,57,6,40,99,85,99};
		  for(int i=0;i<values.length;i++)
		    bstree.insert(values[i]);
		      bstree.inOrder();
		       Integer key=new Integer(values[values.length-1]);
		         System.out.println("查找"+key+","+(bstree.search(key)!=null?"":"不")+"成功");
	}
	
}
