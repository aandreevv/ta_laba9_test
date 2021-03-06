package com.company;

import java.util.ArrayList;

public class Task3 {

    private ArrayList<Gift> cheapestGifts = null;
    private ArrayList<Gift> gifts;
    private int amount;

    public Task3(ArrayList<Gift> gifts, int amount) {
        this.gifts = gifts;
        this.amount = amount;
    }

    private int getSum(ArrayList<Gift> items) {
        int sum = 0;
        for (Gift gift: items) {
            sum += gift.getPrice();
        }
        return sum;
    }

    private void removeExcess(ArrayList<Gift> items) {
        items.removeIf(gift -> gift.getQuality() < 9 || gift.getQuality() > 10);
    }

    private void check(ArrayList<Gift> items) {
        if (cheapestGifts == null) {
            if (items.size() == amount) {
                cheapestGifts = items;
            }
        } else {
            if (items.size() == amount && getSum(items) < getSum(cheapestGifts)) {
                cheapestGifts = items;
            }
        }
    }

    private void solution(ArrayList<Gift> items) {
        removeExcess(items);
        if (items.size() > 0) {
            check(items);
        }
        for (int i = 0; i < items.size(); i++) {
            ArrayList<Gift> newList = new ArrayList<Gift>(items);
            newList.remove(i);
            solution(newList);
        }
    }

    public void solve() {
        solution(gifts);
        System.out.println("Minimum sum: " + getSum(getCheapestGifts()));
        System.out.println("===== List of gifts: =====");
        for (Gift gift: getCheapestGifts()) {
            System.out.println(gift);
        }
        System.out.println("==========================");
        System.out.println();
    }

    public ArrayList<Gift> getCheapestGifts() {
        return cheapestGifts;
    }

}
