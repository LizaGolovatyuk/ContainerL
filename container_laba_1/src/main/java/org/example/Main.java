package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean tmp_move = true;

        Scanner scan = new Scanner(System.in);

        ListNumber<Double> list = new ListNumber <Double>();

        while (tmp_move) {
            System.out.println("Выберите действие, которое хотите совершить: " + "\n" + " (1)-Добавление элемента в заданное место" + "\n" + " (2)-Удаление элемента из заданного места" + "\n" + " (3)-Поиск элемента по заданному месту" + "\n");
            int number = scan.nextInt();
            switch (number) {
                case 1: {
                    System.out.println("Текущий набор чисел:" + "\n");
                    System.out.println(list.print());
                    System.out.println();
                    System.out.println("Введите элемент, который хотите добавить: " + "\n");
                    double x = scan.nextInt();
                    System.out.println("Введите номер места на которое хотите поставить элемент: " + "\n");
                    int place = scan.nextInt();
                    if(list.addElem(x, place))
                    {
                        System.out.println("Новый набор чисел:" + "\n");
                        System.out.println(list.print());
                        System.out.println();
                    }
                    else System.out.println("Неверно введенное место" + "\n");
                    break;
                }
                case 2: {
                    System.out.println("Текущий набор чисел:" + "\n");
                    System.out.println(list.print());
                    System.out.println();
                    System.out.println("Введите номер места где хотите удалить элемент: " + "\n");
                    int place = scan.nextInt();
                    if (list.deleteElem(place))
                    {
                        System.out.println("Новый набор чисел:" + "\n");
                        System.out.println(list.print());
                        System.out.println();
                    }
                    else System.out.println("Неверно введенное место" + "\n");
                    break;
                }
                case 3: {
                    System.out.println("Текущий набор чисел:" + "\n");
                    System.out.println(list.print());
                    System.out.println();
                    System.out.println("Введите номер места элемента, который хотите получить: " + "\n");
                    int place = scan.nextInt();
                    if(list.getElem(place)==null) System.out.println("Неверно введенное место" + "\n");
                    else
                    {
                        System.out.print(list.getElem(place));
                        System.out.println();
                    }
                    break;
                }
            }
            
            System.out.println("Хотите продолжить действия? (Y/N)" + "\n");
            String symbol = scan.next();
            if (symbol.equals("Y")) tmp_move = true;
            else tmp_move = false;
        }
    }
    }