package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Task3_Greedy {
    private ArrayList<Gift> cheapestGifts = new ArrayList<Gift>();
    private ArrayList<Gift> gifts;
    private int amount;

    public Task3_Greedy(ArrayList<Gift> gifts, int amount) {
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

    private void solution(ArrayList<Gift> items) {
        removeExcess(items);
        Collections.sort(gifts, new Comparator<Gift>() {
            @Override
            public int compare(Gift gift1, Gift gift2) {
                return gift1.getPrice() - gift2.getPrice();
            }
        });

        for (int i = 0; i < amount; i++) {
            cheapestGifts.add(items.get(i));
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
