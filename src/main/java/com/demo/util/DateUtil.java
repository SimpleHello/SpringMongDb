package com.demo.util;

/**
 * *****************************************************
 * Copyright (C) Kongtrolink techology Co.ltd - All Rights Reserved
 *
 * This file is part of Kongtrolink techology Co.Ltd property.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 ******************************************************
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mosaico
 */
public class DateUtil {

	private static DateUtil instance;
	private final SimpleDateFormat defaultFormat;

	public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

	private DateUtil() {
		defaultFormat = new SimpleDateFormat(DEFAULT_PATTERN);
	}

	public static DateUtil getInstance() {
		if (instance == null) {
			instance = new DateUtil();
		}
		return instance;
	}

	public String format(Date date) {
		return defaultFormat.format(date);
	}

	public String format(Date date, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}

	public Date parse(String resource) {
		Date date = null;
		try {
			date = defaultFormat.parse(resource);
		} catch (ParseException ex) {
			Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, ex);
		}
		return date;
	}

	public Date parse(String resource, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = format.parse(resource);
		} catch (ParseException ex) {
			Logger.getLogger(DateUtil.class.getName()).log(Level.SEVERE, null, ex);
		}
		return date;
	}

}
