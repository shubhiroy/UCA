#include<stdlib.h>
#include<stdio.h>

typedef struct stack
{
int data;
struct stack* next;

}st;

void push(st** top, int data)
{
    st* new = (st*)malloc(sizeof(st));
    
    new->data = data;
    new->next = *top;
    *top = new;
    
}

int peek(st* top)
{
    return top->data;
}

int empty(st* top)
{
    if(top==NULL)
    {
        return 1;
    }
    return 0;
}
void pop(st** top)
{
    
        st* temp=*top;
        *top=(*top)->next;
        free(temp);
        temp=NULL;    
}

int getMaxArea(int* hist, int n)
{
	st *s = NULL ;
	int area,marea=0,i=0;
	while(i<n){
		if(empty(s) || hist[peek(s)]<=hist[i]){
			push(&s,i);
		}else if(hist[peek(s)]>hist[i]){
			while(!empty(s) &&  hist[peek(s)]>hist[i]){
				int d = hist[peek(s)];
				pop(&s);
				area = (empty(s))?(d*i):(d*(i-peek(s)-1));
				//printf("d=%d  area=%d  marea=%d  i=%d\n",d,area,marea,i);
				if(area>marea){
					marea=area;
				}			
			}
			push(&s,i);
		}
		i++;
	}
	while(!empty(s)){
		int d = hist[peek(s)];
			pop(&s);
			area = (empty(s))?(d*i):(d*(i-peek(s)-1));
			//printf("d=%d  area=%d  marea=%d  i=%d\n",d,area,marea,i);
			if(area>marea){
				marea=area;
			}	
	}
	return marea;
}


int main() 
{   
    int n;
    scanf("%d", &n);
    int arr[n];
    int i;
    for(i=0;i<n;i++)
    {
        scanf("%d", &arr[i]);   
    }
    int r = getMaxArea(arr, n);
    printf("%d", r);
    return 0;
}