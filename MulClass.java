package com.company;

public class MulClass {
    int mul1;
    int mul2;
    MulClass(int mul1, int mul2){
        this.mul1 = mul1;
        this.mul2 = mul2;
    }
    void doMult(){
        System.out.printf("Их произведение " + (int)Math.pow(10, (Math.log10(this.mul1) + Math.log10(this.mul2))));
    }
}
