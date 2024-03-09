package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker(226);
        String imageUrl = httpStatusChecker.getImageUrl();
        System.out.println("imageUrl = " + imageUrl);

        HttpStatusImageDownloader httpSID = new HttpStatusImageDownloader();
        httpSID.downloadStatusImage(435467);

        HttpImageStatusCli httpISCli = new HttpImageStatusCli();
        httpISCli.askStatus();
    }
}