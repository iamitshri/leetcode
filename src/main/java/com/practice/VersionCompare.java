package com.practice;

public class VersionCompare {

    public int compareVersionV2(String version1, String version2) {

        String[] ver1Arr = version1.split("\\.");
        String[] ver2Arr = version2.split("\\.");

        int len = Math.max(ver1Arr.length, ver2Arr.length);

        for (int i = 0; i < len; i++) {

            Integer v1 = i < ver1Arr.length ? Integer.parseInt(ver1Arr[i]) : 0;
            Integer v2 = i < ver2Arr.length ? Integer.parseInt(ver2Arr[i]) : 0;
            int r = v1.compareTo(v2);
            if (r != 0) {
                return r;
            }
        }
        return 0;
    }

    public int compareVersion(String version1, String version2) {

        String[] ver1Arr = version1.split("\\.");
        String[] ver2Arr = version2.split("\\.");
        int i = 0;
        int j = 0;

        while (i < ver1Arr.length && j < ver2Arr.length) {

            int v1 = Integer.parseInt(ver1Arr[i]);
            int v2 = Integer.parseInt(ver2Arr[j]);
            if (v1 == v2) {
                i++;
                j++;
            } else if (v1 > v2) {
                return 1;
            } else {
                return -1;
            }
        }
        if (i == ver1Arr.length && j == ver2Arr.length) {
            return 0;
        } else if (j == ver2Arr.length) {
            while (i < ver1Arr.length && Integer.parseInt(ver1Arr[i]) == 0) {
                i++;
            }
            if (i < ver1Arr.length && Integer.parseInt(ver1Arr[i]) > 0) {
                return 1;
            }

        } else if (i == ver1Arr.length) {
            while (j < ver2Arr.length && Integer.parseInt(ver2Arr[j]) == 0) {
                j++;
            }
            if (j < ver2Arr.length && Integer.parseInt(ver2Arr[j]) > 0) {
                return -1;
            }
        }

        return 0;
    }
}
