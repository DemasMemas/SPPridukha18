package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число >> ");
        int x1 = scanner.nextInt();
        System.out.println("Введите второе число >> ");
        int x2 = scanner.nextInt();
        doMult(x1, x2);
    }

    static void doMult(int first, int second){
        System.out.printf("Их произведение " + (int)Math.pow(10, (Math.log10(first) + Math.log10(second))));
    }
}
