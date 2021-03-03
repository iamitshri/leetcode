package com.practice.array;

public class MajorityElement {

    static int majorityElement(int a[], int size) {

        // find the candidate element
        int cnt = 1;
        int major = a[0];
        for (int i = 1; i < size; i++) {
            if (cnt == 0) {
                major = a[i];
                cnt = 1;
            } else if (major == a[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }

        // check if the candidate is actually majority element
        int num = 0;
        for (int i = 0; i < size; i++) {
            if (a[i] == major) {
                num++;
            }
        }
        return num > size / 2 ? major : -1;

    }
}
