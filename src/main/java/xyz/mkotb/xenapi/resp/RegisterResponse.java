package xyz.mkotb.xenapi.resp;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse extends BaseResponse {
    private String username;
    private String email;
    private String timezone;
    private String gender;
    private int visible;
    @SerializedName(value = "user_group_id")
    private int userGroupId;
    @SerializedName(value = "user_state")
    private String userState;
    @SerializedName(value = "language_id")
    private int languageId;
    @SerializedName(value = "style_id")
    private int styleId;
    @SerializedName(value = "secondary_group_ids")
    private String secondaryGroupIds;
    @SerializedName(value = "display_style_group_id")
    private int displayStyleGroupId;
    // TODO finish
}
