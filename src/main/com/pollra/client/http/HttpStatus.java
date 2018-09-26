package main.com.pollra.client.http;

public enum HttpStatus {
    // 1xx

    // 2xx
    OK("200 OK");

    // 3xx

    // 4xx

    private String statusMessage;

    HttpStatus(String statucsMessage){ this.statusMessage = statucsMessage; }

    public String getStatusMessage() { return statusMessage; }

}
