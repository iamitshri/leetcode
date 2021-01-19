package com.practice;

public class SearchInRotatedSortedArray {

    public int search(int[] a, int target) {

        int l=0;
        int h=a.length-1;

        while(l < h ){

            int mid= (l+h)/2;

            if(a[mid]>a[h]){
                l = mid + 1;
            }
            else
                h = mid;
        }

        int rot=l;
        l=0;h=a.length-1;



        while(l<= h){
            int mid = (l+h)/2;
            int realmid=(mid+rot)%a.length;

            if(a[realmid]==target)
                return realmid;
            if (a[realmid] < target)
                l = mid+1;
            else
                h=mid-1;
        }

        return -1;
    }

}
