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
import xyz.mkotb.xenapi.resp.EditUserResponse;
import xyz.mkotb.xenapi.model.UserState;

import java.util.Map;

public class EditUserRequest extends BaseRequestImpl {
    public EditUserRequest(String user) {
        super("editUser");
        set("user", user);
    }

    public String username() {
        return castGet("username", String.class);
    }

    public EditUserRequest name(String name) {
        set("username", name);
        return this;
    }

    public String password() {
        return castGet("password", String.class);
    }

    public EditUserRequest password(String password) {
        set("password", password);
        return this;
    }

    public String email() {
        return castGet("email", String.class);
    }

    public EditUserRequest email(String email) {
        set("email", email);
        return this;
    }

    public String group() {
        return castGet("group", String.class);
    }

    public EditUserRequest group(String group) {
        set("group", group);
        return this;
    }

    public String gender() {
        return castGet("gender", String.class);
    }

    public EditUserRequest gender(String gender) {
        set("gender", gender);
        return this;
    }

    public String customTitle() {
        return castGet("custom_title", String.class);
    }

    public EditUserRequest customTitle(String title) {
        set("custom_title", title);
        return this;
    }

    public int styleId() {
        return castGet("style_id", int.class);
    }

    public EditUserRequest styleId(int id) {
        set("style_id", id);
        return this;
    }

    public String timezone() {
        return castGet("timezone", String.class);
    }

    public EditUserRequest timezone(String timezone) {
        set("timezone", timezone);
        return this;
    }

    public boolean visible() {
        return castGet("visible", int.class) == 1;
    }

    public EditUserRequest visible(boolean visible) {
        set("visible", visible ? 1 : 0);
        return this;
    }

    public int dayOfBirth() {
        return castGet("dob_day", int.class);
    }

    public EditUserRequest dayOfBirth(int dayOfBirth) {
        set("dob_day", dayOfBirth);
        return this;
    }

    public int monthOfBirth() {
        return castGet("dob_month", int.class);
    }

    public EditUserRequest monthOfBirth(int monthOfBirth) {
        set("dob_month", monthOfBirth);
        return this;
    }

    public int yearOfBirth() {
        return castGet("dob_year", int.class);
    }

    public EditUserRequest yearOfBirth(int yearOfBirth) {
        set("dob_year", yearOfBirth);
        return this;
    }

    public UserState userState() {
        return UserState.byId(castGet("user_state", String.class));
    }

    public EditUserRequest userState(UserState userState) {
        set("user_state", userState.toString());
        return this;
    }

    public Map<String, String> customFields() {
        String[] value = (String[]) get("custom_fields");

        if (value == null) {
            return null;
        }

        return XenUtils.decodeMap(value);
    }

    public EditUserRequest customFields(Map<String, String> map) {
        set("custom_fields", XenUtils.encodeMap(map));
        return this;
    }

    public String[] addGroups() {
        return castGet("add_groups", String.class).split(",");
    }

    public EditUserRequest addGroups(String... addGroups) {
        set("add_groups", String.join(",", addGroups));
        return this;
    }

    public String[] removeGroups() {
        return castGet("remove_groups", String.class).split(",");
    }

    public EditUserRequest removeGroups(String... removeGroups) {
        set("remove_groups", String.join(",", removeGroups));
        return this;
    }

    public int trophyPoints() {
        return castGet("trophy_points", int.class);
    }

    public EditUserRequest trophyPoints(int trophyPoints) {
        set("trophy_points", trophyPoints);
        return this;
    }

    @Override
    public Class<? extends BaseResponse> responseClass() {
        return EditUserResponse.class;
    }
}
