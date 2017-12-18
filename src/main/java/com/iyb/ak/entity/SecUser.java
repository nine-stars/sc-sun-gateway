package com.iyb.ak.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = true)
public class SecUser extends User {
    private String uuid;
    private String mobile;
    private String salt;
    private String showName;
    private boolean enabled = Boolean.TRUE;

    public SecUser(String uuid, String mobile, String password, String salt, String showName,
                   boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired,
                   boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(mobile, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.uuid = uuid;
        this.mobile = mobile;
        this.salt = salt;
        this.showName = showName;
    }

}