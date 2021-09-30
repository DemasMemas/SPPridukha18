package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextInt() == 1){
            System.out.println("Введите первое число >> ");
            int x1 = scanner.nextInt();
            System.out.println("Введите второе число >> ");
            int x2 = scanner.nextInt();
            MulClass mulClass = new MulClass(x1, x2);
            mulClass.doMult();
        }
        else{
            try(FileReader reader = new FileReader("mul.txt")){
                BufferedReader br = new BufferedReader(reader);
                String xStr = br.readLine();
                int x1 = Integer.parseInt(xStr);
                xStr = br.readLine();
                int x2 = Integer.parseInt(xStr);
                br.close();
                MulClass mulClass = new MulClass(x1, x2);
                mulClass.doMult();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }

    }


}

