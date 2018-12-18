#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>
int isPangram(char* str)
{
	int arr[26]={0};
	int i=0,c=0,f=0;
	while(str[i]!='\0'){
		int a = str[i]-'a';
		if(arr[a]==0){
			arr[a]=1;
			c++;
		}
		if(c>25){
			f=1;
			break;
		}
		i++;
	}
	return f;
}
int main() {
    int n;
    scanf("%d",&n);
    int i;
    char res[101];
    for(i=0;i<n;i++)
    {
       getchar();
        char str[100001];
        scanf(" %[^\n]s",str);
        
        int r = isPangram(str);
    char ch[2];
    ch[0]= r+48;
    ch[1] ='\0';
        strcat(res, ch);
        
    }
    
    printf("%s", res);
    return 0;
}
