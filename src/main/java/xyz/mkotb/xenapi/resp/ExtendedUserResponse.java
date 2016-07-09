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

import java.util.Date;

public class ExtendedUserResponse extends UserResponse {
    @SerializedName(value = "secondary_group_ids")
    private String secondaryGroupIds;
    @SerializedName(value = "display_style_group_id")
    private int displayStyleGroupId;
    @SerializedName(value = "permission_combination_id")
    private int permissionCombinationId;
    @SerializedName(value = "message_count")
    private int messageCount;
    @SerializedName(value = "conversations_unread")
    private int unreadConversations;
    @SerializedName(value = "register_date")
    private long registerDate;
    @SerializedName(value = "last_activity")
    private long lastActivity;
    @SerializedName(value = "alerts_unread")
    private int unreadAlerts;
    @SerializedName(value = "avatar_date")
    private long avatarDate;
    @SerializedName(value = "avatar_width")
    private int avatarWidth;
    @SerializedName(value = "avatar_height")
    private int avatarHeight;
    @SerializedName(value = "gravatar")
    private String gravatar;
    @SerializedName(value = "is_moderator")
    private int moderator;
    @SerializedName(value = "is_admin")
    private int admin;
    @SerializedName(value = "is_banned")
    private int banned;
    @SerializedName(value = "like_count")
    private int likeCount;
    @SerializedName(value = "warning_points")
    private int warningPoints;

    public boolean isModerator() {
        return moderator == 1;
    }

    public boolean isAdmin() {
        return admin == 1;
    }

    public boolean isBanned() {
        return banned == 1;
    }

    public Date avatarDate() {
        return new Date(avatarDate);
    }

    public Date lastActivity() {
        return new Date(lastActivity);
    }

    public Date registerDate() {
        return new Date(registerDate);
    }

    public String[] secondaryGroupIds() {
        return secondaryGroupIds.split(",");
    }

    public int displayStyleGroupId() {
        return displayStyleGroupId;
    }

    public int permissionCombinationId() {
        return permissionCombinationId;
    }

    public int messageCount() {
        return messageCount;
    }

    public int unreadConversations() {
        return unreadConversations;
    }

    public int unreadAlerts() {
        return unreadAlerts;
    }

    public int avatarWidth() {
        return avatarWidth;
    }

    public int avatarHeight() {
        return avatarHeight;
    }

    public String gravatar() {
        return gravatar;
    }

    public int likeCount() {
        return likeCount;
    }

    public int warningPoints() {
        return warningPoints;
    }
}
