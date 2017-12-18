package com.iyb.ak.utils;

import com.iyb.ak.entity.SecUser;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Created by fanjun on 2017/7/4.
 */
public class ShaSaltSource implements SaltSource {
	@Override
	public Object getSalt(UserDetails user) {
		return ((SecUser)user).getSalt();
	}
}