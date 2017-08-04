package com.zwl.List;

public interface BinaryTTree<T> {

	boolean isEmpty();           //�ж϶������Ƿ�Ϊ��
	int count();                 //���ض������Ľ�����
	int height();                //���ض������ĸ߶�
	void preOrder();             //�ȸ��������������
	void inOrder();              //�и��������������
	void postOrder();            //����������������
	void levelOrder();           //����α���������
	BinaryNode<T> search(T key);   //���Ҳ������״γ��ֹؼ���ΪkeyԪ�ؽ��
	BinaryNode<T> getParent(BinaryNode<T> node);      //����node�ĸ�ĸ���
	void insertRoot(T x);            //����Ԫ��x��Ϊ�����
	BinaryNode<T> insertChild(BinaryNode<T> p,T x,boolean leftChild); //���뺢�ӽڵ�
	void removeChild(BinaryNode<T> p,boolean leftChild); //ɾ��p�������������
	void removeAll();  //ɾ��������
}
