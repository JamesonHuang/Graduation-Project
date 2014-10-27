package com.rh.ssh.utils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

public class BeanTools {

	public static void checkListItem(List list) throws Exception {
		if (list == null || list.size() == 0) {
			throw new Exception("List isEmpty");
		}
		for (int i = list.size() - 1; i >= 0; i--) {
			if (!notNull(list.get(i))) {
				list.remove(i);
			}
		}
		if (list.size() == 0) {
			throw new Exception("List isEmpty");
		}
	}

	private static boolean notNull(Object obj) {
		if (obj == null) {
			return false;
		}
		boolean notNull = false;
		boolean fieldAccess = false;
		Field[] fields = null;
		Field field = null;
		Class type = null;
		for (Class clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
			fields = clazz.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				field = fields[i];
				type = field.getType();
				if (!notNull && !field.getName().equals("serialVersionUID") && !type.equals(Set.class)) {
					fieldAccess = field.isAccessible();
					if (!fieldAccess) {
						field.setAccessible(true);
					}
					try {
						if (field.get(obj) != null) {
							notNull = true;
							field.setAccessible(fieldAccess);
							break;
						}
					} catch (Exception e) {}
					field.setAccessible(fieldAccess);
				}
			}
		}
		return notNull;
	}
}