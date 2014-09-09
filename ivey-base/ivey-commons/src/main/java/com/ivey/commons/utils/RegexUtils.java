package com.ivey.commons.utils;

import java.util.regex.Pattern;

/**
 * 正则表达式格式 .
 */
public class RegexUtils {

	/** email 的正则表达式 <code>{@value}</code>. */
	public static final String EMAIL = "^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";

	/** IP 的正则表达式 <code>{@value}</code>. */
	public static final String IP = "^(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)$";

	/** 电话号码 <code>{@value}</code>. */
	public static final String TELEPHONE = "^(\\d{3,4}-)?\\d{6,8}$";

	/** 手机号码 <code>{@value}</code>. */
	public static final String MOBILEPHONE = "^[1]+[3,5]+\\d{9}$";

	/** 网址Url 链接 <code>{@value}</code>. */
	public static final String URLLINK = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?";

	/** 邮政编码 <code>{@value}</code>. */
	public static final String ZIPCODE = "^\\d{6}$";

	/** 所有都是字母 <code>{@value}</code>. */
	public static final String LETTER = "^[A-Za-z]+$";

	/** 小写字母 <code>{@value}</code>. */
	public static final String LOWERCASELETTER = "^[a-z]+$";

	/** 大写字母 <code>{@value}</code>. */
	public static final String UPPERCASELETTER = "^[A-Z]+$";

	/**
	 * 两位数小数 <code>{@value}</code>
	 * 
	 * <pre>
	 * 可以是200 也可以是200.00 不可以是 200.0
	 * </pre>
	 */
	public static final String DECIMAL_TWODIGIT = "^[0-9]+(.[0-9]{2})?$";

	/** 纯数字 <code>{@value}</code>. */
	public static final String NUMBER = "^[0-9]*$";

	// alpha numeric space
	/**
	 * 字母和数字 (alpha numeric) <code>{@value}</code>
	 */
	public static final String AN = "^[0-9a-zA-Z]+$";

	/**
	 * 字母和数字和空格(alpha numeric space)<code>{@value}</code>
	 */
	public static final String ANS = "^[0-9a-zA-Z ]+$";

	public static boolean matches(String regex, CharSequence input) {
		return Pattern.matches(regex, input);
	}

}