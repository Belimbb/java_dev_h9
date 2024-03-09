package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Optional;

public class RequestService {
    private final OkHttpClient client = new OkHttpClient();
    private final Request request;

    public RequestService(String url) {
        this.request = new Request.Builder().url(url).build();
    }
    public int getResponseCode(){
        int responseCode = 404;
        Optional<Response> response = sentRequest();
        if (response.isPresent()){
            responseCode = response.get().code();
        }
        return responseCode;
    }

    public Optional<Response> sentRequest(){
        Response response;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException("Some problems with sending request: " + e);
        }
        return Optional.of(response);
    }
}
