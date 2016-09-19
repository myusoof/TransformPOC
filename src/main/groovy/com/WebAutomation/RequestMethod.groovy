package com.WebAutomation

import org.apache.http.client.methods.HttpDelete
import org.apache.http.client.methods.HttpGet
import org.apache.http.client.methods.HttpHead
import org.apache.http.client.methods.HttpOptions
import org.apache.http.client.methods.HttpPost
import org.apache.http.client.methods.HttpPut
import org.apache.http.client.methods.HttpRequestBase
import org.apache.http.client.methods.HttpTrace

/**
 * Created by mohmedyusoof.as on 9/19/2016.
 */
public enum RequestMethod {
    OPTIONS(new HttpOptions()),
    GET(new HttpGet()),
    HEAD(new HttpHead()),
    POST(new HttpPost()),
    PUT(new HttpPut()),
    DELETE(new HttpDelete()),
    TRACE(new HttpTrace());

    private final HttpRequestBase requestMethod;

    RequestMethod(HttpRequestBase requestMethod) {
        this.requestMethod = requestMethod;
    }

    public HttpRequestBase getRequestMethod() {
        return this.requestMethod;
    }
}