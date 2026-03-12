package bai1;

public class UserValidator {
    public boolean isValidUsername(String username) {
        return !username.contains(" ") && username.length() >= 6 && username.length() <= 20;
    }
}
