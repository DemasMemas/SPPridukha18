package pridukha;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> file1contents = new ArrayList<>();
        ArrayList<String> file2contents = new ArrayList<>();
        long start = System.currentTimeMillis();
        try (BufferedReader br1 = new BufferedReader(new FileReader("file 1.txt"))) {
            String line;
            while ((line = br1.readLine()) != null) {
                file1contents.add(line);
                try (BufferedWriter bw1 = new BufferedWriter(new FileWriter("file 1 copy.txt"))) {
                    for (String value : file1contents) {
                        bw1.write(value + "\n");
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br2 = new BufferedReader(new FileReader("file 2.txt"))) {
            String line;
            while ((line = br2.readLine()) != null) {
                file2contents.add(line);
                try (BufferedWriter bw2 = new BufferedWriter(new FileWriter("file 2 copy.txt"))) {
                    for (String value : file2contents) {
                        bw2.write(value + "\n");
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Прошло времени, мс: " + elapsed);

        file1contents.clear();
        file2contents.clear();

        start = System.currentTimeMillis();
        CopyThread file1Thread = new CopyThread("file 1.txt");
        CopyThread file2Thread = new CopyThread("file 2.txt");
        file1Thread.join();
        file2Thread.join();
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("Прошло времени, мс: " + elapsed);
    }
}
