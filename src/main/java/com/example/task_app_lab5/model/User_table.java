package com.example.task_app_lab5.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class User_table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private String email;
    private  byte[] photo;
    private LocalDate createdAt;
   @Enumerated(EnumType.STRING)
    private Role role;


    @OneToMany(mappedBy = "user")
    private List<Tasks> tasks;

    public User_table(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = LocalDate.now();
    }

    public User_table() {
    }

    public void setRole(String roleUser) {
        this.role = Role.valueOf(roleUser.toUpperCase());
    }

    public enum Role {
        ADMIN, USER
    }

    public long getId() {
        return id;
    }
    public Role getRole() {
        return role;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
