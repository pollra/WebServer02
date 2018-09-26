package main.com.pollra.client.http;

import java.util.HashMap;
import java.util.Map;

public class HttpResponse {

    private String protocol;
    private HttpStatus status;
    private Map<String, String> responseHeader;
    private String body;

    private HttpResponse() {}

    public String getProtocol() {
        return protocol;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Map<String, String> getResponseHeader() {
        return responseHeader;
    }

    public String getBody() {
        return body;
    }

    public static class ResponseBuilder{
        private String protocol = "HTTP/1.1";
        private HttpStatus status;
        private Map<String, String> responseHeader = new HashMap<>();
        private String body;

        public ResponseBuilder(HttpStatus status){
            this.status = status;
        }

        public ResponseBuilder setProtocol(String protocol){
            this.protocol = protocol;
            return this;
        }

        public ResponseBuilder addHeader(String key, String value){
            this.responseHeader.put(key, value);
            return this;
        }

        public ResponseBuilder setBody(String body){
            this.body = body;
            return this;
        }

        public HttpResponse build(){
            HttpResponse httpResponse = new HttpResponse();
            httpResponse.protocol = this.protocol;
            httpResponse.status = this.status;
            httpResponse.responseHeader = this.responseHeader;
            httpResponse.body = this.body;
            return httpResponse;
        }
    }

}
