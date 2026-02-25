package com.trupti.service;

import org.springframework.stereotype.Service;

@Service
public class VerifyUserImpl implements VerifyUser {
	@Override
	public String verifyUser(String id) {
		return "verified";
	}
}
