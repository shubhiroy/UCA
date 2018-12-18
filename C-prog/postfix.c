#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>
typedef struct node{
	int  data;
	struct node* next;
}node ;
void push(int val, node** top)
{
	node* nn= (node*)malloc(sizeof(node));
	nn->data=val;
	nn->next=*top;
	*top=nn;
}

void pop(node** top)
{
	struct node* temp=*top;
	*top=temp->next;
	free(temp);
	temp = NULL;
}

int peek(node* top)
{
	return top->data;
}

bool isempty(node* top)
{
	if(top == NULL)
	return 1;
	return 0;
}

int solve(int d1,int d2,char s){
	if(s=='+')
		return d1+d2;
	if(s=='*')
		return d1*d2;
	if(s=='-')
		return d2-d1;
	if(s=='/')
		return d2/d1;
}

bool check(

node* flip(node* n){
	node *s=NULL;
	while(!isempty(n)){
		int d= peek(n);
		pop(&n);
		push(d,&s);
	}
	return s;
}

int sol(node* n){
	while(!isempty(n)){
		if(check(peek(n))){
		}
	}
}

int main(){
	node *n=NULL;
	char str[1000];
	scanf ("%[^\n]%*c", str);
	int i=0,res;
	int num=0;
	while(str[i]!='\0'){
		if(str[i]==' '){
			//printf("%d---",num);
			push(num,&n);
			num=0;
			i++;
			//printf("%d-",peek(n));
			continue;
		}
			//printf("%c-",str[i]);
			num=(num*10)+(str[i]-'0');
			i++;
	}
	push(num,&n);
	//printf("\n%d---",peek(n));
	n=flip(n);
	//printf("%d",peek(n));
}