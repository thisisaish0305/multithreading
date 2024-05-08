package com.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafe_FailFast_Iterator {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            int i = it.next();
            System.out.println(i);
            it.remove();//
            //list.add(4);
        }
        System.out.println(list.size());

        System.out.println();
        CopyOnWriteArrayList<Integer> cl = new CopyOnWriteArrayList<>();
        cl.add(1); cl.add(2); cl.add(3);
        Iterator<Integer> it_ = cl.iterator();
        while (it_.hasNext()){
            int i = it_.next();
            System.out.println(i);
            cl.add(4);//allowed here

        }
        System.out.println(cl.size());
    }
}