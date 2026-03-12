package bai6;

import java.time.LocalDate;

public class User {
    private String username;
    private String email;
    private LocalDate birthDate;

    public User(String username, String email, LocalDate birthDate) {
        this.username = username;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}