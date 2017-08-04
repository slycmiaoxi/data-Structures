package com.zwl.List;

import java.io.Serializable;

public final class MyString implements Comparable<MyString>,Serializable{

	private final char[] value;         //�ַ����飬ֻ�ܸ�ֵһ��
	
	public MyString(){  //����һ���մ�
		this.value=new char[0];
	}
	
	public MyString(String original){ //���ַ�����������ַ�����
		this.value=original.toCharArray();
	}
	
	//��value�����й����begin��ʼ��count���ַ����ַ�������
	public MyString(char[] value,int begin,int count){
		this.value=new char[count];
		 for(int i=begin;i<begin+count;i++)
			 this.value[i]=value[i];
	}
	
	//��value�������ַ������ַ���
	public MyString(char[] value){
		this(value,0,value.length);
	}
	
	public MyString(MyString str){//���ƶ���
		this(str.value);
	}
	
	public int length(){  //�����ַ�������
		return this.value.length;
	}
	
	public char charAt(int i){ //���ص�i���ַ�
		if(i<0||i>=this.value.length)
			 throw new StringIndexOutOfBoundsException(i);
		return this.value[i];
	}
	
	public String toString(){
		return new String(this.value);
	}
	
	public MyString concat(MyString str){ //���ص�ǰ����ָ����str�������ɵ��´�
		if(str==null||str.length()==0)     //Ҫ���ӵĴ�Ϊ��ʱ�����ص�ǰ��
			return this;
		  char[] buffer=new char[this.value.length+str.length()];
		   int i;
		    for(i=0;i<this.value.length;i++)  //���Ƶ�ǰ��
		    buffer[i]=this.value[i];
		     for(int j=0;j<str.value.length;j++)  //����ָ����
		    	 buffer[i+j]=str.value[j];
		       return new MyString(buffer); //���ַ����鹹�촮
	}
	
	public MyString substring(int begin,int end){//���ش��д�begin��end-1���Ӵ�
		if(begin<0)
			begin=0;
		if(end>this.value.length)
			end=this.value.length;
		if(begin>end)
			throw new StringIndexOutOfBoundsException(end-begin);
		if(begin==0&&end==this.value.length)
			return this;
		char[] buffer=new char[end-begin];
		 for(int i=0;i<buffer.length;i++)
			 buffer[i]=this.value[i+begin];
		   return new MyString(buffer);
	}
	
	public MyString substring (int begin){//���ش�����Ŵ�begin��ĩβ���Ӵ�
		return substring(begin,this.value.length);
	}
	
	public boolean equals(Object obj){
		if(this==obj)
			return true;
		if(obj instanceof MyString)
			{MyString str=(MyString)obj;
		if(this.value.length==str.value.length){
			for(int i=0;i<this.value.length;i++)
				if(this.value[i]!=str.value[i])
					return false;
		      return true;}
	}
	return false;
	}
	
//���������ַ���֮��Ĳ�ֵ������0��ʾ���
	public int compareTo(MyString o) {
		for(int i=0;i<this.value.length&&i<o.value.length;i++)
			if(this.value[i]!=o.value[i])
				 return this.value[i]-o.value[i]; //����������һ����ͬ�ַ��Ĳ�ֵ
		return this.value.length-o.value.length;
	}

}
