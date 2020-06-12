package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String path = new File("").getAbsolutePath();
        File file=new File("история посещений.txt");//путь к файлу
        HashTable htable=new HashTable(1559);
        Scanner in=new Scanner(System.in);
        Scanner scanner=new Scanner(file);

        while (scanner.hasNextLine())//запись с файла
            htable.insert(scanner.nextLine());
        int m=-1;
        while (m!=0)
        {
            System.out.println("Выберите действия\n1-Зарегистрироваться\n2-Войти\nДругие значения выходят из программы ");
            int i = in.nextInt();
            in.nextLine();
            switch(i){
                case (1)://регистрация
                    String s1;
                    boolean f=true;
                    System.out.println("Введите логин и пароль ");
                    while (f)  //пока пользователь не зарегистрировался
                    {

                        s1 = in.nextLine();
                        if (htable.find(s1) == true)
                            System.out.println("Такой пользовательно уже существует, придумайте новый пароль");
                        else
                        {
                            htable.insert(s1);
                            f=false;
                            System.out.println("Вы успешно зарегистрировались");
                            FileWriter writer = new FileWriter("история посещений.txt", true);
                            BufferedWriter bufferWriter = new BufferedWriter(writer);
                            bufferWriter.write(s1+"\n");
                            bufferWriter.close();
                        }
                    }
                    break;
                case (2)://вход

                    String s2;
                    boolean f2=true;
                    int j=2;
                    System.out.println("Введите логин и пароль ");
                    while (f2 && j>=0 ) {
                        s2 = in.nextLine();
                        if (htable.find(s2) == true)
                            System.out.println("Вы успешно вошли");
                        else
                        {
                            if (j==0)
                                System.out.println("Повторите позднее ");
                            else
                                System.out.println("Пользователя с таким логином и паролем не существует, осталось "+j+" попыток");
                            j--;
                        }

                    } break;
                default: m=0;break;

            }
        }
        htable.displayTable();//печать
    }
    }

