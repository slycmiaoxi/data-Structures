package com.zwl.List;

public interface QQueue<T> {

	boolean isEmpty();          //�ж϶����Ƿ�Ϊ��
	void enqueue(T x);          //Ԫ��x���
	T dequeue();                //���ӣ����ض�ͷԪ��
	
}
