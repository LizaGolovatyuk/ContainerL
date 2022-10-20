package org.example;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNumberTest {
    ListNumber<Double> container =new ListNumber<Double>();

    @BeforeEach
    void setUp() {
        container.addElem(7.0,1);
        container.addElem(3.0, 1);
        container.addElem(5.0, 2);
        container.addElem(1.0, 4);
    }

    @Test
    public void addNumber_NotCorrect() {
        boolean tmp=container.addElem(7.0, 7);
        Assert.assertEquals(tmp,false);
    }

    @Test
    void addNumber() {
        String result1=container.print();
        String result2=" 3.0 5.0 7.0 1.0 ";
        Assert.assertEquals(result1,result2);
    }

    @Test
    public void deleteNumber_NotCorrect() {
        boolean tmp=container.deleteElem(7);
        Assert.assertEquals(tmp,false);
    }

    @Test
    void deleteNumber() {
            container.deleteElem(1);
            container.deleteElem(2);
            container.deleteElem(2);
            String result1=container.print();
            String result2=" 5.0 ";
            Assert.assertEquals(result1,result2);
    }
    @Test
    public void getElem_NotCorrect() {
        Assert.assertEquals(container.getElem(7),null);
    }

    @Test
    void getElem() {
        String result1="";
        result1+=container.getElem(1);
        result1+=container.getElem(3);
        result1+=container.getElem(4);
        String result2="3.07.01.0";
        Assert.assertEquals(result1,result2);
    }
}