package com.company;

import java.util.ArrayList;

public class Task2 {

    private ArrayList<Gift> bestGifts = null;
    private ArrayList<Gift> gifts;

    public Task2(ArrayList<Gift> gifts) {
        this.gifts = gifts;
    }

    private int getSum(ArrayList<Gift> items) {
        int sum = 0;
        for (Gift gift: items) {
            sum += gift.getPrice();
        }
        return sum;
    }

    private void check(ArrayList<Gift> items) {
        if (bestGifts == null) {
            if (getSum(items) >= 100 && getSum(items) < 50000) {
                bestGifts = items;
            }
        } else {
            if (getSum(items) >= 100 && getSum(items) < 50000 && items.size() > bestGifts.size()) {
                bestGifts = items;
            }
        }
    }

    private void removeExcess(ArrayList<Gift> items) {
        items.removeIf(gift -> gift.getQuality() < 7 || gift.getQuality() >= 9);
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
        System.out.println("     TASK - 2 - Dynamic Programming    ");
        System.out.println("Maximum amount of gifts: " + getBestGifts().size());
        System.out.println("===== List of gifts: =====");
        for (Gift gift: getBestGifts()) {
            System.out.println(gift);
        }
        System.out.println("==========================");
        System.out.println("Total sum: " + getSum(getBestGifts()));
        System.out.println();
    }

    public ArrayList<Gift> getBestGifts() {
        return bestGifts;
    }
}
