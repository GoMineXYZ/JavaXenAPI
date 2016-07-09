/*
 * Copyright (c) 2016, Mazen Kotb, mazenkotb@gmail.com
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
package xyz.mkotb.xenapi;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import xyz.mkotb.xenapi.req.BaseRequestImpl;

import java.net.MalformedURLException;
import java.net.URL;

public final class XenAPI {
    private static final Gson GSON = new Gson();
    private final String baseUrl;
    private final String apiKey;

    private XenAPI(String baseUrl, String apiKey) {
        try {
            this.baseUrl = "https://" + new URL(baseUrl).getHost() + "/api.php";
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        this.apiKey = apiKey;
    }

    public static XenAPI create(String baseUrl, String apiKey) {
        return new XenAPI(baseUrl, apiKey);
    }

    private <T> T request(BaseRequestImpl request, XenCallback<T> callback) {
        HttpRequest http = Unirest.get(baseUrl)
                .queryString("hash", apiKey)
                .queryString(request.fieldMap());

        if (callback != null) {
            http.asStringAsync(new Callback<String>() {
                @Override
                public void completed(HttpResponse<String> httpResponse) {
                    callback.callback(parseResponse(request, httpResponse.getBody()));
                }

                @Override
                public void failed(UnirestException e) {
                    throw new RuntimeException(e);
                }

                @Override
                public void cancelled() {
                    // no
                }
            });
            return null;
        } else {
            try {
                return parseResponse(request, http.asString().getBody());
            } catch (UnirestException ex) {
                throw new RuntimeException(ex); // make better
            }
        }
    }

    private <T> T parseResponse(BaseRequestImpl request, String response) {
        return (T) GSON.fromJson(response, request.responseClass());
    }
}
