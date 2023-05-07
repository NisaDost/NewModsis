package com.NewModsis.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = true, length = 50)
    private String firstName;

    @Column(nullable = false, length = 50)
    private String lastName;


    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    public UserEntity(Long id, String firstName, String lastName, String email, String encryptedPassword) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = encryptedPassword;
    }

    public UserEntity() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String encryptedPassword) {
        this.password = encryptedPassword;
    }

    public Long getId() {
        return id;
    }

    public  String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
