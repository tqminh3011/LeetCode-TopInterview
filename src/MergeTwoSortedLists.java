import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

// Example 1
// Input: list1 = [1,2,4], list2 = [1,3,4]
//Output: [1,1,2,3,4,4]
//Example 2:
//
//Input: list1 = [], list2 = []
//Output: []
//Example 3:
//
//Input: list1 = [], list2 = [0]
//Output: [0]
public class MergeTwoSortedLists {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        ListNode list1 = ListNode.newInstance(scanner.nextLine().trim().split(","));
        ListNode list2 = ListNode.newInstance(scanner.nextLine().trim().split(","));
        System.out.format("\nList 1=%s", list1);
        System.out.format("\nList 2=%s", list2);

        long start = System.currentTimeMillis();
        ListNode result = mergeTwoLists2(list1, list2);
        System.out.format("\nExecuted in %sms", (System.currentTimeMillis() - start));

        System.out.format("\nResult=%s", result);
    }

    // Own solution 1 - worst case O(nlgn), beats 7.3% in time
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> list = new ArrayList<>();
        ListNode iterator = list1;

        while (iterator != null) {
            list.add(iterator.val);
            iterator = iterator.next;
        }

        iterator = list2;
        while (iterator != null) {
            list.add(iterator.val);
            iterator = iterator.next;
        }

        list.sort(Comparator.comparing(Integer::valueOf));

        ListNode result = new ListNode();
        iterator = result;
        boolean iterated = false;

        for (int i=0; i<list.size(); i++) {
            iterated = true;
            iterator.val = list.get(i);
            if (i != list.size()-1) {
                iterator.next = new ListNode();
                iterator = iterator.next;
            }
        }

        return iterated ? result : null;
    }

    // Own solution 2 - improved with worst case O(n+m), beats 100% in time
    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode iterator1 = list1;
        ListNode iterator2 = list2;
        ListNode result = new ListNode();
        ListNode resultIterator = result;

        while (iterator2 != null || iterator1 != null) {
            if (iterator1 == null) {
                resultIterator.next = iterator2;
                break;
            }

            if (iterator2 == null) {
                resultIterator.next = iterator1;
                break;
            }

            resultIterator.next = new ListNode();
            resultIterator = resultIterator.next;

            if (iterator1.val < iterator2.val) {
                resultIterator.val = iterator1.val;
                iterator1 = iterator1.next;
            } else {
                resultIterator.val = iterator2.val;
                iterator2 = iterator2.next;
            }
        }

        return result.next;
    }

    // Online solution, beats 73% in time
    public ListNode onlineMergeTwoLists(ListNode list1, ListNode list2) {
        return new ListNode();
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public static ListNode newInstance(String[] strs) {
            if (Objects.equals(strs[0], "")) {
                return null;
            }

            ListNode result = new ListNode();
            ListNode iterator = result;

            for (String str : strs) {
                iterator.next = new ListNode();
                iterator = iterator.next;
                iterator.val = Integer.parseInt(str);
            }

            return result.next;
        }

        @Override
        public String toString() {
            return val + "," + next + ",";
        }
    }

}