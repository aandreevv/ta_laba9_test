package com.company;

public class Gift {
    private int quality;
    private int price;

    public Gift(int quality, int price) {
        this.quality = quality;
        this.price = price;
    }

    public int getQuality() {
        return quality;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Gift {" +
                "quality=" + quality +
                ", price=" + price +
                '}';
    }
}
