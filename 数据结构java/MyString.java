package com.zwl.List;

import java.io.Serializable;

public final class MyString implements Comparable<MyString>,Serializable{

	private final char[] value;         //字符数组，只能赋值一次
	
	public MyString(){  //构造一个空串
		this.value=new char[0];
	}
	
	public MyString(String original){ //将字符串常量变成字符数组
		this.value=original.toCharArray();
	}
	
	//以value数组中构造从begin开始的count个字符的字符串对象
	public MyString(char[] value,int begin,int count){
		this.value=new char[count];
		 for(int i=begin;i<begin+count;i++)
			 this.value[i]=value[i];
	}
	
	//以value数组中字符构造字符串
	public MyString(char[] value){
		this(value,0,value.length);
	}
	
	public MyString(MyString str){//复制对象
		this(str.value);
	}
	
	public int length(){  //返回字符串长度
		return this.value.length;
	}
	
	public char charAt(int i){ //返回第i个字符
		if(i<0||i>=this.value.length)
			 throw new StringIndexOutOfBoundsException(i);
		return this.value[i];
	}
	
	public String toString(){
		return new String(this.value);
	}
	
	public MyString concat(MyString str){ //返回当前串与指定串str连接生成的新串
		if(str==null||str.length()==0)     //要连接的串为空时，返回当前串
			return this;
		  char[] buffer=new char[this.value.length+str.length()];
		   int i;
		    for(i=0;i<this.value.length;i++)  //复制当前串
		    buffer[i]=this.value[i];
		     for(int j=0;j<str.value.length;j++)  //复制指定串
		    	 buffer[i+j]=str.value[j];
		       return new MyString(buffer); //以字符数组构造串
	}
	
	public MyString substring(int begin,int end){//返回传中从begin到end-1的子串
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
	
	public MyString substring (int begin){//返回串中序号从begin到末尾的子串
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
	
//返回两个字符串之间的差值，返回0表示相等
	public int compareTo(MyString o) {
		for(int i=0;i<this.value.length&&i<o.value.length;i++)
			if(this.value[i]!=o.value[i])
				 return this.value[i]-o.value[i]; //返回两串第一个不同字符的差值
		return this.value.length-o.value.length;
	}

}
