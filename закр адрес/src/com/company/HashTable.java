package com.company;

public class HashTable {
    private list[] hashArray;
    private int arraySize;
    public HashTable(int arraySize)
    {
        this.arraySize=arraySize;
        hashArray=new list[arraySize];
        for(int i=0;i<arraySize;i++)
        {
            hashArray[i]=new list();
        }
    }
    public int hashFunc(String s)
    {
        int hash = 0;
        for (int i = 0; i < s. length (); i++) {
            int l=(int) s.charAt(i);
            hash = (53 * hash + (int) s.charAt(i)) % arraySize;
        }
        return hash;
    }
    public void insert(String s)
    {
        int key=hashFunc(s);
        hashArray[key].insertNode(s);
    }
    public void displayTable()
    {
        for (int i=0;i<arraySize;i++)
        {
            System.out.print(i+1+". ");
            hashArray[i].displayList();
        }
    }
    public boolean find(String s)
    {
        int hashVal=hashFunc(s);
        return hashArray[hashVal].findNode(s);
    }
}
