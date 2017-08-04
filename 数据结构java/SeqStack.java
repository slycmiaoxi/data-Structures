package com.zwl.List;

public class SeqStack<T> implements SStack<T>{

	private Object element[];    //存取栈数据元素的数组
	private int top;             //栈顶元素下标
	
	public SeqStack(int size){    //构造容量为size的空栈
		this.element=new Object[Math.abs(size)];
		this.top=-1;
	}
	
	public SeqStack(){         //构造默认容量的空栈
		this(64);
	}
	
	public boolean isEmpty() { //判断栈是否为空
		
		return this.top==-1;
	}

	public void push(T x) {    //元素x入栈，空对象不能入栈
		if(x==null)
			return;
		if(this.top==element.length-1)   //栈满，扩充栈容量
		{
			Object[] temp=this.element;
			this.element=new Object[temp.length*2];
			for(int i=0;i<temp.length;i++)
				this.element[i]=temp[i];
		}
		this.top++;
		this.element[this.top]=x;
	}

	public T pop() {  //出栈
		
		return this.top==-1?null:(T)this.element[this.top--];
	}

	public T get() {		//取栈顶元素
		return this.top==-1?null:(T)this.element[this.top];
	}

}
