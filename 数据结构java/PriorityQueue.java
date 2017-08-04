package com.zwl.List;

public class PriorityQueue<T extends Comparable<T>> implements QQueue{

	private SortedSinglyLinkedList<T> list; //使用排序单链表存储队列元素
	
	public PriorityQueue(){   //构造空队列
		this.list=new SortedSinglyLinkedList<T>();
	}
	
	public boolean isEmpty() { //判断队列是否为空
		return list.isEmpty();
	}

	public void enqueue(Object x) { //元素x入队，根据元素大小插入在单链表适当位置
		list.insert(x);
		
	}

	public Object dequeue() {//出队，返回对头元素

		return list.remove(0);
	}

	public String toString(){
		return list.toString();
	}
}
