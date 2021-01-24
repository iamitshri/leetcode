package com.practice;

/*this solution is not working*/
public class MedianofTwoSortedArrays {

	/**
	 * There are two sorted arrays A and B of size m and n respectively. Find
	 * the median of the two sorted arrays. The overall run time complexity
	 * should be O(log (m+n)).
	 */
	public double findMedianSortedArrays(int a[], int b[]) {

		if (a != null && b != null) {
			return findMedianSortedArrays(a, 0, a.length - 1, b, 0, b.length - 1);
		}

		return 0.0;
	}

	public double findMedianSortedArrays(int a[], int astart, int aend, int b[], int bstart, int bend) {
		double amed = 0.0, bmed = 0.0, med = 0.0;
		if (a == null || a.length == 0) {
			return findmedianofArray(b, bstart, bend);

		}
		if (b == null || b.length == 0) {
			return findmedianofArray(a, astart, aend);

		}

		if (aend == astart && bend == bstart)
			return (a[astart] + b[bstart]) / 2.0;

		if (aend == astart) {

			if ((bend - bstart + 1) % 2 != 0) {
				// If the larger array has odd number of elements, then consider
				// the middle 3 elements of larger array and the only element of
				// smaller array. Take few examples like following
				// A = {9}, B[] = {5, 8, 10, 20, 30} and
				// A[] = {1}, B[] = {5, 8, 10, 20, 30}
				return (b[(bstart + bend) / 2]
						+ findmedianof3(a[astart], b[(bstart + bend) / 2 - 1], b[(bstart + bend) / 2 + 1])) / 2.0;
			} else {
				// Case 3: If the larger array has even number of element, then
				// median
				// will be one of the following 3 elements
				// ... The middle two elements of larger array
				// ... The only element of smaller array
				return findmedianof3(b[(bstart + bend) / 2], b[(bstart + bend + 1) / 2], a[astart]);
			}

		}

		if (bend == bstart) {
			if ((aend - astart + 1) % 2 != 0) {
				return (a[(astart + aend) / 2]
						+ findmedianof3(b[bstart], a[(astart + aend) / 2 - 1], a[(astart + aend) / 2 + 1])) / 2.0;
			} else {
				return findmedianof3(a[(astart + aend) / 2], a[(astart + aend + 1) / 2], b[bstart]);
			}

		}

		if (aend - astart == 1 && bend - bstart == 1) {
			return (Math.max(a[astart], b[bstart]) + Math.min(a[aend], b[bend])) / 2.0;
		}

		amed = findmedianofArray(a, astart, aend);
		bmed = findmedianofArray(b, bstart, bend);

		if (amed == bmed)
			return amed;
		else if (amed > bmed) {

			if ((bend - bstart + 1) % 2 == 0) {
				med = findMedianSortedArrays(a, astart, (astart + aend) / 2, b, (bstart + bend + 1) / 2, bend);
			} else {
				med = findMedianSortedArrays(a, astart, (astart + aend) / 2, b, (bstart + bend) / 2, bend);
			}

		} else {

			if ((aend - astart + 1) % 2 == 0) {
				med = findMedianSortedArrays(a, (astart + aend + 1) / 2, aend, b, bstart, (bstart + bend) / 2);
			} else
				med = findMedianSortedArrays(a, (astart + aend) / 2, aend, b, bstart, (bstart + bend) / 2);

		}

		return med;
	}

	/**
	 * @param b
	 * @param bstart
	 * @param bend
	 */
	private double findmedianofArray(int[] b, int bstart, int bend) {
		double bmed;
		if ((bend - bstart + 1) % 2 == 0) {
			bmed = (b[((bend + bstart) / 2)] + b[((bend + bstart + 1) / 2)]) / 2.0;
		} else {
			bmed = (b[((bend + bstart) / 2)]);
		}
		return bmed;
	}

	float findmedianof3(int a, int b, int c) {
		return a + b + c - Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MedianofTwoSortedArrays m = new MedianofTwoSortedArrays();
		System.out.print(m.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4, 5, 6 }));
	}

}
