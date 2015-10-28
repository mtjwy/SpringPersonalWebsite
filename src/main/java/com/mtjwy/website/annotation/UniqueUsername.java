package com.mtjwy.website.annotation;


import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//http://docs.spring.io/spring/docs/4.2.2.BUILD-SNAPSHOT/spring-framework-reference/htmlsingle/#validation-beanvalidation-spring-method
@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = {UniqueUsernameValidator.class })
public @interface UniqueUsername {
	
	String message();

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
}
