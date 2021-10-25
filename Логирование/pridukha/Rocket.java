package pridukha;

import java.util.Random;

public class Rocket {
    Random random = new Random();
    int fuel;
    String name;
    int rocketID;
    static int id = 1;
    boolean alive;
    Rocket(String name, int fuel){
        this.name = name;
        this.fuel = fuel;
        this.rocketID = id++;
        this.alive = this.fuel > 0;
    }

    String firstPhase(){
        this.fuel -= 10;
        if (this.fuel <= 0){
            this.alive = false;
            return "Капец падаем";
        } else{
            return "Фаза 1 - ОК";
        }
    }

    String secondPhase(){
        if (this.alive) {
            this.fuel -= random.nextInt(20);
            if (this.fuel <= 0) {
                this.alive = false;
                return "Капец падаем";
            } else {
                return "Фаза 2 - ОК";
            }
        } else{
            return "Связь потеряна";
        }
    }

    String thirdPhase(){
        if (this.alive) {
            this.fuel -= random.nextInt(30);
            if (this.fuel <= 0) {
                this.alive = false;
                return "Капец падаем";
            } else {
                return "Фаза 3 - ОК";
            }
        } else{
            return "Связь потеряна";
        }
    }

    String finalPhase(){
        if (this.alive & random.nextInt(100) > 50) {
            return "Ракета выполнила миссию";
        } else{
            return "Связь потеряна";
        }
    }
}
