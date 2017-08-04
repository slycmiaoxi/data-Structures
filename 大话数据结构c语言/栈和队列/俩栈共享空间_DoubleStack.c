#include "stdio.h"    
#include "stdlib.h"   
#include "io.h"  
#include "math.h"  
#include "time.h"

#define OK 1
#define ERROR 0
#define TRUE 1
#define FALSE 0
#define MAXSIZE 20 /* �洢�ռ��ʼ������ */

typedef int Status; 

typedef int SElemType; /* SElemType���͸���ʵ������������������Ϊint */

/* ��ջ����ռ�ṹ */
typedef struct
{
	SElemType data[MAXSIZE];
	int top1;    //ջ1ջ��ָ��
	int top2;    //ջ2ջ��Ԫ��
}SqDoubleStack;

Status visit(SElemType c)
{
        printf("%d ",c);
        return OK;
}

/*  ����һ����ջS */
Status InitStack(SqDoubleStack *S)
{
	S->top1=-1;
	S->top2=MAXSIZE;
	return OK;
}

/* ��S��Ϊ��ջ */
Status ClearStack(SqDoubleStack *S)
{ 
        S->top1=-1;
        S->top2=MAXSIZE;
        return OK;
}

/* ��ջSΪ��ջ���򷵻�TRUE�����򷵻�FALSE */
Status StackEmpty(SqDoubleStack S)
{
	if(S.top1==-1&&S.top2==MAXSIZE)
		return TRUE;
	else
		return FALSE;
}

/* ����S��Ԫ�ظ�������ջ�ĳ��� */
int StackLength(SqDoubleStack S)
{
	return (S.top1+1)+(MAXSIZE-1-S.top2);
}


/* ����Ԫ��eΪ�µ�ջ��Ԫ�� */
Status Push(SqDoubleStack *S,SElemType *e,int stackNumber)
{
	if(S->top1+1==S->top2)  //��ջ����
		return ERROR; 
	if(stackNumber==1)       //����ջ1ջ��
		S->data[++S->top1]=e;
	else if(stackNumber==2)  //����ջ2ջ��
		S->data[--S->top2]=e;
	return OK;
}

/* ��ջ���գ���ɾ��S��ջ��Ԫ�أ���e������ֵ��������OK�����򷵻�ERROR */
Status Pop(SqDoubleStack *S,SElemType *e,int stackNumber)
{
	if(stackNumber==1)  //ջһջ��Ԫ�س�ջ
	{
		if(S->top1==-1)
			return ERROR;
		*e=S->data[S->top1--];
	}
	else if(stackNumber==2) //ջ��ջ��Ԫ�س�ջ
	{
		if(S->top2==MAXSIZE)
			return ERROR;
		*e=S->data[S->top2++];
	}
	return OK;
}

Status StackTraverse(SqDoubleStack S)
{
        int i;
        i=0;
        while(i<S.top1)
        {
                visit(S.data[i++]);
        }
        i=S.top2;
        while(i<MAXSIZE)
        {
                visit(S.data[i++]);
        }
        printf("\n");
        return OK;
}

int main()
{
        int j;
        SqDoubleStack s;
        int e;
        if(InitStack(&s)==OK)
        {
                for(j=1;j<=5;j++)
                        Push(&s,j,1);
                for(j=MAXSIZE;j>=MAXSIZE-2;j--)
                        Push(&s,j,2);
        }

        printf("ջ��Ԫ������Ϊ��");
        StackTraverse(s);

        printf("��ǰջ��Ԫ���У�%d \n",StackLength(s));

        Pop(&s,&e,2);
        printf("������ջ��Ԫ�� e=%d\n",e);
        printf("ջ�շ�%d(1:�� 0:��)\n",StackEmpty(s));

        for(j=6;j<=MAXSIZE-2;j++)
                Push(&s,j,1);

        printf("ջ��Ԫ������Ϊ��");
        StackTraverse(s);

        printf("ջ����%d(1:�� 0:��)\n",Push(&s,100,1));

        
        ClearStack(&s);
        printf("���ջ��ջ�շ�%d(1:�� 0:��)\n",StackEmpty(s));
        
        return 0;
}