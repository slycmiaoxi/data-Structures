package com.zwl.List;

public class SinglyLinkenList<T> implements LList<T> {

	public Node<T> head;  //头指针
	
	public SinglyLinkenList(){ //构造空链表
		this.head=new Node<T>();
	}
	
	public SinglyLinkenList(T[] element){//尾插入构造单链表
		this();
		Node<T> rear=this.head; //指向单链表最后一个结点
		for(int i=0;i<element.length;i++){
			rear.next=new Node<T>(element[i],null); //尾插入
			rear=rear.next;     //指向新的链尾结点
		}
		
	}
	
	public boolean isEmpty() {
		
		return this.head.next==null;
	}

	public int length() {
		
		int i=0;
		Node<T> p=this.head.next;  //p从单链表第一个结点开始
		while(p!=null){            //若单链表未结束
			i++;
			p=p.next;             //p的后继结点
		}
		
		return i;
	}
	
	public String toString(){
		String str="(";
		Node<T> p=this.head.next;
		while(p!=null){
			str+=p.data.toString();
			if(p.next!=null)
				str+=",";  //不是最后一个结点时加分隔符
			p=p.next;
		}
		return str+")";
	}

	public T get(int i) {  //返回第i个元素，若i指定序号无效，则返回null
	  if(i>=0)
	  {
		  Node<T> p=this.head.next;
		   for(int j=0;p!=null&&j<i;j++)
			   p=p.next;
		    if(p!=null)
		    	return p.data;
	  }
		
		return null;
	}

	//设置第i个元素值为x，若i指定序号无效则抛出序号越界异常
	public void set(int i, T x) {
		if(x==null)
			return;            //不能设置空对象
		if(i>=0)
		{
			Node<T> p=this.head.next;
			 for(int j=0;p!=null&&j<i;j++)
				 p=p.next;
			 if(p!=null)
				 p.data=x;        //p指向第i个节点
		}
		else throw new IndexOutOfBoundsException(i+"");
		
	}

	private Node<T> copy(Node<T> p){
		Node<T> q=null; //新结点
		if(p!=null)  //要复制的结点非空
		{
			q=new Node<T>(p.data,null); //相当于q.data=p.data，q.next=null
			q.next=copy(p.next);//递归，q1.data=p.next.data，q1.next=null，先返回q1，q.next=q1
			//可以看成一棵二叉树
		}
		return q;
	}
	
	public void insert(int i, T x) {//将x对象插入在序号为i的结点前

		if(x==null)
			return;
		Node<T> p=this.head;  //p指向头结点
		for(int j=0;p.next!=null&&j<i;j++) //寻找插入位置
			p=p.next;  //循环停止时，p指向第i-1结点或最后一个结点
		p.next=new Node<T>(x,p.next);
		
	}

	//单链表最后添加对象
	public void append(T x) {
		insert(Integer.MAX_VALUE,x);
		
	}

	
	public T remove(int i) {
		if(i>=0)
		{
			Node<T> p=this.head;
			 for(int j=0;p.next!=null&&j<i;j++)//找到待删除的结点i的前驱结点i-1
				 p=p.next;
			 if(p.next!=null)
			 {
				 T old=p.next.data;     //获取原对象
				  p.next=p.next.next;    //删除p的后继结点
				   return old;
			 }
		}
		return null;
	}

	public void removeAll() {
	this.head.next=null;
		
	}

	public int indexOf(T key) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean contain(T key) {
		
		return this.search(key)!=null;
	}

	public T search(T key) {
	 if(key==null)
		 return null;
	 Node<T> p=this.head.next;
	 while(p!=null)
	 {
		 if(p.data.equals(key))
			 return p.data;
		 p=p.next;
	 }
		return null;
	}

}
