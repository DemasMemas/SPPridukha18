package pridukha;


import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите ссылку на изображение: ");
        downloadThread downloadThreadPicture = new downloadThread(in.nextLine(), ".png");
        System.out.print("Введите ссылку на mp3 файл: ");
        downloadThread downloadThreadMusic = new downloadThread(in.nextLine(), ".mp3");
        System.out.println("Вы хотите воспроизвести музыку? Введите 1 если да");
        if (in.nextLine().equals("1")){
            try (FileInputStream inputStream = new FileInputStream("downloaded_file.mp3")) {
                try {
                    Player player = new Player(inputStream);
                    player.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

//https://www.fonstola.ru/download.php?file=202002/1920x1200/fonstola.ru-370734.jpg
//https://dl3s2.muzika.fun/aHR0cDovL2YubXAzcG9pc2submV0L21wMy8wMDQvNjczLzUwNS80NjczNTA1Lm1wMw==