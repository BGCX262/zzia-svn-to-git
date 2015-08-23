package cn.ming.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ClassTestOne {
    @Test
    public void fun() {
        List<Integer> list = new ArrayList<Integer>();
        addList(list);
        System.out.println(list);
    }

    private void addList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
    }
}
