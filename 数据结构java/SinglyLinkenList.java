package com.zwl.List;

public class SinglyLinkenList<T> implements LList<T> {

	public Node<T> head;  //ͷָ��
	
	public SinglyLinkenList(){ //���������
		this.head=new Node<T>();
	}
	
	public SinglyLinkenList(T[] element){//β���빹�쵥����
		this();
		Node<T> rear=this.head; //ָ���������һ�����
		for(int i=0;i<element.length;i++){
			rear.next=new Node<T>(element[i],null); //β����
			rear=rear.next;     //ָ���µ���β���
		}
		
	}
	
	public boolean isEmpty() {
		
		return this.head.next==null;
	}

	public int length() {
		
		int i=0;
		Node<T> p=this.head.next;  //p�ӵ������һ����㿪ʼ
		while(p!=null){            //��������δ����
			i++;
			p=p.next;             //p�ĺ�̽��
		}
		
		return i;
	}
	
	public String toString(){
		String str="(";
		Node<T> p=this.head.next;
		while(p!=null){
			str+=p.data.toString();
			if(p.next!=null)
				str+=",";  //�������һ�����ʱ�ӷָ���
			p=p.next;
		}
		return str+")";
	}

	public T get(int i) {  //���ص�i��Ԫ�أ���iָ�������Ч���򷵻�null
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

	//���õ�i��Ԫ��ֵΪx����iָ�������Ч���׳����Խ���쳣
	public void set(int i, T x) {
		if(x==null)
			return;            //�������ÿն���
		if(i>=0)
		{
			Node<T> p=this.head.next;
			 for(int j=0;p!=null&&j<i;j++)
				 p=p.next;
			 if(p!=null)
				 p.data=x;        //pָ���i���ڵ�
		}
		else throw new IndexOutOfBoundsException(i+"");
		
	}

	private Node<T> copy(Node<T> p){
		Node<T> q=null; //�½��
		if(p!=null)  //Ҫ���ƵĽ��ǿ�
		{
			q=new Node<T>(p.data,null); //�൱��q.data=p.data��q.next=null
			q.next=copy(p.next);//�ݹ飬q1.data=p.next.data��q1.next=null���ȷ���q1��q.next=q1
			//���Կ���һ�ö�����
		}
		return q;
	}
	
	public void insert(int i, T x) {//��x������������Ϊi�Ľ��ǰ

		if(x==null)
			return;
		Node<T> p=this.head;  //pָ��ͷ���
		for(int j=0;p.next!=null&&j<i;j++) //Ѱ�Ҳ���λ��
			p=p.next;  //ѭ��ֹͣʱ��pָ���i-1�������һ�����
		p.next=new Node<T>(x,p.next);
		
	}

	//�����������Ӷ���
	public void append(T x) {
		insert(Integer.MAX_VALUE,x);
		
	}

	
	public T remove(int i) {
		if(i>=0)
		{
			Node<T> p=this.head;
			 for(int j=0;p.next!=null&&j<i;j++)//�ҵ���ɾ���Ľ��i��ǰ�����i-1
				 p=p.next;
			 if(p.next!=null)
			 {
				 T old=p.next.data;     //��ȡԭ����
				  p.next=p.next.next;    //ɾ��p�ĺ�̽��
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
