package com.practice;

import java.util.LinkedList;

public class HashMapDS {

	Object[] mapArr = new Object[10];

	void put(String key, String val) {
		int hc = getHashCodeFromKey(key);

		// MAp it to array index
		LinkedList<MapNode> ll = new LinkedList<MapNode>();
		if (mapArr[hc] == null) {
			mapArr[hc] = ll;
		} else {
			ll = (LinkedList<MapNode>) mapArr[hc];
		}
		boolean foundExistingKey = false;
		if (ll != null) {
			for (MapNode mn : ll) {
				if (key.equalsIgnoreCase(mn.getKey())) {
					mn.setValue(val);
					foundExistingKey = true;
					break;
				}

			}
			if (!foundExistingKey) {
				ll.add(new MapNode(key, val));
			}
		}

		// Add entry to map with value being link list

	}

	private int getHashCodeFromKey(String key) {

		return 1;
	}

	String get(String key) {

		String ret = null;
		// look up key in arr
		// get arr entry which is ll of nodes

		int hc = getHashCodeFromKey(key);

		// MAp it to array index
		LinkedList<MapNode> ll = new LinkedList<MapNode>();
		if (mapArr[hc] != null) {
			ll = (LinkedList<MapNode>) mapArr[hc];
			for (MapNode mn : ll) {
				if (key.equalsIgnoreCase(mn.getKey())) {
					ret = mn.getValue();
					break;
				}

			}

		}
		return ret;

	}

	public static void main(String[] s) {
		HashMapDS hm = new HashMapDS();
		hm.put("check", "This out");
		hm.put("check", "This");

		System.out.println(hm.get("check"));
	}

}
