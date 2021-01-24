package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*this solution is not working*/
public class PermutationsII {

	ArrayList<Integer> intArr = new ArrayList<Integer>();
	HashMap<Integer, ArrayList<Integer>> levelmemory = new HashMap<Integer, ArrayList<Integer>>();

	/**
	 * Given a collection of numbers that might contain duplicates, return all
	 * possible unique permutations.
	 * 
	 * For example, [1,1,2] have the following unique permutations: [1,1,2],
	 * [1,2,1], and [2,1,1].
	 * 
	 * 
	 * @param num
	 * @return
	 */
	public List<List<Integer>> permute(int[] num) {

		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();

		if (num == null || num.length == 0)
			return result;

		boolean[] used = new boolean[num.length];
		int level = 0;
		return permuteuniqueHelper(num, result, used, level);

	}

	public ArrayList<List<Integer>> permuteuniqueHelper(int[] num, ArrayList<List<Integer>> result, boolean[] used,
			int level) {

		if (intArr.size() == num.length) {
			result.add((List<Integer>) intArr.clone());
			return result;
		}

		for (int i = 0; i < num.length; i++) {

			if (used[i])
				continue;

			ArrayList<Integer> levelList = levelmemory.get(level);

			if (levelList == null) {

				levelList = new ArrayList<Integer>();
				levelList.add(num[i]);
				levelmemory.put(level, levelList);

			} else if (levelList.contains(num[i])) {

				continue;
			}

			intArr.add(num[i]);
			used[i] = true;

			result = permuteuniqueHelper(num, result, used, level + 1);

			used[i] = false;
			intArr.remove(intArr.size() - 1);

		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PermutationsII p = new PermutationsII();
		List<List<Integer>> res = p.permute(new int[] { 1, 1, 2 });
		for (List<Integer> list : res) {
			for (Integer integer : list) {
				System.out.print(integer);
			}
			System.out.println();

		}
	}

}
