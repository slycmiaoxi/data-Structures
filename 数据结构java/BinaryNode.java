package com.zwl.List;

public class BinaryNode<T> {

	public T data;                 //�����򣬴洢����Ԫ��
	public BinaryNode<T> left,right;   //���򣬷ֱ�ָ�����Һ��ӽ��
	
	public BinaryNode(T data,BinaryNode<T> left,BinaryNode<T> right){
		this.data=data;
		this.left=left;
		this.right=right;
	}
	
	public BinaryNode(T data){
		this(data,null,null);
	}
	
	public BinaryNode(){
		this(null,null,null);
	}
}
