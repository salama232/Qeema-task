package com.qeema.task.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class MyUserDetails implements UserDetails {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String email;
    private String password;
    private boolean active;
    private int session_id;
    private List<GrantedAuthority> authorities;

    public MyUserDetails(User user) {
        this.userName = user.getUsername();
        this.email=user.getEmail();
        this.password = user.getPassword();
        this.active = user.isActive();
        this.authorities = Arrays.stream(user.getRoles().split(","))
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
    }



	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
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
        return active;
    }
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public int getSession_id() {
		return session_id;
	}



	public void setSession_id(int session_id) {
		this.session_id = session_id;
	}
	
}
