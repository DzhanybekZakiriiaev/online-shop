package com.example.inscope.domain.auth;

import com.example.inscope.domain.user.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class CustomUser implements UserDetails {

  private final Users users;

  public CustomUser(Users users) {
    this.users = users;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singleton(new SimpleGrantedAuthority(users.getRole().toString()));
  }

  @Override
  public String getPassword() {
    return users.getPassword();
  }

  @Override
  public String getUsername() {
    return users.getUsername();
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

  public Users getUsers() {
    return users;
  }

}
