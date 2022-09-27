package com.example.udp4;

public class SumForTwo extends Thread{
    public int b,c;
    public float res;
    SumForTwo(int b, int c) {
        this.b = b;
        this.c = c;
    }
    public void run() {
        float sum = 0;

        for (float i = b; i <= c; i++) {
            sum+= (3.0*i)/(5.0 - i);
        }

        res+=sum;
    }
}
