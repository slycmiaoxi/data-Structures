package com.zwl.List;

public class SeqStack<T> implements SStack<T>{

	private Object element[];    //��ȡջ����Ԫ�ص�����
	private int top;             //ջ��Ԫ���±�
	
	public SeqStack(int size){    //��������Ϊsize�Ŀ�ջ
		this.element=new Object[Math.abs(size)];
		this.top=-1;
	}
	
	public SeqStack(){         //����Ĭ�������Ŀ�ջ
		this(64);
	}
	
	public boolean isEmpty() { //�ж�ջ�Ƿ�Ϊ��
		
		return this.top==-1;
	}

	public void push(T x) {    //Ԫ��x��ջ���ն�������ջ
		if(x==null)
			return;
		if(this.top==element.length-1)   //ջ��������ջ����
		{
			Object[] temp=this.element;
			this.element=new Object[temp.length*2];
			for(int i=0;i<temp.length;i++)
				this.element[i]=temp[i];
		}
		this.top++;
		this.element[this.top]=x;
	}

	public T pop() {  //��ջ
		
		return this.top==-1?null:(T)this.element[this.top--];
	}

	public T get() {		//ȡջ��Ԫ��
		return this.top==-1?null:(T)this.element[this.top];
	}

}
