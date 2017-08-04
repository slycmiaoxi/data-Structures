package com.zwl.List;

public class DLinkNode<T> {

	public T data;  //数据元素
	public DLinkNode<T> prev,next; //prev指向前驱结点，next指向后继结点
	
	public DLinkNode(T data, DLinkNode<T> prev, DLinkNode<T> next) {
		super();
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	
	public DLinkNode(){
		this(null,null,null);
	}
}
