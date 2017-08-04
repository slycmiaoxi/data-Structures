package com.zwl.List;

public class PriorityQueue<T extends Comparable<T>> implements QQueue{

	private SortedSinglyLinkedList<T> list; //ʹ����������洢����Ԫ��
	
	public PriorityQueue(){   //����ն���
		this.list=new SortedSinglyLinkedList<T>();
	}
	
	public boolean isEmpty() { //�ж϶����Ƿ�Ϊ��
		return list.isEmpty();
	}

	public void enqueue(Object x) { //Ԫ��x��ӣ�����Ԫ�ش�С�����ڵ������ʵ�λ��
		list.insert(x);
		
	}

	public Object dequeue() {//���ӣ����ض�ͷԪ��

		return list.remove(0);
	}

	public String toString(){
		return list.toString();
	}
}
