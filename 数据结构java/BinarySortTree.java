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
	
	public BinaryNode<T> remove(T x){ //ɾ��Ԫ��Ϊx�Ľ�㣬����ɾ����㣬��ûɾ���򷵻�null
		if(root==null||x==null) //�ն���������Ҫɾ����Ԫ��Ϊ�ն�����ɾ��
			return null;		
	}
	
	//����pΪ����������ɾ��Ԫ��Ϊx�Ľ�㣬parent��p�ĸ�ĸ��㣬����ɾ����㣬�ݹ��㷨
	public BinaryNode<T> remove(T x,BinaryNode<T> p,BinaryNode<T> parent){
		if(p==null)  //ɾ���Ľ��Ϊ�գ�����ɾ��
			return null;
		if(x.compareTo(p.data)<0)  
			return remove(x,p.left,p); //��p����������ɾ��x���ݹ����
		if(x.compareTo(p.data)>0)
			return remove(x,p.right,p); //��p����������ɾ��x���ݹ����
		if(p.left!=null&&p.right!=null) //�ҵ���ɾ�����p��p��2�Ƚ��
		{
			 BinaryNode<T> insucc=p.right; //p���и������µĺ�̽��
			 while(insucc.left!=null) //����ѭ����ֱ���ҵ���̽�㣬���Ҹú�̽��������
				 insucc=insucc.left;
			 p.data=insucc.data;      //�Ժ�̽���滻���ҵ���pֵ
			 return remove(p.data,p.right,p);//���ϵݹ��������̣��滻������Ľ�������±�ɶ�����			  
		}
		 if(parent==null) //p��1�Ȼ�Ҷ�ӽ�㣬ɾ������㣬��p==root
		 {
			 if(p.left!=null)
				 root=p.left;
			 else
				 root=p.right;
			 return p;
		 }
		if(p==parent.left) //p��1�Ȼ���Ҷ�ӽ�㣬p��parent������
			if(p.left!=null)
				parent.left=p.left;
			else
				parent.right=p.right;
		else                //p��parent���Һ���
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
		         System.out.println("����"+key+","+(bstree.search(key)!=null?"":"��")+"�ɹ�");
	}
	
}
