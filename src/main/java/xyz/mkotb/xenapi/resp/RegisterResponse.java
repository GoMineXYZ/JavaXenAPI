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
import xyz.mkotb.xenapi.user.UserAccessible;

import java.util.Date;

public class RegisterResponse extends ExtendedUserResponse {
    private String status;
    private String signature;
    private String homepage;
    private String location;
    private String occupation;
    private String following;
    private String ignored;
    private String about;
    private String data;
    @SerializedName(value = "user_group_id")
    private int userGroupId;
    @SerializedName(value = "language_id")
    private int languageId;
    @SerializedName(value = "trophy_points")
    private int trophyPoints;
    @SerializedName(value = "user_id")
    private int userId;
    @SerializedName(value = "csrf_token")
    private String csrfToken;
    @SerializedName(value = "status_date")
    private long statusDate;
    @SerializedName(value = "status_profile_post_id")
    private int statusProfilePostId;
    @SerializedName(value = "avatar_crop_x")
    private int avatarCropX;
    @SerializedName(value = "avatar_crop_y")
    private int avatarCropY;
    @SerializedName(value = "facebook_auth_id")
    private long facebookAuthId;
    @SerializedName(value = "content_show_signature")
    private int showSignature;
    @SerializedName(value = "show_dob_date")
    private int showDateOfBirth;
    @SerializedName(value = "show_dob_year")
    private int showYearOfBirth;
    @SerializedName(value =  "receive_admin_email")
    private int receiveAdminEmail;
    @SerializedName(value = "email_on_conversation")
    private int emailOnConversation;
    @SerializedName(value = "default_watch_state")
    private String defaultWatchState; // TODO make an enum
    @SerializedName(value = "is_discouraged")
    private int discouraged;
    @SerializedName(value = "alert_optout")
    private String alertOptOut;
    @SerializedName(value = "enable_rte")
    private int rteEnabled;
    @SerializedName(value = "allow_view_profile")
    private String allowViewProfile;
    @SerializedName(value = "allow_post_profile")
    private String allowPostProfile;
    @SerializedName(value = "allow_receive_news_feed")
    private String allowReceiveNewsFeed;
    @SerializedName(value = "allow_send_personal_conversation")
    private String allowPm;
    @SerializedName(value = "allow_view_identities")
    private String allowViewIdentities;
    @SerializedName(value = "remember_key")
    private String rememberKey;

    public UserAccessible allowViewProfile() {
        return UserAccessible.valueOf(allowViewProfile.toUpperCase());
    }

    public UserAccessible allowPostProfile() {
        return UserAccessible.valueOf(allowPostProfile.toUpperCase());
    }

    public UserAccessible allowReceiveNewsFeed() {
        return UserAccessible.valueOf(allowReceiveNewsFeed.toUpperCase());
    }

    public UserAccessible allowPersonalMessaging() {
        return UserAccessible.valueOf(allowPm);
    }

    public UserAccessible allowViewIdentities() {
        return UserAccessible.valueOf(allowViewIdentities);
    }

    public boolean rteEnabled() {
        return rteEnabled == 1;
    }

    public boolean isDiscouraged() {
        return discouraged == 1;
    }

    public boolean emailOnConversation() {
        return emailOnConversation == 1;
    }

    public boolean receiveAdminEmail() {
        return receiveAdminEmail == 1;
    }

    public boolean showYearOfBirth() {
        return showYearOfBirth == 1;
    }

    public boolean showDateOfBirth() {
        return showDateOfBirth == 1;
    }

    public boolean showSignature() {
        return showSignature == 1;
    }

    public Date statusDate() {
        return new Date(statusDate);
    }

    public String status() {
        return status;
    }

    public String signature() {
        return signature;
    }

    public String homepage() {
        return homepage;
    }

    public String location() {
        return location;
    }

    public String occupation() {
        return occupation;
    }

    public String following() {
        return following;
    }

    public String ignored() {
        return ignored;
    }

    public String about() {
        return about;
    }

    public String data() {
        return data;
    }

    public int userGroupId() {
        return userGroupId;
    }

    public int languageId() {
        return languageId;
    }

    public int trophyPoints() {
        return trophyPoints;
    }

    public int userId() {
        return userId;
    }

    public String csrfToken() {
        return csrfToken;
    }

    public int statusProfilePostId() {
        return statusProfilePostId;
    }

    public int avatarCropX() {
        return avatarCropX;
    }

    public int avatarCropY() {
        return avatarCropY;
    }

    public long facebookAuthId() {
        return facebookAuthId;
    }

    public String defaultWatchState() {
        return defaultWatchState;
    }

    public int discouraged() {
        return discouraged;
    }

    public String alertOptOut() {
        return alertOptOut;
    }

    public String rememberKey() {
        return rememberKey;
    }
}
