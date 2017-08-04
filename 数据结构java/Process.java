package com.zwl.List;

public class Process implements Comparable<Process>{

	private String name;   //进程名
	private int priority;  //优先级


	public Process(String name, int priority) {
		super();
		this.name = name;
		this.priority = priority;
	}
	
	
	public int compareTo(Process o) {//比较两个进程的大小，约定进程排队次序的规则

		return this.priority-o.priority;
	}

}
