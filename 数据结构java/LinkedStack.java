package com.zwl.List;

public class LinkedStack<T> implements SStack<T>{

	private Node<T> top;         //ջ�����
	
	public LinkedStack(){        //�����ջ
		this.top=null;
	}
	
	public boolean isEmpty() {     //�ж�ջ�Ƿ�Ϊ��
		return this.top==null;
	}

	public void push(T x) {
		if(x!=null)
			this.top=new Node(x, this.top);  //ͷ���룬x�����Ϊ�µ�ջ�����
		
	}

	public T pop() {         //��ջ������ջ��Ԫ��
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
