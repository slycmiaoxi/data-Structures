package com.zwl.List;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class seqList<T> implements LList<T>{

	private Object[] element; //������Ա�Ԫ�ص�һά����
	private int len;       //˳����ȣ�����Ԫ�ظ���
	
	public seqList(int size){            //��������Ϊsize�Ŀձ�
		//��size<0��java���׳������鳤���쳣
		this.element=new Object[size];
		this.len=0;
	}
	
	public seqList(){     //����Ĭ�������Ŀձ�������64
		this(64);
	}
	
	public boolean isEmpty() {
		
		return this.len==0;
	}

	public int length() {
	
		return this.len;
	}

	public T get(int i) { //���ص�i��Ԫ�أ�i>=0),��iָ��Ԫ����Ч���򷵻�null
	if(i>=0&&i<this.len)
		return (T)this.element[i];
    return null;
	}

	//���õ�i(i>=0)��Ԫ�ص�ֵΪx����iָ�������Ч���׳����Խ���쳣
	public void set(int i, T x) {
		if(x==null)
			return;
		if(i>=0&&i<this.len)
			this.element[i]=x;
		else
			throw new IndexOutOfBoundsException(i+"");
		
	}
/**
 * ��˳���Ԫ��aiλ�ò���Ԫ��x����ѡ���뽫i��n��Ԫ�غ��ƣ��ճ�һ��λ�ã�Ȼ�����Ԫ��x
 */
	public void insert(int i, T x) {
		if(x==null){
			System.out.println("null");
			return ;           //�������null
		}
		if(this.len==element.length)	 //����������������˳�������
		{ 
			Object[] temp=this.element;
			this.element=new Object[temp.length*2]; //��������2��
			for(int j=0;j<temp.length;j++){ 
				this.element[i]=temp[i];  //��������Ԫ��
			}
		}
			if(i<0)                      //�±��ݴ�
				i=0;
			if(i>this.len)
				i=this.len;
			for(int j=this.len-1;j>=i;j--)       //Ԫ�غ��ƣ�ƽ���ƶ�len/2
				this.element[j+1]=this.element[j];
			this.element[i]=x;
			this.len++;
		}
		


	public void append(T x) {
		insert(this.len,x);	   //��˳���������x����
	}
	
	/**
	 * ɾ��Ԫ��ai�����뽫Ԫ��i+1��n��ǰ�ƶ�
	 */
	public T remove(int i) { //ɾ���ɹ����ر�ɾ�����󣬷��򷵻�null
		if(this.len==0||i<0||i>this.len)
			return null;
		T old=(T)this.element[i];
		 for(int j=i;j<this.len-1;j++)     //Ԫ��ǰ�ƣ�ƽ���ƶ�len/2
			 this.element[j]=this.element[j+1];
		 this.element[this.len-1]=null;
		 this.len--;
		return old;
	}

	public void removeAll() {
		
		this.len=0;
	}

//˳����ҹؼ���Ϊkey��Ԫ�أ������״γ��ֵ�λ�ã������Ҳ��ɹ�����-1
	public int indexOf(T key) {
		if(key!=null)
			for(int i=0;i<this.len;i++)
				if(this.element[i].equals(key))
					return i;
		return -1;
	}

	//�ж����Ա��Ƿ�����ؼ���ΪkeyԪ��
	public boolean contain(T key) {
		
		return this.indexOf(key)>=0;
	}

	//���ң������״γ��ֵĹؼ���Ϊkey��Ԫ��
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
