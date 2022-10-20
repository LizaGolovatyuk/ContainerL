package org.example;

/**
 * Класс Numbers - это узел однонаправленного списка
 */
public class Numbers<T> {
    public T x;
    protected Numbers <T> next;
    protected Numbers() {};
    public Numbers (T new_x) {
        x=new_x;
        next=null;
    };
}
