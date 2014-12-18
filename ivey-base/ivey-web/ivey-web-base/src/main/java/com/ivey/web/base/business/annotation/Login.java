package com.ivey.web.base.business.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Login {
	Authrity level() default Authrity.MEMBER;

	public enum Authrity {
		MEMBER, SELLER, OPERATIOR
	}
}
