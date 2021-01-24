package com.practice;

public class MapNode {

	String key;
	String value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public MapNode(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

}
