package com.example.http_snooper;

import java.util.ArrayList;
import java.util.List;

public class IntrospectedRequest {
    private boolean isSecure;
    private int localPort;
    private String localAddr;
    private String localName;
    private int serverPort;
    private int remotePort;
    private String remoteAddr;
    private String contextPath;
    private String servletPath;
    private String queryString;
    private final List<KeyValue> requestHeaders = new ArrayList<>();
    private final List<KeyValue> sessionAttributes = new ArrayList<>();

    public boolean isSecure() {
        return isSecure;
    }

    public void setSecure(boolean secure) {
        isSecure = secure;
    }

    public List<KeyValue> getSessionAttributes() {
        return sessionAttributes;
    }

    public void addSessionAttribute(String key, String value) {
        sessionAttributes.add(new KeyValue(key, value));
    }

    public List<KeyValue> getRequestHeaders() {
        return requestHeaders;
    }

    public void addRequestHeader(String key, String value) {
        requestHeaders.add(new KeyValue(key, value));
    }

    public int getLocalPort() {
        return localPort;
    }

    public void setLocalPort(int localPort) {
        this.localPort = localPort;
    }

    public String getLocalAddr() {
        return localAddr;
    }

    public void setLocalAddr(String localAddr) {
        this.localAddr = localAddr;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public int getRemotePort() {
        return remotePort;
    }

    public void setRemotePort(int remotePort) {
        this.remotePort = remotePort;
    }

    public String getRemoteAddr() {
        return remoteAddr;
    }

    public void setRemoteAddr(String remoteAddr) {
        this.remoteAddr = remoteAddr;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public String getServletPath() {
        return servletPath;
    }

    public void setServletPath(String servletPath) {
        this.servletPath = servletPath;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public record KeyValue(String key, String value) { }

}
