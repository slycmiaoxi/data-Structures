package com.zwl.List;

public class Josephus {

	public Josephus(int number,int start,int distance){
		//LList<String> list=new seqList<String>(number);
		LList<String> list=new SinglyLinkenList<String>();
		for(int i=0;i<number;i++)
			list.append((char)('A'+i)+"");
		System.out.println("初始化约瑟夫环:"+'('+number+','+start+','+distance+')');
		int i=start;
		while(list.length()>1){
			i=(i+distance-1)%list.length();
			System.out.print("删除"+list.remove(i).toString()+"");
			System.out.println(list.toString());
		}
		System.out.println("最后的被赦免者是:"+list.get(0).toString());	
	}
	
	public static void main(String args[]){
		new Josephus(5,0,2);
	}
}
