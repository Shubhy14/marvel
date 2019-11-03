#include <iostream>

using namespace std;

int main()
{
    int data[20],datarec[20],c,c1,c2,c3,i;
    cout<<"Enter the 4 bits of data:"<<endl;
    cin>>data[3];
    cin>>data[5];
    cin>>data[6];
    cin>>data[7];
    data[1]=data[3]^data[5]^data[7];
    data[2]=data[3]^data[6]^data[7];
    data[4]=data[5]^data[6]^data[7];
    cout<<"Sent frame:";
    for(i=1;i<=7;i++)
    {
        cout<<data[i];
    }
    cout<<"\nEnter received frame:"<<endl;
    for(i=1;i<=7;i++)
    {
        cin>>datarec[i];
    }
    cout<<"\nReceived frame:";
    for(i=1;i<=7;i++)
    {
        cout<<datarec[i];
    }
    c1=datarec[1]^datarec[3]^datarec[5]^datarec[7];
    c2=datarec[2]^datarec[3]^datarec[6]^datarec[7];
    c3=datarec[4]^datarec[5]^datarec[6]^datarec[7];
    c=c1+(2*c2)+(4*c3);
    if(c==0)
    {
        cout<<"No error";
    }
    else
    {
        cout<<"Error at position"<<c<<endl;
        cout<<"Correct data"<<endl;
        if(datarec[c]==0)
        {
            datarec[c]=1;
        }
        else
        {
            datarec[c]=0;
        }
        for(i=1;i<=7;i++)
        {
            cout<<datarec[i];
        }
    }
    return 0;
}
