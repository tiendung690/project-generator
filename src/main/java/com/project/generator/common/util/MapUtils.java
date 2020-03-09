package com.project.generator.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUtils {

	public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws Exception {
		if (map == null)
			return null;

		Object obj = beanClass.newInstance();

		Field[] fields = obj.getClass().getDeclaredFields();

		for (Field field : fields) {
			int mod = field.getModifiers();

			if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
				continue;
			}
			field.setAccessible(true);

			field.set(obj, map.get(field.getName()));
		}

		return obj;
	}

	public static Map<String, Object> objectToMap(Object obj, String... ignoreChars) throws Exception {
		if (obj == null) {
			return null;
		}
		List<String> list = new ArrayList<>();
		if (ignoreChars.length > 0) {
			list = Arrays.asList(ignoreChars);
		}
		Map<String, Object> map = new HashMap<String, Object>();

		Class clazz = obj.getClass();
		List<Field> fieldList = new ArrayList<>();

		while (clazz != null) {
			fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
			clazz = clazz.getSuperclass();
		}

		for (Field field : fieldList) {
			field.setAccessible(true);
			if (list.contains(field.getName())) {
				continue;
			}
			map.put(field.getName(), field.get(obj));
		}

		return map;
	}
}
