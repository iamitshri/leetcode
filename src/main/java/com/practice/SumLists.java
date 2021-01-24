package com.practice;

import java.util.LinkedList;

public class SumLists {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;
		if (l1 == null)
			return l2;

		if (l2 == null)
			return l1;

		String l1Str = "", l2Str = "";
		ListNode temp = l1;
		while (temp != null) {
			l1Str += temp.val;
			temp = temp.next;
		}
		l1Str = reverse(l1Str);
		int l1Num = Integer.parseInt(l1Str);
		temp = l2;
		while (temp != null) {
			l2Str += temp.val;
			temp = temp.next;
		}
		l2Str = reverse(l2Str);
		int l2Num = Integer.parseInt(l2Str);

		int resultNum = l1Num + l2Num;

		ListNode head = new ListNode(0);
		result = head;
		while (resultNum > 0) {
			ListNode node = new ListNode(resultNum % 10);
			result.next = node;
			result = result.next;
			resultNum = resultNum / 10;
		}
		/*
		 * String resultStr = String.valueOf(resultNum); resultStr =
		 * reverse(resultStr);
		 */
		return head.next;

	}

	static String reverse(String input) {
		if (input == null)
			return null;
		String result = null;
		char[] chars = input.toCharArray();
		int i = 0, end = chars.length - 1;
		Character temp;
		while (i < end) {
			temp = chars[i];
			chars[i] = chars[end];
			chars[end] = temp;
			i++;
			end--;
		}
		result = new String(chars);
		return result;
	}

	/**
	 * You are given two non-empty linked lists representing two non-negative
	 * integers. The digits are stored in reverse order and each of their nodes
	 * contain a single digit. Add the two numbers and return it as a linked
	 * list.
	 * 
	 * You may assume the two numbers do not contain any leading zero, except
	 * the number 0 itself.
	 * 
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
	 * 
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbersRecursive(ListNode l1, ListNode l2) {
		return addTwoNumbersHelper(l1, l2, 0, null);
	}

	private static ListNode addTwoNumbersHelper(ListNode l1, ListNode l2, int carry, ListNode resultLst) {

		ListNode nextl1 = null;
		ListNode nextl2 = null;
		int term1 = 0;
		int term2 = 0;

		if (l1 == null) {
			term1 = 0;
		} else {
			term1 = l1.val;
			nextl1 = l1.next;
		}

		if (l2 == null) {
			term2 = 0;
		} else {
			term2 = l2.val;
			nextl2 = l2.next;
		}

		int sum = term1 + term2 + carry;

		if (sum >= 10) {
			carry = sum / 10;
			sum = sum % 10;
		} else {
			carry = 0;
		}

		ListNode resultNode = new ListNode(sum);
		resultLst = addToEnd(resultLst, resultNode);
		if (nextl1 == null && nextl2 == null) {
			if (carry > 0) {
				resultLst = addToEnd(resultLst, new ListNode(carry));
			}
			return resultLst;
		}
		return addTwoNumbersHelper(nextl1, nextl2, carry, resultLst);
	}

	static ListNode addToEnd(ListNode resultNode, ListNode newNode) {

		if (newNode == null && resultNode == null) {
			return null;
		}
		if (newNode == null) {
			return resultNode;
		}
		newNode.next = null;

		if (resultNode == null) {
			return newNode;
		}

		ListNode temp = resultNode;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = newNode;

		return resultNode;

	}

	/*
	 * You are given two non-empty linked lists representing two non-negative
	 * integers. The most significant digit comes first and each of their nodes
	 * contain a single digit. Add the two numbers and return it as a linked
	 * list.
	 * 
	 * You may assume the two numbers do not contain any leading zero, except
	 * the number 0 itself.
	 * 
	 * Follow up: What if you cannot modify the input lists? In other words,
	 * reversing the lists is not allowed.
	 * 
	 * Example:
	 * 
	 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 8 -> 0 -> 7
	 * 
	 * 
	 */
	public static ListNode addTwoNumbersPart2(ListNode l1, ListNode l2) {
		ListNode result = null;
		if (l1 == null && l2 == null)
			return result;

		if (l1 == null)
			return l2;

		if (l2 == null)
			return l1;

		int l1len = getListLen(l1);
		int l2len = getListLen(l2);

		ListNode oldL1 = l1;
		ListNode oldL2 = l2;
		LinkedList<ListNode> resultLst = new LinkedList();
		int carry = 0;
		if (l1len > l2len) {
			l1 = getNewRef(l1len - l2len, l1);
			carry = addTwoNumbersPart2Helper(l1, oldL2, resultLst);
			carry = resultLsttakeLeftOverTerms(resultLst, oldL1, l1, carry);
		} else {
			l2 = getNewRef(l2len - l1len, l2);
			carry = addTwoNumbersPart2Helper(oldL1, l2, resultLst);
			carry = resultLsttakeLeftOverTerms(resultLst, oldL2, l2, carry);
		}
		if (carry > 0) {
			ListNode newNode = new ListNode(carry);
			resultLst.push(newNode);
		}
		ListNode head = null;
		if (!resultLst.isEmpty()) {
			head = resultLst.pop();
		}

		while (!resultLst.isEmpty()) {
			ListNode temp = resultLst.pop();

			addToEnd(head, temp);
		}
		return head;
	}

	private static int resultLsttakeLeftOverTerms(LinkedList<ListNode> resultLst, ListNode walkOverThisList,
			ListNode l1, int carryFromPast) {
		if (walkOverThisList == null) {

			return 0;
		}
		if (walkOverThisList == l1) {
			if (carryFromPast > 0) {
				ListNode newNode = new ListNode(carryFromPast);
				resultLst.push(newNode);

			}
			return 0;
		}
		if (walkOverThisList.next == l1) {

			int carry = 0;
			int sum = walkOverThisList.val + carryFromPast;
			if (sum >= 10) {
				carry = sum / 10;
				sum = sum % 10;
			} else {
				carry = 0;
			}
			ListNode newNode = new ListNode(sum);
			resultLst.push(newNode);

			return carry;
		}

		int carry = resultLsttakeLeftOverTerms(resultLst, walkOverThisList.next, l1, carryFromPast);
		int sum = walkOverThisList.val + carry;
		if (sum >= 10) {
			carry = sum / 10;
			sum = sum % 10;
		} else {
			carry = 0;
		}
		ListNode newNode = new ListNode(sum);
		resultLst.push(newNode);

		return carry;

	}

	private static int addTwoNumbersPart2Helper(ListNode l1, ListNode l2, LinkedList<ListNode> resultLst) {

		if (l1 == null && l2 == null) {
			return 0;
		}

		ListNode nextl1 = null;
		ListNode nextl2 = null;
		int term1 = 0;
		int term2 = 0;

		if (l1 == null) {
			term1 = 0;
		} else {
			term1 = l1.val;
			nextl1 = l1.next;
		}

		if (l2 == null) {
			term2 = 0;
		} else {
			term2 = l2.val;
			nextl2 = l2.next;
		}

		int carry = addTwoNumbersPart2Helper(nextl1, nextl2, resultLst);

		int sum = term1 + term2 + carry;

		if (sum >= 10) {
			carry = sum / 10;
			sum = sum % 10;
		} else {
			carry = 0;
		}
		ListNode resultNode = new ListNode(sum);
		resultLst.push(resultNode);
		return carry;
	}

	static ListNode getNewRef(int diff, ListNode l1) {
		ListNode newL1 = l1;
		while (diff > 0) {
			newL1 = newL1.next;
			diff--;
		}
		return newL1;
	}

	static int getListLen(ListNode head) {
		int result = 0;
		if (head == null)
			return 0;
		ListNode temp = head;

		while (temp != null) {
			result++;
			temp = temp.next;
		}
		return result;
	}

	public static void main(String[] args) {
		/*
		 * 7->1->6 = 617 5->9->2 = 295 output: 2 -> 1 -> 9 = 912
		 */
		/*
		 * 
		 * 
		 * ListNode.printLL(addTwoNumbers(ListUtil.getListNodes(new int[] { 7,
		 * 1, 6 }),ListUtil.getListNodes(new int[] { 5, 9, 2 })));
		 * 
		 * ListNode.printLL(addTwoNumbersRecursive(ListUtil.getListNodes(new
		 * int[] { 5 }), ListUtil.getListNodes(new int[] { 5 })));
		 * 
		 * 
		 */
		ListUtil.printLL(
				addTwoNumbersPart2(ListUtil.getListNodes(new int[] { 5 }), ListUtil.getListNodes(new int[] { 5 })));

	}

}
