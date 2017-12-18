package com.iyb.ak.security.crypto.hash;

import com.iyb.ak.security.codec.ByteSource;
import com.iyb.ak.utils.encode.EncodeUtils;
import org.springframework.security.authentication.encoding.PasswordEncoder;

/**
 * Created by fanjun on 2017/7/4.
 */
public class ShaPasswordEncoder implements PasswordEncoder {
	public static final String HASH_ALGORITHM = "SHA-256";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;

	@Override
	public String encodePassword(String rawPass, Object salt) {
		if(salt == null) return null;
		SimpleHash hash = new SimpleHash(HASH_ALGORITHM, rawPass, ByteSource.Util.bytes(EncodeUtils.hexDecode((String) salt)), HASH_INTERATIONS);
		return hash.toHex();
	}

	@Override
	public boolean isPasswordValid(String encPass, String rawPass, Object salt) {
		SimpleHash hash = new SimpleHash(HASH_ALGORITHM, rawPass, ByteSource.Util.bytes(EncodeUtils.hexDecode((String) salt)), HASH_INTERATIONS);
		String hex = hash.toHex();
		return hex.equals(encPass);
	}

}