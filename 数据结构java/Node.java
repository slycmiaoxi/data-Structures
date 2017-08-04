package com.zwl.List;

public class Node<T> {  //单链表结点类

	public T data;            //数据域，保存数据元素
	public Node<T> next;      //地址域，引用后继结点
	
	public Node(T data,Node<T> next){
		this.data=data;
		this.next=next;
	}
	
	public Node(){
		this(null,null);
	}
}
