package com.zwl.List;

public class SeqQueue<T> implements QQueue<T>{

	private Object element[];  //存储队列数据元素的数组
	private int front,rear;    //分别为对头和队尾元素
	
	public SeqQueue(int length){        //构造容量为length的空队列
		if(length<64)
			length=64;
		this.element=new Object[Math.abs(length)];
		this.front=this.rear=0;
	}
	
	public SeqQueue(){       //构造默认容量空队列
		this(64);
	}
	
	public boolean isEmpty() {     //判断队列是否为空
		return this.front==this.rear;
	}

	public void enqueue(T x) {   //元素x入队，空对象不能入队
	if(x==null)
		return;
	if(this.front==(this.rear+1)%this.element.length) //当队满时，扩充容量
	{
		Object[] temp=this.element;
		this.element=new Object[temp.length*2];
		int i=this.front,j=0;
		while(i!=this.rear){        //按照队列元素次序复制数组元素
			this.element[j]=temp[i];
			i=(i+1)%temp.length;
			j++;
		}
		this.front=0;
		this.rear=j;
	}
		this.element[this.rear]=x;
		this.rear=(this.rear+1)%this.element.length;
	}

	public T dequeue() {         //出队，返回队头元素，若队列空则返回null
   if(isEmpty())
		return null;
    T temp=(T)this.element[this.front];
      this.front=(this.front+1)%this.element.length;  //取得队头元素
     return temp;
	}

}
