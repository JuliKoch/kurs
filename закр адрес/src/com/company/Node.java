package com.company;

public class Node {
    private String data; //логин и пароль
    public Node next;//указатель на следующий элемент
    public Node(String data)
    {

        this.data=data;
        next=null;
    }
    public String getData()
    {
        return data;
    }
}
