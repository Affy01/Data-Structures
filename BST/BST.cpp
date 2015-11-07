#include "BST.h"
# include <iostream>
# include <cstdlib>


using namespace std;

BST::BST()
{
    root=NULL;
}

BST::node* BST::createleaf(int data)
{
    node *n=new node;
    n->data=data;
    n->left=NULL;
    n->right=NULL;
    return n;
}

void BST::addleaf(int key)
{
    addleafPrivate(key,root);
}

void BST::addleafPrivate(int key,node * ptr)
{
    if(root==NULL)
    {
        root=createleaf(key);
    }
    else if (key<ptr->data)
    {
        if(ptr->left==NULL)
        {
            ptr->left=createleaf(key);
        }
        else
        {
            addleafPrivate(key,ptr->left);
        }
    }
    else if (key>ptr->data)
    {
        if(ptr->right==NULL)
        {
            ptr->right=createleaf(key);
        }
        else
        {
            addleafPrivate(key,ptr->right);
        }
    }
    else
    {
        cout<<"key already present"<<endl;
    }
}

void BST:: printinorder()
{
    printinorderprivate(root);
}

void BST::printinorderprivate(node * ptr)
{
    if(root!=NULL)
    {
        if(ptr->left!=NULL)
        {
            printinorderprivate(ptr->left);
        }
        cout<<ptr->data<<endl;
        if(ptr->right!=NULL)
        {
            printinorderprivate(ptr->right);
        }
    }
    else
    {
        cout<<"Tree is empty"<<endl;
    }
}

BST::node * BST::returnnode(int key)
{
    node * ptr;
    ptr=returnnodeprivate(key,root);
    cout<<ptr<<endl;
}


BST::node * BST::returnnodeprivate(int key, node * ptr)
{
    if(ptr!=NULL)
    {
        if(ptr->data==key)
        {
            return ptr;
        }
        else
        {
            if(key<ptr->data)
            {
                return returnnodeprivate(key,ptr->left);
            }
            else
            {
                return returnnodeprivate(key,ptr->right);
            }
        }
    }
    else
        return NULL;
}

int BST::returnrootkey()
{
    if(root!=NULL)
    {
        cout<<"root is "<<root->data<<endl;
        return root->data;
    }
    else return -100000;
}

void BST::printchildren(int key)
{
    node * ptr;
    ptr=returnnodeprivate(key,root);
    if(ptr!=NULL)
    {
        if(ptr->right!=NULL)
        {
            cout<<ptr->right->data<<endl;
        }
        if(ptr->left!=NULL)
        {
            cout<<ptr->left->data<<endl;
        }

    }
    else
        cout<<key<<" not present"<<endl;
}


int BST::findsmallest()
{
    return findsmallestprivate(root);
}

int BST::findsmallestprivate(node * ptr)
{
    if(root==NULL)
    {
        cout<<"Tree is empty"<<endl;
        return -100000;
    }
    else
    {
        if(ptr->left!=NULL)
        {
            return findsmallestprivate(ptr->left);
        }
        else
            return ptr->data;
    }

}

void BST::removenode(int key)
{
    removenodeprivate(key,root);
}

void BST::removenodeprivate(int key, node * ptr)
{
    if(root!=NULL)
    {
        if(root->data==key)
        {
            removerootmatch();
        }
        else if(key<ptr->data&&ptr->left!=NULL)
        {
            if(ptr->left->data==key)
            {
                removematch(ptr,ptr->left,true);
            }
            else
            removenodeprivate(key,ptr->left);
        }
        else if(key>ptr->data&&ptr->right!=NULL)
        {
            if(ptr->right->data==key)
            {
                removematch(ptr,ptr->right,false);
            }
            else
            removenodeprivate(key,ptr->right);
        }
        else
        {
            cout<<"key not present"<<endl;
        }
    }
    else
        cout<<"The tree is empty"<<endl;
}

void BST::removerootmatch()
{
    if(root!=NULL)
    {
        node * delptr=root;
        int rootkey=root->data;
        int smallestinrightsubtree;

        if(root->left==NULL&&root->right==NULL)
        {
            root==NULL;
            delete delptr;
        }

        else if(root->left==NULL&&root->right!=NULL)
        {
            root=root->right;
            delptr->right=NULL;
            delete delptr;
            cout<<"Root was deleted, new root contains "<<root->data<<endl;
        }
        else if(root->left!=NULL&&root->right==NULL)
        {
            root=root->left;
            delptr->left=NULL;
            delete delptr;
            cout<<"Root was deleted, new root contains "<<root->data<<endl;
        }
        else
        {
            smallestinrightsubtree=findsmallestprivate(root->right);
            removenodeprivate(smallestinrightsubtree,root);
            root->data=smallestinrightsubtree;
            cout<<"Root was removed new root is "<<root->data<<endl;
        }


    }
    else
        cout<<"Tree is empty"<<endl;




}

void BST::removematch(node * parent, node * match, bool left)
{
    if(root!=NULL)
    {
        node * delptr;
        int matchkey = match->data;
        int smallestinrightsubtree;

        if(match->left==NULL&&match->right==NULL)
        {
            delptr=match;
            left==true? parent->left=NULL:parent->right=NULL;
            delete delptr;
            cout<<"Node was deleted"<<endl;
        }


    else if(match->left==NULL&&match->right!=NULL)
    {
        delptr=match;
        left==true? parent->left=match->right:parent->right=match->right;
        match->right=NULL;
        delete delptr;
        cout<<"Node was deleted"<<endl;
    }
    else if(match->left!=NULL&&match->right==NULL)
    {
        delptr=match;
        left==true? parent->left=match->left:parent->right=match->left;
        match->left=NULL;
        delete delptr;
        cout<<"Node was deleted"<<endl;
    }
    else
    {
        smallestinrightsubtree = findsmallestprivate(match->right);
        removenodeprivate(smallestinrightsubtree,match); ///Can pass match->right??
        match->data=smallestinrightsubtree;
    }

    }
    else
        cout<<"Tree is empty"<<endl;
}

BST::~BST()
{
    removesubtree(root);
}

void BST::removesubtree(node * ptr)
{
    if(ptr!=NULL)
    {
        if(ptr->left!=NULL)
        {
            removesubtree(ptr->left);
        }
        if(ptr->right!=NULL)
        {
            removesubtree(ptr->right);
        }
        cout<<"Deleting "<<ptr->data<<endl;
        delete ptr;
    }
}
