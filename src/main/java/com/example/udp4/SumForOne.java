package com.example.udp4;

public class SumForOne extends Thread {
    public int a = 0;
    public int b = 0;
    public int res;
    SumForOne(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public void run() {

        int sum = 0;

        for (int i = a ; i <= b; i++) {
            sum+= Math.pow(i + 1, 2);
        }

        res+=sum;
    }

}
