package com.company;

public class HashTable {
    private DataItem[] hashArray; //массив ячеек
    private int arraySize;//размер

    HashTable(int arraySize)//конструктор
    {
        this.arraySize=arraySize;
        hashArray=new DataItem[arraySize];

    }
    public void displayTable()// печать таблицы
    {
        System.out.print("Table: ");
        for (int i=0;i<arraySize;i++)
        {
            if (hashArray[i]!=null)
                System.out.println(i+1+" "+hashArray[i].getiData()+" ");
            else
                System.out.println(1+i+" ** ");
        }
        System.out.println("");
    }
    public int hashFunc1(String s)//первая хеш-функция
    {
        int hash = 0;
        for (int i = 0; i < s. length (); i++) {
            hash = (53* hash + (int) s.charAt(i)) % arraySize;
        }
        return hash;
    }
    public int hashFunc2(String s)//вторая хеш-функция
    {
        int hash=0;
        for (int i = 0; i < s. length (); i++) {
            hash = hash+ (int) s.charAt(i)%53;
        }
        return hash%arraySize+1;
    }
    public void insert(String data) //вставка
    {
        DataItem item=new DataItem(data);
        int hashVal1=hashFunc1(data);
        int hashval2=hashFunc2(data);
        while (hashArray[hashVal1]!=null)//пока не будет найдена пустая ячейка
        {
            hashVal1+=hashval2;//смещение
            hashVal1%=arraySize;//возврат к началу
        }
        hashArray[hashVal1]=item;//вставляем элемент
    }
    public boolean find(String data)//поиск
    {
        int hashVal1=hashFunc1(data);
        int hashval2=hashFunc2(data);
        while (hashArray[hashVal1]!=null)//пока не будет найдена пустая ячейка
        {
            if(hashArray[hashVal1].getiData().equals(data))//проверка
                return true; //такой элемент существует
            hashVal1+=hashval2;//смещение
            hashVal1%=arraySize;//возврат к началу
        }
        return false;//такого элемента нет
    }
}
