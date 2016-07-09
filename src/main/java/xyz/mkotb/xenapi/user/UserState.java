package xyz.mkotb.xenapi.user;

public enum UserState {
    PENDING_CONFIRMATION("email_confirm"),
    MODERATED("moderated"),
    VALID("valid");

    private String id;

    UserState(String id) {
        this.id = id;
    }

    public static UserState byId(String id) {
        switch (id.toLowerCase()) {
            case "email_confirm":
                return PENDING_CONFIRMATION;
            case "moderated":
                return MODERATED;
            case "valid":
                return VALID;
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return id;
    }
}
