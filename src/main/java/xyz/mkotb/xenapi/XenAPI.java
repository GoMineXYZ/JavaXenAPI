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
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.async.Callback;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import org.json.JSONObject;
import xyz.mkotb.xenapi.ex.XenAPIException;
import xyz.mkotb.xenapi.req.*;
import xyz.mkotb.xenapi.resp.*;

public class XenAPI {
    private static final Gson GSON = new Gson();
    private final String baseUrl;
    private final String apiKey;

    private XenAPI(String baseUrl, String apiKey) {
        this.baseUrl = baseUrl;
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
            http.asJsonAsync(new Callback<JsonNode>() {
                @Override
                public void completed(HttpResponse<JsonNode> httpResponse) {
                    T response;

                    try {
                        response = parseResponse(request, httpResponse.getBody().getObject());
                    } catch (XenAPIException ex) {
                        callback.error(ex);
                        return;
                    }

                    callback.callback(response);
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
                return parseResponse(request, http.asJson().getBody().getObject());
            } catch (UnirestException ex) {
                throw new RuntimeException(ex); // make better
            }
        }
    }

    private <T> T parseResponse(BaseRequestImpl request, JSONObject response) {
        if (response.has("error") && response.has("message")) {
            throw new XenAPIException(response.getInt("error"), response.getString("message"));
        }

        if (response.has("error_id") && response.has("error_phrase")) {
            throw new XenAPIException(response.getInt("error_id"), response.getString("error_phrase"));
        }

        return (T) GSON.fromJson(response.toString(), request.responseClass());
    }

    public EditUserResponse editUser(EditUserRequest request) {
        return request(request, null);
    }

    public void editUserAsync(EditUserRequest request, XenCallback<EditUserResponse> callback) {
        request(request, callback);
    }

    public RegisterResponse registerUser(RegisterRequest request) {
        return request(request, null);
    }

    public void registerUserAsync(RegisterRequest request, XenCallback<RegisterResponse> callback) {
        request(request, callback);
    }

    public AuthenticateResponse authenticate(AuthenticateRequest request) {
        return request(request, null);
    }

    public GetUserResponse getUser(GetUserRequest request) {
        return request(request, null);
    }

    public void getUserAsync(GetUserRequest request, XenCallback<GetUserResponse> callback) {
        request(request, callback);
    }

    public AddonResponse getAddon(GetAddonRequest request) {
        return request(request, null);
    }

    public void getAddonAsync(GetAddonRequest request, XenCallback<AddonResponse> callback) {
        request(request, callback);
    }

    public GetAddonsResponse getAddons(GetAddonsRequest request) {
        return request(request, null);
    }

    public void getAddonsAsync(GetAddonsRequest request, XenCallback<GetAddonsResponse> callback) {
        request(request, callback);
    }

    public GetGroupResponse getGroup(GetGroupRequest request) {
        return request(request, null);
    }

    public void getGroupAsync(GetGroupRequest request, XenCallback<GetGroupResponse> callback) {
        request(request, callback);
    }

    public NodeResponse getNode(GetNodeRequest request) {
        return request(request, null);
    }

    public void getNodeAsync(GetNodeRequest request, XenCallback<NodeResponse> callback) {
        request(request, callback);
    }

    public GetNodesResponse getNodes(GetNodesRequest request) {
        return request(request, null);
    }

    public void getNodesAsync(GetNodesRequest request, XenCallback<GetNodesResponse> callback) {
        request(request, callback);
    }
}
