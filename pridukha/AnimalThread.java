package pridukha;

import java.util.ArrayList;

public class AnimalThread extends Thread{
    String name;
    Integer metres;
    ArrayList<String> line = new ArrayList<>();
    AnimalThread (String name){
        this.name = name;
        this.metres = 0;
        this.start();
        this.line.add("|");
        for (int i = 0; i < 100; i++){
            this.line.add(".");
        }
        System.out.println(this.name + " !!! " + String.join("", this.line) + " !!! " + this.metres + " метров");
    }

    public void run(){
        while(metres < 100){
            metres += 1;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            this.line.set(metres, "|");
            this.line.set(metres - 1, ".");
            System.out.println(this.name + " !!! " + String.join("", this.line) + " !!! " + this.metres + " метров");
        }
        System.out.println(this.name + " финишировал!");
    }
}
