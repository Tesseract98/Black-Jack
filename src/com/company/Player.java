package com.company;

public class Player {
    private int count = 0;
    private int wins = 0;

    public void setCountNull(){
        this.count = 0;
    }

    public int getWins() {
        return wins;
    }

    public void setWins() {
        this.wins += 1;
    }

    public void setCount(int count) {
        this.count += count;
    }

    public int getCount() {
        return count;
    }
}
