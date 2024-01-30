package com.virtualexhibiton.model;

import jakarta.persistence.*;
import java.util.*;

import lombok.*;

@Data
@Builder
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String firstname;
    private String lastname;
    private String email;
    private String password;

    @Column(name = "Contact")
    private String mobile;

    @Lob
    @Column(name = "Profile picture", columnDefinition = "LONGBLOB")
    private byte[] profile;


    @ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;

    public User(String firstname, String lastname, String email, String password, String mobile, byte [] profile) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.profile = profile;
    }



}
