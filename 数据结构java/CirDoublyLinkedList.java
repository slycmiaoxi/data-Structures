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

	public void insert(int i, T x) {//��x������������Ϊi�Ľ��
	if(x==null)
		return;
	DLinkNode<T> p=this.head;
	for(int j=0;p.next!=this.head&&j<i;j++) //Ѱ�Ҳ���λ��
		p=p.next;                           //ѭ��ֹͣʱ��pָ���i-1�����
	 DLinkNode<T> q=new DLinkNode<T>(x,p,p.next);//������p���֮��
	 p.next.prev=q;
	 p.next=q;
		
	}

	public void append(T x) {
	 if(x==null)
		 return;
	 DLinkNode<T> q=new DLinkNode<T>(x,head.prev,head);
	 head.prev.next=q; //������ͷ���֮ǰ���൱��β����
	 head.prev=q;
		
	}

	public T remove(int i) {
	if(i>0)
	{
		DLinkNode<T> p=this.head.next;
		for(int j=0;p!=head&&j<i;j++)  //��λ����ɾ�����
			p=p.next;
		if(p!=head)
		{ 
			T old=p.data;     //���ԭ����
			p.prev.next=p.next;  //ɾ��p����Լ�
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
