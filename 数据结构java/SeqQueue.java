package com.zwl.List;

public class SeqQueue<T> implements QQueue<T>{

	private Object element[];  //�洢��������Ԫ�ص�����
	private int front,rear;    //�ֱ�Ϊ��ͷ�Ͷ�βԪ��
	
	public SeqQueue(int length){        //��������Ϊlength�Ŀն���
		if(length<64)
			length=64;
		this.element=new Object[Math.abs(length)];
		this.front=this.rear=0;
	}
	
	public SeqQueue(){       //����Ĭ�������ն���
		this(64);
	}
	
	public boolean isEmpty() {     //�ж϶����Ƿ�Ϊ��
		return this.front==this.rear;
	}

	public void enqueue(T x) {   //Ԫ��x��ӣ��ն��������
	if(x==null)
		return;
	if(this.front==(this.rear+1)%this.element.length) //������ʱ����������
	{
		Object[] temp=this.element;
		this.element=new Object[temp.length*2];
		int i=this.front,j=0;
		while(i!=this.rear){        //���ն���Ԫ�ش���������Ԫ��
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

	public T dequeue() {         //���ӣ����ض�ͷԪ�أ������п��򷵻�null
   if(isEmpty())
		return null;
    T temp=(T)this.element[this.front];
      this.front=(this.front+1)%this.element.length;  //ȡ�ö�ͷԪ��
     return temp;
	}

}
