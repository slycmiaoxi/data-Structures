package com.zwl.List;

public interface LList<T> {

	boolean isEmpty();       //�ж����Ա��Ƿ�Ϊ��
	int length();            //�������Ա���
	T get(int i);            //���ص�i(i>=0)��Ԫ��
	void set(int i,T x);     //���õ�i��Ԫ��ֵΪx
	void insert(int i,T x);  //����x��Ϊ��i��Ԫ��
	void append(T x);        //�����Ա��������i��Ԫ��
	T remove(int i);         //ɾ����i��Ԫ�ز����ر�ɾ������
	void removeAll();        //ɾ�����Ա�����Ԫ��
	int indexOf(T key);      //˳����ҹؼ���Ϊkey��Ԫ�أ������״γ��ֵ�λ��
	boolean contain(T key);  //�Ƿ�����ؼ���
	T search(T key);         //˳����ҹؼ���Ϊkey��Ԫ�أ������״γ��ֵ�Ԫ��
}
