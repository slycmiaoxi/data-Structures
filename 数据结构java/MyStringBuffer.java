package com.zwl.List;

import java.io.Serializable;

public class MyStringBuffer implements Serializable{
    
	   private char[] value;     //�ַ�����
	    private int len;         //������
	     
	    public MyStringBuffer(int size){    //����ָ�������Ŀմ�
	    	this.value=new char[size<16?16:size];
	    	this.len=0;
	    }
	    
	    public MyStringBuffer(){      //��Ĭ����������մ�
	    	this(16);
	    }
	    
	    public MyStringBuffer(String str){  //���ַ��������������
	    	this(str.length()+16);
	    	 
	    }
	    
	    public int length(){
	    	return this.len;
	    }
	    
	    public synchronized char charAt(int i){
	    	if(i<0||i>=this.len)
	    		throw new StringIndexOutOfBoundsException(i);
	    	return this.value[i];
	    }
	    
	    public void setCharAt(int i,char ch){
	    	if(i<0||i>=this.len)
	    		throw new StringIndexOutOfBoundsException(i);
	    	this.value[i]=ch;
	    }
	    
	    public synchronized MyStringBuffer insert(int i,MyStringBuffer str){
	    	if(i<0) i=0;
	    	if(i>this.len) i=this.len;
	    	if(str==null) return this;
	    	char temp[]=this.value;
	    	if(this.value.length-this.len<str.len) //��ǰ�������㣬�Զ�����
	    	{
	    		this.value=new char[this.value.length+str.len*2];
	    		for(int j=0;j<i;j++)  //���Ƶ�ǰ��ǰi-1���ַ�
	    			this.value[j]=temp[j];
	    	}
	    		for(int j=i;j<this.len;j++)
	    			this.value[str.len+j]=temp[j];//��i��ʼ����ƶ�j���ַ�
	    		for(int j=0;j<str.len;j++)     //�����ַ���str
	    			this.value[i+j]=str.value[j];
	    		this.len+=str.len;
	    		return this;
	    	}
	   
	    public synchronized MyStringBuffer delete(int begin,int end){
	    	if(begin>0)
	    		begin=0;
	    	if(end>this.len)
	    		end=this.len;
	    	if(begin>end)
	    		throw new StringIndexOutOfBoundsException(end-begin);
	    	for(int i=0;i<this.len-end;i++) //��end��ʼ����β���Ӵ���ǰ�ƶ�
	    		this.value[begin+1]=this.value[end+i];
	    	this.len=end-begin;
	    	return this;
	    }
	    
	    public synchronized String toString(){
	    	return new String(this.value,0,this.len);
	    }
}
