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
package xyz.mkotb.xenapi.req;

import xyz.mkotb.xenapi.XenUtils;
import xyz.mkotb.xenapi.resp.BaseResponse;
import xyz.mkotb.xenapi.resp.RegisterResponse;
import xyz.mkotb.xenapi.model.UserState;

import java.util.Map;

public class RegisterRequest extends BaseRequestImpl {
    public RegisterRequest(String username, String password, String email) {
        super("register");
        set("username", username);
        set("password", password);
        set("email", email);
    }

    public String group() {
        return castGet("group", String.class);
    }

    public RegisterRequest group(String group) {
        set("group", group);
        return this;
    }

    public String gender() {
        return castGet("gender", String.class);
    }

    public RegisterRequest gender(String gender) {
        set("gender", gender);
        return this;
    }

    public String customTitle() {
        return castGet("custom_title", String.class);
    }

    public RegisterRequest customTitle(String title) {
        set("custom_title", title);
        return this;
    }

    public int styleId() {
        return castGet("style_id", int.class);
    }

    public RegisterRequest styleId(int id) {
        set("style_id", id);
        return this;
    }

    public String timezone() {
        return castGet("timezone", String.class);
    }

    public RegisterRequest timezone(String timezone) {
        set("timezone", timezone);
        return this;
    }

    public boolean visible() {
        return castGet("visible", int.class) == 1;
    }

    public RegisterRequest visible(boolean visible) {
        set("visible", visible ? 1 : 0);
        return this;
    }

    public int dayOfBirth() {
        return castGet("dob_day", int.class);
    }

    public RegisterRequest dayOfBirth(int dayOfBirth) {
        set("dob_day", dayOfBirth);
        return this;
    }

    public int monthOfBirth() {
        return castGet("dob_month", int.class);
    }

    public RegisterRequest monthOfBirth(int monthOfBirth) {
        set("dob_month", monthOfBirth);
        return this;
    }

    public int yearOfBirth() {
        return castGet("dob_year", int.class);
    }

    public RegisterRequest yearOfBirth(int yearOfBirth) {
        set("dob_year", yearOfBirth);
        return this;
    }

    public UserState userState() {
        return UserState.byId(castGet("user_state", String.class));
    }

    public RegisterRequest userState(UserState userState) {
        set("user_state", userState.toString());
        return this;
    }

    public Map<String, String> customFields() {
        String value = castGet("custom_fields", String.class);

        if (value == null) {
            return null;
        }

        return XenUtils.decodeMap(value);
    }

    public RegisterRequest customFields(Map<String, String> map) {
        set("custom_fields", XenUtils.encodeMap(map));
        return this;
    }

    public String[] addGroups() {
        return castGet("add_groups", String.class).split(",");
    }

    public RegisterRequest addGroups(String... addGroups) {
        set("add_groups", String.join(",", addGroups));
        return this;
    }

    public String ipAddress() {
        return castGet("ip_address", String.class);
    }

    public RegisterRequest ipAddress(String ipAddress) {
        set("ip_address", ipAddress);
        return this;
    }

    @Override
    public Class<? extends BaseResponse> responseClass() {
        return RegisterResponse.class;
    }
}
