package com.zwl.List;

public class LinkedQueue<T> implements QQueue<T>{

	private Node<T> front,rear;        //分别指向队头和队尾
	
	public LinkedQueue(){             //构造空队列
		this.front=this.rear=null;
	}
	
	public boolean isEmpty() {        //判断队列是否为空
		return this.front==null&&this.rear==null;
	}

	public void enqueue(T x) {       //元素x入队，空对象入队
		if(x==null)  
			return;
		Node<T> q=new Node<T>(x,null);  
		 if(this.front==null)
			 this.front=q;   //空队入队
		 else
			 this.rear.next=q; //插入在队尾之后
		 this.rear=q;		
	}

	public T dequeue() {  //出队，返回对头元素，若队列元素为空，返回null
		if(isEmpty())
			return null;
		T temp=this.front.data;    //取得队头元素
		this.front=this.front.next;    //删除队头结点
		if(this.front==null)
			this.rear=null;
		return temp;
	}

}
