package com.zwl.List;

public class BSArray {

	//���������е������У����ҵ��ؼ��֣��򷵻���Ӧ�±꣬���򷵻�-1
	public static<T> int binarySearch(Comparable<T>[] value,T key){
		return binarySearch(value,0,value.length-1,key);
	}
	
	public static<T> int binarySearch(Comparable<T>[] value,int begin,int end,T key){
		if(key!=null)
			while(begin<=end){    //�߽���Ч
				int mid=(begin+end)/2;  //�м�λ�ã���ǰ�Ƚ�Ԫ��λ��
		System.out.println(value[mid]+"?");
		if(value[mid].compareTo(key)==0) //����Ƚϴ�С
			return mid;                  //���ҳɹ�
		if(value[mid].compareTo(key)>0)  
			end=mid-1;                    //��С��ǰ���
		else
			begin=mid+1;                 //��С������
	} 
	return -1;                           //���Ҳ��ɹ�
	}
}
