package com.zwl.List;

public interface SStack<T> {

	boolean isEmpty();  //�ж��Ƿ�Ϊ��ջ
	void push(T x);     //Ԫ��x��ջ
	T pop();            //��ջ�����ص�ǰջ��Ԫ��
	T get();            //ȡջ��Ԫ�أ�δ��ջ
}
