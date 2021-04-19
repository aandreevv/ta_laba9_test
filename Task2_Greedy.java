package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Task2_Greedy {
    private ArrayList<Gift> bestGifts = new ArrayList<Gift>();
    private ArrayList<Gift> gifts;

    public Task2_Greedy(ArrayList<Gift> gifts) {
        this.gifts = gifts;
    }
    private int getSum(ArrayList<Gift> items) {
        int sum = 0;
        for (Gift gift: items) {
            sum += gift.getPrice();
        }
        return sum;
    }

    private void removeExcess(ArrayList<Gift> items) {
        items.removeIf(gift -> gift.getQuality() < 7 || gift.getQuality() >= 9);
    }

    private void solution() {
        removeExcess(gifts);
        Collections.sort(gifts, new Comparator<Gift>() {
            @Override
            public int compare(Gift gift1, Gift gift2) {
                return gift1.getPrice()/gift1.getQuality() - gift2.getPrice()/gift2.getQuality();
            }
        });

        for (Gift gift: gifts) {
            int sum = getSum(bestGifts);
            if (sum + gift.getPrice() < 50000) {
                bestGifts.add(gift);
            }
        }
    }

    public void solve() {
        solution();
        System.out.println("     TASK - 2 - Greedy Algorithm    ");
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
