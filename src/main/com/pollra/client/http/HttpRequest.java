package main.com.pollra.client.http;

import java.util.Map;

public class HttpRequest {

    private HttpRequestMethod method;
    private String uri;
    private String protocol;
    private Map<String, String> keyAndValue;
    private String body;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public HttpRequest(HttpRequestMethod method, String uri, String protocol, Map<String, String> keyAndValue, String body) {
        this.method = method;
        this.uri = uri;
        this.protocol = protocol;
        this.keyAndValue = keyAndValue;
        this.body = body;
    }

    public HttpRequestMethod getMethod() {
        return method;
    }

    public void setMethod(HttpRequestMethod method) {
        this.method = method;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Map<String, String> getKeyAndValue() {
        return keyAndValue;
    }

    public void setKeyAndValue(Map<String, String> keyAndValue) {
        this.keyAndValue = keyAndValue;
    }

    @Override
    public String toString() {
        return "HttpRequest{" +
                "method=" + method +
                ", uri='" + uri + '\'' +
                ", protocol='" + protocol + '\'' +
                ", keyAndValue=" + keyAndValue +'\''+
                ", body="+body+
                '}';
    }
}
