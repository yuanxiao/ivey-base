package com.ivey.commons.utils.Validator;

import java.util.Collection;
import java.util.Map;

public class Validator {

	public static boolean isNullOrEmpty(Object obj) {
		if (obj instanceof Collection<?>) {
			return obj == null || ((Collection<?>) obj).size() == 0;
		} else if (obj instanceof Map<?, ?>) {
			return obj == null || ((Map<?, ?>) obj).isEmpty();
		} else if (obj instanceof String) {
			return obj == null || "".equals(obj);
		} else {
			return obj == null;
		}
	}

	public static boolean isNotNullOrEmpty(Object obj) {
		return !isNullOrEmpty(obj);
	}
}
