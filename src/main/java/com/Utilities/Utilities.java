package com.Utilities;

import java.util.Map;
import java.util.Map.Entry;

import com.jayway.jsonpath.JsonPath;

public class Utilities {

	public <K, V> K getFirstKeyinHashMap(Map<K, V> hmap) {
		Entry<K, V> entry = hmap.entrySet().iterator().next();
		return entry.getKey();
	}

	public <K, V> V getFirstValueinHashMap(Map<K, V> hmap) {
		Entry<K, V> entry = hmap.entrySet().iterator().next();
		return entry.getValue();
	}
	
	public String getValueJson(String json, String key) {
		return JsonPath.parse(json).read(key).toString();
	}
	
	public int getIntegerValueJson(String json, String key) {
		return JsonPath.parse(json).read(key);
	}

}
