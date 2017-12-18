package com.iyb.ak.security;


import com.google.common.collect.Sets;
import com.iyb.ak.entity.SecUser;
import com.iyb.ak.entity.User;
import com.iyb.ak.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 实现SpringSecurity的UserDetailsService接口,实现获取用户Detail信息的回调函数.
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	private Logger logger = LoggerFactory.getLogger(getClass());


	@Autowired
	UserMapper userMapper;

	/**
	 * 获取用户Details信息的回调函数.
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

		User user = new User();
		user.setMobile(username);
		user = userMapper.selectOne(user);

		if (user == null) {
			throw new UsernameNotFoundException("用户" + username + " 不存在");
		}

		Collection<GrantedAuthority> grantedAuths = Sets.newHashSet();//obtainGrantedAuthorities(user);

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = enabled;

		SecUser userdetails = new SecUser(user.getUuid(), user.getMobile(), user.getPassword(), user.getSalt(), user.getName(),
				enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);

		return userdetails;
	}

	/**
	 * 获得用户所有角色的权限集合.
	 */
//	private Collection<GrantedAuthority> obtainGrantedAuthorities(LoginUserDto user) {
//		Collection<GrantedAuthority> authSet = Sets.newHashSet();
//
//		Result<List<RoleDto>> req = userClient.getRoles(user.getUuid());
//		if(!req.getSuccess()) logger.warn("getRoles error:" + req.getMessage());
//		List<RoleDto> roles = req.getData();
//		for (RoleDto role : roles) {
//			authSet.add(new SimpleGrantedAuthority(role.getRoleCode()));
//		}
//		return authSet;
//	}
}
