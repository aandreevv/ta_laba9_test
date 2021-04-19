package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Gift> gifts = new ArrayList<Gift>();
        gifts.add(new Gift(5, 5000));
        gifts.add(new Gift(6, 11000));
        gifts.add(new Gift(6, 3048));
        gifts.add(new Gift(5, 2670));
        gifts.add(new Gift(6, 1500));
        gifts.add(new Gift(7, 50000));
        gifts.add(new Gift(7, 15500));
        gifts.add(new Gift(8, 20100));
        gifts.add(new Gift(7, 15000));
        gifts.add(new Gift(9, 2222));
        gifts.add(new Gift(9, 333));
        gifts.add(new Gift(10, 11));
        gifts.add(new Gift(10, 139444));
        Task1_Greedy t1 = new Task1_Greedy(gifts, 2);
        t1.solve();
        Task1 task1 = new Task1(gifts, 2);
        task1.solve();

    }

}
