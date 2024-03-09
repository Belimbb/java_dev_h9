package org.example;

import java.util.Scanner;

public class HttpImageStatusCli {
    private String sText = "Enter HTTP status code";
    public void askStatus(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(sText);
        if (scanner.hasNextInt()){
            int code = scanner.nextInt();
            HttpStatusImageDownloader httpSID = new HttpStatusImageDownloader();
            try {
                httpSID.downloadStatusImage(code);
            } catch (RuntimeException e){
                System.out.println(String.format("There is not image for HTTP status %s", code));
                askStatus();
            }
            sText = "Enter HTTP status code for downloading another image!";
            askStatus();
        }else {
            sText = "Please enter valid number like 200 or 300";
            askStatus();
        }
    }
}
