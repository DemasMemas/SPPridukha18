package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void main() {
        int x1 = 2;
        int x2 = 4;
        MulClass mulClass = new MulClass(x1, x2);
        mulClass.doMult();
        try(FileReader reader = new FileReader("mul.txt")){
            BufferedReader br = new BufferedReader(reader);
            String xStr = br.readLine();
            x1 = Integer.parseInt(xStr);
            xStr = br.readLine();
            x2 = Integer.parseInt(xStr);
            br.close();
            mulClass = new MulClass(x1, x2);
            mulClass.doMult();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}