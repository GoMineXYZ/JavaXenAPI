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
import xyz.mkotb.xenapi.model.LastPost;
import xyz.mkotb.xenapi.model.NodeType;

import java.util.Date;

public class NodeResponse extends BaseResponse {
    private int nodeId;
    private String title;
    private String description;
    private int depth;
    @SerializedName(value = "style_id")
    private int styleId;
    @SerializedName(value = "lft")
    private int left;
    @SerializedName(value = "rgt")
    private int right;
    @SerializedName(value = "node_name")
    private String nodeName;
    @SerializedName(value = "node_type_id")
    private String nodeType;
    @SerializedName(value = "parent_node_id")
    private int parentNodeId;
    @SerializedName(value = "display_order")
    private int displayOrder;
    @SerializedName(value = "display_in_list")
    private int displayInList;
    @SerializedName(value = "effective_style_id")
    private int effectiveStyleId;

    // link forum fields start
    @SerializedName(value = "link_url")
    private String linkUrl;
    @SerializedName(value = "redirect_count")
    private int redirectCount;
    // link forum fields end

    // page fields start
    @SerializedName(value = "publish_date")
    private long publishDate;
    @SerializedName(value = "modified_date")
    private long modifiedDate;
    @SerializedName(value = "view_count")
    private int viewCount;
    @SerializedName(value = "log_visits")
    private int logVisits;
    @SerializedName(value = "list_siblings")
    private int listSiblings;
    @SerializedName(value = "list_children")
    private int listChildren;
    @SerializedName(value = "callback_class")
    private String callbackClass;
    @SerializedName(value = "callback_method")
    private String callbackMethod;
    // page fields end

    // forum fields start
    @SerializedName(value = "discussion_count")
    private int discussionCount;
    @SerializedName(value = "message_count")
    private int messageCount;
    @SerializedName(value = "last_post_id")
    private int lastPostId;
    @SerializedName(value = "last_post_date")
    private long lastPostDate;
    @SerializedName(value = "last_post_user_id")
    private int lastPostUserId;
    @SerializedName(value = "last_post_username")
    private String lastPostUsername;
    @SerializedName(value = "last_thread_title")
    private String lastThreadTitle;
    @SerializedName(value = "moderate_messages")
    private int moderateMessages;
    @SerializedName(value = "allow_posting")
    private int allowPosting;
    @SerializedName(value = "count_messages")
    private int countMessages;
    @SerializedName(value = "find_new")
    private int findNew;
    @SerializedName(value = "prefix_cache")
    private String prefixCache;
    @SerializedName(value = "default_prefix_id")
    private int defaultPrefixId;

    private void preconditionType(NodeType required) {
        NodeType type = nodeType();
        if (type != required)
            throw new UnsupportedOperationException("This method may only " +
                    "be used for " + required.name().toLowerCase().replace("_", " ") + "! " +
                    "This node is a " +  type.name().toLowerCase().replace("_", " "));
    }

    public int nodeId() {
        return nodeId;
    }

    public String title() {
        return title;
    }

    public String description() {
        return description;
    }

    public int depth() {
        return depth;
    }

    public int styleId() {
        return styleId;
    }

    public int left() {
        return left;
    }

    public int right() {
        return right;
    }

    public String nodeName() {
        return nodeName;
    }

    public int parentNodeId() {
        return parentNodeId;
    }

    public int displayOrder() {
        return displayOrder;
    }

    public int displayInList() {
        return displayInList;
    }

    public int effectiveStyleId() {
        return effectiveStyleId;
    }

    public int redirectCount() {
        preconditionType(NodeType.LINK_FORUM);
        return redirectCount;
    }

    public String linkUrl() {
        preconditionType(NodeType.LINK_FORUM);
        return linkUrl;
    }

    public String callbackMethod() {
        preconditionType(NodeType.PAGE);
        return callbackMethod;
    }

    public String callbackClass() {
        preconditionType(NodeType.PAGE);
        return callbackClass;
    }

    public int viewCount() {
        preconditionType(NodeType.PAGE);
        return viewCount;
    }

    public boolean logVisits() {
        preconditionType(NodeType.PAGE);
        return logVisits == 1;
    }

    public boolean listSiblings() {
        preconditionType(NodeType.PAGE);
        return listSiblings == 1;
    }

    public boolean listChildren() {
        preconditionType(NodeType.PAGE);
        return listChildren == 1;
    }

    public Date publishDate() {
        preconditionType(NodeType.PAGE);
        return new Date(publishDate);
    }

    public Date modifiedDate() {
        preconditionType(NodeType.PAGE);
        return new Date(modifiedDate);
    }


    public int discussionCount() {
        preconditionType(NodeType.FORUM);
        return discussionCount;
    }

    public int messageCount() {
        preconditionType(NodeType.FORUM);
        return messageCount;
    }

    public int defaultPrefixId() {
        preconditionType(NodeType.FORUM);
        return defaultPrefixId;
    }

    public String prefixCache() {
        preconditionType(NodeType.FORUM);
        return prefixCache;
    }

    public boolean moderateMessages() {
        preconditionType(NodeType.FORUM);
        return moderateMessages == 1;
    }

    public boolean allowPosting() {
        preconditionType(NodeType.FORUM);
        return allowPosting == 1;
    }

    public boolean countMessages() {
        preconditionType(NodeType.FORUM);
        return countMessages == 1;
    }

    public boolean findNew() {
        preconditionType(NodeType.FORUM);
        return findNew == 1;
    }

    public LastPost lastPost() {
        preconditionType(NodeType.FORUM);
        return new LastPost(lastPostId, lastPostDate, lastPostUserId,
                lastPostUsername, lastThreadTitle);
    }

    public NodeType nodeType() {
        return NodeType.byId(nodeType);
    }
}
