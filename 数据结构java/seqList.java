package com.zwl.List;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class seqList<T> implements LList<T>{

	private Object[] element; //存放线性表元素的一维数组
	private int len;       //顺序表长度，记载元素个数
	
	public seqList(int size){            //创建容量为size的空表
		//若size<0，java将抛出负数组长度异常
		this.element=new Object[size];
		this.len=0;
	}
	
	public seqList(){     //创建默认容量的空表，这里是64
		this(64);
	}
	
	public boolean isEmpty() {
		
		return this.len==0;
	}

	public int length() {
	
		return this.len;
	}

	public T get(int i) { //返回第i个元素（i>=0),若i指定元素无效，则返回null
	if(i>=0&&i<this.len)
		return (T)this.element[i];
    return null;
	}

	//设置第i(i>=0)个元素的值为x，若i指定序号无效则抛出序号越界异常
	public void set(int i, T x) {
		if(x==null)
			return;
		if(i>=0&&i<this.len)
			this.element[i]=x;
		else
			throw new IndexOutOfBoundsException(i+"");
		
	}
/**
 * 在顺序表元素ai位置插入元素x，首选必须将i到n个元素后移，空出一个位置，然后插入元素x
 */
	public void insert(int i, T x) {
		if(x==null){
			System.out.println("null");
			return ;           //不能添加null
		}
		if(this.len==element.length)	 //若数组满，则扩充顺序表容量
		{ 
			Object[] temp=this.element;
			this.element=new Object[temp.length*2]; //容量扩充2倍
			for(int j=0;j<temp.length;j++){ 
				this.element[i]=temp[i];  //复制数组元素
			}
		}
			if(i<0)                      //下标容错
				i=0;
			if(i>this.len)
				i=this.len;
			for(int j=this.len-1;j>=i;j--)       //元素后移，平均移动len/2
				this.element[j+1]=this.element[j];
			this.element[i]=x;
			this.len++;
		}
		


	public void append(T x) {
		insert(this.len,x);	   //在顺序表最后插入x对象
	}
	
	/**
	 * 删除元素ai，必须将元素i+1到n向前移动
	 */
	public T remove(int i) { //删除成功返回被删除对象，否则返回null
		if(this.len==0||i<0||i>this.len)
			return null;
		T old=(T)this.element[i];
		 for(int j=i;j<this.len-1;j++)     //元素前移，平均移动len/2
			 this.element[j]=this.element[j+1];
		 this.element[this.len-1]=null;
		 this.len--;
		return old;
	}

	public void removeAll() {
		
		this.len=0;
	}

//顺序查找关键字为key的元素，返回首次出现的位置，若查找不成功返回-1
	public int indexOf(T key) {
		if(key!=null)
			for(int i=0;i<this.len;i++)
				if(this.element[i].equals(key))
					return i;
		return -1;
	}

	//判断线性表是否包含关键字为key元素
	public boolean contain(T key) {
		
		return this.indexOf(key)>=0;
	}

	//查找，返回首次出现的关键字为key的元素
	public T search(T key) {
	 int find=this.indexOf(key);
		return find==-1?null:(T)this.element[find];
	}
	
	public String toString(){
		String str="(";
		if(this.len>0)
			str+=this.element[0].toString();
		for(int i=1;i<this.len;i++)
			str+=","+this.element[i].toString();
		return str+")";
	}
	
	public boolean equals(Object obj){
		if(this==obj)
			return true;
		if(obj instanceof seqList){
			seqList<T> list=(seqList<T>)obj;
			if(this.length()==list.length()){
				for(int i=0;i<this.length();i++)
					if(!(this.get(i).equals(list.get(i))))
						return false;
				return true;
			}
				
		}
			return true;
	
	}

}
