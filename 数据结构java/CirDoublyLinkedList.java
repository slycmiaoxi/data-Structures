package com.zwl.List;

public class CirDoublyLinkedList<T> implements LList<T>{

	public DLinkNode<T> head;
	
	public CirDoublyLinkedList(){
		this.head=new DLinkNode<T>();
		this.head.prev=head;
		this.head.next=head;
	}
	
	
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	public T get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public void set(int i, T x) {
		// TODO Auto-generated method stub
		
	}

	public void insert(int i, T x) {//将x对象插入在序号为i的结点
	if(x==null)
		return;
	DLinkNode<T> p=this.head;
	for(int j=0;p.next!=this.head&&j<i;j++) //寻找插入位置
		p=p.next;                           //循环停止时，p指向第i-1个结点
	 DLinkNode<T> q=new DLinkNode<T>(x,p,p.next);//插入在p结点之后
	 p.next.prev=q;
	 p.next=q;
		
	}

	public void append(T x) {
	 if(x==null)
		 return;
	 DLinkNode<T> q=new DLinkNode<T>(x,head.prev,head);
	 head.prev.next=q; //插入在头结点之前，相当于尾插入
	 head.prev=q;
		
	}

	public T remove(int i) {
	if(i>0)
	{
		DLinkNode<T> p=this.head.next;
		for(int j=0;p!=head&&j<i;j++)  //定位到待删除结点
			p=p.next;
		if(p!=head)
		{ 
			T old=p.data;     //获得原对象
			p.prev.next=p.next;  //删除p结点自己
			p.next.prev=p.prev;
			return old;
		}
	}
		return null;
	}

	public void removeAll() {
		this.head.prev=head;
		this.head.next=head;
		
	}

	public int indexOf(T key) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean contain(T key) {
		// TODO Auto-generated method stub
		return false;
	}

	public T search(T key) {
		// TODO Auto-generated method stub
		return null;
	}

}
