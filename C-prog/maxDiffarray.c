#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>
int maxDifference(int* a, int n)
{
	int i=0,max =-1,min=a[i++];
	while(i<n){
		if(a[i]>min){
			int diff = a[i]-min;
			if(max<diff){
				max=diff;
			}
		}else{
			min=a[i];
		}
		i++;
	}
	return max;
}
int main() {
    int n;
    scanf("%d",&n);
    int arr[n];
    
    int i;
    for(i=0;i<n;i++)
        scanf("%d", (arr+i));
    int res = maxDifference(arr,n);
    printf("%d",res);
    return 0;
}