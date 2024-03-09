package org.example;

public class HttpStatusChecker {
    private final int imageCode;

    public HttpStatusChecker(int imageCode) {
        this.imageCode = imageCode;
    }

    public String getImageUrl() {
        String imageUrl = "https://http.cat/%s.jpg";
        String formattedUrl = String.format(imageUrl, imageCode);
        RequestService requestService = new RequestService(formattedUrl);
        int responseCode = requestService.getResponseCode();
        if (responseCode == 200) {
            return formattedUrl;
        }
        throw new RuntimeException("Invalid image code");
    }

}
