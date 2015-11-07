#ifndef BST_H
#define BST_H
# include <iostream>
# include <cstdlib>


class BST
{
    private:
        struct node
        {
            int data;
            node * left;
            node * right;
        };
        node * root;
        node* createleaf(int key);
        void addleafPrivate(int key,node * ptr);
        void printinorderprivate(node * ptr);
        node * returnnodeprivate(int key, node * ptr);
        int findsmallestprivate(node * ptr);
        void removenodeprivate(int key, node * ptr);
        void removerootmatch();
        void removematch(node * parent, node * match, bool left);
        void removesubtree(node * ptr);

    public:
        BST();
        ~BST();
        void addleaf(int key);
        void printinorder();
        node * returnnode(int key);
        int returnrootkey();
        void printchildren(int key);
        int findsmallest();
        void removenode(int key);




};

#endif // BST_H
