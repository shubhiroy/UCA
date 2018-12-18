// # Construct tree from preorder and inorder

#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>
typedef struct TreeNode {
        int val;
        struct TreeNode *left;
        struct TreeNode *right;

}TreeNode;


void postOrder(TreeNode* r)
{

    if( r== NULL)
        return;
    postOrder(r->left);
    postOrder(r->right);
    printf("%d ", r->val);
}

TreeNode* initialize(int val)
{
  TreeNode* nn = (TreeNode*)malloc(sizeof(TreeNode));
  nn->val = val;
  nn->left = NULL;
  nn->right = NULL;
  return nn;
}

int search(int B[],int s,int e,int ele){
	int i;
	for(i=s;i<=e;i++){
		if(B[i]==ele)
			break;
	}
	return i;
}

TreeNode* buildTreee(int A[],int B[],int s,int e,int* m){
	if(s>e) return NULL;
	int val = A[(*m)];
	TreeNode* node = initialize(val);
	(*m)++;
	if(s==e){ 
		return node;
	}
	
	
	
	int j = search(B,s,e,val);
	node->left = buildTreee(A,B,s,j-1,m);
	node->right = buildTreee(A,B,j+1,e,m);
	return node;
}

TreeNode* buildTree(int A[],int B[],int n){
	int s=0,e=n-1,m=0;
	return buildTreee(A,B,s,e,&m);
}
  
int main()
{

    int n, i;

    scanf("%d", &n);
    int A[n], B[n];
    for(i=0;i<n;i++)
    {
        scanf("%d", &A[i]);
    }
    for(i=0;i<n;i++)
    {
        scanf("%d", &B[i]);
    }
    TreeNode* Res = buildTree(A,B,n);

    postOrder(Res);
}