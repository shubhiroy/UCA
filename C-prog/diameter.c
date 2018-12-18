#include<stdio.h>
#include<stdlib.h>
typedef struct btree
{
    int data;
    struct btree* left;
    struct btree* right;
}btree;

btree* initializeNode(int d)
{
    btree* nn = (btree*)malloc(sizeof(btree));
    nn->data = d;
    nn->left = NULL;
    nn->right = NULL;
    return nn;
}
int max(int a, int b)
{
    if(a>b)
        return a;
    return b;
}
int height(btree* root)
{
    if(root==NULL)
        return 0;
    return 1+ max(height(root->left) , height(root->right));

}

btree* createTree(btree* root, int d)
{
    if( root == NULL)
    {
        return initializeNode(d);
    }

    if( d  < root-> data)
    {

        root->left  = createTree(root->left, d);
    }
    else
        root->right  = createTree(root->right, d);

    return root;
}


int diameter( btree* root){
 
  }
  

int main()
{

    btree* root = NULL;

    int n;
    scanf("%d", &n);
    int arr[n];
    int i;
    for(i=0;i<n;i++)
    {
        scanf("%d", &arr[i]);
        root = createTree(root, arr[i]);
    }
    printf("%d", diameter(root));

}
