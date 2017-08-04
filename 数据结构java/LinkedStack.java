package com.zwl.List;

public class LinkedStack<T> implements SStack<T>{

	private Node<T> top;         //栈顶结点
	
	public LinkedStack(){        //构造空栈
		this.top=null;
	}
	
	public boolean isEmpty() {     //判断栈是否为空
		return this.top==null;
	}

	public void push(T x) {
		if(x!=null)
			this.top=new Node(x, this.top);  //头插入，x结点作为新的栈顶结点
		
	}

	public T pop() {         //出栈，返回栈顶元素
		if(this.top==null)
			return null;
		T temp=this.top.data;
		this.top=this.top.next;
		return temp;
	}

	public T get() {
		return this.top==null?null:this.top.data;
	}

}
