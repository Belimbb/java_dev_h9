package org.example;

import okhttp3.Response;

import java.io.*;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code){
        String url = "https://http.cat/%s.jpg";
        RequestService requestService = new RequestService(String.format(url, code));
        if (requestService.sentRequest().isPresent() && requestService.getResponseCode()!=404){
            Response response = requestService.sentRequest().get();
            InputStream inputStream = response.body().byteStream();
            fileDownloader(inputStream, code);
        } else{
            throw new RuntimeException("Invalid image code");
        }
    }

    private void fileDownloader(InputStream inputStream, int imageCode){
        try (OutputStream outputStream = new FileOutputStream(String.format("%s.png", imageCode))) {
            byte[] buffer = new byte[2048];
            int read;
            while ((read = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, read);
            }
            System.out.println("Image was downloaded successfully");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
