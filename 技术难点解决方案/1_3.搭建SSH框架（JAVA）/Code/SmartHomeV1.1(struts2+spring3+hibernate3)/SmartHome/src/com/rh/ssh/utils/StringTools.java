package com.rh.ssh.utils;

public class StringTools {

	public static boolean notEmpty(Object obj) {
		if (obj != null && !obj.equals("")) {
			return true;
		}
		return false;
	}

	public static boolean trimNotEmpty(Object obj) {
		if (obj != null && !obj.toString().trim().equals("")) {
			return true;
		}
		return false;
	}
}