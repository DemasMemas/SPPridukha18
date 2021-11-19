package pridukha;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

class downloadThread extends Thread {
     String link;
     String fileExtention;

    downloadThread (String link, String fileExtention){
        this.link = link;
        this.fileExtention = fileExtention;
        this.start();
    }
    @Override
    public void run(){
        URL website = null;
        try {
            website = new URL(this.link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ReadableByteChannel rbc = null;
        try {
            rbc = Channels.newChannel(website.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("downloaded_file" + this.fileExtention);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(fileExtention + " успешно скачан");
    }
}
