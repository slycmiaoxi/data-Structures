package com.zwl.List;

public interface SStack<T> {

	boolean isEmpty();  //判断是否为空栈
	void push(T x);     //元素x入栈
	T pop();            //出栈，返回当前栈顶元素
	T get();            //取栈顶元素，未出栈
}
