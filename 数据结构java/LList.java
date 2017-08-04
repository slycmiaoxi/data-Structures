package com.zwl.List;

public interface LList<T> {

	boolean isEmpty();       //判断线性表是否为空
	int length();            //返回线性表长度
	T get(int i);            //返回第i(i>=0)个元素
	void set(int i,T x);     //设置第i个元素值为x
	void insert(int i,T x);  //插入x作为第i个元素
	void append(T x);        //在线性表最后插入第i个元素
	T remove(int i);         //删除第i个元素并返回被删除对象
	void removeAll();        //删除线性表所有元素
	int indexOf(T key);      //顺序查找关键字为key的元素，返回首次出现的位置
	boolean contain(T key);  //是否包含关键字
	T search(T key);         //顺序查找关键字为key的元素，返回首次出现的元素
}
