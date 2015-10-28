package com.mtjwy.website.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.mtjwy.website.repository.WebUserRepository;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
	
	@Autowired
	private WebUserRepository webUserRepository;

	@Override
	public void initialize(UniqueUsername constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		if (webUserRepository == null) {
			return true;
		}
		return webUserRepository.findByName(username) == null;
	}
	
}
