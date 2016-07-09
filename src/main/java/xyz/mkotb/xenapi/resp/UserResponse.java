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
package xyz.mkotb.xenapi.resp;

import com.google.gson.annotations.SerializedName;
import xyz.mkotb.xenapi.XenUtils;
import xyz.mkotb.xenapi.user.UserState;

import java.util.Date;
import java.util.Map;

public class UserResponse extends BaseResponse {
    private String username;
    private String password;
    private String email;
    private String group;
    private String gender;
    @SerializedName(value = "custom_title")
    private String customTitle;
    @SerializedName(value = "style_id")
    private String styleId;
    private String timezone;
    private int visible;
    @SerializedName(value = "dob_day")
    private int dayOfBirth;
    @SerializedName(value = "dob_month")
    private int monthOfBirth;
    @SerializedName(value = "dob_year")
    private int yearOfBirth;
    private String state;
    @SerializedName(value = "custom_fields")
    private String customFields;
    @SerializedName("add_groups")
    private String addGroups;
    @SerializedName("remove_groups")
    private String removeGroups;

    public String username() {
        return username;
    }

    public String password() {
        return password;
    }

    public String email() {
        return email;
    }

    public String group() {
        return group;
    }

    public String gender() {
        return gender;
    }

    public String customTitle() {
        return customTitle;
    }

    public String styleId() {
        return styleId;
    }

    public String timezone() {
        return timezone;
    }

    public boolean visible() {
        return visible == 1;
    }

    public int dayOfBirth() {
        return dayOfBirth;
    }

    public int monthOfBirth() {
        return monthOfBirth;
    }

    public int yearOfBirth() {
        return yearOfBirth;
    }

    public UserState state() {
        return UserState.byId(state);
    }

    public Map<String, String> customFields() {
        return XenUtils.decodeMap(customFields);
    }

    public String[] addGroups() {
        return addGroups.split(",");
    }

    public String[] removeGroups() {
        return removeGroups.split(",");
    }
}
