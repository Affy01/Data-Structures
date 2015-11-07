#include <iostream>
#include <cstdlib>

#include "BST.h"

using namespace std;

int main()
{
    int arr [16]={50,76,21,4,32,64,15,52,14,100,83,2,3,70,87,80};
    BST mytree;
    int data=0;
    mytree.printinorder();
    for(int i=0;i<16;i++)
    {
        mytree.addleaf(arr[i]);
    }

    cout<<"Printing in order "<<endl;

    mytree.printinorder();

    //mytree.printchildren(mytree.returnrootkey());
    cout<<"Smallest number is "<<mytree.findsmallest()<<endl;

    cout<<"Enter value to delete and -1 to exit \n";

    while(data!=-1)
    {
        cin>>data;
        if(data!=-1)
        {
            mytree.removenode(data);
            mytree.printinorder();
        }
    }

    return 0;
}
