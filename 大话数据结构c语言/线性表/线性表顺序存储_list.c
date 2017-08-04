#include<stdio.h>

#include<stdlib.h>

#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0

#define MAXSIZE 20       /* �洢�ռ��ʼ����ֵ */
typedef int ElemType;
typedef int Status;  /* Status�Ǻ���������,��ֵ�Ǻ������״̬���룬��OK�� */
typedef struct
{
ElemType data[MAXSIZE];  //����洢����Ԫ�أ��������ΪMAXSIZE
int length;              //��ǰ���Ա�ĳ���
}SqList;


//��ʼ�����Ա�
 Status InitList(SqList *L)
{
    L->length=0;
    return OK;
}

/* ��ʼ������˳�����Ա�L�Ѵ��ڡ������������LΪ�ձ��򷵻�TRUE�����򷵻�FALSE */
Status ListEmpty(SqList L)
{
	return L.length==0?TRUE:FALSE;
}


/* ��ʼ������˳�����Ա�L�Ѵ��ڡ������������L����Ϊ�ձ� */
Status CleanList(SqList *L)
{
	 L->length=0;
    return OK;
}

/* ��ʼ������˳�����Ա�L�Ѵ��ڡ��������������L������Ԫ�ظ��� */
 Status ListLength(SqList L)
 {
 	return L.length;
 }


/* ��ʼ������˳�����Ա�L�Ѵ��ڣ�1��i��ListLength(L) */
/* �����������e����L�е�i������Ԫ�ص�ֵ,ע��i��ָλ�ã���1��λ�õ������Ǵ�0��ʼ */
Status GetElem(SqList L,int i,ElemType *e)
{
if(L.length==0||i<1||i>L.length)
    return ERROR;
      *e=L.data[i-1];
         return OK;
}

/* ��ʼ������˳�����Ա�L�Ѵ��� */
/* �������������L�е�1����e�����ϵ������Ԫ�ص�λ�� */
/* ������������Ԫ�ز����ڣ��򷵻�ֵΪ0 */
Status LocateElem(SqList L,ElemType e)
{
	int i;
	if(L.length==0)
		return 0;
	for(i=0;i<L.length;i++)
		if(L.data[i]==e)
			break;
		if(i>=L.length)
            return 0;
        return i+1;
}


/* ��ʼ������˳�����Ա�L�Ѵ���,1��i��ListLength(L)�� */
/* �����������L�е�i��λ��֮ǰ�����µ�����Ԫ��e��L�ĳ��ȼ�1 */
Status ListInsert(SqList *L,int i,ElemType e)
{
   int k;
    if(L->length==MAXSIZE) //˳�����Ա�����
       return ERROR;
    if(i<1||i>L->length+1) //��i���ڷ�Χ��
       return ERROR;
     if(i<=L->length)      //����������λ�ò��ڱ�β
     {
        for(k=L->length-1;k>=i-1;k--)//��Ҫ����λ�ú�����Ԫ������ƶ�һλ
           L->data[k+1]=L->data[k]; 
     }
      L->data[i-1]=e; //����Ԫ�ز���
      L->length++;
      return OK;
}

/* ��ʼ������˳�����Ա�L�Ѵ��ڣ�1��i��ListLength(L) */
/* ���������ɾ��L�ĵ�i������Ԫ�أ�����e������ֵ��L�ĳ��ȼ�1 */
 Status ListDelete(SqList *L,int i,ElemType *e)
 {
       int k;
        if(L->length==0)        //���Ա�Ϊ��
          return ERROR;
        if(i<1||i>L->length)    //ɾ��λ�ò���
        	return ERROR;
        *e=L->data[i-1];        
        if(i<L->length)         //�������ɾ�����Ԫ��
        {
        	for(k=i;k<L->length;k++)
        	  L->data[k-1]=L->data[k]; //��ɾ���ĺ��Ԫ��ǰ��
        }
        L->length--;
         return OK;
 }

 //���ĳ��Ԫ��
 Status visit(ElemType c)
 {
 	printf("%d ",c);
 	return OK;
 }

 /* ��ʼ������˳�����Ա�L�Ѵ��� */
/* ������������ζ�L��ÿ������Ԫ����� */
 Status ListTraverse(SqList L)
 {
 	int i;
 	for(i=0;i<L.length;i++)
 		 visit(L.data[i]);
 		printf("\n");
 		return OK;
 }

//��������lb�е�����la�е�Ԫ�ز��뵽la��
 void unionL(SqList *La,SqList Lb)
 {
    int La_len,Lb_len,i;
    ElemType e;
    La_len=ListLength(*La);
    Lb_len=ListLength(Lb);
    for(i=0;i<Lb_len;i++)
    {
    	GetElem(Lb,i,&e);
    	if(!LocateElem(*La,e))
    		 ListInsert(La,++La_len,e);
    }
 }

 int main()
 {
  SqList L;
  ElemType e;
  Status i;
  int j,k;
  i=InitList(&L);
  printf("��ʼ��L��L.length=%d\n",L.length);
  for(j=1;j<=5;j++)
    i=ListInsert(&L,1,j);
  printf("��L�ı�ͷ���β���1~5��L��data=");
  ListTraverse(L);
   printf("L.length=%d \n",L.length);
   i=ListEmpty(L);
   printf("L�Ƿ�գ�i=%d(1:�� 0:��)\n",i);

   i=CleanList(&L);
   printf("���L��L.length=%d\n",L.length);
    i=ListEmpty(L);
    printf("L�Ƿ�գ�i=%d(1:�� 0:��)\n",i);
      for(j=1;j<=10;j++)
            ListInsert(&L,j,j);
    printf("��L�ı�β���β���1��10��L.data=");
    ListTraverse(L); 

    printf("L.length=%d \n",L.length);
    ListInsert(&L,1,0);
    printf("��L�ı�ͷ����0��L.data=");
    ListTraverse(L); 
    printf("L.length=%d \n",L.length);

     GetElem(L,5,&e);
    printf("��5��Ԫ�ص�ֵΪ��%d\n",e);
    for(j=3;j<=4;j++)
    {
            k=LocateElem(L,j);
            if(k)
                    printf("��%d��Ԫ�ص�ֵΪ%d\n",k,j);
            else
                    printf("û��ֵΪ%d��Ԫ��\n",j);
    }

     k=ListLength(L); /* kΪ�� */
    for(j=k+1;j>=k;j--)
    {
            i=ListDelete(&L,j,&e); /* ɾ����j������ */
            if(i==ERROR)
                    printf("ɾ����%d������ʧ��\n",j);
            else
                    printf("ɾ����%d����Ԫ��ֵΪ��%d\n",j,e);
    }
    printf("�������L��Ԫ�أ�");
    ListTraverse(L); 

    j=5;
    ListDelete(&L,j,&e); /* ɾ����5������ */
    printf("ɾ����%d����Ԫ��ֵΪ��%d\n",j,e);

    printf("�������L��Ԫ�أ�");
    ListTraverse(L); 

    return 0;
 }