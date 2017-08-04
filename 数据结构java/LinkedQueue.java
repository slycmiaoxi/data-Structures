package com.zwl.List;

public class LinkedQueue<T> implements QQueue<T>{

	private Node<T> front,rear;        //�ֱ�ָ���ͷ�Ͷ�β
	
	public LinkedQueue(){             //����ն���
		this.front=this.rear=null;
	}
	
	public boolean isEmpty() {        //�ж϶����Ƿ�Ϊ��
		return this.front==null&&this.rear==null;
	}

	public void enqueue(T x) {       //Ԫ��x��ӣ��ն������
		if(x==null)  
			return;
		Node<T> q=new Node<T>(x,null);  
		 if(this.front==null)
			 this.front=q;   //�ն����
		 else
			 this.rear.next=q; //�����ڶ�β֮��
		 this.rear=q;		
	}

	public T dequeue() {  //���ӣ����ض�ͷԪ�أ�������Ԫ��Ϊ�գ�����null
		if(isEmpty())
			return null;
		T temp=this.front.data;    //ȡ�ö�ͷԪ��
		this.front=this.front.next;    //ɾ����ͷ���
		if(this.front==null)
			this.rear=null;
		return temp;
	}

}
