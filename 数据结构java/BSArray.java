package com.zwl.List;

public class BSArray {

	//在升序排列的数组中，若找到关键字，则返回相应下标，否则返回-1
	public static<T> int binarySearch(Comparable<T>[] value,T key){
		return binarySearch(value,0,value.length-1,key);
	}
	
	public static<T> int binarySearch(Comparable<T>[] value,int begin,int end,T key){
		if(key!=null)
			while(begin<=end){    //边界有效
				int mid=(begin+end)/2;  //中间位置，当前比较元素位置
		System.out.println(value[mid]+"?");
		if(value[mid].compareTo(key)==0) //对象比较大小
			return mid;                  //查找成功
		if(value[mid].compareTo(key)>0)  
			end=mid-1;                    //缩小到前半段
		else
			begin=mid+1;                 //缩小到后半段
	} 
	return -1;                           //查找不成功
	}
}
