package com.company;

public class Croupier {
    private int count = 0;
    private int wins = 0;

    public void setCountNull(){
        this.count = 0;
    }

    public void setWins() {
        this.wins += 1;
    }

    public int getWins() {
        return wins;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count += count;
    }
}
