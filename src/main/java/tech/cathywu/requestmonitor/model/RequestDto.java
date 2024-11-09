package tech.cathywu.requestmonitor.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document(collection = "request_record")
public class RequestDto implements Serializable {
    private String url;
    private String method;
    private String headers;
    private Object body;
    private String clientIp;
    private String queryParam;
    private Date timestamp;

    public RequestDto() {
        this.timestamp = new Date();
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
