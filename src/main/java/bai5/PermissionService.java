package bai5;

public class PermissionService {
    public boolean canPerformAction(User user, Action action) {
        switch (user.getRole()) {
            case ADMIN:
                return true;

            case MODERATOR:
                return action == Action.BAN_USER ||
                        action == Action.VIEW_PROFILE;

            case USER:
                return action == Action.VIEW_PROFILE;

            default:
                return false;
        }
    }
}
