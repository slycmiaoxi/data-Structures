package com.zwl.List;

public class Process implements Comparable<Process>{

	private String name;   //������
	private int priority;  //���ȼ�


	public Process(String name, int priority) {
		super();
		this.name = name;
		this.priority = priority;
	}
	
	
	public int compareTo(Process o) {//�Ƚ��������̵Ĵ�С��Լ�������ŶӴ���Ĺ���

		return this.priority-o.priority;
	}

}
