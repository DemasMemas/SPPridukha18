package pridukha;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    public static Logger log = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }

        ArrayList<Rocket> rocketList = new ArrayList<>();
        Rocket rocketIvan1 = new Rocket("Ivan1", 50);
        Rocket rocketVanya2 = new Rocket("Vanya2", 25);
        Rocket rocketVanyusha3 = new Rocket("Vanyusha3", 12);
        Rocket rocketOleg4 = new Rocket("Oleg4", -12);
        Scanner in = new Scanner(System.in);
        Rocket rocketCustom = new Rocket("Сань, не забудь имя поменять", 185);
        try {
            System.out.println("Введите по очереди название и запас топлива конструируемой ракеты");
            rocketCustom = new Rocket(in.nextLine(), in.nextInt());
        } catch (InputMismatchException e){
            log.log(Level.INFO, "Конструктор дурак. Ошибка: ", e);
        }
        rocketList.add(rocketIvan1);
        rocketList.add(rocketVanya2);
        rocketList.add(rocketVanyusha3);
        rocketList.add(rocketOleg4);
        rocketList.add(rocketCustom);

        for (Rocket rocket:rocketList) {
            if (rocket.alive){
                log.info("Ракета " + rocket.name + " успешно построена");
                String rocketStatusInfo = rocket.firstPhase();
                log.info(rocketStatusInfo + ". Сообщение передала ракета " + rocket.name);
                rocketStatusInfo = rocket.secondPhase();
                log.info(rocketStatusInfo + ". Сообщение передала ракета " + rocket.name);
                rocketStatusInfo = rocket.thirdPhase();
                log.info(rocketStatusInfo + ". Сообщение передала ракета " + rocket.name);
                rocketStatusInfo = rocket.finalPhase();
                log.info(rocketStatusInfo + ". Сообщение передала ракета " + rocket.name);
                log.info("\n-------------------------------\n");
            } else {
                log.info("Ракета не заправлена. Сообщение передала ракета " + rocket.name);
            }
        }



    }
}
