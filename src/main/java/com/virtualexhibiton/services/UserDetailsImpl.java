package com.virtualexhibiton.services;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.virtualexhibiton.model.User;
import com.virtualexhibiton.model.UserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
	
	
	@Autowired
	private static UserService user_Servcie;
	
	
    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String email;

    private String mobile;

    private String firstname;

    private String lastname;

    private byte[] profile;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long id, String email, String mobile, String firstname, String lastname, byte[] profile, String password,
                           Collection<? extends GrantedAuthority> authorities) {
        this.id = id;

        this.email = email;
        this.mobile = mobile;
        this.firstname = firstname;
        this.lastname = lastname;
        this.profile = profile;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(User user) {
    	UserRole role = user_Servcie.get(user.getUser_type_id());
//        List<GrantedAuthority> authorities =user.getRoles().stream()
//                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
//                .collect(Collectors.toList());
    	List<GrantedAuthority> authorities = new ArrayList<>();
    	authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getUser_role()));
        return new UserDetailsImpl(
                user.getId(),
                user.getEmail(),
                user.getMobile(),
                user.getFirstname(),
                user.getLastname(),
                user.getProfile(),
                user.getPassword(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public byte[] getProfile() {
        return profile;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}
