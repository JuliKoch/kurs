package com.company;

public class list {
    private Node head;
    public list()
    {
        head=null;
    }
    public void insertNode(String data)
    {
        Node theNode=new Node(data);

        if (head==null)
            head=theNode;
        else
            theNode.next=head;
        head=theNode;

    }
    public boolean findNode(String data)
    {
        Node current=head;
        while(current!=null)
        {
            if (current.getData().equals(data))
                return true;
            current=current.next;
        }
        return false;
    }
    public void displayList()
    {
        System.out.print("List (first-->last): ");
        Node current=head;
        while (current!=null)
        {
            System.out.print(current.getData()+", ");
            current=current.next;
        }
        System.out.println();
    }
}
