package com.zwl.List;

import java.util.Set;

public class HashSet<T> {

	private SinglyLinkenList<T>[] table;    //ɢ�б�ͬ��ʵ������������
	public HashSet(int size){               //����ָ��������ɢ�б�
		this.table=new SinglyLinkenList[Math.abs(size)];
		for(int i=0;i<table.length;i++)
			table[i]=new SinglyLinkenList<T>();
	}
	
	public HashSet(){ //�����������Ϊ97������
		this(97);
	}
	
	private int hash(T x){  //ɢ�к�����ȷ���ؼ���ΪkeyԪ�ص�ɢ�е�ַ
		int key=Math.abs(x.hashCode()); //ÿ�������hashcode������������ɢ���룬����ÿ������ͬ
		return key%table.length; //������������������ɢ�б���
	}
	
	public void insert(T x){//����xԪ��
		table[hash(x)].insert(0, x);
	}
	
	public void remove(T x){ //ɾ��xԪ��
		table[hash(x)].remove((Integer) x);
	}
	
	public T search(T key){ //���ز��ҵ��Ĺؼ���ΪkeyԪ�أ����Ҳ��ɹ�����null
		return table[hash(key)].search(key);
	}
	
	public boolean contain(T key){ //�ж�ɢ�б��Ƿ�����ؼ���ΪkeyԪ��
		return this.search(key)!=null;
	}
	
	public String toString(){
		String str="";
		for(int i=0;i<table.length;i++)  //������ͬ��ʵ�����
			if(!table[i].isEmpty())
				str+=table[i].toString()+"\n";
		return str;
	}
}
