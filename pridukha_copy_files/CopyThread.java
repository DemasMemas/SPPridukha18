package pridukha;

import java.io.*;
import java.util.ArrayList;

public class CopyThread extends Thread{
    String fileName;
    CopyThread(String fileName){
        this.start();
        this.fileName = fileName;
    }

    @Override
    public void run() {
        super.run();
        ArrayList<String> filecontents = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                filecontents.add(line);
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName + " copy_parallel.txt"))) {
                    for (String value : filecontents) {
                        bw.write(value + "\n");
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
    }
}
