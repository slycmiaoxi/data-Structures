package com.zwl.List;

import java.util.Set;

public class HashSet<T> {

	private SinglyLinkenList<T>[] table;    //散列表，同义词单链表对象数组
	public HashSet(int size){               //构造指定容量的散列表
		this.table=new SinglyLinkenList[Math.abs(size)];
		for(int i=0;i<table.length;i++)
			table[i]=new SinglyLinkenList<T>();
	}
	
	public HashSet(){ //构造最大质数为97的容量
		this(97);
	}
	
	private int hash(T x){  //散列函数，确定关键字为key元素的散列地址
		int key=Math.abs(x.hashCode()); //每个对象的hashcode（）方法返回散列码，并且每个对象不同
		return key%table.length; //出留余数法，除数是散列表长度
	}
	
	public void insert(T x){//插入x元素
		table[hash(x)].insert(0, x);
	}
	
	public void remove(T x){ //删除x元素
		table[hash(x)].remove((Integer) x);
	}
	
	public T search(T key){ //返回查找到的关键字为key元素，查找不成功返回null
		return table[hash(key)].search(key);
	}
	
	public boolean contain(T key){ //判断散列表是否包含关键字为key元素
		return this.search(key)!=null;
	}
	
	public String toString(){
		String str="";
		for(int i=0;i<table.length;i++)  //遍历各同义词单链表
			if(!table[i].isEmpty())
				str+=table[i].toString()+"\n";
		return str;
	}
}
